/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.3.0.M2
 * Generated at: 2018-07-01 10:55:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/C:/Users/17923/.m2/repository/org/apache/taglibs/taglibs-standard-impl/1.2.1/taglibs-standard-impl-1.2.1.jar!/META-INF/c.tld", Long.valueOf(1384339662000L));
    _jspx_dependants.put("file:/C:/Users/17923/.m2/repository/org/apache/taglibs/taglibs-standard-impl/1.2.1/taglibs-standard-impl-1.2.1.jar", Long.valueOf(1528985631829L));
    _jspx_dependants.put("file:/C:/Users/17923/.m2/repository/jstl/jstl/1.2/jstl-1.2.jar", Long.valueOf(1528940694784L));
    _jspx_dependants.put("jar:file:/C:/Users/17923/.m2/repository/jstl/jstl/1.2/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153356282000L));
  }

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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link rel=\"icon\" href=\"http://192.168.1.157/H-ui/static/h-ui.admin/images/favicon.ico\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://192.168.1.157/H-ui/static/h-ui/css/H-ui.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://192.168.1.157/H-ui/static/h-ui.admin/css/H-ui.login.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://192.168.1.157/H-ui/static/h-ui.admin/css/style.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://192.168.1.157/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css\" />\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>管理员登录</title>\n");
      out.write("</head>\n");
      out.write("<body style=\"background-color: #F3F3F3\">\n");
      out.write("\n");
      out.write("\t<div class=\"loginWraper\">\n");
      out.write("\t\t<div id=\"loginform\" class=\"loginBox\">\n");
      out.write("\t\t\t<form class=\"form form-horizontal\" action=\"\" method=\"post\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<div class = \"formControls col-xs-8 col-xs-offset-3\">\n");
      out.write("           \t\t\t");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<div class=\"row cl\">\n");
      out.write("\t\t\t\t\t<label class=\"form-label col-xs-3\"><i class=\"Hui-iconfont\">&#xe60d;</i></label>\n");
      out.write("\t\t\t\t\t<div class=\"formControls col-xs-8\">\n");
      out.write("\t\t\t\t\t\t<input id=\"\" name=\"username\" type=\"text\" class=\"input-text size-L\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"row cl\">\n");
      out.write("\t\t\t\t\t<label class=\"form-label col-xs-3\"><i class=\"Hui-iconfont\">&#xe60e;</i></label>\n");
      out.write("\t\t\t\t\t<div class=\"formControls col-xs-8\">\n");
      out.write("\t\t\t\t\t\t<input id=\"\" name=\"password\" type=\"password\" class=\"input-text size-L\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"row cl\">\n");
      out.write("\t\t\t\t\t<div class=\"formControls col-xs-8 col-xs-offset-3\">\n");
      out.write("\t\t\t\t\t\t<input name=\"captcha\" class=\"input-text size-L\" type=\"text\" onblur=\"if(this.value==''){this.value='验证码:'}\" onclick=\"if(this.value=='验证码:'){this.value='';}\" value=\"验证码:\" style=\"width: 150px;\">\n");
      out.write("\t\t\t\t\t\t<img onclick=\"refreshCode(this)\" id=\"captcha\" src=\"http://192.168.1.157/getCaptcha\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"row cl\">\n");
      out.write("\t\t\t\t\t<div class=\"formControls col-xs-8 col-xs-offset-3\">\n");
      out.write("\t\t\t\t\t\t<label for=\"online\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"online\" id=\"online\" value=\"\"> 使我保持登录状态\n");
      out.write("\t\t\t\t\t\t</label>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"row cl\">\n");
      out.write("\t\t\t\t\t<div class=\"formControls col-xs-8 col-xs-offset-3\">\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-success radius size-L\" value=\"&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;\">&nbsp;&nbsp;&nbsp; \n");
      out.write("\t\t\t\t\t\t<input data-toggle=\"modal\" data-target=\"#myModal\" type=\"button\" class=\"btn btn-default radius size-L\" value=\"&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("<!-- 模态框（Modal） -->\n");
      out.write("<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                <h4 class=\"modal-title\" id=\"myModalLabel\">注册用户</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\" id=\"registerDiv\">\n");
      out.write("            \t<form id = \"form_user_register\" class=\"form form-horizontal\" action=\"\" method=\"post\">\n");
      out.write("\t\t\t      <div class=\"row cl\">\n");
      out.write("\t\t\t        <label class=\"form-label col-xs-3\"><i class=\"Hui-iconfont\"></i></label>\n");
      out.write("\t\t\t        <div class=\"formControls col-xs-8\">\n");
      out.write("\t\t\t          <input id=\"username\" name=\"username\" type=\"text\" placeholder=\"用户名\" class=\"input-text size-L\" style=\"width: 200px\">\n");
      out.write("\t\t\t        </div>\n");
      out.write("\t\t\t      </div>\n");
      out.write("\t\t\t      <div class=\"row cl\">\n");
      out.write("\t\t\t        <label class=\"form-label col-xs-3\"><i class=\"Hui-iconfont\"></i></label>\n");
      out.write("\t\t\t        <div class=\"formControls col-xs-8\">\n");
      out.write("\t\t\t          <input id=\"password\" name=\"password\" type=\"password\" placeholder=\"密码\" class=\"input-text size-L\" style=\"width: 250px\">\n");
      out.write("\t\t\t        </div>\n");
      out.write("\t\t\t      </div>\n");
      out.write("\t\t\t      <div class=\"row cl\">\n");
      out.write("\t\t\t        <label class=\"form-label col-xs-3\"><i class=\"Hui-iconfont\"></i></label>\n");
      out.write("\t\t\t        <div class=\"formControls col-xs-8\">\n");
      out.write("\t\t\t          <input id=\"rePassword\" name=\"rePassword\" type=\"password\" placeholder=\"确认密码\" class=\"input-text size-L\" style=\"width: 250px\">\n");
      out.write("\t\t\t        </div>\n");
      out.write("\t\t\t      </div>\n");
      out.write("\t\t\t      <div class=\"row cl\">\n");
      out.write("\t\t\t        <label class=\"form-label col-xs-3\"><i class=\"Hui-iconfont\"></i></label>\n");
      out.write("\t\t\t        <div class=\"formControls col-xs-8\">\n");
      out.write("\t\t\t          <input id=\"tel\" name=\"tel\" type=\"text\" placeholder=\"手机号码\" class=\"input-text size-L\" style=\"width: 250px\">\n");
      out.write("\t\t\t        </div>\n");
      out.write("\t\t\t      </div>\n");
      out.write("\t\t\t      <div class=\"row cl \">\n");
      out.write("\t\t\t        <label class=\"form-label col-xs-3\"><i class=\"Hui-iconfont\"></i></label>\n");
      out.write("\t\t\t        <div class=\"formControls col-xs-8\">\n");
      out.write("\t\t\t\t\t\t<input id=\"sub\" type=\"submit\" class=\"btn btn-primary radius\" value=\"&nbsp;&nbsp;保存并提交审核&nbsp;&nbsp;\">\n");
      out.write("\t\t\t\t\t\t<button  class=\"btn btn-default radius\" type=\"reset\">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>\n");
      out.write("\t\t\t        </div>\n");
      out.write("\t\t\t\t  </div>\n");
      out.write("\t\t\t    </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\n");
      out.write("            </div>\n");
      out.write("        </div><!-- /.modal-content -->\n");
      out.write("    </div><!-- /.modal -->\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"footer\">Copyright @njnode.cn</div>\n");
      out.write("<script type=\"text/javascript\" src=\"http://192.168.1.157/H-ui/lib/jquery/1.9.1/jquery.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"http://192.168.1.157/H-ui/static/h-ui/js/H-ui.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"http://192.168.1.157/H-ui/lib/layer/2.4/layer.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"http://192.168.1.157/H-ui/lib/jquery.validation/1.14.0/jquery.validate.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"http://192.168.1.157/H-ui/lib/jquery.validation/1.14.0/validate-methods.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"http://192.168.1.157/H-ui/lib/jquery.validation/1.14.0/messages_zh.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"http://192.168.1.157/H-ui/lib/common.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(function() {\n");
      out.write("\tvar validate = $(\"#form_user_register\").validate({ \n");
      out.write("\t\terrorPlacement: function(error, element) {  \n");
      out.write("\t        if (element.is(\":input\")){ \n");
      out.write("\t        \terror.appendTo(element.parent());\n");
      out.write("\t        }\n");
      out.write("\t    },\n");
      out.write("\t\tdebug: true, //调试模式取消submit的默认提交功能   \n");
      out.write("\t    focusInvalid: false, //当为false时，验证无效时，没有焦点响应  \n");
      out.write("\t    onkeyup: false,   \n");
      out.write("\t    submitHandler: function(){   //表单提交句柄,为一回调函数，带一个参数：form    \n");
      out.write("\t    \tusername = $(\"#registerDiv input[name='username']\").val();\n");
      out.write("\t    \tpassword = $(\"#registerDiv input[name='password']\").val();\n");
      out.write("\t    \ttel = $(\"#registerDiv input[name='tel']\").val();\n");
      out.write("// \t    \tconsole.log(username+\"  ===  \"+password+\"  ===  \"+tel);\n");
      out.write("\t\t\tvar d = {username:username,password:password,tel:tel};\n");
      out.write("\t    \tNJ_NODE.ajaxPost(d,\"text\",\"http://192.168.1.157/sys/_/register\",function(data){\n");
      out.write("\t    \t\tif(data){\n");
      out.write("\t    \t\t\tconsole.log(data)\n");
      out.write("\t    \t\t\tlayer.msg('注册成功！',{icon:1,time:3000});\n");
      out.write("\t    \t    \tsetTimeout(function(){\n");
      out.write("\t    \t    \t\tvar index = parent.layer.getFrameIndex(window.name);\n");
      out.write("\t\t    \t \t\tparent.location.reload(true);\n");
      out.write("\t\t    \t \t\tparent.layer.close(index);\t\n");
      out.write("\t    \t    \t},1500)\n");
      out.write("\t    \t\t}else{\n");
      out.write("\t    \t    \tlayer.msg('网络不稳！注册用户失败！',{icon:5,time:1000});\n");
      out.write("\t    \t    \tsetTimeout(function(){\n");
      out.write("\t    \t    \t\tvar index = parent.layer.getFrameIndex(window.name);\n");
      out.write("\t\t    \t \t\tparent.location.reload(true);\n");
      out.write("\t\t    \t \t\tparent.layer.close(index);\t\n");
      out.write("\t    \t    \t},1500)\n");
      out.write("\t    \t\t}\n");
      out.write("    \t\t});\n");
      out.write("\t    },   \n");
      out.write("\t    \n");
      out.write("\t    rules:{\n");
      out.write("\t\t\tusername:{\n");
      out.write("\t\t\t\trequired:true,\n");
      out.write("\t\t\t\tminlength:2,\n");
      out.write("\t\t\t\tmaxlength:16\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\ttel:{\n");
      out.write("\t\t\t\trequired:true,\n");
      out.write("\t\t\t\tisPhone:true\n");
      out.write("\t\t\t},\n");
      out.write("\t        password:{\n");
      out.write("\t            required:true,\n");
      out.write("\t            rangelength:[3,10]\n");
      out.write("\t        },\n");
      out.write("\t        rePassword:{\n");
      out.write("\t            equalTo:\"#password\"\n");
      out.write("\t        }                    \n");
      out.write("\t    },\n");
      out.write("\t    messages:{\n");
      out.write("\t        password:{\n");
      out.write("\t            required: \"不能为空\",\n");
      out.write("\t            rangelength: $.format(\"最少:{0}位, 最长:{1}位\")\n");
      out.write("\t        },\n");
      out.write("\t        rePassword:{\n");
      out.write("\t            equalTo:\"两次密码输入不一致\"\n");
      out.write("\t        }                                    \n");
      out.write("\t    }\n");
      out.write("\t});\n");
      out.write("\n");
      out.write("});\n");
      out.write("function refreshCode(obj){\n");
      out.write("\tobj.src = \"http://192.168.1.157/getCaptcha?random=\"+Math.random();;\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}