<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin-top:15px; margin-left: 15px">
    <div style="margin-top:30px; margin-left: 15px">
        <div style="width: 50%;margin: auto">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                <legend>学员信息管理系统-添加教师</legend>
            </fieldset>
            <form class="layui-form layui-form-pane" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">教师姓名</label>
                    <div class="layui-input-inline">
                        <input name="teaName" id="teaName" class="layui-input" type="text" placeholder="请输入姓名" autocomplete="off">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">联系电话</label>
                    <div class="layui-input-inline">
                        <input name="teaPhone" id="teaPhone" placeholder="请输入电话号码" class="layui-input" onkeyup="value=value.replace(/[^\d]/g,'')">
                    </div>
                </div>
            </form>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-normal" id="savestu">添加</button>
                <button class="layui-btn layui-btn-normal" id="returnalltea">返回</button>
            </div>
        </div>
    </div>
</div>
<script>
    //点击保存修改 保存修改的教师信息
    $(function () {
        $("#savestu").click(function () {
            if($("#teaName").val()==""||$("#teaPhone").val()==""){
                layer.msg('请填写完整信息!');
            }else{
                var tName = $("#teaName").val();
                var tPhone = $("#teaPhone").val();
                layer.confirm('确定添加?', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    $("#content").load("${path}/index/regtea.action",{"teaName":tName,"teaPhone":tPhone},function(){
                        layer.closeAll();
                    });
                });
            }
        });
    });

    //点击返回全部
    $(function () {
        $("#returnalltea").click(function () {
            layer.load(0, {shade: false});
            $("#content").load("/StudentManagerSys/index/alltea.action",function(){
                layer.closeAll();
            });
        });
    });
</script>



