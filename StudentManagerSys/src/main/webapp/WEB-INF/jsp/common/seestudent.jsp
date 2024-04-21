<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin-top:15px; margin-left: 15px">
    <div style="margin-top:15px; margin-left: 15px;">
        <fieldset class="layui-elem-field layui-field-title">
            <legend>学生信息/成绩</legend>
        </fieldset>
        <!--学生信息-->
        <div  class="col-md-12" style="margin-left: 250px;">
            <form action="" method="post">
                <div class="input-group col-md-6">
                    <p class="col-md-2">学号:</p>
                    <div class="col-md-4">
                        <input name="stuNum" id="stuNum" value="${nowStu.stuNum}" disabled="disabled" type="text" class="form-control">
                    </div>
                </div>
                <br>
                <div class="input-group col-md-6">
                    <p class="col-md-2">姓名:</p>
                    <div class="col-md-4">
                        <input name="stuName" id="stuName" value="${nowStu.stuName}" type="text" class="form-control">
                    </div>
                </div>
                <br>
                <div class="input-group col-md-6">
                    <p class="col-md-2">密码:</p>
                    <div class="col-md-4">
                        <input name="stuPsw" id="stuPsw" value="${nowStu.stuPsw}" type="text" class="form-control">
                    </div>
                </div>
                <br>
                <div class="input-group col-md-6">
                    <p class="col-md-2">性别:</p>
                    <div class="col-md-4">
                        <input name="Sex" id="Sex" value="${nowStu.sex}" type="text" class="form-control">
                    </div>
                </div>
                <br>
                <div class="input-group col-md-6">
                    <p class="col-md-2">联系电话:</p>
                    <div class="col-md-4">
                        <input name="stuPhone" id="stuPhone" value="${nowStu.stuPhone}" type="text" class="form-control">
                    </div>
                </div>
                <br>
                <div class="input-group col-md-6">
                    <p class="col-md-2">地址:</p>
                    <div class="col-md-4">
                        <input name="stuAddress" id="stuAddress" value="${nowStu.stuAddress}" type="text" class="form-control">
                    </div>
                </div>
                <br>
                <div class="input-group col-md-6">
                    <p class="col-md-2">备注:</p>
                    <div class="col-md-4">
                        <input name="stuElse" id="stuElse" value="${nowStu.stuElse}" type="text" class="form-control">
                    </div>
                </div>
                <br>
            </form>
            <div class="btn-group">
                <button id="subStu" type="button" class="btn btn-default" style="margin-left: 150px;">保存修改</button>
            </div>
        </div>
        <br><br><br>
        <!--选课信息-->
        <div  class="col-md-12" style="margin-left: 250px;">
            <div style="width: 50%;">
                <table class="table table-bordered table-hover">
                    <caption>选课详情:</caption>
                    <thead>
                    <tr>
                        <th>学号</th>
                        <th>课程名</th>
                        <th>成绩</th>
                    </tr>
                    </thead>
                    <tbody id="ctb">
                    <c:forEach items="${sclist}" var="sc">
                        <tr>
                            <td>${sc.stuNum}</td>
                            <td>${sc.couName}</td>
                            <td><input value="${sc.scScore}" onkeyup="value=value.replace(/[^\d]/g,'')"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="btn-group">
                    <button id="subCou" type="button" class="btn btn-default" style="margin-left: 150px;">保存修改</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    //点击保存修改的选课信息
    $(function () {
        $("#subCou").click(function () {
            layer.confirm('保存修改?', {
                btn: ['确定','取消'] //按钮
            }, function(){
                var tb = document.getElementById("ctb");
                var rows = tb.rows;
                var sNum = $("#stuNum").val();
                var coumsg = sNum+",";
                for(var i = 0; i<rows.length; i++ ){
                    coumsg=coumsg+(rows[i].cells[1].innerHTML)+","+(rows[i].cells[2].firstChild.value)+",";
                }
                $("#content").load("${path}/index/baocunsco.action",{"coumsg":coumsg},function(){
                    layer.closeAll();
                });
            });
        });
    });

    //点击保存修改学生信息
    $(function () {
        $("#subStu").click(function () {
            if($("#stuName").val()==""||$("#stuPsw").val()==""||$("#Sex").val()==""||$("#stuPhone").val()=="" ||$("#stuAddress").val()==""){
                layer.msg('请填写完整信息!');
            }else{
                var sNum = $("#stuNum").val();
                var sName = $("#stuName").val();
                var sPsw = $("#stuPsw").val();
                var sPhone = $("#stuPhone").val();
                var sSex = $("#Sex").val();
                var sAddress = $("#stuAddress").val();
                var sElse = $("#stuElse").val();
                layer.confirm('保存修改?', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    $("#content").load("${path}/index/baocun.action",{"stuNum":sNum,"stuName":sName,"stuPsw":sPsw,"Sex":sSex,"stuPhone":sPhone,"stuAddress":sAddress,"stuElse":sElse},function(){
                        layer.closeAll();
                    });
                });
            }
        });
    });
</script>

