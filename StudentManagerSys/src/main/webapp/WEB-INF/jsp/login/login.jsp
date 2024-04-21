<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>学员信息管理系统-登陆</title>

    <link rel='stylesheet' type='text/css' href='${path}/dist/css/bootstrap.min.css'/>
    <link rel='stylesheet' type='text/css' href='${path}/css/revise.css'/>
    <link rel='stylesheet' type='text/css' href='${path}/css/bootstrap-datetimepicker.min.css'/>
    <link href="${path}/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/layui/css/layui.css" media="all">
    <%--<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=TgntbCqoSFrZns4pDSDKjvsb2Lxb76eX"></script>--%>
    <script src="${path}/dist/js/jquery.min.js"></script>
    <style type="text/css">
        body{
            background: url("${path}/img/Login_bg.jpg");
            background-size:100%;
            background-repeat:no-repeat;
        }
        .form{
            background: rgba(255,255,255,0.2);width:400px;margin:120px auto;
        }
        /*阴影*/
        .fa{
            display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;
        }
        input[type="text"],input[type="password"]{
            padding-left:26px;
        }
        .checkbox{
            padding-left:21px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <br>
                <br>
                <h3 class="form-title">学员信息管理系统</h3>
                <br>
                <form class='form-horizontal' action="${path}/index/login.action" method="post" role='form'>
                    <div class="col-md-9">
                        <div class="form-group">
                            <i class="fa fa-user fa-lg"></i>
                            <input class="form-control required" type="text" placeholder="Username" id="username" name="username" autofocus="autofocus" maxlength="12"/>
                            <c:if test="${error2!=null}">
                                <span style="color: #ac2925">${error2}</span>
                            </c:if>
                            <c:if test="${error0!=null}">
                                <span style="color: #ac2925">${error0}</span>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <i class="fa fa-lock fa-lg"></i>
                            <input class="form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="8"/>
                            <c:if test="${error3!=null}">
                                <span style="color: #ac2925">${error3}</span>
                            </c:if>
                            <c:if test="${error1!=null}">
                                <span style="color: #ac2925">${error1}</span>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <span class="checkbox">
                                <input type="checkbox" name="remember" value="1"/>管理员
                                <a class="pull-right" id="register">注册</a>
                            </span>
                        </div>
                        <div class="form-group col-md-offset-9">
                            <button type="submit" class="btn btn-success pull-right" name="submit">登录</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
<script src="${path}/dist/js/jquery.min.js"></script>
<script src='${path}/dist/js/bootstrap.min.js'></script>
<script src="${path}/dist/js/bootstrap-modal.js"></script>
<script src="${path}/js/layer/layer.js"></script>
<script src="${path}/dist/js/bootstrap-datetimepicker.min.js"></script>
<script src="${path}/layui/layui.js" charset="utf-8"></script>
<script>
    $(function () {
        $("#register").click(function () {
            window.location.href="${path}/load/register.action";
        });
    });
</script>
</body>
</html>
