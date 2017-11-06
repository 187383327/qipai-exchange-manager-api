package com.github.microprograms.qipai_exchange_manager_api.model;

import com.github.microprograms.micro_relational_data_model_runtime.Comment;
import com.github.microprograms.micro_relational_data_model_runtime.MicroRelationalDataModel;
import com.github.microprograms.micro_relational_data_model_runtime.Required;
import com.github.microprograms.micro_relational_data_model_runtime.PrimaryKey;

@Comment(value = "商品订单")
@MicroRelationalDataModel(version = "v1.0.0")
public class GoodsOrder {

    @Comment(value = "订单号")
    @Required(value = true)
    @PrimaryKey(value = 1)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Comment(value = "用户ID")
    @Required(value = true)
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    @Comment(value = "商品数量")
    @Required(value = false)
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Comment(value = "订单金额(元宝)")
    @Required(value = false)
    private Integer orderAmount;

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
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

    @Comment(value = "支付方式(1微信)")
    @Required(value = false)
    private Integer payChannel;

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }
}
