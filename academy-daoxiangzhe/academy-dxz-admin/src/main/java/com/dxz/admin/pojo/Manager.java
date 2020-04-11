package com.dxz.admin.pojo;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @Length(min = 0, max = 20, message = "账号名称长度为1-20")
    private String name;
    @Length(min = 1, max = 100, message = "密码长度为1-100")
    private String password;

    private Long roleId;
    private String roleName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private String salt;

    private Long createAt;
    private Long minCreateAt;
    private Long maxCreateAt;

    public Long getMinCreateAt() {
        return minCreateAt;
    }

    public void setMinCreateAt(Long minCreateAt) {
        this.minCreateAt = minCreateAt;
    }

    public Long getMaxCreateAt() {
        return maxCreateAt;
    }

    public void setMaxCreateAt(Long maxCreateAt) {
        this.maxCreateAt = maxCreateAt;
    }

    private Long createId;

    private String createBy;

    private Long updateAt;

    private Long updateId;

    private String updateBy;

    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
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
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", roleId=" + roleId +
                ", createAt=" + createAt +
                ", createId=" + createId +
                ", createBy='" + createBy + '\'' +
                ", updateAt=" + updateAt +
                ", updateId=" + updateId +
                ", updateBy='" + updateBy + '\'' +
                ", roles=" + roles +
                '}';
    }

//    public Manager() {
//    }
//
//    public Manager(Long id, @NotEmpty(message = "账号名称不能为空")
//                   @Length(min = 1, max = 20, message = "账号名称长度为1-20") String name,
//                   @NotEmpty(message = "密码不能为空")
//                   @Length(min = 1, max = 100, message = "密码长度为1-100") String password,
//                   String salt, Long createAt, Long createId, String createBy,
//                   Long updateAt, Long updateId, String updateBy, List<Role> roles) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//        this.salt = salt;
//        this.createAt = createAt;
//        this.createId = createId;
//        this.createBy = createBy;
//        this.updateAt = updateAt;
//        this.updateId = updateId;
//        this.updateBy = updateBy;
//        this.roles = roles;
//    }
}