package com.bm.oms.model;

import com.bm.oms.dto.base.BaseEntity;
import java.util.Date;

public class LuckBasin  extends BaseEntity {
    private Long id;

    private Integer item;

    private String img;

    private String content;

    private String magicid;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getMagicid() {
        return magicid;
    }

    public void setMagicid(String magicid) {
        this.magicid = magicid == null ? null : magicid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}