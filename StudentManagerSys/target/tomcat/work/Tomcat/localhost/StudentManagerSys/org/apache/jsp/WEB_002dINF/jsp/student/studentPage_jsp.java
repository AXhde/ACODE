/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-06 12:44:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class studentPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>学员信息管理系统-管理员</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel='stylesheet' type='text/css' href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dist/css/bootstrap.min.css'/>\r\n");
      out.write("    <link rel='stylesheet' type='text/css' href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/revise.css'/>\r\n");
      out.write("    <link rel='stylesheet' type='text/css' href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap-datetimepicker.min.css'/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui/css/layui.css\" media=\"all\">\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://api.map.baidu.com/api?v=2.0&ak=TgntbCqoSFrZns4pDSDKjvsb2Lxb76eX\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dist/js/jquery.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"layui-layout-body\">\r\n");
      out.write("<div class=\"layui-layout layui-layout-admin\">\r\n");
      out.write("    <div class=\"layui-header layui-bg-cyan\">\r\n");
      out.write("        <div class=\"layui-logo layui-bg-cyan\">学员信息管理系统</div>\r\n");
      out.write("        <!-- 头部区域 -->\r\n");
      out.write("        <ul class=\"layui-nav layui-layout-left layui-bg-gyan\">\r\n");
      out.write("            <li class=\"layui-nav-item\"><a href=\"#\" id=\"index\"><i class=\"layui-icon\">&#xe68e;</i>首页</a></li>\r\n");
      out.write("            <li class=\"layui-nav-item\">\r\n");
      out.write("                <a href=\"javascript:;\">关于</a>\r\n");
      out.write("                <dl class=\"layui-nav-child\">\r\n");
      out.write("                    <dd><a href=\"#\" id=\"about\">关于我们</a></dd>\r\n");
      out.write("                    <dd><a href=\"#\" id=\"version\">系统版本</a></dd>\r\n");
      out.write("                </dl>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <ul class=\"layui-nav layui-layout-right layui-bg-cyan\">\r\n");
      out.write("            <li class=\"layui-nav-item\">\r\n");
      out.write("                <a href=\"javascript:;\">\r\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/img/user.jpg\" class=\"layui-nav-img\">\r\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.stuName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("                </a>\r\n");
      out.write("                <input type=\"hidden\" id=\"nowNum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.stuNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                <dl class=\"layui-nav-child\">\r\n");
      out.write("                    <dd><a id=\"changePsw\" href=\"#\"><i class=\"layui-icon\">&#xe642;</i>密码修改</a></dd>\r\n");
      out.write("                </dl>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"layui-nav-item\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/load/logout.action\">安全退出</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-side layui-bg-cyan\">\r\n");
      out.write("        <div class=\"layui-side-scroll\">\r\n");
      out.write("            <!-- 左侧导航区域 -->\r\n");
      out.write("            <ul class=\"layui-nav layui-nav-tree\"  lay-filter=\"test\">\r\n");
      out.write("                <li class=\"layui-nav-item layui-bg-cyan\"><a id=\"mymsg\"><i class=\"layui-icon\">&#xe63f;</i>&nbsp;信息维护</a></li>\r\n");
      out.write("                <li class=\"layui-nav-item layui-bg-cyan\"><a id=\"showallTea\"><i class=\"layui-icon\">&#xe63f;</i>&nbsp;教师信息</a></li>\r\n");
      out.write("                <li class=\"layui-nav-item layui-bg-cyan\"><a id=\"showcou\"><i class=\"layui-icon\">&#xe63f;</i>&nbsp;所有课程</a></li>\r\n");
      out.write("                <li class=\"layui-nav-item layui-bg-cyan\"><a id=\"selectcou\"><i class=\"layui-icon\">&#xe63f;</i>&nbsp;开始选课</a></li>\r\n");
      out.write("                <li class=\"layui-nav-item layui-bg-cyan\"><a id=\"seescore\"><i class=\"layui-icon\">&#xe63f;</i>&nbsp;已选课程</a></li>\r\n");
      out.write("                <li class=\"layui-nav-item layui-bg-cyan\"><a><i class=\"layui-icon\">&#xe609;</i>&nbsp;敬请期待</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-body\" id=\"content\">\r\n");
      out.write("        <!-- 内容主体区域 -->\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-footer\">\r\n");
      out.write("        <!-- 底部固定区域 -->\r\n");
      out.write("        © www.ahszu.edu.cn - 宿州学院 - 版权所有\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dist/js/jquery.min.js\"></script>\r\n");
      out.write("<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dist/js/bootstrap.min.js'></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dist/js/bootstrap-modal.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/layer/layer.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dist/js/bootstrap-datetimepicker.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui/layui.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/myjs/studentjs.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    //点开始选课\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $(\"#selectcou\").click(function () {\r\n");
      out.write("            var nowNum = $(\"#nowNum\").val();\r\n");
      out.write("            layer.load(0, {shade: false});\r\n");
      out.write("            $(\"#content\").load(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Student/loadSelectCouPage.action\",{\"nowNum\":nowNum},function(){\r\n");
      out.write("                layer.closeAll();\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    //点击已选课程\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $(\"#seescore\").click(function () {\r\n");
      out.write("            var nowNum = $(\"#nowNum\").val();\r\n");
      out.write("            layer.load(0, {shade: false});\r\n");
      out.write("            $(\"#content\").load(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Student/showScore.action\",{\"nowNum\":nowNum},function(){\r\n");
      out.write("                layer.closeAll();\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    //点击查看所有课程\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $(\"#showcou\").click(function () {\r\n");
      out.write("            layer.load(0, {shade: false});\r\n");
      out.write("            $(\"#content\").load(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Student/showCourses.action\",function(){\r\n");
      out.write("                layer.closeAll();\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    //点击教师信息\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $(\"#showallTea\").click(function () {\r\n");
      out.write("            layer.load(0, {shade: false});\r\n");
      out.write("            $(\"#content\").load(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Student/showtea.action\",function(){\r\n");
      out.write("                layer.closeAll();\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    //点击信息维护,加载个人信息页面\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $(\"#mymsg\").click(function () {\r\n");
      out.write("            var nowNum = $(\"#nowNum\").val();\r\n");
      out.write("            layer.load(0, {shade: false});\r\n");
      out.write("            $(\"#content\").load(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Student/loadMymsgPage.action\",{\"nowNum\":nowNum},function(){\r\n");
      out.write("                layer.closeAll();\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    //点击修改密码\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $(\"#changePsw\").click(function () {\r\n");
      out.write("            var nowNum = $(\"#nowNum\").val();\r\n");
      out.write("            layer.load(0, {shade: false});\r\n");
      out.write("            $(\"#content\").load(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Student/changePswPage.action\",{\"nowNum\":nowNum},function(){\r\n");
      out.write("                layer.closeAll();\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    layui.use('element', function(){\r\n");
      out.write("        var element = layui.element;\r\n");
      out.write("    })\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
