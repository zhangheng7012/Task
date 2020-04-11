package com.dxz.admin.controller;

import com.dxz.admin.dao.ManagerMapper;
import com.dxz.admin.pojo.Manager;
import com.dxz.admin.pojo.Role;
import com.dxz.admin.result.CodeInfo;
import com.dxz.admin.result.Result;
import com.dxz.admin.service.ManagerService;
import com.dxz.admin.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@Validated
public class ManagerController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ManagerService managerService;
    @Resource
    private ManagerMapper managerMapper;
    @Autowired
    private RoleService roleService;

    // Long id,String name,Long minCreateAt,Long maxCreateAt
    @GetMapping("/a/u/manager/list/search")
    public Result findManagerListSearch(@Valid Manager manager,
                                        @RequestParam(required = false,
                                                defaultValue = "1",value = "pageNumber") Integer pageNumber,
                                        @RequestParam(required = false,
                                                defaultValue = "10",value = "pageSize") Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Manager> managers = null;
        try {
            managers = managerService.findManagerListSearch(manager);
            if(managers.size() == 0){
                log.info("无符合条件的账号");
                return new Result(CodeInfo.MANAGER_FIND_NULL.getCode(),CodeInfo.MANAGER_FIND_NULL.getMsg());
            }
        }catch (Exception e){
            log.error("账户列表获取失败：{}",e.getMessage());
            return new Result(CodeInfo.MANAGER_LIST_GET_FAIL.getCode(),CodeInfo.MANAGER_LIST_GET_FAIL.getMsg());
        }
        PageInfo<Manager> pageInfo = new PageInfo<Manager>(managers);
        return new Result(CodeInfo.SUCCESS.getCode(),CodeInfo.SUCCESS.getMsg(),pageInfo);
    }

    @GetMapping("/a/u/manager")
    public Result toAddManager() {
        List<Role> roles = roleService.listRolesByNull();
        if(roles.size() == 0){
            log.info("角色列表获取失败");
            return new Result(CodeInfo.ROLE_LIST_GET_FAIL.getCode(),CodeInfo.ROLE_LIST_GET_FAIL.getMsg());
        }
        return new Result(CodeInfo.SUCCESS.getCode(),CodeInfo.SUCCESS.getMsg(),roles);
    }

    // String name,String password, Long createId, List<Long> roleIdList
    @PostMapping("/a/u/manager")
    public Result addManager(@NotEmpty(message = "账号名称不能为空")
                             @Length(min = 1, max = 20, message = "账号名称长度为1-20") String name,
                             @NotEmpty(message = "密码不能为空")
                             @Length(min = 1, max = 100, message = "密码长度为1-100") String password,
                             @NotNull(message = "创建人id不能为空") Long createId, Long roleId){
        Manager manager = new Manager();
        manager.setPassword(password);
        manager.setName(name);
        manager.setCreateId(createId);
        // 查看名称是否重复
        if(managerService.findManagerByName(name) != null) {
            log.error("账号名称重复：{}", name);
            return new Result(CodeInfo.MANAGER_NAME_GET.getCode(), CodeInfo.MANAGER_NAME_GET.getMsg());
        }else {
            // 插入账号数据
            Long addManagerId = managerService.addManager(manager);
            if(addManagerId == null){
                log.error("账号插入失败");
                return new Result(CodeInfo.MANAGER_INSTER_FAIL.getCode(), CodeInfo.MANAGER_INSTER_FAIL.getMsg());
            }
            // 插入账号-角色关系数据
            Long managerRoleId = managerService.addManagerRole(addManagerId, createId, roleId);
            if(managerRoleId == null){
                log.error("插入账号-角色关系数据为空");
            }
            return new Result(CodeInfo.SUCCESS.getCode(), CodeInfo.SUCCESS.getMsg());
        }
    }

    @DeleteMapping(value = {"/a/u/manager/{id}","/a/u/manager/"})
    public Result deleteManager(@NotNull(message = "账号id不能为空") @PathVariable(value = "id",required = false) Long id){
        Boolean a = managerService.deleteManager(id);
        if(a) {
            log.info("账号 {} 删除成功", id);
            return new Result(CodeInfo.SUCCESS.getCode(), CodeInfo.SUCCESS.getMsg());
        }else {
            log.error("账号 {} 删除失败", id);
            return new Result(CodeInfo.MANAGER_DELETE_FAIL.getCode(), CodeInfo.MANAGER_DELETE_FAIL.getMsg());
        }
    }

    @GetMapping(value = {"/a/u/manager/{id}","/a/u/manager/"})
    public Result editManager(@NotNull(message = "账号id不能为空") @PathVariable(value = "id",required = false) Long id){
        Map<String,Object> map = new HashMap<>();
        Manager manager = managerMapper.selectByPrimaryKey(id);
        if(manager == null) {
            log.info("账号 {} 不存在", id);
            return new Result(CodeInfo.MANAGER_NULL_FAIL.getCode(), CodeInfo.MANAGER_NULL_FAIL.getMsg());
        }else {
            List<Role> roles = roleService.listRolesById(id);
            manager.setRoles(roles);
            log.info("账号 {} 查询成功", id);

            List<Role> rolesList = roleService.listRolesByNull();
            log.info("角色列表查询成功，长度：{}", rolesList.size());

            map.put("manager", manager);
            map.put("roles", rolesList);

            if(roles.size() == 0 && rolesList.size() == 0){
                log.error("账号 {} 信息获取失败", id );
                return new Result(CodeInfo.ROLE_LIST_GET_FAIL.getCode(), CodeInfo.ROLE_LIST_GET_FAIL.getMsg());
            }
            return new Result(CodeInfo.SUCCESS.getCode(), CodeInfo.SUCCESS.getMsg(), map);
        }
    }

    // Long id,String name,Long updateId,Long roleId
    @PutMapping(value = {"/a/u/manager/{id}","/a/u/manager/"})
    public Result updateManager(@NotNull(message = "账号id不能为空") @PathVariable(value = "id",required = false) Long id,
                                @NotEmpty(message = "账号名称不能为空") String name, Manager manager){
        manager.setName(name);
        manager.setId(id);
        Boolean a = managerService.updateManager(manager, manager.getRoleId());
        if (a) {
            log.info("账号 {} 编辑成功", manager.getId());
            return new Result(CodeInfo.SUCCESS.getCode(), CodeInfo.SUCCESS.getMsg());
        } else {
            log.error("账号 {} 编辑失败", manager.getId());
            return new Result(CodeInfo.MANAGER_UPDATE_FAIL.getCode(), CodeInfo.MANAGER_UPDATE_FAIL.getMsg());
        }

    }
}
