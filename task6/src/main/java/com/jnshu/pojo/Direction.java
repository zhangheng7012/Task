package com.jnshu.pojo;

public class Direction {

    private Integer id;

    private String image;

    private String direction;

    private String profession;

    private String introduction;

    private Integer threshold;

    private Integer difficult;

    private String period;

    private Integer importance;

    private String salaryOne;

    private String salaryTwo;

    private String salaryThree;

    private Integer studyNum;

    private String point;

    private Long createAt;

    private Long updateAt;

    public Direction() {
    }

    public Direction(Integer id, String image, String direction, String profession,
                     String introduction, Integer threshold, Integer difficult,
                     String period, Integer importance, String salaryOne,
                     String salaryTwo, String salaryThree, Integer studyNum,
                     String point, Long createAt, Long updateAt) {
        this.id = id;
        this.image = image;
        this.direction = direction;
        this.profession = profession;
        this.introduction = introduction;
        this.threshold = threshold;
        this.difficult = difficult;
        this.period = period;
        this.importance = importance;
        this.salaryOne = salaryOne;
        this.salaryTwo = salaryTwo;
        this.salaryThree = salaryThree;
        this.studyNum = studyNum;
        this.point = point;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", direction='" + direction + '\'' +
                ", profession='" + profession + '\'' +
                ", introduction='" + introduction + '\'' +
                ", threshold=" + threshold +
                ", difficult=" + difficult +
                ", period='" + period + '\'' +
                ", importance=" + importance +
                ", salaryOne='" + salaryOne + '\'' +
                ", salaryTwo='" + salaryTwo + '\'' +
                ", salaryThree='" + salaryThree + '\'' +
                ", studyNum=" + studyNum +
                ", point='" + point + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Integer getDifficult() {
        return difficult;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public String getSalaryOne() {
        return salaryOne;
    }

    public void setSalaryOne(String salaryOne) {
        this.salaryOne = salaryOne == null ? null : salaryOne.trim();
    }

    public String getSalaryTwo() {
        return salaryTwo;
    }

    public void setSalaryTwo(String salaryTwo) {
        this.salaryTwo = salaryTwo == null ? null : salaryTwo.trim();
    }

    public String getSalaryThree() {
        return salaryThree;
    }

    public void setSalaryThree(String salaryThree) {
        this.salaryThree = salaryThree == null ? null : salaryThree.trim();
    }

    public Integer getStudyNum() {
        return studyNum;
    }

    public void setStudyNum(Integer studyNum) {
        this.studyNum = studyNum;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
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
}