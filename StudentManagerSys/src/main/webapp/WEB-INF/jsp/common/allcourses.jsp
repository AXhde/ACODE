<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${path}/media/css/jquery.dataTables.min.css" media="all">
<div style="margin-top:15px; margin-left: 15px">
    <h3>&nbsp;所有课程</h3>
    <br>
    <table class="layui-table" id="coursestbl" lay-skin="line" style="width: 95%;">
        <thead>
        <tr>
            <th>序号</th>
            <th>课程号</th>
            <th>课程名</th>
            <th>学时</th>
            <th>授课教师</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allcou}" var="cou" varStatus="status">
            <tr>
                <th>${status.index+1}</th>
                <th>${cou.couNum}</th>
                <th>${cou.couName}</th>
                <th>${cou.couhour}</th>
                <th>${cou.teaName}</th>
                <td>
                    <a onclick="delthis(this)" href="javascript:"><i class="layui-icon"  style="font-size: 25px; color: red;">&#xe640;</i></a>
                    <a onclick="seethis(this)" href="javascript:"><i class="layui-icon" style="font-size: 25px; color: deepskyblue;">&#xe642;</i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="${path}/media/js/jquery.dataTables.min.js"></script>
<script>
    //点击编辑班级信息
    function seethis(param) {
        var nowNum = param.parentNode.parentNode.children[1].innerText;
        layer.msg(nowNum);
        layer.load(0, {shade: false});
        $("#content").load("${path}/index/editorcourses.action",{"nowNum":nowNum},function(){
            layer.closeAll();
        });
    }

    //点击删除
    function delthis(param) {
        var delNum = param.parentNode.parentNode.children[1].innerText;
        layer.msg(delNum);
        layer.confirm('确定删除?', {
            btn: ['删除','取消'] //按钮
        }, function(){
            $("#content").load("${path}/index/delcourses.action",{"delNum":delNum},function(){
                layer.closeAll();
            });
        });
    }

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


