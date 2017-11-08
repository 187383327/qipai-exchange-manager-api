package com.github.microprograms.qipai_exchange_manager_api.model;

import com.github.microprograms.micro_relational_data_model_runtime.Comment;
import com.github.microprograms.micro_relational_data_model_runtime.MicroRelationalDataModel;
import com.github.microprograms.micro_relational_data_model_runtime.Required;
import com.github.microprograms.micro_relational_data_model_runtime.PrimaryKey;

@Comment(value = "用户")
@MicroRelationalDataModel(version = "v1.0.1")
public class User {

    @Comment(value = "用户ID")
    @Required(value = true)
    @PrimaryKey(value = 1)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Comment(value = "用户昵称")
    @Required(value = true)
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Comment(value = "手机号")
    @Required(value = true)
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Comment(value = "会员等级")
    @Required(value = true)
    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Comment(value = "元宝数")
    @Required(value = true)
    private Integer goldIngotAmount;

    public Integer getGoldIngotAmount() {
        return goldIngotAmount;
    }

    public void setGoldIngotAmount(Integer goldIngotAmount) {
        this.goldIngotAmount = goldIngotAmount;
    }

    @Comment(value = "钱包 - 余额(元)")
    @Required(value = true)
    private Integer walletAmount;

    public Integer getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(Integer walletAmount) {
        this.walletAmount = walletAmount;
    }

    @Comment(value = "钱包 - 提现账号姓名")
    @Required(value = true)
    private String walletRealname;

    public String getWalletRealname() {
        return walletRealname;
    }

    public void setWalletRealname(String walletRealname) {
        this.walletRealname = walletRealname;
    }

    @Comment(value = "钱包 - 银行卡号")
    @Required(value = true)
    private String walletBankCardNumber;

    public String getWalletBankCardNumber() {
        return walletBankCardNumber;
    }

    public void setWalletBankCardNumber(String walletBankCardNumber) {
        this.walletBankCardNumber = walletBankCardNumber;
    }

    @Comment(value = "消费金额(元)")
    @Required(value = true)
    private Integer consumptionAmount;

    public Integer getConsumptionAmount() {
        return consumptionAmount;
    }

    public void setConsumptionAmount(Integer consumptionAmount) {
        this.consumptionAmount = consumptionAmount;
    }

    @Comment(value = "注册时间")
    @Required(value = true)
    private Long dtCreate;

    public Long getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Long dtCreate) {
        this.dtCreate = dtCreate;
    }

    @Comment(value = "是否启用(0否1是)")
    @Required(value = true)
    private Integer enable;

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Comment(value = "物流 - 收货人(默认)")
    @Required(value = true)
    private String transportReceiver;

    public String getTransportReceiver() {
        return transportReceiver;
    }

    public void setTransportReceiver(String transportReceiver) {
        this.transportReceiver = transportReceiver;
    }

    @Comment(value = "物流 - 收货地址(默认)")
    @Required(value = true)
    private String transportAddr;

    public String getTransportAddr() {
        return transportAddr;
    }

    public void setTransportAddr(String transportAddr) {
        this.transportAddr = transportAddr;
    }

    @Comment(value = "推荐人ID")
    @Required(value = true)
    private Integer referenceUserId;

    public Integer getReferenceUserId() {
        return referenceUserId;
    }

    public void setReferenceUserId(Integer referenceUserId) {
        this.referenceUserId = referenceUserId;
    }
}
