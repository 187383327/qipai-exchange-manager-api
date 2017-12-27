package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_api_runtime.model.ResponseCode;

public enum ErrorCodeEnum implements ResponseCode {

    /**资源不存在或已被删除*/
    not_exists(1010, "资源不存在或已被删除"), /**字符串太长或太短*/
    too_long_or_too_short(1011, "字符串太长或太短"), /**缺少必填的参数*/
    missing_required_parameters(1012, "缺少必填的参数"), /**商品类别数量超限*/
    goods_category_over_limit(1013, "商品类别数量超限"), /**账号和密码不匹配*/
    loginName_loginPassword_not_match(1014, "账号和密码不匹配"), /**Token已失效，请重新登录*/
    invalid_token(1015, "Token已失效，请重新登录"), /**数据已被修改，请重新操作*/
    concurrency_modification_exception(1016, "数据已被修改，请重新操作"), /**权限不足*/
    permission_denied(1017, "权限不足"), /**没有字段需要更新，请填写需要更新的字段*/
    no_fields_need_to_be_updated(1018, "没有字段需要更新，请填写需要更新的字段"), /**无效的商品ID*/
    invalid_goods_id(1019, "无效的商品ID");

    private ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;

    public int getCode() {
        return code;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
