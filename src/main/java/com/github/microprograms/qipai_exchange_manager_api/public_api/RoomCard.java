package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.MicroEntityAnnotation;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@MicroEntityAnnotation()
public class RoomCard {

    @Comment(value = "编号")
    @Required(value = true)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Comment(value = "房卡封面图")
    @Required(value = true)
    private String coverImgUrl;

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    @Comment(value = "房卡标题")
    @Required(value = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Comment(value = "价格(元)")
    @Required(value = false)
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Comment(value = "金币")
    @Required(value = false)
    private Integer goldCoin;

    public Integer getGoldCoin() {
        return goldCoin;
    }

    public void setGoldCoin(Integer goldCoin) {
        this.goldCoin = goldCoin;
    }

    @Comment(value = "销售数量")
    @Required(value = false)
    private Integer salesVolume;

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    @Comment(value = "是否启用(0否1是)")
    @Required(value = false)
    private Integer enable;

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Comment(value = "是否删除(0否1是)")
    @Required(value = true)
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
