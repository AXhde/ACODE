<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin-top:15px; margin-left: 15px">
    <div style="margin-top:30px; margin-left: 15px">
        <div style="width: 50%;margin: auto">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                <legend>学员信息管理系统-修改班级信息</legend>
            </fieldset>
            <form class="layui-form layui-form-pane" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">班级编号:</label>
                    <div class="layui-input-inline">
                        <input name="clsNum" id="clsNum" value="${nowclass.clsNum}" disabled="disabled" class="layui-input" type="text">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">班级名:</label>
                    <div class="layui-input-inline">
                        <input name="clsName" id="clsName" value="${nowclass.clsName}" class="layui-input" type="text" placeholder="请输入姓名" autocomplete="off">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">班主任:</label>
                    <div class="layui-input-inline">
                        <select id="teaName">
                            <option value="-1">请选择</option>
                            <c:forEach items="${allt}" var="allt">
                                <option value="${allt.teaName}">${allt.teaName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">所属专业:</label>
                    <div class="layui-input-inline">
                        <input name="department" id="department" value="${nowclass.department}" disabled="disabled" class="layui-input" type="text" autocomplete="off">
                    </div>
                </div>

            </form>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-normal" id="saveclass">保存修改</button>
                <button class="layui-btn layui-btn-normal" id="returnallcla">返回</button>
            </div>
        </div>
    </div>
</div>
<script>
    //点击保存修改 保存修改的教师信息
    $(function () {
        $("#saveclass").click(function () {
            if($("#clsName").val()==""||$("#teaName").val()=="-1"){
                layer.msg('请填写完整信息!');
            }else{
                var cNum = $("#clsNum").val();
                var cName = $("#clsName").val();
                var cteaName = $("#teaName").val();
                var cdepa = $("#department").val();
                layer.confirm('保存修改?', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    $("#content").load("${path}/index/saveclass.action",{"clsNum":cNum,"clsName":cName,"teaName":cteaName,"department":cdepa},function(){
                        layer.closeAll();
                    });
                });
            }
        });
    });

    //点击返回
    $(function () {
        $("#returnallcla").click(function () {
            layer.load(0, {shade: false});
            $("#content").load("/StudentManagerSys/index/allcla.action",function(){
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



