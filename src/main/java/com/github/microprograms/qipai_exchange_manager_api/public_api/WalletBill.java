package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.MicroEntityAnnotation;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@MicroEntityAnnotation()
public class WalletBill {

    @Comment(value = "ID")
    @Required(value = true)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Comment(value = "用户ID")
    @Required(value = true)
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Comment(value = "类型(1入账,2提现)")
    @Required(value = true)
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Comment(value = "时间")
    @Required(value = true)
    private Long dtCreate;

    public Long getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Long dtCreate) {
        this.dtCreate = dtCreate;
    }

    @Comment(value = "金额")
    @Required(value = true)
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Comment(value = "入账 - 贡献用户ID")
    @Required(value = true)
    private Integer inContributorUserId;

    public Integer getInContributorUserId() {
        return inContributorUserId;
    }

    public void setInContributorUserId(Integer inContributorUserId) {
        this.inContributorUserId = inContributorUserId;
    }

    @Comment(value = "入账 - 贡献用户等级(1一级,2二级)")
    @Required(value = true)
    private Integer inContributorUserLevel;

    public Integer getInContributorUserLevel() {
        return inContributorUserLevel;
    }

    public void setInContributorUserLevel(Integer inContributorUserLevel) {
        this.inContributorUserLevel = inContributorUserLevel;
    }
}
