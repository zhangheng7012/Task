package com.ssm.pojo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
    // 使用基本类型的封装类，可以为null
    private Integer id;
    private Long createAt;
    private Long updateAt;

    //非空校验、长度校验：0-20字符之间
    @NotEmpty(message = "{student.name.isNull}")
    @Size(min = 0,max = 20,message = "{student.name.length.error}")
    private String name;

    //非空校验
    @NotNull(message = "{student.qq.isNull}")
    private Integer qq;

    //非空校验
    @NotEmpty(message = "{student.job.isNull}")
    private String job;

    private Long date;
    private String school;
    private Integer onlineNum;
    private String daily;
    private String dream;
    private String brother;
    private String knowHow;

    public Student() {
    }

    public Student(Integer id, Long createAt,
                    Long updateAt, String name, Integer qq, String job,
                    Long date, String school, Integer onlineNum, String daily, String dream,
                    String brother, String knowHow) {
        this.id = id;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.name = name;
        this.qq = qq;
        this.job = job;
        this.date = date;
        this.school = school;
        this.onlineNum = onlineNum;
        this.daily = daily;
        this.dream = dream;
        this.brother = brother;
        this.knowHow = knowHow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getOnlineNum() {
        return onlineNum;
    }

    public void setOnlineNum(Integer onlineNum) {
        this.onlineNum = onlineNum;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getDream() {
        return dream;
    }

    public void setDream(String dream) {
        this.dream = dream;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getKnowHow() {
        return knowHow;
    }

    public void setKnowHow(String knowHow) {
        this.knowHow = knowHow;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", job='" + job + '\'' +
                ", date='" + date + '\'' +
                ", school='" + school + '\'' +
                ", onlineNum=" + onlineNum +
                ", daily='" + daily + '\'' +
                ", dream='" + dream + '\'' +
                ", brother='" + brother + '\'' +
                ", knowHow='" + knowHow + '\'' +
                '}';
    }
}
