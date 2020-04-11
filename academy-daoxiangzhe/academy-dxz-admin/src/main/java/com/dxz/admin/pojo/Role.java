package com.dxz.admin.pojo;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @NotEmpty(message = "角色名称不能为空")
    @Length(min = 1, max = 20, message = "角色名称长度为1-20")
    private String name;
//    @NotEmpty(message = "角色介绍不能为空")
    @Length(min = 0, max = 50, message = "角色介绍长度为1-50")
    private String roleMsg;

    private List<Long> perIdList;

    public List<Long> getPerIdList() {
        return perIdList;
    }

    public void setPerIdList(List<Long> perIdList) {
        this.perIdList = perIdList;
    }

    private Long createAt;

    private Long createId;

    private String createBy;

    private Long updateAt;

    private Long updateId;

    private String updateBy;

    private List<Permission> Permissions;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public List<Permission> getPermissions() {
        return Permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        Permissions = permissions;
    }

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

    public String getRoleMsg() {
        return roleMsg;
    }

    public void setRoleMsg(String roleMsg) {
        this.roleMsg = roleMsg == null ? null : roleMsg.trim();
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roleMsg='" + roleMsg + '\'' +
                ", perIdList=" + perIdList +
                ", createAt=" + createAt +
                ", createId=" + createId +
                ", createBy='" + createBy + '\'' +
                ", updateAt=" + updateAt +
                ", updateId=" + updateId +
                ", updateBy='" + updateBy + '\'' +
                ", Permissions=" + Permissions +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "Role{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", roleMsg='" + roleMsg + '\'' +
//                ", createAt=" + createAt +
//                ", createId=" + createId +
//                ", createBy='" + createBy + '\'' +
//                ", updateAt=" + updateAt +
//                ", updateId=" + updateId +
//                ", updateBy='" + updateBy + '\'' +
//                ", Permissions=" + Permissions +
//                '}';
//    }

}