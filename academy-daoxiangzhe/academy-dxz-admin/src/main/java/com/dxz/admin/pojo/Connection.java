package com.dxz.admin.pojo;

import java.io.Serializable;

public class Connection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Connection{" +
                "id=" + id +
                ", vid=" + vid +
                ", uid=" + uid +
                ", status=" + status +
                ", createAt=" + createAt +
                ", createId=" + createId +
                ", updateAt=" + updateAt +
                ", updateId=" + updateId +
                '}';
    }

    private Long id;

    private Long vid;

    private Long uid;

    private Integer status;

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

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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