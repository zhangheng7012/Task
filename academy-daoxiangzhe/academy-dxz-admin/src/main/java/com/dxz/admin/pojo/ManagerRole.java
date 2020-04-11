package com.dxz.admin.pojo;

import java.io.Serializable;

public class ManagerRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "ManagerRole{" +
                "id=" + id +
                ", mid=" + mid +
                ", rid=" + rid +
                ", createAt=" + createAt +
                ", createId=" + createId +
                ", updateAt=" + updateAt +
                ", updateId=" + updateId +
                '}';
    }

    private Long id;

    private Long mid;

    private Long rid;

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

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
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