package com.dxz.home.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", sort=" + sort +
                ", openid='" + openid + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", grade=" + grade +
                ", score=" + score +
                ", status=" + status +
                ", signSum=" + signSum +
                ", signCon=" + signCon +
                ", signNowCon=" + signNowCon +
                '}';
    }

    private Long id;

    @Length(min = 1, max = 20, message = "用户名称长度为1-20")
    private String name;

    private String avatarUrl;

    private Integer sort;

    private String openid;

    private Long phone;

    @Email(message = "邮箱格式错误")
    private String email;

    @Range(min = 1, max = 6, message = "年级数字应为1-6")
    private Integer grade;

    private Long score;

    private Long minScore;
    private Long maxScore;

    public Long getMinScore() {
        return minScore;
    }

    public void setMinScore(Long minScore) {
        this.minScore = minScore;
    }

    public Long getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Long maxScore) {
        this.maxScore = maxScore;
    }

    @Range(min = 1, max = 2, message = "状态数字应为1或2")
    private Integer status;

    private Long signSum;

    private Long signCon;

    private Long signNowCon;

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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSignSum() {
        return signSum;
    }

    public void setSignSum(Long signSum) {
        this.signSum = signSum;
    }

    public Long getSignCon() {
        return signCon;
    }

    public void setSignCon(Long signCon) {
        this.signCon = signCon;
    }

    public Long getSignNowCon() {
        return signNowCon;
    }

    public void setSignNowCon(Long signNowCon) {
        this.signNowCon = signNowCon;
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