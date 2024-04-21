<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${path}/media/css/jquery.dataTables.min.css" media="all">
<div style="margin-top:15px; margin-left: 15px">
    <h3>&nbsp;我的选课/成绩</h3>
    <br>
    <table class="layui-table" id="coursestbl" lay-skin="line" style="width: 95%;">
        <thead>
        <tr>
            <th>序号</th>
            <th>学号</th>
            <th>课程名</th>
            <th>成绩</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allScore}" var="sco" varStatus="status">
            <tr>
                <th>${status.index+1}</th>
                <th>${sco.stuNum}</th>
                <th>${sco.couName}</th>
                <th>${sco.scScore}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="layui-form-item" style="margin-left: 480px;">
        <button id="goselect" class="layui-btn layui-btn-normal">去选课<i class="layui-icon">&#xe623;</i></button>
    </div>
</div>
<script src="${path}/media/js/jquery.dataTables.min.js"></script>
<script>

    //点开始选课
    $(function () {
        $("#goselect").click(function () {
            var nowNum = $("#nowNum").val();
            layer.load(0, {shade: false});
            $("#content").load("${path}/Student/loadSelectCouPage.action",{"nowNum":nowNum},function(){
                layer.closeAll();
            });
        });
    });
    //DataTables分页
    $(document).ready(function(){
        $('#coursestbl').DataTable({
            "paging":true,
            "lengthChange":true,
            "searching":false,
            "ordering":false,
            "info":true,
            "autoWidth":true,
            "oLanguage":{
                "sLengthMenu":"每页显示_MENU_条",
                "sZeroRecords":"抱歉,没有找到!",
                "sInfo":"从_START_到_END_ / 共_TOTAL_条",
                "sInfoFiltered":"(从_MAX_条数据中检索)",
                "oPaginate":{
                    "sFirst":"首页",
                    "sPrevious":"上一页",
                    "sNext":"下一页",
                    "sLast":"尾页"
                }
            }
        });
    });
</script>


