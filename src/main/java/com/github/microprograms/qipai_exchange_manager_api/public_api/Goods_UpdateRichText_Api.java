package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import org.apache.commons.io.IOUtils;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "商品/优选商品 - 更新富文本")
@MicroApiAnnotation(type = "read", version = "v1.0.65")
public class Goods_UpdateRichText_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        File dir = new File(Consts.goods_detail_dir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String filename = String.format("%s.html", req.getGoodsId());
        Writer writer = new FileWriter(new File(dir, filename));
        try {
            IOUtils.write(req.getDetail(), writer);
        } finally {
            IOUtils.closeQuietly(writer);
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

        @Comment(value = "商品ID")
        @Required(value = true)
        private String goodsId;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        @Comment(value = "详情(富文本)")
        @Required(value = true)
        private String detail;

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
