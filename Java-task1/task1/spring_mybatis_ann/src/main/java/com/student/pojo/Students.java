package com.student.pojo;

public class Students {
    // 使用基本类型的封装类，可以为null
    private Integer id;
    private Long createAt;
    /*
        添加时间戳日期对应的String类型时间，
        并生成set、get方法，重写有参构造函数，修改to string方法的相应内容
        用于将时间戳转为日期格式输出，
    */
    private String createAtStr;
    private String updateAtStr;
    private String dateStr;

    public String getCreateAtStr() {
        return createAtStr;
    }

    public void setCreateAtStr(String createAtStr) {
        this.createAtStr = createAtStr;
    }

    public String getUpdateAtStr() {
        return updateAtStr;
    }

    public void setUpdateAtStr(String updateAtStr) {
        this.updateAtStr = updateAtStr;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }


    private Long updateAt;
    private String name;
    private Integer qq;
    private String job;
    private Long date;
    private String school;
    private Integer onlineNum;
    private String daily;
    private String dream;
    private String brother;
    private String knowHow;

    public Students() {
    }

    public Students(Integer id, Long createAt, String createAtStr, String updateAtStr,
                 String dateStr, Long updateAt, String name, Integer qq, String job,
                 Long date, String school, Integer onlineNum, String daily, String dream,
                 String brother, String knowHow) {
        this.id = id;
        this.createAt = createAt;
        this.createAtStr = createAtStr;
        this.updateAtStr = updateAtStr;
        this.dateStr = dateStr;
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
                ", createAt=" + createAtStr +
                ", updateAt=" + updateAtStr +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", job='" + job + '\'' +
                ", date='" + dateStr + '\'' +
                ", school='" + school + '\'' +
                ", onlineNum=" + onlineNum +
                ", daily='" + daily + '\'' +
                ", dream='" + dream + '\'' +
                ", brother='" + brother + '\'' +
                ", knowHow='" + knowHow + '\'' +
                '}';
    }
}
