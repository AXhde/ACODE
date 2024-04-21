/**
 * Created by Mr.z on 2018/4/23 0023.
 */
/**
 * admin js
 */
//登陆成功,初始化首页
$(function () {
    layer.load(0, {shade: false});
    $("#content").load("/StudentManagerSys/index/index.action",function(){
        layer.closeAll();
    });
});

//点击回到首页
$(function () {
    $("#index").click(function () {
        layer.load(0, {shade: false});
        $("#content").load("/StudentManagerSys/index/index.action",function(){
            layer.closeAll();
        });
    });
});

//点击联系我们
$(function () {
    $("#about").click(function () {
        layer.load(0, {shade: false});
        $("#content").load("/StudentManagerSys/index/about.action",function(){
            layer.closeAll();
        });
    });
});

//点击系统版本
$(function () {
    $("#version").click(function () {
        layer.open({
            type: 1
            ,title: false //不显示标题栏
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,resize: false
            ,btn: ['关闭']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">' +
            '<h3>Version</h3><br>学生信息管理系统<br>StudentManageSystem<br>1.0<br><br>Author : Mr.z<br>Tel:18895707271</div>'
        });
    });
});

//点击查看学生
$(function () {
    $("#findstu").click(function () {
        layer.load(0, {shade: false});
        $("#content").load("/StudentManagerSys/index/stulist.action",function(){
            layer.closeAll();
        });
    });
});


