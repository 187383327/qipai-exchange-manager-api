package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.FieldToUpdate;
import com.github.microprograms.ignite_utils.sql.dml.UpdateSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Commons;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "提现申请 - 拒绝")
@MicroApiAnnotation(type = "read", version = "v1.0.53")
public class WithdrawCash_Reject_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        if (StringUtils.isBlank(req.getToken())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        DepartmentMember departmentMember = Commons.queryDepartmentMemberByToken(req.getToken());
        if (departmentMember == null) {
            throw new MicroApiExecuteException(ErrorCodeEnum.invalid_token);
        }
        if (StringUtils.isBlank(req.getWithdrawCashId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        WithdrawCash withdrawCash = Commons.queryWithdrawCashById(req.getWithdrawCashId());
        if (withdrawCash == null) {
            throw new MicroApiExecuteException(ErrorCodeEnum.not_exists);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            List<FieldToUpdate> fields = new ArrayList<>();
            // 状态(0未审核1已同意2已拒绝)
            fields.add(new FieldToUpdate("status", 2));
            fields.add(new FieldToUpdate("auditorId", departmentMember.getId()));
            fields.add(new FieldToUpdate("auditorName", departmentMember.getName()));
            fields.add(new FieldToUpdate("dtAudit", System.currentTimeMillis()));
            if (req.getRejectReason() != null) {
                fields.add(new FieldToUpdate("rejectReason", req.getRejectReason()));
            }
            conn.createStatement().executeUpdate(new UpdateSql(WithdrawCash.class).fields(fields).where(buildFinalCondition(req)).build());
        }
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("id=", req.getWithdrawCashId()).toString();
    }

    public static class Req extends Request {

        @Comment(value = "Token") @Required(value = true) private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Comment(value = "提现申请ID") @Required(value = true) private String withdrawCashId;

        public String getWithdrawCashId() {
            return withdrawCashId;
        }

        public void setWithdrawCashId(String withdrawCashId) {
            this.withdrawCashId = withdrawCashId;
        }

        @Comment(value = "拒绝原因") @Required(value = true) private Integer rejectReason;

        public Integer getRejectReason() {
            return rejectReason;
        }

        public void setRejectReason(Integer rejectReason) {
            this.rejectReason = rejectReason;
        }
    }
}
