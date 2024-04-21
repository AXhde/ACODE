<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin-top:15px; margin-left: 15px">
    <div style="margin-top:30px; margin-left: 15px">
        <div style="width: 50%;margin: auto">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                <legend>修改密码</legend>
            </fieldset>
            <form class="layui-form layui-form-pane" method="post">
                <input type="hidden" id="admNum" value="${nowAdm.admNum}">
                <div class="layui-form-item">
                    <label class="layui-form-label">新的密码:</label>
                    <div class="layui-input-inline">
                        <input name="clsName" id="newPsw1" class="layui-input" type="password" placeholder="请输入新密码" autocomplete="off">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码:</label>
                    <div class="layui-input-inline">
                        <input name="stuPsw" id="newPsw2" class="layui-input" type="password" placeholder="确认新密码" autocomplete="off">
                    </div>
                </div>

            </form>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-normal" id="changeSave">确定修改</button>
            </div>
        </div>
    </div>
</div>
<script>
    //确认修改密码
    $(function () {
        $("#changeSave").click(function () {
            var admNum = $("#admNum").val();
            var newPsw1 = $("#newPsw1").val();
            var newPsw2 = $("#newPsw2").val();
            if(newPsw1==""||newPsw2==""){
                layer.msg("密码不能为空!");
            }else if(newPsw1!=newPsw2){
                layer.msg("两次输入不一样");
            }else{
                layer.confirm('确定修改?', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    layer.load(0, {shade: false});
                    $("#content").load("${path}/index/saveChangeAdmPsw.action",{"admNum":admNum,"newPsw":newPsw1},function(){
                        layer.closeAll();
                    });
                });
            }
        });
    });

    layui.use(['layer', 'form', 'element'], function(){
        var layer = layui.layer;
        var form = layui.form;
        var element = layui.element;
        form.render();
    });
</script>



