package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "调试 - 抛出错误码")
@MicroApiAnnotation(type = "read", version = "v1.0.56")
public class Debug_ThrowErrorCode_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        for (ErrorCodeEnum x : ErrorCodeEnum.values()) {
            if (req.getErrorCode() == x.getCode()) {
                throw new MicroApiExecuteException(x);
            }
        }
        throw new Exception(String.format("ErrorCode Canot Found, errorCode=%d", req.getErrorCode()));
    }

    public static class Req extends Request {

        @Comment(value = "错误码") @Required(value = true) private Integer errorCode;

        public Integer getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }
    }
}
