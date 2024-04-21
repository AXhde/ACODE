<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin-top:15px; margin-left: 350px">
    <h3>&nbsp;我的信息</h3>
    <br>
    <form class="layui-form layui-form-pane" method="post" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">学号:</label>
            <div class="layui-input-inline">
                <input name="stuNum" id="stuNum" value="${mymsg.stuNum}" disabled="disabled" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">姓名:</label>
            <div class="layui-input-inline">
                <input name="stuName" id="stuName" value="${mymsg.stuName}" class="layui-input" type="text" placeholder="请输入姓名">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别:</label>
            <div class="layui-input-inline">
                <input name="Sex" id="Sex" value="${mymsg.sex}" type="text" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">联系电话:</label>
            <div class="layui-input-inline">
                <input name="stuPhone" id="stuPhone" value="${mymsg.stuPhone}" placeholder="请输入电话号码" class="layui-input" onkeyup="value=value.replace(/[^\d]/g,'')">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">入学时间:</label>
                    <div class="layui-input-inline">
                        <input name="createDate" id="createDate" value="${mymsg.createDate}" class="layui-input"  type="text" placeholder="yyyy-MM-dd">
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-inline" style="width: 300px;">
                <input name="stuAddress" id="stuAddress" value="${mymsg.stuAddress}" class="layui-input" type="text" placeholder="请输入地址">
            </div>
        </div>
    </form>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-normal" id="savechange">保存修改</button>
        <button class="layui-btn layui-btn-normal" id="return">返回首页</button>
    </div>
</div>
<script>

    //点击保存修改
    $(function () {
        $("#savechange").click(function () {
            var stuNum = $("#stuNum").val();
            var stuName = $("#stuName").val();
            var sex = $("#Sex").val();
            var stuPhone = $("#stuPhone").val();
            var createDate = $("#createDate").val();
            var stuAddress = $("#stuAddress").val();
            if(stuName==""||sex==""||stuPhone==""||createDate==""||stuAddress==""){
                layer.msg("请输入完整信息");
            }else if(!((sex=="男")||(sex=="女"))){
                layer.msg("性别输入有误,请输入 男 或 女");
            }else{
                layer.confirm('确定修改?', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    layer.load(0, {shade: false});
                    $("#content").load("${path}/Student/savemsg.action",{"stuNum":stuNum,"stuName":stuName,"sex":sex,
                        "stuPhone":stuPhone,"createDate":createDate,"stuAddress":stuAddress},function(){
                        layer.closeAll();
                    });
                });
            }
        });
    });

    //点击返回首页
    $(function () {
        $("#return").click(function () {
            layer.load(0, {shade: false});
            $("#content").load("/StudentManagerSys/index/index.action",function(){
                layer.closeAll();
            });
        });
    });

    //layer组件 START
    layui.use(['layer', 'form', 'element','laydate'], function(){
        var layer = layui.layer;
        var form = layui.form;
        var element = layui.element;
        form.render();
        var laydate = layui.laydate;
        laydate.render({
            elem: '#createDate'
        });
    });

</script>



