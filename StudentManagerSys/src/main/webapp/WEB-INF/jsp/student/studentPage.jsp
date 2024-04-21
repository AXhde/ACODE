<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>学员信息管理系统-管理员</title>

    <link rel='stylesheet' type='text/css' href='${path}/dist/css/bootstrap.min.css'/>
    <link rel='stylesheet' type='text/css' href='${path}/css/revise.css'/>
    <link rel='stylesheet' type='text/css' href='${path}/css/bootstrap-datetimepicker.min.css'/>
    <link rel="stylesheet" href="${path}/layui/css/layui.css" media="all">

    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=TgntbCqoSFrZns4pDSDKjvsb2Lxb76eX"></script>
    <script src="${path}/dist/js/jquery.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header layui-bg-cyan">
        <div class="layui-logo layui-bg-cyan">学员信息管理系统</div>
        <!-- 头部区域 -->
        <ul class="layui-nav layui-layout-left layui-bg-gyan">
            <li class="layui-nav-item"><a href="#" id="index"><i class="layui-icon">&#xe68e;</i>首页</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">关于</a>
                <dl class="layui-nav-child">
                    <dd><a href="#" id="about">关于我们</a></dd>
                    <dd><a href="#" id="version">系统版本</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right layui-bg-cyan">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${path}/img/user.jpg" class="layui-nav-img">
                    ${student.stuName}
                </a>
                <input type="hidden" id="nowNum" value="${student.stuNum}">
                <dl class="layui-nav-child">
                    <dd><a id="changePsw" href="#"><i class="layui-icon">&#xe642;</i>密码修改</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${path}/load/logout.action">安全退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-cyan">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域 -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-bg-cyan"><a id="mymsg"><i class="layui-icon">&#xe63f;</i>&nbsp;信息维护</a></li>
                <li class="layui-nav-item layui-bg-cyan"><a id="showallTea"><i class="layui-icon">&#xe63f;</i>&nbsp;教师信息</a></li>
                <li class="layui-nav-item layui-bg-cyan"><a id="showcou"><i class="layui-icon">&#xe63f;</i>&nbsp;所有课程</a></li>
                <li class="layui-nav-item layui-bg-cyan"><a id="selectcou"><i class="layui-icon">&#xe63f;</i>&nbsp;开始选课</a></li>
                <li class="layui-nav-item layui-bg-cyan"><a id="seescore"><i class="layui-icon">&#xe63f;</i>&nbsp;已选课程</a></li>
                <li class="layui-nav-item layui-bg-cyan"><a><i class="layui-icon">&#xe609;</i>&nbsp;敬请期待</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body" id="content">
        <!-- 内容主体区域 -->
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © www.ahszu.edu.cn - 宿州学院 - 版权所有
    </div>
</div>
<script src="${path}/dist/js/jquery.min.js"></script>
<script src='${path}/dist/js/bootstrap.min.js'></script>
<script src="${path}/dist/js/bootstrap-modal.js"></script>
<script src="${path}/js/layer/layer.js"></script>
<script src="${path}/dist/js/bootstrap-datetimepicker.min.js"></script>
<script src="${path}/layui/layui.js" charset="utf-8"></script>
<script src="${path}/myjs/studentjs.js" charset="utf-8"></script>
<script>

    //点开始选课
    $(function () {
        $("#selectcou").click(function () {
            var nowNum = $("#nowNum").val();
            layer.load(0, {shade: false});
            $("#content").load("${path}/Student/loadSelectCouPage.action",{"nowNum":nowNum},function(){
                layer.closeAll();
            });
        });
    });

    //点击已选课程
    $(function () {
        $("#seescore").click(function () {
            var nowNum = $("#nowNum").val();
            layer.load(0, {shade: false});
            $("#content").load("${path}/Student/showScore.action",{"nowNum":nowNum},function(){
                layer.closeAll();
            });
        });
    });

    //点击查看所有课程
    $(function () {
        $("#showcou").click(function () {
            layer.load(0, {shade: false});
            $("#content").load("${path}/Student/showCourses.action",function(){
                layer.closeAll();
            });
        });
    });

    //点击教师信息
    $(function () {
        $("#showallTea").click(function () {
            layer.load(0, {shade: false});
            $("#content").load("${path}/Student/showtea.action",function(){
                layer.closeAll();
            });
        });
    });

    //点击信息维护,加载个人信息页面
    $(function () {
        $("#mymsg").click(function () {
            var nowNum = $("#nowNum").val();
            layer.load(0, {shade: false});
            $("#content").load("${path}/Student/loadMymsgPage.action",{"nowNum":nowNum},function(){
                layer.closeAll();
            });
        });
    });

    //点击修改密码
    $(function () {
        $("#changePsw").click(function () {
            var nowNum = $("#nowNum").val();
            layer.load(0, {shade: false});
            $("#content").load("${path}/Student/changePswPage.action",{"nowNum":nowNum},function(){
                layer.closeAll();
            });
        });
    });


    layui.use('element', function(){
        var element = layui.element;
    })
</script>
</body>
</html>
