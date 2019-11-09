package com.chuilun.pojo;

public class Studio {
    // 工作室id
    private Integer id;
    // 工作室名称
    private String name;
    // 工作室上下架状态，上架true，下架false
    private Boolean status;
    // 工作室的插入图片，5个
    private String picturePath;
    // 工作室创建时间
    private Long createAt;
    // 工作室修改时间
    private Long updateAt;
    // 工作室最后修改人
    private String updateBy;

    public Studio() {
    }

    public Studio(Integer id, String name, Boolean status, String picturePath,
                  Long createAt, Long updateAt, String updateBy) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.picturePath = picturePath;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", picture_path='" + picturePath + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
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

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }
}