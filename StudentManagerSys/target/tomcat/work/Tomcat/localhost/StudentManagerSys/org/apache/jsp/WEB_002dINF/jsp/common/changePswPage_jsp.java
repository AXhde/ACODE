/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-05 17:57:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class changePswPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                <legend>修改密码</legend>\r\n");
      out.write("            </fieldset>\r\n");
      out.write("            <form class=\"layui-form layui-form-pane\" method=\"post\">\r\n");
      out.write("                <input type=\"hidden\" id=\"stuNum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nowstu.stuNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">新的密码:</label>\r\n");
      out.write("                    <div class=\"layui-input-inline\">\r\n");
      out.write("                        <input name=\"clsName\" id=\"newPsw1\" class=\"layui-input\" type=\"password\" placeholder=\"请输入新密码\" autocomplete=\"off\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">确认密码:</label>\r\n");
      out.write("                    <div class=\"layui-input-inline\">\r\n");
      out.write("                        <input name=\"stuPsw\" id=\"newPsw2\" class=\"layui-input\" type=\"password\" placeholder=\"确认新密码\" autocomplete=\"off\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </form>\r\n");
      out.write("            <div class=\"layui-form-item\">\r\n");
      out.write("                <button class=\"layui-btn layui-btn-normal\" id=\"changeSave\">确定修改</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("    //确认修改密码\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $(\"#changeSave\").click(function () {\r\n");
      out.write("            var stuNum = $(\"#stuNum\").val();\r\n");
      out.write("            var newPsw1 = $(\"#newPsw1\").val();\r\n");
      out.write("            var newPsw2 = $(\"#newPsw2\").val();\r\n");
      out.write("            if(newPsw1==\"\"||newPsw2==\"\"){\r\n");
      out.write("                layer.msg(\"密码不能为空!\");\r\n");
      out.write("            }else if(newPsw1!=newPsw2){\r\n");
      out.write("                layer.msg(\"两次输入不一样\");\r\n");
      out.write("            }else{\r\n");
      out.write("                layer.confirm('确定修改?', {\r\n");
      out.write("                    btn: ['确定','取消'] //按钮\r\n");
      out.write("                }, function(){\r\n");
      out.write("                    layer.load(0, {shade: false});\r\n");
      out.write("                    $(\"#content\").load(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Student/saveChangePsw.action\",{\"stuNum\":stuNum,\"newPsw\":newPsw1},function(){\r\n");
      out.write("                        layer.closeAll();\r\n");
      out.write("                    });\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    layui.use(['layer', 'form', 'element'], function(){\r\n");
      out.write("        var layer = layui.layer;\r\n");
      out.write("        var form = layui.form;\r\n");
      out.write("        var element = layui.element;\r\n");
      out.write("        form.render();\r\n");
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
