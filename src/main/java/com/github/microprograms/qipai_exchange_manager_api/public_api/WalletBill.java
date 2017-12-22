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
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    @Comment(value = "金额(分)")
    @Required(value = true)
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Comment(value = "钱包 - 旧余额(分)")
    @Required(value = true)
    private Integer oldWalletAmount;

    public Integer getOldWalletAmount() {
        return oldWalletAmount;
    }

    public void setOldWalletAmount(Integer oldWalletAmount) {
        this.oldWalletAmount = oldWalletAmount;
    }

    @Comment(value = "钱包 - 新余额(分)")
    @Required(value = true)
    private Integer newWalletAmount;

    public Integer getNewWalletAmount() {
        return newWalletAmount;
    }

    public void setNewWalletAmount(Integer newWalletAmount) {
        this.newWalletAmount = newWalletAmount;
    }

    @Comment(value = "入账 - 贡献用户ID")
    @Required(value = true)
    private String inContributorUserId;

    public String getInContributorUserId() {
        return inContributorUserId;
    }

    public void setInContributorUserId(String inContributorUserId) {
        this.inContributorUserId = inContributorUserId;
    }

    @Comment(value = "入账 - 贡献用户的vv游戏ID")
    @Required(value = true)
    private String inContributorVvUserId;

    public String getInContributorVvUserId() {
        return inContributorVvUserId;
    }

    public void setInContributorVvUserId(String inContributorVvUserId) {
        this.inContributorVvUserId = inContributorVvUserId;
    }

    @Comment(value = "入账 - 贡献用户等级(1一级,2二级,3三级)")
    @Required(value = true)
    private Integer inContributorUserLevel;

    public Integer getInContributorUserLevel() {
        return inContributorUserLevel;
    }

    public void setInContributorUserLevel(Integer inContributorUserLevel) {
        this.inContributorUserLevel = inContributorUserLevel;
    }

    @Comment(value = "上次修改时间")
    @Required(value = true)
    private Long dtLastModify;

    public Long getDtLastModify() {
        return dtLastModify;
    }

    public void setDtLastModify(Long dtLastModify) {
        this.dtLastModify = dtLastModify;
    }
}
