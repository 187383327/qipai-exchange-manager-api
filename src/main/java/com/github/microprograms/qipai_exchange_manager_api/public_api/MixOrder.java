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

    @Comment(value = "提交时间")
    @Required(value = true)
    private Long dtCreate;

    public Long getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Long dtCreate) {
        this.dtCreate = dtCreate;
    }

    @Comment(value = "订单状态(0待付款,1待收货,2已完成,3已取消)")
    @Required(value = false)
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Comment(value = "订单类型(1商品订单,2礼包订单,3房卡订单)")
    @Required(value = false)
    private Integer orderType;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    @Comment(value = "商品订单 - 商品数量")
    @Required(value = false)
    private Integer goodsOrder_goodsQuantity;

    public Integer getGoodsOrder_goodsQuantity() {
        return goodsOrder_goodsQuantity;
    }

    public void setGoodsOrder_goodsQuantity(Integer goodsOrder_goodsQuantity) {
        this.goodsOrder_goodsQuantity = goodsOrder_goodsQuantity;
    }

    @Comment(value = "商品订单 - 订单金额(元宝)")
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
    private Integer goodsOrder_detail;

    public Integer getGoodsOrder_detail() {
        return goodsOrder_detail;
    }

    public void setGoodsOrder_detail(Integer goodsOrder_detail) {
        this.goodsOrder_detail = goodsOrder_detail;
    }

    @Comment(value = "礼包订单 - 礼包ID")
    @Required(value = false)
    private Integer giftPackOrder_giftPackId;

    public Integer getGiftPackOrder_giftPackId() {
        return giftPackOrder_giftPackId;
    }

    public void setGiftPackOrder_giftPackId(Integer giftPackOrder_giftPackId) {
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

    @Comment(value = "房卡订单 - 房卡ID")
    @Required(value = false)
    private Integer roomCardOrder_roomCardId;

    public Integer getRoomCardOrder_roomCardId() {
        return roomCardOrder_roomCardId;
    }

    public void setRoomCardOrder_roomCardId(Integer roomCardOrder_roomCardId) {
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

    @Comment(value = "房卡订单 - 订单金额(元)")
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
}