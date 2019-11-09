package com.chuilun.pojo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ArtWork {
    // 作品id
    private Integer id;

    // 作品名称
    //非空校验、长度校验：0-20字符之间
    @NotEmpty(message = "{work.name.isNull}")
    @Size(min = 0,max = 7,message = "{work.name.length.error}")
    private String name;

    // 作品所属作品集id
    // 非空校验
    @NotNull(message = "{work.worksId.isNull}")
    private Integer worksId;

    // 作品简介
    private String brief;
    // 作品缩略图
    private String thumbnail;
    // 作品视频链接
    private String video;
    // 作品原图
    private String original;

    // 作品上下架状态，上架true，下架false
    private Boolean status;

    // 作品创建时间
    private Long createAt;
    // 作品修改时间
    private Long updateAt;
    // 作品最后修改人
    private String updateBy;

    public ArtWork() {
    }

    public ArtWork(Integer id, String name, Integer worksId, String brief,
                   String thumbnail, String video, String original,
                   Boolean status, Long createAt, Long updateAt, String updateBy) {
        this.id = id;
        this.name = name;
        this.worksId = worksId;
        this.brief = brief;
        this.thumbnail = thumbnail;
        this.video = video;
        this.original = original;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "ArtWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", worksId=" + worksId +
                ", brief='" + brief + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", video='" + video + '\'' +
                ", original='" + original + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getWorksId() {
        return worksId;
    }

    public void setWorksId(Integer worksId) {
        this.worksId = worksId;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original == null ? null : original.trim();
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