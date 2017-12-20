package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import org.apache.commons.lang3.StringUtils;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.DeleteSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "图文 - 删除")
@MicroApiAnnotation(type = "read", version = "v1.0.50")
public class ImageText_Delete_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        if (StringUtils.isBlank(req.getImageTextId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            conn.createStatement().executeUpdate(new DeleteSql(ImageText.class).where(buildFinalCondition(req)).build());
        }
        Response resp = new Response();
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("id=", req.getImageTextId()).toString();
    }

    public static class Req extends Request {

        @Comment(value = "图文ID")
        @Required(value = true)
        private String imageTextId;

        public String getImageTextId() {
            return imageTextId;
        }

        public void setImageTextId(String imageTextId) {
            this.imageTextId = imageTextId;
        }
    }
}
