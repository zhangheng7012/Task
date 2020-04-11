package com.dxz.home.pojo;

import java.io.Serializable;

public class Sign implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", userId=" + userId +
                ", signTime=" + signTime +
                ", createAt=" + createAt +
                ", createId=" + createId +
                ", updateAt=" + updateAt +
                ", updateId=" + updateId +
                '}';
    }

    private Long id;

    private Long userId;

    private Long signTime;
    private Long minSignTime;
    private Long maxSignTime;

    public Long getMinSignTime() {
        return minSignTime;
    }

    public void setMinSignTime(Long minSignTime) {
        this.minSignTime = minSignTime;
    }

    public Long getMaxSignTime() {
        return maxSignTime;
    }

    public void setMaxSignTime(Long maxSignTime) {
        this.maxSignTime = maxSignTime;
    }

    private Long createAt;

    private Long createId;

    private Long updateAt;

    private Long updateId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSignTime() {
        return signTime;
    }

    public void setSignTime(Long signTime) {
        this.signTime = signTime;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }
}