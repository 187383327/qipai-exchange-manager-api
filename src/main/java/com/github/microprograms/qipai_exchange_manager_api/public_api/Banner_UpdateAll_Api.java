package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.DeleteSql;
import com.github.microprograms.ignite_utils.sql.dml.InsertSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.enums.MicroApiReserveResponseCodeEnum;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.public_api.Banner_QueryAll_Api.Resp;
import com.github.microprograms.qipai_exchange_manager_api.utils.Commons;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "Banner - 更新全部")
@MicroApiAnnotation(type = "read", version = "v1.0.61")
public class Banner_UpdateAll_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        if (StringUtils.isBlank(req.getToken())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        DepartmentMember departmentMember = Commons.queryDepartmentMemberByToken(req.getToken());
        if (departmentMember == null) {
            throw new MicroApiExecuteException(ErrorCodeEnum.invalid_token);
        }
        Department department = Commons.queryDepartmentById(departmentMember.getDepartmentId());
        if (!Commons.hasPermission(department, PermissionEnum.bannerManage)) {
            throw new MicroApiExecuteException(ErrorCodeEnum.permission_denied);
        }
        Connection conn = IgniteUtils.getConnection(Consts.jdbc_url);
        try {
            conn.setAutoCommit(false);
            conn.createStatement().executeUpdate(new DeleteSql(Banner.class).where(Condition.build("type=", 1)).build());
            for (Banner x : req.getBanners()) {
                if (x.getReorder() == null) {
                    continue;
                }
                com.github.microprograms.qipai_exchange_core.model.Banner newBanner = new com.github.microprograms.qipai_exchange_core.model.Banner();
                newBanner.setId(UUID.randomUUID().toString());
                newBanner.setType(1);
                newBanner.setReorder(x.getReorder());
                newBanner.setUrl(x.getUrl());
                String goodsId = x.getGoodsId();
                if (StringUtils.isNotBlank(goodsId) && Commons.queryGoodsById(goodsId) == null) {
                    throw new MicroApiExecuteException(ErrorCodeEnum.invalid_goods_id);
                }
                newBanner.setGoodsId(StringUtils.isBlank(goodsId) ? "" : goodsId);
                newBanner.setDtCreate(System.currentTimeMillis());
                conn.createStatement().executeUpdate(InsertSql.build(newBanner));
            }
            conn.commit();
        } catch (MicroApiExecuteException e) {
            conn.rollback();
            resp.error(e.getResponseCode(), e.getCause());
        } catch (Exception e) {
            conn.rollback();
            resp.error(MicroApiReserveResponseCodeEnum.api_execute_exception, e);
        } finally {
            conn.close();
        }
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "Token")
        @Required(value = true)
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Comment(value = "Banner列表(全部)")
        @Required(value = true)
        private java.util.List<Banner> banners;

        public java.util.List<Banner> getBanners() {
            return banners;
        }

        public void setBanners(java.util.List<Banner> banners) {
            this.banners = banners;
        }
    }
}
