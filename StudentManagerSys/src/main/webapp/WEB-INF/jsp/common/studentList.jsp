<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin-top:15px; margin-left: 15px">
    <h3>&nbsp;查看学生</h3>
    <br>
    <!--条件查询框组 start-->
    <div class="layui-form-item">
        <form class="layui-form" action="#">
            <label class="layui-form-label" style="width: 70px;">学号:</label>
            <div class="layui-input-inline" style="width: 140px;">
                <input id="sNum" class="layui-input" type="text" placeholder="请输入学号">
            </div>

            <label class="layui-form-label" style="width: 70px;">姓名:</label>
            <div class="layui-input-inline" style="width: 140px;">
                <input id="sName" class="layui-input" type="text" placeholder="请输入姓名">
            </div>

            <label class="layui-form-label" style="width: 70px;">班级:</label>
            <div class="layui-input-inline" style="width: 140px;">
                <select id="cName">
                    <option value="-1">全部</option>
                    <c:forEach items="${classlist}" var="stuclass">
                        <option value="${stuclass.clsName}">${stuclass.clsName}</option>
                    </c:forEach>
                </select>
            </div>

            <label class="layui-form-label" style="width: 110px;">入学时间:</label>
            <div class="layui-input-inline" style="width: 140px;">
                <input id="cDate" class="layui-input"  type="text" placeholder="yyyy-MM-dd">
            </div>
        </form>
        <div>
            <button class="layui-btn layui-btn-normal" id="chaxun">查询</button>
        </div>
    </div>
    <!--条件查询框组 end-->

    <div id="stuTable" style="width: 100%;">
        <!--学生详情 -->
        <table class="layui-table" lay-skin="line" style="width: 99%;">
            <colgroup>
                <col width="70">
                <col width="120">
                <col width="100">
                <col width="80">
                <col width="150">
                <col width="150">
                <col width="150">
                <col width="250">
                <col width="250">
                <col width="150">
            </colgroup>
            <thead>
                <tr>
                    <th style="width: 30px;">序号</th>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>班级名</th>
                    <th>联系电话</th>
                    <th>入学时间</th>
                    <th>地址</th>
                    <th>备注</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${stuPage.list}" var="stu" varStatus="status">
                <tr>
                    <th style="text-align: center">${status.index + 1}</th>
                    <th>${stu.stuNum}</th>
                    <th>${stu.stuName}</th>
                    <th>${stu.sex}</th>
                    <th>${stu.clsName}</th>
                    <th>${stu.stuPhone}</th>
                    <th>${stu.createDate}</th>
                    <th>${stu.stuAddress}</th>
                    <th>${stu.stuElse}</th>
                    <td>
                        <a onclick="del(this)" href="javascript:"><i class="layui-icon"  style="font-size: 25px; color: red;">&#xe640;</i></a>
                        <a onclick="see(this)" href="javascript:"><i class="layui-icon" style="font-size: 25px; color: deepskyblue;">&#xe642;</i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <input type="hidden" id="pageNow" value="${stuPage.pageNow}">
    </div>
    <!--翻页按钮组-->
    <div style="width: 99%;">
        <div style="margin-left: 40%;">
            <button class="layui-btn layui-btn-primary" id="last">上一页</button>
            <button class="layui-btn layui-btn-primary" id="next">下一页</button>
        </div>
    </div>
</div>
<script>

    //点击查看
    function see(param) {
        var Num = param.parentNode.parentNode.children[1].innerText;
        $("#content").load("${path}/index/seeOneStu.action",{"Num":Num},function(){
            layer.closeAll();
        });
    }

    function init(){

    }


    //点击删除
    function del(param) {
        var delNum = param.parentNode.parentNode.children[1].innerText;
        layer.confirm('确定删除?', {
            btn: ['删除','取消'] //按钮
        }, function(){
            $("#content").load("${path}/index/delStuByNum.action",{"delNum":delNum},function(){
                layer.closeAll();
            });
        });
    }

    //点击查询
    $(function () {
        $("#chaxun").click(function () {
            var stuNum = $("#sNum").val();
            var stuName = $("#sName").val();
            var clsName = $("#cName").val();
            var createDate = $("#cDate").val();
            $("#stuTable").load("${path}/index/chaxun.action",{"stuNum":stuNum,"stuName":stuName,"clsName":clsName,"createDate":createDate},function(){
                layer.closeAll();
            })
        });
    });

    //点击上一页
    $(function () {
        $("#last").click(function () {
            var stuNum = $("#sNum").val();
            var stuName = $("#sName").val();
            var clsName = $("#cName").val();
            var createDate = $("#cDate").val();
            var pagenow = ($("#pageNow").val())*1-1;
            layer.load(0, {shade: false});
            $("#stuTable").load("${path}/index/runPage.action",{"pagenow":pagenow,"stuNum":stuNum,"stuName":stuName,"clsName":clsName,"createDate":createDate},function(){
                layer.closeAll();
            })
        });
    });

    //点击下一页
    $(function () {
        $("#next").click(function () {
            var stuNum = $("#sNum").val();
            var stuName = $("#sName").val();
            var clsName = $("#cName").val();
            var createDate = $("#cDate").val();
            var pagenow = ($("#pageNow").val())*1+1;
            layer.load(0, {shade: false});
            $("#stuTable").load("/StudentManagerSys/index/runPage.action",{"pagenow":pagenow,"stuNum":stuNum,"stuName":stuName,"clsName":clsName,"createDate":createDate},function(){
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
            elem: '#cDate'
        });
    });
</script>



