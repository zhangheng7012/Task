<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>手机注册</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap-datetimepicker.min.css" />
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>

    <style type="text/css">
        #register {
            width: 450px;
            height: 100px;
            margin: 50px auto;
        }

        #btn {
            margin-left: 197px;
            margin-top: -24px;
            width: 120px;
            height: 25px;
            font-size: 14px;
            color: #7904c9
        }

        body {
            background-color: #ecfcf9;
        }
    </style>


    <script type="text/javascript">

        $(function(){
            $("#btn").click(function(){
                    if($("#tel").val()){
                        $.ajax({
                            type:"POST",
                            url :"getTelCode",
                            data:{
                                tel:$("#tel").val(),
                            },
                            success:function(data){
                                alert("验证码发送成功，请注意查收。");
                            },
                        })
                    }else{
                        alert("手机验证发送失败");
                    }
                }
            );
        });

    </script>
</head>
<body>

<p style="color:red">${msg}</p><hr>

<div class="container">
    <div id="register">
        <form class="form-horizontal" id="RegistForm" method="post" action="register1" enctype="multipart/form-data">
            <fieldset>
                <div id="legend" class="">
                    <legend class="">用户注册</legend>
                </div>
                <div class="form-group">
                    <!-- Text input-->
                    <label class="col-sm-2 control-label">账号</label>
                    <div class="col-sm-6">
                        <input type="text" placeholder="请输入账号..." class="form-control"
                               name="name" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-6">
                        <input type="password" placeholder="请输入密码..." required
                               class="form-control" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">头像</label>
                    <div class="col-sm-6">
                        <input type="file" placeholder="请上传头像..." class="form-control"
                               id="multipartFile" name="multipartFile" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">手机</label>
                    <div class="col-sm-6">
                        <input type="text" placeholder="请填写手机号..." class="form-control"
                               id="tel" name="phone" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">验证码</label>
                    <div class="col-sm-6">
                        <input type="text" name="code" id="code" placeholder="请输入手机验证码..."
                               class="form-control" required>
                    </div>
                    <div class="col-sm-5">
                        <input type="button" name="btn"
                               class="btn btn-default" id="btn" value="发送验证码" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <a href="login" class="btn btn-success">返回登录</a>
                        <a href="register2" class="btn btn-success">改为邮箱注册</a>
                        <input class="btn btn-info" type="submit" id="submit" value="手机注册" />
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>