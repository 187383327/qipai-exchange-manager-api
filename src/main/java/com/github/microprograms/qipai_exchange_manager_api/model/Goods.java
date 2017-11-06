package com.github.microprograms.qipai_exchange_manager_api.model;

import com.github.microprograms.micro_relational_data_model_runtime.Comment;
import com.github.microprograms.micro_relational_data_model_runtime.MicroRelationalDataModel;
import com.github.microprograms.micro_relational_data_model_runtime.Required;
import com.github.microprograms.micro_relational_data_model_runtime.PrimaryKey;

@Comment(value = "商品")
@MicroRelationalDataModel(version = "v1.0.0")
public class Goods {

    @Comment(value = "商品编号")
    @Required(value = true)
    @PrimaryKey(value = 1)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Comment(value = "商品类别编号")
    @Required(value = true)
    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Comment(value = "商品类别名称")
    @Required(value = true)
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Comment(value = "商品名")
    @Required(value = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Comment(value = "商品价格(元宝)")
    @Required(value = true)
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Comment(value = "会员价格(元宝)")
    @Required(value = true)
    private Integer vipPrice;

    public Integer getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(Integer vipPrice) {
        this.vipPrice = vipPrice;
    }

    @Comment(value = "钻石会员(元宝)")
    @Required(value = true)
    private Integer goldVipPrice;

    public Integer getGoldVipPrice() {
        return goldVipPrice;
    }

    public void setGoldVipPrice(Integer goldVipPrice) {
        this.goldVipPrice = goldVipPrice;
    }

    @Comment(value = "排序")
    @Required(value = true)
    private Integer reorder;

    public Integer getReorder() {
        return reorder;
    }

    public void setReorder(Integer reorder) {
        this.reorder = reorder;
    }

    @Comment(value = "库存")
    @Required(value = true)
    private Integer stock;

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Comment(value = "兑换量")
    @Required(value = true)
    private Integer exchangeAmount;

    public Integer getExchangeAmount() {
        return exchangeAmount;
    }

    public void setExchangeAmount(Integer exchangeAmount) {
        this.exchangeAmount = exchangeAmount;
    }

    @Comment(value = "添加时间")
    @Required(value = true)
    private Long dtCreate;

    public Long getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Long dtCreate) {
        this.dtCreate = dtCreate;
    }

    @Comment(value = "商品主图(JsonArray)")
    @Required(value = true)
    private String pictures;

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    @Comment(value = "详情(富文本)")
    @Required(value = true)
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
