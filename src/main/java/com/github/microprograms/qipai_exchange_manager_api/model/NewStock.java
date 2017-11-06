package com.github.microprograms.qipai_exchange_manager_api.model;

import com.github.microprograms.micro_relational_data_model_runtime.Comment;
import com.github.microprograms.micro_relational_data_model_runtime.MicroRelationalDataModel;
import com.github.microprograms.micro_relational_data_model_runtime.Required;
import com.github.microprograms.micro_relational_data_model_runtime.PrimaryKey;

@Comment(value = "新增入库")
@MicroRelationalDataModel(version = "v1.0.0")
public class NewStock {

    @Comment(value = "ID")
    @Required(value = true)
    @PrimaryKey(value = 1)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Comment(value = "商品编号")
    @Required(value = true)
    private Integer goodsId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Comment(value = "商品名称")
    @Required(value = true)
    private String goodsName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Comment(value = "新增库存")
    @Required(value = false)
    private Integer newStock;

    public Integer getNewStock() {
        return newStock;
    }

    public void setNewStock(Integer newStock) {
        this.newStock = newStock;
    }

    @Comment(value = "剩余库存")
    @Required(value = false)
    private Integer remainingStock;

    public Integer getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(Integer remainingStock) {
        this.remainingStock = remainingStock;
    }
}
