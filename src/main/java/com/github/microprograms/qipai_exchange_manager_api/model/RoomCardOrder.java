package com.github.microprograms.qipai_exchange_manager_api.model;

import com.github.microprograms.micro_relational_data_model_runtime.Comment;
import com.github.microprograms.micro_relational_data_model_runtime.MicroRelationalDataModel;
import com.github.microprograms.micro_relational_data_model_runtime.Required;
import com.github.microprograms.micro_relational_data_model_runtime.PrimaryKey;

@Comment(value = "房卡订单")
@MicroRelationalDataModel(version = "v1.0.1")
public class RoomCardOrder {

    @Comment(value = "订单号")
    @Required(value = true)
    @PrimaryKey(value = 1)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Comment(value = "房卡标题")
    @Required(value = true)
    private String roomCardOrderName;

    public String getRoomCardOrderName() {
        return roomCardOrderName;
    }

    public void setRoomCardOrderName(String roomCardOrderName) {
        this.roomCardOrderName = roomCardOrderName;
    }

    @Comment(value = "购买数量")
    @Required(value = false)
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Comment(value = "订单金额(元)")
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
}
