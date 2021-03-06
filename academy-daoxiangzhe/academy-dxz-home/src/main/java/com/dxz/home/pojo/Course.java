package com.dxz.home.pojo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sort=" + sort +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", grade=" + grade +
                ", subject=" + subject +
                ", introduction='" + introduction + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", content='" + content + '\'' +
                ", loveSum=" + loveSum +
                ", collectSum=" + collectSum +
                ", status=" + status +
                ", teacherId=" + teacherId +
                ", teacherName=" + teacherName +
                ", avatarUrl=" + avatarUrl +
                ", createAt=" + createAt +
                ", createId=" + createId +
                ", updateAt=" + updateAt +
                ", updateId=" + updateId +
                '}';
    }

    private Long id;

    private String title;

    private Integer sort;

    private String bannerUrl;

//    @Range(min = 1, max = 6, message = "年级数字应为1-6")
    private Integer grade;

//    @Range(min = 1, max = 6, message = "科目数字应为1-6")
    private Integer subject;

    private String introduction;

    private String videoUrl;

    private String content;

    private Long loveSum;
    private Long minLoveSum;
    private Long maxLoveSum;

    private Long collectSum;
    private Long minCollectSum;
    private Long maxCollectSum;

    public Long getLoveSum() {
        return loveSum;
    }

    public void setLoveSum(Long loveSum) {
        this.loveSum = loveSum;
    }

    public Long getCollectSum() {
        return collectSum;
    }

    public void setCollectSum(Long collectSum) {
        this.collectSum = collectSum;
    }

    public Long getMinLoveSum() {
        return minLoveSum;
    }

    public void setMinLoveSum(Long minLoveSum) {
        this.minLoveSum = minLoveSum;
    }

    public Long getMaxLoveSum() {
        return maxLoveSum;
    }

    public void setMaxLoveSum(Long maxLoveSum) {
        this.maxLoveSum = maxLoveSum;
    }

    public Long getMinCollectSum() {
        return minCollectSum;
    }

    public void setMinCollectSum(Long minCollectSum) {
        this.minCollectSum = minCollectSum;
    }

    public Long getMaxCollectSum() {
        return maxCollectSum;
    }

    public void setMaxCollectSum(Long maxCollectSum) {
        this.maxCollectSum = maxCollectSum;
    }

    private Integer status;

    private Long teacherId;
    private String teacherName;
    private String avatarUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl == null ? null : bannerUrl.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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