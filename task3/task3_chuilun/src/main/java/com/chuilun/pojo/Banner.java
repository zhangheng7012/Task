package com.chuilun.pojo;

public class Banner {
    // banner的id
    private Integer id;
    // banner原图
    private String cover;
    // banner对应作品的url
    private String url;
    // banner上下架状态，上架true，下架false
    private Boolean status;
    // banner创建时间
    private Long createAt;
    // banner修改时间
    private Long updateAt;
    // banner最后修改人
    private String updateBy;

    public Banner() {
    }

    public Banner(Integer id, String cover, String url, Boolean status,
                  Long createAt, Long updateAt, String updateBy) {
        this.id = id;
        this.cover = cover;
        this.url = url;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", cover='" + cover + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
}