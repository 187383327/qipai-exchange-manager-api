package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.MicroEntityAnnotation;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@MicroEntityAnnotation()
public class User {

    @Comment(value = "用户ID")
    @Required(value = true)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Comment(value = "Token")
    @Required(value = true)
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Comment(value = "微信 - UNIONID")
    @Required(value = true)
    private String wxUnionId;

    public String getWxUnionId() {
        return wxUnionId;
    }

    public void setWxUnionId(String wxUnionId) {
        this.wxUnionId = wxUnionId;
    }

    @Comment(value = "微信 - 昵称")
    @Required(value = true)
    private String wxNickname;

    public String getWxNickname() {
        return wxNickname;
    }

    public void setWxNickname(String wxNickname) {
        this.wxNickname = wxNickname;
    }

    @Comment(value = "微信 - 头像")
    @Required(value = true)
    private String wxAvatarImgUrl;

    public String getWxAvatarImgUrl() {
        return wxAvatarImgUrl;
    }

    public void setWxAvatarImgUrl(String wxAvatarImgUrl) {
        this.wxAvatarImgUrl = wxAvatarImgUrl;
    }

    @Comment(value = "极光推送 - 别名")
    @Required(value = true)
    private String jpushAlias;

    public String getJpushAlias() {
        return jpushAlias;
    }

    public void setJpushAlias(String jpushAlias) {
        this.jpushAlias = jpushAlias;
    }

    @Comment(value = "vv棋牌 - 游戏账号ID")
    @Required(value = true)
    private String vvUserId;

    public String getVvUserId() {
        return vvUserId;
    }

    public void setVvUserId(String vvUserId) {
        this.vvUserId = vvUserId;
    }

    @Comment(value = "vv棋牌 - 元宝数量")
    @Required(value = true)
    private Integer vvIngot;

    public Integer getVvIngot() {
        return vvIngot;
    }

    public void setVvIngot(Integer vvIngot) {
        this.vvIngot = vvIngot;
    }

    @Comment(value = "vv棋牌 - 金币数量")
    @Required(value = true)
    private Integer vvBean;

    public Integer getVvBean() {
        return vvBean;
    }

    public void setVvBean(Integer vvBean) {
        this.vvBean = vvBean;
    }

    @Comment(value = "vv棋牌 - 房卡数量")
    @Required(value = true)
    private Integer vvSpecialGold;

    public Integer getVvSpecialGold() {
        return vvSpecialGold;
    }

    public void setVvSpecialGold(Integer vvSpecialGold) {
        this.vvSpecialGold = vvSpecialGold;
    }

    @Comment(value = "头像")
    @Required(value = true)
    private String avatarImgUrl;

    public String getAvatarImgUrl() {
        return avatarImgUrl;
    }

    public void setAvatarImgUrl(String avatarImgUrl) {
        this.avatarImgUrl = avatarImgUrl;
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

    @Comment(value = "会员等级(0游客,1会员,2钻石会员)")
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

    @Comment(value = "钱包 - 余额(分)")
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
    private String myLeaderId;

    public String getMyLeaderId() {
        return myLeaderId;
    }

    public void setMyLeaderId(String myLeaderId) {
        this.myLeaderId = myLeaderId;
    }

    @Comment(value = "推荐人的vv游戏ID")
    @Required(value = true)
    private String myLeaderVvUserId;

    public String getMyLeaderVvUserId() {
        return myLeaderVvUserId;
    }

    public void setMyLeaderVvUserId(String myLeaderVvUserId) {
        this.myLeaderVvUserId = myLeaderVvUserId;
    }

    @Comment(value = "推荐人ID1")
    @Required(value = true)
    private String myLeaderId1;

    public String getMyLeaderId1() {
        return myLeaderId1;
    }

    public void setMyLeaderId1(String myLeaderId1) {
        this.myLeaderId1 = myLeaderId1;
    }

    @Comment(value = "推荐人ID2")
    @Required(value = true)
    private String myLeaderId2;

    public String getMyLeaderId2() {
        return myLeaderId2;
    }

    public void setMyLeaderId2(String myLeaderId2) {
        this.myLeaderId2 = myLeaderId2;
    }

    @Comment(value = "我的邀请人数")
    @Required(value = true)
    private Integer myFollowerCount;

    public Integer getMyFollowerCount() {
        return myFollowerCount;
    }

    public void setMyFollowerCount(Integer myFollowerCount) {
        this.myFollowerCount = myFollowerCount;
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

    @Comment(value = "会员专区 - 我的人头币余额")
    @Required(value = true)
    private Integer headCoinAmount;

    public Integer getHeadCoinAmount() {
        return headCoinAmount;
    }

    public void setHeadCoinAmount(Integer headCoinAmount) {
        this.headCoinAmount = headCoinAmount;
    }
}
