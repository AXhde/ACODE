/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-08 15:29:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editorteacher_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<div style=\"margin-top:15px; margin-left: 15px\">\r\n");
      out.write("    <div style=\"margin-top:30px; margin-left: 15px\">\r\n");
      out.write("        <div style=\"width: 50%;margin: auto\">\r\n");
      out.write("            <fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 50px;\">\r\n");
      out.write("                <legend>学员信息管理系统-修改教师信息</legend>\r\n");
      out.write("            </fieldset>\r\n");
      out.write("            <form class=\"layui-form layui-form-pane\" method=\"post\">\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">教师编号</label>\r\n");
      out.write("                    <div class=\"layui-input-inline\">\r\n");
      out.write("                        <input name=\"teaNum\" id=\"teaNum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nowteaeacher.teaNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" disabled=\"disabled\" class=\"layui-input\" type=\"text\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">教师姓名</label>\r\n");
      out.write("                    <div class=\"layui-input-inline\">\r\n");
      out.write("                        <input name=\"teaName\" id=\"teaName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nowteaeacher.teaName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"layui-input\" type=\"text\" placeholder=\"请输入姓名\" autocomplete=\"off\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">联系电话</label>\r\n");
      out.write("                    <div class=\"layui-input-inline\">\r\n");
      out.write("                        <input name=\"teaPhone\" id=\"teaPhone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nowteaeacher.teaPhone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"请输入电话号码\" class=\"layui-input\" onkeyup=\"value=value.replace(/[^\\d]/g,'')\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("            <div class=\"layui-form-item\">\r\n");
      out.write("                <button class=\"layui-btn layui-btn-normal\" id=\"savestu\">保存修改</button>\r\n");
      out.write("                <button class=\"layui-btn layui-btn-normal\" id=\"returnalltea\">返回</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("    //点击保存修改 保存修改的教师信息\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $(\"#savestu\").click(function () {\r\n");
      out.write("            if($(\"#teaNum\").val()==\"\"||$(\"#teaName\").val()==\"\"||$(\"#teaPhone\").val()==\"\"){\r\n");
      out.write("                layer.msg('请填写完整信息!');\r\n");
      out.write("            }else{\r\n");
      out.write("                var tNum = $(\"#teaNum\").val();\r\n");
      out.write("                var tName = $(\"#teaName\").val();\r\n");
      out.write("                var tPhone = $(\"#teaPhone\").val();\r\n");
      out.write("                layer.confirm('保存修改?', {\r\n");
      out.write("                    btn: ['确定','取消'] //按钮\r\n");
      out.write("                }, function(){\r\n");
      out.write("                    $(\"#content\").load(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/index/savetea.action\",{\"teaNum\":tNum,\"teaName\":tName,\"teaPhone\":tPhone},function(){\r\n");
      out.write("                        layer.closeAll();\r\n");
      out.write("                    });\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    //点击返回全部\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $(\"#returnalltea\").click(function () {\r\n");
      out.write("            layer.load(0, {shade: false});\r\n");
      out.write("            $(\"#content\").load(\"/StudentManagerSys/index/alltea.action\",function(){\r\n");
      out.write("                layer.closeAll();\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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