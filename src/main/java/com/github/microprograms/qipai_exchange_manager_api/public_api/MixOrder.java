package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.MicroEntityAnnotation;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@MicroEntityAnnotation()
public class MixOrder {

    @Comment(value = "订单号")
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

    @Comment(value = "微信 - UNIONID")
    @Required(value = true)
    private String wxUnionId;

    public String getWxUnionId() {
        return wxUnionId;
    }

    public void setWxUnionId(String wxUnionId) {
        this.wxUnionId = wxUnionId;
    }

    @Comment(value = "提交时间")
    @Required(value = true)
    private Long dtCreate;

    public Long getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Long dtCreate) {
        this.dtCreate = dtCreate;
    }

    @Comment(value = "订单状态(1待付款,2待收货,3已完成,4已取消)")
    @Required(value = false)
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Comment(value = "订单类型(1使用元宝支付的商品/优选商品订单,2使用人民币支付的房卡订单,3使用元宝支付的礼包订单)")
    @Required(value = false)
    private Integer orderType;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    @Comment(value = "商品订单 - 商品总数量")
    @Required(value = false)
    private Integer goodsOrder_goodsQuantity;

    public Integer getGoodsOrder_goodsQuantity() {
        return goodsOrder_goodsQuantity;
    }

    public void setGoodsOrder_goodsQuantity(Integer goodsOrder_goodsQuantity) {
        this.goodsOrder_goodsQuantity = goodsOrder_goodsQuantity;
    }

    @Comment(value = "商品订单 - 订单总金额(元宝)")
    @Required(value = false)
    private Integer goodsOrder_orderAmount;

    public Integer getGoodsOrder_orderAmount() {
        return goodsOrder_orderAmount;
    }

    public void setGoodsOrder_orderAmount(Integer goodsOrder_orderAmount) {
        this.goodsOrder_orderAmount = goodsOrder_orderAmount;
    }

    @Comment(value = "商品订单 - 商品明细(JsonArray)")
    @Required(value = false)
    private String goodsOrder_detail;

    public String getGoodsOrder_detail() {
        return goodsOrder_detail;
    }

    public void setGoodsOrder_detail(String goodsOrder_detail) {
        this.goodsOrder_detail = goodsOrder_detail;
    }

    @Comment(value = "房卡订单 - 房卡ID")
    @Required(value = false)
    private String roomCardOrder_roomCardId;

    public String getRoomCardOrder_roomCardId() {
        return roomCardOrder_roomCardId;
    }

    public void setRoomCardOrder_roomCardId(String roomCardOrder_roomCardId) {
        this.roomCardOrder_roomCardId = roomCardOrder_roomCardId;
    }

    @Comment(value = "房卡订单 - 购买数量")
    @Required(value = false)
    private Integer roomCardOrder_buyQuantity;

    public Integer getRoomCardOrder_buyQuantity() {
        return roomCardOrder_buyQuantity;
    }

    public void setRoomCardOrder_buyQuantity(Integer roomCardOrder_buyQuantity) {
        this.roomCardOrder_buyQuantity = roomCardOrder_buyQuantity;
    }

    @Comment(value = "房卡订单 - 购买金币总数量(个)")
    @Required(value = false)
    private Integer roomCardOrder_buyBeanAmount;

    public Integer getRoomCardOrder_buyBeanAmount() {
        return roomCardOrder_buyBeanAmount;
    }

    public void setRoomCardOrder_buyBeanAmount(Integer roomCardOrder_buyBeanAmount) {
        this.roomCardOrder_buyBeanAmount = roomCardOrder_buyBeanAmount;
    }

    @Comment(value = "房卡订单 - 订单总金额(元)")
    @Required(value = false)
    private Integer roomCardOrder_orderAmount;

    public Integer getRoomCardOrder_orderAmount() {
        return roomCardOrder_orderAmount;
    }

    public void setRoomCardOrder_orderAmount(Integer roomCardOrder_orderAmount) {
        this.roomCardOrder_orderAmount = roomCardOrder_orderAmount;
    }

    @Comment(value = "房卡订单 - 支付方式(1微信)")
    @Required(value = false)
    private Integer roomCardOrder_payChannel;

    public Integer getRoomCardOrder_payChannel() {
        return roomCardOrder_payChannel;
    }

    public void setRoomCardOrder_payChannel(Integer roomCardOrder_payChannel) {
        this.roomCardOrder_payChannel = roomCardOrder_payChannel;
    }

    @Comment(value = "房卡订单 - 房卡明细(JsonObject)")
    @Required(value = false)
    private String roomCardOrder_detail;

    public String getRoomCardOrder_detail() {
        return roomCardOrder_detail;
    }

    public void setRoomCardOrder_detail(String roomCardOrder_detail) {
        this.roomCardOrder_detail = roomCardOrder_detail;
    }

    @Comment(value = "房卡订单 - 微信支付 - 回调时间")
    @Required(value = false)
    private Long roomCardOrder_wxPay_dtNotify;

    public Long getRoomCardOrder_wxPay_dtNotify() {
        return roomCardOrder_wxPay_dtNotify;
    }

    public void setRoomCardOrder_wxPay_dtNotify(Long roomCardOrder_wxPay_dtNotify) {
        this.roomCardOrder_wxPay_dtNotify = roomCardOrder_wxPay_dtNotify;
    }

    @Comment(value = "房卡订单 - 微信支付 - 原始通知内容")
    @Required(value = false)
    private String roomCardOrder_wxPay_rawNotify;

    public String getRoomCardOrder_wxPay_rawNotify() {
        return roomCardOrder_wxPay_rawNotify;
    }

    public void setRoomCardOrder_wxPay_rawNotify(String roomCardOrder_wxPay_rawNotify) {
        this.roomCardOrder_wxPay_rawNotify = roomCardOrder_wxPay_rawNotify;
    }

    @Comment(value = "房卡订单 - 微信支付 - 是否支付成功(0否1是)")
    @Required(value = false)
    private Integer roomCardOrder_wxPay_isSuccess;

    public Integer getRoomCardOrder_wxPay_isSuccess() {
        return roomCardOrder_wxPay_isSuccess;
    }

    public void setRoomCardOrder_wxPay_isSuccess(Integer roomCardOrder_wxPay_isSuccess) {
        this.roomCardOrder_wxPay_isSuccess = roomCardOrder_wxPay_isSuccess;
    }

    @Comment(value = "房卡订单 - HS Api - 请求时间")
    @Required(value = false)
    private Long roomCardOrder_hsApi_dtRequest;

    public Long getRoomCardOrder_hsApi_dtRequest() {
        return roomCardOrder_hsApi_dtRequest;
    }

    public void setRoomCardOrder_hsApi_dtRequest(Long roomCardOrder_hsApi_dtRequest) {
        this.roomCardOrder_hsApi_dtRequest = roomCardOrder_hsApi_dtRequest;
    }

    @Comment(value = "房卡订单 - HS Api - 响应时间")
    @Required(value = false)
    private Long roomCardOrder_hsApi_dtResponse;

    public Long getRoomCardOrder_hsApi_dtResponse() {
        return roomCardOrder_hsApi_dtResponse;
    }

    public void setRoomCardOrder_hsApi_dtResponse(Long roomCardOrder_hsApi_dtResponse) {
        this.roomCardOrder_hsApi_dtResponse = roomCardOrder_hsApi_dtResponse;
    }

    @Comment(value = "房卡订单 - HS Api - 原始请求参数")
    @Required(value = false)
    private String roomCardOrder_hsApi_rawRequest;

    public String getRoomCardOrder_hsApi_rawRequest() {
        return roomCardOrder_hsApi_rawRequest;
    }

    public void setRoomCardOrder_hsApi_rawRequest(String roomCardOrder_hsApi_rawRequest) {
        this.roomCardOrder_hsApi_rawRequest = roomCardOrder_hsApi_rawRequest;
    }

    @Comment(value = "房卡订单 - HS Api - 原始响应参数")
    @Required(value = false)
    private String roomCardOrder_hsApi_rawResponse;

    public String getRoomCardOrder_hsApi_rawResponse() {
        return roomCardOrder_hsApi_rawResponse;
    }

    public void setRoomCardOrder_hsApi_rawResponse(String roomCardOrder_hsApi_rawResponse) {
        this.roomCardOrder_hsApi_rawResponse = roomCardOrder_hsApi_rawResponse;
    }

    @Comment(value = "礼包订单 - 礼包ID")
    @Required(value = false)
    private String giftPackOrder_giftPackId;

    public String getGiftPackOrder_giftPackId() {
        return giftPackOrder_giftPackId;
    }

    public void setGiftPackOrder_giftPackId(String giftPackOrder_giftPackId) {
        this.giftPackOrder_giftPackId = giftPackOrder_giftPackId;
    }

    @Comment(value = "礼包订单 - 购买数量")
    @Required(value = false)
    private Integer giftPackOrder_buyQuantity;

    public Integer getGiftPackOrder_buyQuantity() {
        return giftPackOrder_buyQuantity;
    }

    public void setGiftPackOrder_buyQuantity(Integer giftPackOrder_buyQuantity) {
        this.giftPackOrder_buyQuantity = giftPackOrder_buyQuantity;
    }

    @Comment(value = "礼包订单 - 订单金额(元宝)")
    @Required(value = false)
    private Integer giftPackOrder_orderAmount;

    public Integer getGiftPackOrder_orderAmount() {
        return giftPackOrder_orderAmount;
    }

    public void setGiftPackOrder_orderAmount(Integer giftPackOrder_orderAmount) {
        this.giftPackOrder_orderAmount = giftPackOrder_orderAmount;
    }

    @Comment(value = "物流 - 收货人")
    @Required(value = true)
    private String transportReceiver;

    public String getTransportReceiver() {
        return transportReceiver;
    }

    public void setTransportReceiver(String transportReceiver) {
        this.transportReceiver = transportReceiver;
    }

    @Comment(value = "物流 - 收货人手机号")
    @Required(value = true)
    private String transportPhone;

    public String getTransportPhone() {
        return transportPhone;
    }

    public void setTransportPhone(String transportPhone) {
        this.transportPhone = transportPhone;
    }

    @Comment(value = "物流 - 收货地址")
    @Required(value = true)
    private String transportAddr;

    public String getTransportAddr() {
        return transportAddr;
    }

    public void setTransportAddr(String transportAddr) {
        this.transportAddr = transportAddr;
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
