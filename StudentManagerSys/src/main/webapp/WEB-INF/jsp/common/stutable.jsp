<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
