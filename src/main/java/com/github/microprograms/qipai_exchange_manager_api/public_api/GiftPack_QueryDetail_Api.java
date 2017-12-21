package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;
import org.apache.commons.lang3.StringUtils;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "礼包 - 查询详情")
@MicroApiAnnotation(type = "read", version = "v1.0.51")
public class GiftPack_QueryDetail_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        if (StringUtils.isBlank(req.getGiftPackId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            String finalCondition = buildFinalCondition(req);
            ResultSet selectRs = conn.createStatement().executeQuery(new SelectSql(GiftPack.class).where(finalCondition).build());
            resp.setData(IgniteUtils.getJavaObject(selectRs, GiftPack.class));
        }
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("id=", req.getGiftPackId()).toString();
    }

    public static class Req extends Request {

        @Comment(value = "礼包ID")
        @Required(value = true)
        private String giftPackId;

        public String getGiftPackId() {
            return giftPackId;
        }

        public void setGiftPackId(String giftPackId) {
            this.giftPackId = giftPackId;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "礼包详情")
        @Required(value = true)
        private GiftPack data;

        public GiftPack getData() {
            return data;
        }

        public void setData(GiftPack data) {
            this.data = data;
        }
    }
}
