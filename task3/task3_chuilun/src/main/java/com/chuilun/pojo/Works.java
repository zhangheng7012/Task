package com.chuilun.pojo;

import java.util.List;

public class Works {
    // 作品集id
    private Integer id;
    // 作品集名称
    private String name;
    // 父作品集id
    private Integer parentWorksId;
    // 作品集上下架状态，上架true，下架false
    private Boolean status;
    // 创建时间
    private Long createAt;
    // 最后修改人
    private String updateBy;

    // 作品集对应多个二级作品集
    private List<Works> secWorks;

    public List<Works> getSecWorks() {
        return secWorks;
    }

    public void setSecWorks(List<Works> secWorks) {
        this.secWorks = secWorks;
    }

    public Works() {
    }

    public Works(Integer id, String name, Integer parentWorksId,
                 Boolean status, Long createAt, String updateBy,
                 List<Works> secWorks) {
        this.id = id;
        this.name = name;
        this.parentWorksId = parentWorksId;
        this.status = status;
        this.createAt = createAt;
        this.updateBy = updateBy;
        this.secWorks = secWorks;
    }

    @Override
    public String toString() {
        return "Works{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentWorksId=" + parentWorksId +
                ", status=" + status +
                ", createAt=" + createAt +
                ", updateBy='" + updateBy + '\'' +
                ", secWorks=" + secWorks +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentWorksId() {
        return parentWorksId;
    }

    public void setParentWorksId(Integer parentWorksId) {
        this.parentWorksId = parentWorksId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}