package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.FieldToUpdate;
import com.github.microprograms.ignite_utils.sql.dml.UpdateSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Commons;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "订单 - 更新发货状态")
@MicroApiAnnotation(type = "read", version = "v1.0.64")
public class MixOrder_UpdateTransportStatus_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        if (StringUtils.isBlank(req.getToken()) || StringUtils.isBlank(req.getTransportCompany()) || StringUtils.isBlank(req.getTransportNumber())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        DepartmentMember departmentMember = Commons.queryDepartmentMemberByToken(req.getToken());
        if (departmentMember == null) {
            throw new MicroApiExecuteException(ErrorCodeEnum.invalid_token);
        }
        if (StringUtils.isBlank(req.getMixOrderId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            List<FieldToUpdate> fields = new ArrayList<>();
            fields.add(new FieldToUpdate("transportCompany", req.getTransportCompany()));
            fields.add(new FieldToUpdate("transportNumber", req.getTransportNumber()));
            // 物流 - 是否已发货(0未发货1已发货)
            fields.add(new FieldToUpdate("transportIsDelivered", 1));
            fields.add(new FieldToUpdate("transportConsignerId", departmentMember.getId()));
            fields.add(new FieldToUpdate("transportConsignerName", departmentMember.getName()));
            fields.add(new FieldToUpdate("transportDtDelivered", System.currentTimeMillis()));
            conn.createStatement().executeUpdate(new UpdateSql(MixOrder.class).fields(fields).where(buildFinalCondition(req)).build());
        }
        Response resp = new Response();
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("id=", req.getMixOrderId()).toString();
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

        @Comment(value = "订单ID")
        @Required(value = true)
        private String mixOrderId;

        public String getMixOrderId() {
            return mixOrderId;
        }

        public void setMixOrderId(String mixOrderId) {
            this.mixOrderId = mixOrderId;
        }

        @Comment(value = "物流 - 物流公司")
        @Required(value = true)
        private String transportCompany;

        public String getTransportCompany() {
            return transportCompany;
        }

        public void setTransportCompany(String transportCompany) {
            this.transportCompany = transportCompany;
        }

        @Comment(value = "物流 - 物流单号")
        @Required(value = true)
        private String transportNumber;

        public String getTransportNumber() {
            return transportNumber;
        }

        public void setTransportNumber(String transportNumber) {
            this.transportNumber = transportNumber;
        }
    }
}
