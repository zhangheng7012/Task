package com.jnshu.pojo;

public class Student {

    private Integer id;

    private String image;

    private String profession;

    private String name;

    private String introduction;

    private Integer salary;

    private Long createAt;

    private Long updateAt;

    public Student() {
    }

    public Student(Integer id, String image, String profession, String name,
                   String introduction, Integer salary, Long createAt, Long updateAt) {
        this.id = id;
        this.image = image;
        this.profession = profession;
        this.name = name;
        this.introduction = introduction;
        this.salary = salary;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", profession='" + profession + '\'' +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", salary=" + salary +
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
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