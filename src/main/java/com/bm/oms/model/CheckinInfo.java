package com.bm.oms.model;

import com.bm.oms.dto.base.BaseEntity;
import java.util.Date;

public class CheckinInfo extends BaseEntity {

    private Long id;

    private Integer hour;

    private Integer gold;

    private Integer doubleRate;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getDoubleRate() {
        return doubleRate;
    }

    public void setDoubleRate(Integer doubleRate) {
        this.doubleRate = doubleRate;
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