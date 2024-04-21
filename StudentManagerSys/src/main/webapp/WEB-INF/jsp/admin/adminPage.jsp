<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>学员信息管理系统-管理员</title>
    <link rel='stylesheet' type='text/css' href='${path}/dist/css/bootstrap.min.css'/>
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
                        <img src="${path}/img/admin.jpg" class="layui-nav-img">
                        ${admin.admName}
                    </a>
                    <input type="hidden" id="nowNum" value="${admin.admNum}">
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
                    <li class="layui-nav-item layui-bg-cyan">
                        <a href="#">学生管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="#" id="findstu">&nbsp<i class="layui-icon">&#xe615;</i>&nbsp查看学生</a></dd>
                            <dd><a href="#" id="addstu">&nbsp<i class="layui-icon">&#xe654;</i>&nbsp添加学生</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item layui-bg-cyan">
                        <a class="" href="#">教师管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="#" id="alltea">&nbsp<i class="layui-icon">&#xe615;</i>&nbsp查看教师</a></dd>
                            <dd><a href="#" id="addtea">&nbsp<i class="layui-icon">&#xe654;</i>&nbsp添加教师</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item layui-bg-cyan">
                        <a href="#">班级管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="#" id="allclass">&nbsp<i class="layui-icon">&#xe615;</i>&nbsp查询班级</a></dd>
                            <dd><a href="#" id="addclass">&nbsp<i class="layui-icon">&#xe654;</i>&nbsp添加班级</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item layui-bg-cyan">
                        <a href="#">课程管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="#" id="allcou">&nbsp<i class="layui-icon">&#xe615;</i>&nbsp查看课程</a></dd>
                            <dd><a href="#" id="addcou">&nbsp<i class="layui-icon">&#xe654;</i>&nbsp添加课程</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item layui-bg-cyan"><a><i class="layui-icon">&#xe609;</i>&nbsp敬请期待</a></li>
                </ul>
            </div>
        </div>

        <div class="layui-body" id="content">

            <!-- 内容主体区域 -->
            <%--<div style="padding: 15px;">内容主体区域</div>--%>
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
    <script src="${path}/myjs/adminjs.js" charset="utf-8"></script>
    <script>
        //点击修改密码
        $(function () {
            $("#changePsw").click(function () {
                var nowNum = $("#nowNum").val();
                layer.load(0, {shade: false});
                $("#content").load("${path}/index/changeAdmPswPage.action",{"nowNum":nowNum},function(){
                    layer.closeAll();
                    });
                });
            });

        //点击添加课程
        $(function () {
            $("#addcou").click(function () {
                layer.load(0, {shade: false});
                $("#content").load("${path}/index/loadAddCourses.action",function(){
                    layer.closeAll();
                });
            });
        });

        //点击查看课程
        $(function () {
            $("#allcou").click(function () {
                layer.load(0, {shade: false});
                $("#content").load("${path}/index/allcou.action",function(){
                    layer.closeAll();
                });
            });
        });

        //点击添加班级
        $(function () {
            $("#addclass").click(function () {
                layer.load(0, {shade: false});
                $("#content").load("${path}/index/loadAddClassPage.action",function(){
                    layer.closeAll();
                });
            });
        });

        //点击查询班级
        $(function () {
            $("#allclass").click(function () {
                layer.load(0, {shade: false});
                $("#content").load("${path}/index/allcla.action",function(){
                    layer.closeAll();
                });
            });
        });

        //点击添加教师
        $(function () {
            $("#addtea").click(function () {
                layer.load(0, {shade: false});
                $("#content").load("${path}/index/loadregtpage.action",function(){
                    layer.closeAll();
                });
            });
        });

        //点击查看教师
        $(function () {
            $("#alltea").click(function () {
                layer.load(0, {shade: false});
                $("#content").load("${path}/index/alltea.action",function(){
                    layer.closeAll();
                });
            });
        });

        //点击添加学生
        $(function () {
            $("#addstu").click(function () {
                layer.load(0, {shade: false});
                $("#content").load("${path}/index/adds.action",function(){
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
