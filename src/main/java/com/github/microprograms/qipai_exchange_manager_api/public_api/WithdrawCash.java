package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.MicroEntityAnnotation;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@MicroEntityAnnotation()
public class WithdrawCash {

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

    @Comment(value = "审核时间")
    @Required(value = true)
    private Long dtAudit;

    public Long getDtAudit() {
        return dtAudit;
    }

    public void setDtAudit(Long dtAudit) {
        this.dtAudit = dtAudit;
    }

    @Comment(value = "审核人ID")
    @Required(value = true)
    private String auditorId;

    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId;
    }

    @Comment(value = "审核人名称")
    @Required(value = true)
    private Long auditorName;

    public Long getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(Long auditorName) {
        this.auditorName = auditorName;
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
