<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>学员信息管理系统-注册</title>
    <link rel='stylesheet' type='text/css' href='${path}/dist/css/bootstrap.min.css'/>
    <link rel='stylesheet' type='text/css' href='${path}/css/revise.css'/>
    <link rel='stylesheet' type='text/css' href='${path}/css/bootstrap-datetimepicker.min.css'/>
    <link href="${path}/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/layui/css/layui.css" media="all">
</head>
<body>
    <div style="width: 50%;margin: auto;margin-top: 100px">
        <ul class="layui-timeline">
            <li class="layui-timeline-item">
                <i class="layui-icon layui-timeline-axis"></i>
                <div class="layui-timeline-content layui-text">
                    <h1 class="layui-timeline-title">注册成功<i class="layui-icon" style="font-size: 30px; color: deepskyblue;">&#x1005;</i>  </h1>
                    <p>
                        <h2>你的学号是:${NewStuNum}</h2><br>
                        <h3>请牢记你的学号</h3><br>
                        <h3>遗忘请联系管理员!</h3>
                        <i class="layui-icon"></i>
                    </p>
                </div>
            </li>
        </ul>
        <div class="layui-form-item" style="margin-left: 40px">
            <button class="layui-btn layui-btn-normal" id="return">返回登陆</button>
        </div>
    </div>
<script src="${path}/dist/js/jquery.min.js"></script>
<script src='${path}/dist/js/bootstrap.min.js'></script>
<script src="${path}/dist/js/bootstrap-modal.js"></script>
<script src="${path}/js/layer/layer.js"></script>
<script src="${path}/dist/js/bootstrap-datetimepicker.min.js"></script>
<script src="${path}/layui/layui.js" charset="utf-8"></script>
<script>
    //返回登录界面
    $(function () {
        $("#return").click(function () {
            window.location.href="${path}/load/logout.action";
        });
    });
</script>
</body>
</html>
