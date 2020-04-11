package com.dxz.admin.shiro;

import com.dxz.admin.pojo.Manager;
import com.dxz.admin.service.ManagerService;
import com.dxz.admin.service.PermissionService;
import com.dxz.admin.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Set;


public class MyShiroRealm extends AuthorizingRealm {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ManagerService managerService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Session session = SecurityUtils.getSubject().getSession();

        Manager manager= (Manager) session.getAttribute("MANAGER_SESSION");
        // 账号的角色集合
        Set<String> roles = roleService.findRoleNameByManagerName(manager.getName());
        log.info("账号{}：角色有：{}",manager.getName(),roles);
        authorizationInfo.setRoles(roles);
        // 账号的权限集合
        Set<String> pers= permissionService.listPermissionNames(manager.getName());
        authorizationInfo.setStringPermissions(pers);
        log.info("账号{}：权限有：{}",manager.getName(),pers);
        return authorizationInfo;
    }

    // 主要是用来进行身份认证的，也就是说验证输入的账号和密码是否正确。
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取输入的账号.
        String managerName = (String) token.getPrincipal();

        //通过managerName从数据库中查找manager对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        Manager manager = managerService.findManagerByName(managerName);
        log.info("认证的账号名称：{}",manager.getName());

        if (manager == null) {
            log.info("该账号不存在：{}",managerName);
            return null;
        }
        // 密码
        String credentials = manager.getPassword();
        // 账号名称为盐
        ByteSource credentialsSalt = ByteSource.Util.bytes(manager.getName());
        // 新建账号，仅有id、名称，用于缓存
        Manager newManager = new Manager();
        newManager.setId(manager.getId());
        newManager.setName(manager.getName());

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                manager.getName(), //账号名
                newManager, //新建账号，仅有id、名称
                credentials, //密码
                credentialsSalt,//账号名称为盐
                getName()  //realm name
        );
        Session session = SecurityUtils.getSubject().getSession();

        //修改session的过期时间为 12小时，单位为毫秒 12*60*60*1000L
        SecurityUtils.getSubject().getSession().setTimeout(12*60*60*1000L);

        session.setAttribute("MANAGER_SESSION", newManager);
        return authenticationInfo;
    }
}
