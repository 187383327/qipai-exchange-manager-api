package com.github.microprograms.qipai_exchange_manager_api.public_api;

public enum PermissionEnum {
    /** 订单查看 */
    orderQuery("orderQuery", "订单查看"),
    /** 订单修改 */
    orderUpdate("orderUpdate", "订单修改"),
    /** 订单删除 */
    orderDelete("orderDelete", "订单删除"),
    /** 商品添加 */
    goodsAdd("goodsAdd", "商品添加"),
    /** 商品修改 */
    goodsUpdate("goodsUpdate", "商品修改"),
    /** 商品删除 */
    goodsDelete("goodsDelete", "商品删除"),
    /** 房卡添加 */
    roomCardAdd("roomCardAdd", "房卡添加"),
    /** 房卡修改 */
    roomCardUpdate("roomCardUpdate", "房卡修改"),
    /** 房卡删除 */
    roomCardDelete("roomCardDelete", "房卡删除"),
    /** 同意提现 */
    withdrawCashAuditAgree("withdrawCashAuditAgree", "同意提现"),
    /** 拒绝提现 */
    withdrawCashAuditReject("withdrawCashAuditReject", "拒绝提现"),
    /** 库存查看 */
    stockQuery("stockQuery", "库存查看"),
    /** 入库管理 */
    stockUpdate("stockUpdate", "入库管理"),
    /** banner管理 */
    bannerManage("bannerManage", "banner管理"),
    /** 会员专区Banner管理 */
    choiceBannerManage("choiceBannerManage", "会员专区Banner管理"),
    /** 搜索推荐管理 */
    goodsHotWordsManage("goodsHotWordsManage", "搜索推荐管理"),
    /** 图文添加 */
    imageTextAdd("imageTextAdd", "图文添加"),
    /** 部门成员查看 */
    departmentMemberQuery("departmentMemberQuery", "部门成员查看"),
    /** 部门成员修改 */
    departmentMemberUpdate("departmentMemberUpdate", "部门成员修改");

    private String id;
    private String desc;

    private PermissionEnum(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
}
