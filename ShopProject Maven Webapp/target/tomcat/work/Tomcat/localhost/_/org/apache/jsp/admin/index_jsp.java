/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2018-07-10 13:33:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--[if IE 9]><html class=\"no-js lt-ie10\" lang=\"en\"> <![endif]-->\r\n");
      out.write("<!--[if gt IE 9]><!--> <html class=\"no-js\" lang=\"en\"> <!--<![endif]-->\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>Legendary</title>\r\n");
      out.write("        <meta name=\"description\" content=\"Legendary\">\r\n");
      out.write("        <meta name=\"robots\" content=\"noindex, nofollow\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\r\n");
      out.write("        <meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t\t<meta http-equiv=\"expires\" content=\"0\">   \r\n");
      out.write("\t\t        \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"/admin/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"/admin/css/font-awesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"/admin/css/main.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"page-wrapper\" class=\"page-loading\">\r\n");
      out.write("            <div class=\"preloader\">\r\n");
      out.write("                <div class=\"inner\">\r\n");
      out.write("                    <div class=\"preloader-spinner themed-background hidden-lt-ie10\"></div>\r\n");
      out.write("                    <h3 class=\"text-primary visible-lt-ie10\"><strong>Loading..</strong></h3>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"page-container\" class=\"header-fixed-top sidebar-visible-lg-full\">\r\n");
      out.write("                <div id=\"sidebar\">\r\n");
      out.write("                    <div id=\"sidebar-brand\" class=\"themed-background\">\r\n");
      out.write("                        <a href=\"#\" class=\"sidebar-title\">\r\n");
      out.write("                            <i class=\"icon-cog\"></i> \r\n");
      out.write("                            <span class=\"sidebar-nav-mini-hide\">Legendary</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"sidebar-scroll\">\r\n");
      out.write("                        <div class=\"sidebar-content\">\r\n");
      out.write("                            <ul class=\"sidebar-nav\">\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"/StatisticsServlet?method=info\" target=\"main\"><i class=\"icon-home sidebar-nav-icon\"></i><span class=\"sidebar-nav-mini-hide\"> 主页</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("                                    <a href=\"#\" class=\"sidebar-nav-menu\">\r\n");
      out.write("                                    \t<i class=\"icon-chevron-right sidebar-nav-indicator sidebar-nav-mini-hide\"></i>\r\n");
      out.write("                                   \t\t<i class=\"icon-gift sidebar-nav-icon\"></i>\r\n");
      out.write("                                   \t\t<span class=\"sidebar-nav-mini-hide\">订单信息</span></a>\r\n");
      out.write("                                    <ul>\r\n");
      out.write("                                        <li><a href=\"/OrdersServlet?method=queryAll\" target=\"main\">订单管理</a></li>\r\n");
      out.write("                                        <li><a href=\"/OrdersServlet?method=query&state=1\" target=\"main\">待付款订单</a></li>\r\n");
      out.write("                                        <li><a href=\"/OrdersServlet?method=query&state=2\" target=\"main\">待发货订单</a></li>\r\n");
      out.write("                                        <li><a href=\"/OrdersServlet?method=query&state=3\" target=\"main\">待收货订单</a></li>\r\n");
      out.write("                                        <li><a href=\"/OrdersServlet?method=query&state=4\" target=\"main\">待评价订单</a></li>\r\n");
      out.write("                                        <li><a href=\"/OrdersServlet?method=query&state=5\" target=\"main\">审查退货订单</a></li>\r\n");
      out.write("                                        <li><a href=\"/OrdersServlet?method=query&state=6\" target=\"main\">退货订单</a></li>\r\n");
      out.write("                                        <li><a href=\"/OrdersServlet?method=query&state=7\" target=\"main\">退货已发订单</a></li>\r\n");
      out.write("                                        <li><a href=\"/OrdersServlet?method=query&state=8\" target=\"main\">已完成订单</a></li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"#\" class=\"sidebar-nav-menu\">\r\n");
      out.write("                                    \t<i class=\"icon-chevron-right sidebar-nav-indicator sidebar-nav-mini-hide\"></i>\r\n");
      out.write("                                    \t<i class=\"icon-group sidebar-nav-icon\"></i>\r\n");
      out.write("                                    \t<span class=\"sidebar-nav-mini-hide\">商品信息</span></a>\r\n");
      out.write("                                    <ul>\r\n");
      out.write("                                        <li><a href=\"/GoodsServlet?method=query\" target=\"main\">商品管理</a></li>\r\n");
      out.write("                                        <li><a href=\"/SpecificationServlet?method=query\" target=\"main\">规格管理</a></li>\r\n");
      out.write("                                        <li><a href=\"/CatalogsServlet?method=query\" target=\"main\">类别管理</a></li>\r\n");
      out.write("                                        <li><a href=\"/GoodsServlet?method=publish\" target=\"main\">发布商品</a></li>\r\n");
      out.write("                                        <li><a href=\"/PicinfosServlet?method=query\" target=\"main\">图片管理</a></li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"#\" class=\"sidebar-nav-menu\">\r\n");
      out.write("                                    \t<i class=\"icon-chevron-right sidebar-nav-indicator sidebar-nav-mini-hide\"></i>\r\n");
      out.write("                                    \t<i class=\"icon-gift sidebar-nav-icon\"></i>\r\n");
      out.write("                                    \t<span class=\"sidebar-nav-mini-hide\">用户信息</span></a>\r\n");
      out.write("                                    <ul>\r\n");
      out.write("                                    \t<li><a href=\"/AdminServlet?method=query\" target=\"main\">查询用户</a></li>\r\n");
      out.write("                                        <li><a href=\"/admin/admin/addAdmin.jsp\" target=\"main\">添加用户</a></li>\r\n");
      out.write("                                        <li><a href=\"/RoleServlet?method=query\" target=\"main\">查询角色</a></li>\r\n");
      out.write("                                        <li><a href=\"/admin/role/addRole.jsp\" target=\"main\">添加角色</a></li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </li>\r\n");
      out.write("                               \t<li>\r\n");
      out.write("                                    <a href=\"/MemberServlet?method=query\" target=\"main\"><i class=\"icon-home sidebar-nav-icon\"></i><span class=\"sidebar-nav-mini-hide\">会员管理</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"#\" class=\"sidebar-nav-menu\">\r\n");
      out.write("                                    \t<i class=\"icon-chevron-right sidebar-nav-indicator sidebar-nav-mini-hide\"></i>\r\n");
      out.write("                                    \t<i class=\"icon-gift sidebar-nav-icon\"></i>\r\n");
      out.write("                                    \t<span class=\"sidebar-nav-mini-hide\">查看日志</span></a>\r\n");
      out.write("                                    <ul>\r\n");
      out.write("                                        <li><a href=\"/LogsServlet?method=query\" target=\"main\">用户日志</a></li>\r\n");
      out.write("                                        <li><a href=\"#\">会员日志</a></li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"/admin/picture/picture.jsp\" target=\"main\"><i class=\"icon-home sidebar-nav-icon\"></i><span class=\"sidebar-nav-mini-hide\"> 退出系统</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"main-container\">\r\n");
      out.write("                    <header class=\"navbar navbar-inverse navbar-fixed-top\">\r\n");
      out.write("                        <ul class=\"nav navbar-nav-custom\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"javascript:void(0)\" onclick=\"Tool.sidebar('toggle-sidebar');this.blur();\">\r\n");
      out.write("                                    <i class=\"icon-reorder animation-fadeInRight\" id=\"sidebar-toggle-mini\"></i>\r\n");
      out.write("                                    <i class=\"icon-reorder animation-fadeInRight\" id=\"sidebar-toggle-full\"></i>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <ul class=\"nav navbar-nav-custom pull-right\">\r\n");
      out.write("                            <li class=\"dropdown\">\r\n");
      out.write("                                <a href=\"javascript:void(0)\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                                    <img src=\"https://gw.alicdn.com/tps/i3/TB1yeWeIFXXXXX5XFXXuAZJYXXX-210-210.png_60x60.jpg\" alt=\"avatar\">\r\n");
      out.write("                                    <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${session_user.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <ul class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                                    <li>\r\n");
      out.write("                                        <a href=\"#\">\r\n");
      out.write("                                            <i class=\"icon-pencil fa-fw pull-right\"></i>\r\n");
      out.write("                                            个人资料\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li>\r\n");
      out.write("                                        <a href=\"login.html\">\r\n");
      out.write("                                            <i class=\"icon-off fa-fw pull-right\"></i>\r\n");
      out.write("                                            退出\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </header>\r\n");
      out.write("                    <div id=\"page-content\">\r\n");
      out.write("\t\t\t            <div id=\"page-wrapper\">\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"page-inner\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<iframe id=\"external-frame\" scrolling=\"no\" onload=\"setIframeHeight(this)\" name=\"main\" width=\"100%\" scrolling=\"auto\" height=\"100%\" src=\"/StatisticsServlet?method=info\" frameborder=\"0\"></iframe>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\t\t\tfunction setIframeHeight(iframe) {\r\n");
      out.write("\t\t\t\tif(iframe) {\r\n");
      out.write("\t\t\t\t\tvar iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;\r\n");
      out.write("\t\t\t\t\tif(iframeWin.document.body) {\r\n");
      out.write("\t\t\t\t\t\tiframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\t\twindow.onload = function() {\r\n");
      out.write("\t\t\t\tsetIframeHeight(document.getElementById('external-frame'));\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/js/bootstrap.js\"></script>\r\n");
      out.write("        <script src=\"/admin/js/vendor/jquery-2.2.4.min.js\"></script>\r\n");
      out.write("        <script src=\"/admin/js/vendor/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"/admin/js/plugins.js\"></script>\r\n");
      out.write("        <script src=\"/admin/js/tool.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
