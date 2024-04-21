<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin-top:15px; margin-left: 15px">
    <div style="margin-top:30px; margin-left: 15px">
        <div style="width: 50%;margin: auto">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                <legend>学员信息管理系统-修改课程信息</legend>
            </fieldset>
            <form class="layui-form layui-form-pane" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">课程号:</label>
                    <div class="layui-input-inline">
                        <input name="couNum" id="couNum" value="${nowCourses.couNum}" disabled="disabled" class="layui-input" type="text">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">课程名:</label>
                    <div class="layui-input-inline">
                        <input name="couName" id="couName" value="${nowCourses.couName}" class="layui-input" type="text" placeholder="请输入姓名" autocomplete="off">
                    </div>
                </div>


                <div class="layui-form-item">
                    <label class="layui-form-label">学时:</label>
                    <div class="layui-input-inline">
                        <input name="couhour" id="couhour" value="${nowCourses.couhour}" class="layui-input" type="text" autocomplete="off" onkeyup="value=value.replace(/[^\d]/g,'')">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">授课教师:</label>
                    <div class="layui-input-inline">
                        <select id="teaName">
                            <option value="-1">请选择</option>
                            <c:forEach items="${allt}" var="allt">
                                <option value="${allt.teaName}">${allt.teaName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

            </form>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-normal" id="saveclass">保存修改</button>
                <button class="layui-btn layui-btn-normal" id="returnallcou">返回</button>
            </div>
        </div>
    </div>
</div>
<script>
    //点击保存修改 保存修改的教师信息
    $(function () {
        $("#saveclass").click(function () {
            if($("#couName").val()==""||$("#couhour").val()==""||$("#teaName").val()=="-1"){
                layer.msg('请填写完整信息!');
            }else{
                var couNum = $("#couNum").val();
                var couName = $("#couName").val();
                var couhour = $("#couhour").val();
                var teaName = $("#teaName").val();
                layer.confirm('保存修改?', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    $("#content").load("${path}/index/savecourses.action",{"couNum":couNum,"couName":couName,"couhour":couhour,"teaName":teaName},function(){
                        layer.closeAll();
                    });
                });
            }
        });
    });

    //点击返回
    $(function () {
        $("#returnallcou").click(function () {
            layer.load(0, {shade: false});
            $("#content").load("/StudentManagerSys/index/allcou.action",function(){
                layer.closeAll();
            });
        });
    });

    layui.use(['layer', 'form', 'element'], function(){
        var layer = layui.layer;
        var form = layui.form;
        var element = layui.element;
        form.render();
    });
</script>



