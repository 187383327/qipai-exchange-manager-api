package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.MicroEntityAnnotation;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@MicroEntityAnnotation()
public class GiftPackBuyHistory {

    @Comment(value = "ID")
    @Required(value = true)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Comment(value = "礼包ID")
    @Required(value = true)
    private String giftPackId;

    public String getGiftPackId() {
        return giftPackId;
    }

    public void setGiftPackId(String giftPackId) {
        this.giftPackId = giftPackId;
    }

    @Comment(value = "礼包名称")
    @Required(value = true)
    private String giftPackName;

    public String getGiftPackName() {
        return giftPackName;
    }

    public void setGiftPackName(String giftPackName) {
        this.giftPackName = giftPackName;
    }

    @Comment(value = "会员专享礼包价")
    @Required(value = true)
    private Integer giftPackPrice;

    public Integer getGiftPackPrice() {
        return giftPackPrice;
    }

    public void setGiftPackPrice(Integer giftPackPrice) {
        this.giftPackPrice = giftPackPrice;
    }

    @Comment(value = "用户ID")
    @Required(value = true)
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Comment(value = "购买时间")
    @Required(value = true)
    private Long dtCreate;

    public Long getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Long dtCreate) {
        this.dtCreate = dtCreate;
    }
}
