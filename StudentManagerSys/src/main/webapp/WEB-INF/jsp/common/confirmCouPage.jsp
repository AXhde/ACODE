<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${path}/media/css/jquery.dataTables.min.css" media="all">
<div style="margin-top:15px; margin-left: 15px">
    <h3>&nbsp;确认已经选课程</h3>
    <br>
    <table class="layui-table" id="coursestbl" lay-skin="line" style="width: 95%;">
        <thead>
        <tr>
            <th>序号</th>
            <th>课程号</th>
            <th>课程名</th>
        </tr>
        </thead>
        <tbody id="coutb2">
        <c:forEach items="${selectCouList}" var="sc" varStatus="status">
            <tr>
                <th>${status.index+1}</th>
                <th>${sc.stuNum}</th>
                <th>${sc.couName}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="layui-form-item" style="margin-left: 480px;">
        <button id="saveSelect" class="layui-btn layui-btn-normal">确认选课</button>
    </div>
</div>
<script src="${path}/media/js/jquery.dataTables.min.js"></script>
<script>

    //点击确认选课
    $(function () {
        $("#saveSelect").click(function () {
            var nowNum = $("#nowNum").val();
            var tb = document.getElementById("coutb2");
            var rows = tb.rows;
            var scMsg = nowNum+",";
            for(var i = 0; i<rows.length; i++ ){
                scMsg=scMsg+(rows[i].cells[2].innerHTML)+","
            };
            layer.load(0, {shade: false});
            $("#content").load("${path}/Student/saveSelectScore.action",{"scMsg":scMsg},function(){
                layer.closeAll();
            });
        });
    });
    //DataTables分页
//    $(document).ready(function(){
//        $('#coursestbl').DataTable({
//            "paging":true,
//            "lengthChange":true,
//            "searching":false,
//            "ordering":false,
//            "info":true,
//            "autoWidth":true,
//            "oLanguage":{
//                "sLengthMenu":"每页显示_MENU_条",
//                "sZeroRecords":"抱歉,没有找到!",
//                "sInfo":"从_START_到_END_ / 共_TOTAL_条",
//                "sInfoFiltered":"(从_MAX_条数据中检索)",
//                "oPaginate":{
//                    "sFirst":"首页",
//                    "sPrevious":"上一页",
//                    "sNext":"下一页",
//                    "sLast":"尾页"
//                }
//            }
//        });
//    });
</script>


