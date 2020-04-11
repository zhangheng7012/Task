package com.dxz.admin.result;

public enum CodeInfo {

    /**
     * @Description: 请求成功
     */
    SUCCESS(1200, "请求成功"),

    /**
     * @Description: 集中的错误类型
     */
    PARAM_VALID_WRONG(7001,"参数校验错误"),

    PHOTO_UP_FAIL(1001, "图片上传失败"),
    PHOTO_NULL(1002, "上传图片为空"),
    PHOTO_SIZE_FAIL(1003, "上传图片过大"),
    PHOTO_TYPE_FAIL(1004, "上传图片类型错误"),
    PHOTO_DELETE_FAIL(1005, "图片删除失败"),
    SOMETHING_WRONG(1006, "未知异常"),

    /**
     * @Description: 课程管理模块
     */
    COURSE_LIST_GET_FAIL(5001,"课程列表获取失败"),
    COURSE_STATUS_UPDATE_FAIL(5002,"课程状态修改失败"),
    COURSE_FIND_NULL(5003,"无符合条件的课程"),
    COURSE_NAME_GET(5004,"课程标题已存在"),
    COURSE_INSTER_FAIL(5005,"课程插入失败"),
    COURSE_DELETE_FAIL(5006,"课程删除失败"),
    COURSE_MSG_GET_FAIL(5007,"课程信息获取失败"),
    COURSE_UPDATE_FAIL(5008,"课程信息编辑失败"),
    COURSE_BANNER_MORE(5009,"banner视频上架数量过多，请任意下架banner视频后再操作"),
    COURSE_BANNER_NULL(5010,"无banner视频"),
    COURSE_CONNECT_INSTER_FAIL(5011,"课程收藏/点赞失败"),
    COURSE_CONNECT_DELETE_FAIL(5012,"课程取消收藏/点赞失败"),
    COURSE_CONNECT_GET(5013,"课程已收藏/点赞"),
    COURSE_STATUS_WRONG(5014,"上架课程，需下架后进行操作"),


    /**
     * @Description: 用户管理模块
     */
    USER_LIST_GET_FAIL(4001,"用户列表获取失败"),
    USER_STATUS_UPDATE_FAIL(4002,"用户状态修改失败"),
    USER_FIND_NULL(4003,"无符合条件的用户"),
    USER_MSG_GET_FAIL(4004,"用户信息获取失败"),
    USER_UPDATE_FAIL(4005,"用户信息编辑失败"),
    USER_CODE_TIMES(4006,"短时间验证次数过多"),
    USER_PHONE_CODE_GET_FAIL(4007,"获取手机验证码失败"),
    USER_EMAIL_CODE_GET_FAIL(4008,"获取邮箱验证码失败"),
    USER_PHONE_BIND_FAIL(4009,"手机绑定失败"),
    USER_EMAIL_BIND_FAIL(4010,"邮箱绑定失败"),
    USER_CODE_FAIL(4011,"验证码异常"),
    USER_NAME_GET(4012,"用户已存在"),
    USER_INSTER_FAIL(4013,"用户插入失败"),
    USER_DELETE_FAIL(4014,"用户删除失败"),
    USER_SIGN_FAIL(4015,"签到失败"),
    USER_TODAY_SIGN(4016,"签到失败，今日已签到"),
    USER_NOT_TEACHER(4017,"该用户不是老师，无法删除"),
    USER_STATUS_FAIL(4018,"用户已被冻结，请联系管理员"),
    USER_TEACHER_NOT_DEL(4019,"老师名下有课程，无法删除"),
    USER_NOT_LOGIN(4020,"用户未登录"),

    /**
     * @Description: 角色管理模块
     */
    ROLE_LIST_GET_FAIL(3001,"角色列表获取失败"),
    ROLE_NAME_GET(3002,"角色名已存在"),
    ROLE_INSTER_FAIL(3003,"角色插入失败"),
    ROLE_DELETE_FAIL(3004,"角色删除失败"),
    ROLE_NULL_FAIL(3005,"该角色不存在"),
    ROLE_MSG_GET_FAIL(3006,"角色信息获取失败"),
    ROLE_UPDATE_FAIL(3007,"角色编辑失败"),
    PERMISSION_LIST_GET_FAIL(3008,"权限列表获取失败"),
    ROLE_NOT_DELETE(3009,"角色绑定有账号，无法删除"),

    /**
     * @Description: 账户管理模块
     */
    MANAGER_LOGIN_SUCCESS(1200,"账号登录成功"),
    MANAGER_LOGOUT(1200,"账号退出登录成功"),
    MANAGER_PASSWORD_FAIL(2001,"登录失败，密码错误！"),
    MANAGER_LOGIN_FAIL(2002,"登录失败，该账户已被冻结"),
    MANAGER_NULL_FAIL(2003,"该账户不存在"),
    MANAGER_NOT_LOGIN(2004,"账号未登录"),
    MANAGER_UNAUTHORIZED(2005,"账号未授权"),
    MANAGER_INSTER_FAIL(2006,"账户插入失败"),
    MANAGER_NAME_GET(2007,"账户名已存在"),
    MANAGER_LIST_GET_FAIL(2008,"账户列表获取失败"),
    MANAGER_DELETE_FAIL(2009,"账户删除失败"),
    MANAGER_UPDATE_FAIL(2010,"账户编辑失败"),
    MANAGER_MSG_GET_FAIL(2011,"账户信息获取失败"),
    MANAGER_FIND_NULL(2012,"无符合条件的账号");


    private int code;
    private String msg;

    private CodeInfo(int code,String msg) {
        this.setCode(code);
        this.setMsg(msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "[" + this.code + "]" + this.msg;
    }

}
