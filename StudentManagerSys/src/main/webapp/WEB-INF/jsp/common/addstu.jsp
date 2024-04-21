<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin-top:15px; margin-left: 15px">
    <div style="width: 50%;margin: auto">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>学员信息管理系统-添加学生</legend>
        </fieldset>
        <form class="layui-form layui-form-pane" method="post">
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
                <div class="layui-input-block" id="wrap">
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
                            <input name="createDate" id="createDate" class="layui-input"  type="text" placeholder="yyyy-MM-dd">
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

            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea name="stuElse" id="stuElse" class="layui-textarea" placeholder="请输入内容"></textarea>
                </div>
            </div>
        </form>
        <div class="layui-form-item">
            <button class="layui-btn layui-btn-normal" id="adds">添加</button>
            <button class="layui-btn layui-btn-normal" id="returnallstu">返回</button>
        </div>
    </div>
</div>

<script>
    //点击添加
    $(function () {
        $("#adds").click(function () {
            if($("#stuName").val()==""||$("#stuPsw").val()==""||$("#clsName").val()=="-1"
                ||$("#stuPhone").val()=="" ||$("#createDate").val()==""||$("#stuAddress").val()==""){
                layer.msg('请填写完整信息!');
            }else{
                var sName = $("#stuName").val();
                var sPsw = $("#stuPsw").val();
                var sClass = $("#clsName").val();
                var sex = $('#wrap input[name="Sex"]:checked ').val();
                var sPhone = $("#stuPhone").val();
                var cDate = $("#createDate").val();
                var sAddress = $("#stuAddress").val();
                var sElse = $("#stuElse").val();
                layer.confirm('确定添加?', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    $("#content").load("${path}/index/addstu.action",{"stuName":sName,"stuPsw":sPsw,"clsName":sClass,"sex":sex,"stuPhone":sPhone,"createDate":cDate,"stuAddress":sAddress,"stuElse":sElse},function(){
                        layer.closeAll();
                    });
                });
            }
        });
    })

    //点击查看学生
    $(function () {
        $("#returnallstu").click(function () {
            layer.load(0, {shade: false});
            $("#content").load("${path}/index/stulist.action",function(){
                layer.closeAll();
            });
        });
    })

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
    //layer组件 END
</script>
