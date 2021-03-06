package com.dxz.admin.pojo;

import java.io.Serializable;

public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", perMsg='" + perMsg + '\'' +
                ", url='" + url + '\'' +
//                ", createAt=" + createAt +
//                ", createId=" + createId +
//                ", updateAt=" + updateAt +
//                ", updateId=" + updateId +
                '}';
    }

    private Long id;

    private String name;

    private String perMsg;

    private String url;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPerMsg() {
        return perMsg;
    }

    public void setPerMsg(String perMsg) {
        this.perMsg = perMsg == null ? null : perMsg.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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