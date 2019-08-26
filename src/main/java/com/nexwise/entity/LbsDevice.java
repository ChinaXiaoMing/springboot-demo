package com.nexwise.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class LbsDevice implements Serializable {
    private static final long serialVersionUID = 3599419240973242970L;
    private Long id;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date creationtime;

    private Integer devid;

    private Double gpsE;

    private Double gpsN;

    private Integer index;

    private String name;

    private String remark;

    private Integer status;

    private String type;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    private Integer version;

    private Long areaid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public Integer getDevid() {
        return devid;
    }

    public void setDevid(Integer devid) {
        this.devid = devid;
    }

    public Double getGpsE() {
        return gpsE;
    }

    public void setGpsE(Double gpsE) {
        this.gpsE = gpsE;
    }

    public Double getGpsN() {
        return gpsN;
    }

    public void setGpsN(Double gpsN) {
        this.gpsN = gpsN;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getAreaid() {
        return areaid;
    }

    public void setAreaid(Long areaid) {
        this.areaid = areaid;
    }
}