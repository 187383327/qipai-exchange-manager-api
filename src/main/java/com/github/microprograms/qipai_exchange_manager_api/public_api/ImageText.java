package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.MicroEntityAnnotation;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@MicroEntityAnnotation()
public class ImageText {

    @Comment(value = "ID")
    @Required(value = true)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Comment(value = "链接")
    @Required(value = true)
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Comment(value = "标题")
    @Required(value = true)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Comment(value = "内容(富文本)")
    @Required(value = true)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Comment(value = "创建时间")
    @Required(value = true)
    private Long dtCreate;

    public Long getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Long dtCreate) {
        this.dtCreate = dtCreate;
    }
}
