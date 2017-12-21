package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.MicroEntityAnnotation;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@MicroEntityAnnotation()
public class SystemConfig {

    @Comment(value = "ID")
    @Required(value = true)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Comment(value = "会员升级条件 - 普通会员")
    @Required(value = true)
    private Integer vipLevelUpConditionCommonVip;

    public Integer getVipLevelUpConditionCommonVip() {
        return vipLevelUpConditionCommonVip;
    }

    public void setVipLevelUpConditionCommonVip(Integer vipLevelUpConditionCommonVip) {
        this.vipLevelUpConditionCommonVip = vipLevelUpConditionCommonVip;
    }

    @Comment(value = "会员升级条件 - 钻石会员")
    @Required(value = true)
    private Integer vipLevelUpConditionGoldVip;

    public Integer getVipLevelUpConditionGoldVip() {
        return vipLevelUpConditionGoldVip;
    }

    public void setVipLevelUpConditionGoldVip(Integer vipLevelUpConditionGoldVip) {
        this.vipLevelUpConditionGoldVip = vipLevelUpConditionGoldVip;
    }
}
