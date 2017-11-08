package com.github.microprograms.qipai_exchange_manager_api.model;

import com.github.microprograms.micro_relational_data_model_runtime.Comment;
import com.github.microprograms.micro_relational_data_model_runtime.MicroRelationalDataModel;
import com.github.microprograms.micro_relational_data_model_runtime.Required;
import com.github.microprograms.micro_relational_data_model_runtime.PrimaryKey;

@Comment(value = "提现")
@MicroRelationalDataModel(version = "v1.0.1")
public class WithdrawCash {

    @Comment(value = "ID")
    @Required(value = true)
    @PrimaryKey(value = 1)
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

    @Comment(value = "提现金额(元)")
    @Required(value = true)
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Comment(value = "申请时间")
    @Required(value = true)
    private Long dtCreate;

    public Long getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Long dtCreate) {
        this.dtCreate = dtCreate;
    }

    @Comment(value = "状态(0未审核1已同意2已拒绝)")
    @Required(value = true)
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Comment(value = "拒绝原因")
    @Required(value = true)
    private Integer rejectReason;

    public Integer getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(Integer rejectReason) {
        this.rejectReason = rejectReason;
    }
}
