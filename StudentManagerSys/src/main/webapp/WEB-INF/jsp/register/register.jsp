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
    <div style="width: 50%;margin: auto">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>学员信息管理系统-学生注册</legend>
        </fieldset>
        <form class="layui-form layui-form-pane" method="post" action="${path}/index/register.action">
                <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input name="stuName" id="stuName" class="layui-input" type="text" placeholder="请输入">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <input name="stuPsw" id="stuPsw" class="layui-input" type="password" placeholder="请输入密码" autocomplete="off">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">班级</label>
                <div class="layui-input-inline">
                    <select name="clsName" id="clsName">
                        <option value="-1">请选择</option>
                        <c:forEach items="${classlist}" var="stuclass">
                            <option value="${stuclass.clsName}">${stuclass.clsName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block">
                    <input type="radio" name="Sex" value="男" title="男">
                    <input type="radio" name="Sex" value="女" title="女" checked>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">联系电话</label>
                <div class="layui-input-inline">
                    <input name="stuPhone" id="stuPhone" placeholder="请输入电话号码" class="layui-input" onkeyup="value=value.replace(/[^\d]/g,'')">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">入学时间</label>
                        <div class="layui-input-inline">
                            <input name="createDate" id="createDate" class="layui-input" type="text" placeholder="yyyy-MM-dd">
                        </div>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">地址</label>
                <div class="layui-input-block">
                    <input name="stuAddress" id="stuAddress" class="layui-input" type="text" placeholder="请输入地址" autocomplete="off">
                </div>
            </div>
        </form>
        <div class="layui-form-item">
            <button class="layui-btn layui-btn-normal" id="register">注册</button>
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
    //layer组件 START
    layui.use(['layer', 'form', 'element'], function(){
        var layer = layui.layer
            ,form = layui.form
            ,element = layui.element
    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
            elem: '#createDate'
        });
    });
    //layer组件 END

    //点击注册 判断必填项 为TRUE则提交表单
    $(function () {
        $("#register").click(function () {
            if($("#stuName").val()==""||$("#stuPsw").val()==""||$("#clsName").val()=="-1"
                ||$("#stuPhone").val()=="" ||$("#createDate").val()==""||$("#stuAddress").val()==""){
                layer.msg('请填写完整信息!');
            }else{
                //验证通过,提交表单
                $("form").submit();
            }
        });
    })

    //返回登录界面
    $(function () {
        $("#return").click(function () {
            window.location.href="${path}/load/logout.action";
        });
    });
</script>
</body>
</html>
