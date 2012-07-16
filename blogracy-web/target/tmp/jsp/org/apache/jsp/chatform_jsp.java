package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import net.blogracy.model.hashes.Hashes;
import net.blogracy.model.users.Users;
import net.blogracy.controller.FileSharing;
import net.blogracy.controller.ChatController;
import net.blogracy.config.Configurations;

public final class chatform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String userHash = request.getParameter("user");
if (userHash == null || userHash.length() == 0) {
    userHash = Configurations.getUserConfig().getUser().getHash().toString();
} else if (userHash.length() != 32) {
	userHash = Hashes.hash(userHash); // TODO: remove
}

pageContext.setAttribute("application", "Blogracy");
pageContext.setAttribute("user", Users.newUser(Hashes.fromString(userHash)));
pageContext.setAttribute("localUser", Configurations.getUserConfig().getUser());
pageContext.setAttribute("remoteUser", ChatController.getRemoteUser());

ChatController.chatting();

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("    <title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${application}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</title>\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\t\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/chat files/chat.css\" type=\"text/css\">\r\n");
      out.write("    <style type=\"text/css\" media=\"screen\"> \r\n");
      out.write("        @import url(/admin/styles/sorttable.css);\r\n");
      out.write("        @import url(/admin/styles/prettify.css);\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"chat files/jquery-1.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"chat files/amq_jquery_adapter.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"chat files/amq.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"chat files/chat.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script src=\"/scripts/jquery-1.7.js\"></script>\r\n");
      out.write("    <script src=\"/scripts/jquery.form.js\"></script>\r\n");
      out.write("    <script src=\"/scripts/bootstrap-alerts.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("        // wait for the DOM to be loaded\r\n");
      out.write("        jQuery(function() {\r\n");
      out.write("            jQuery('#message-send').ajaxForm({\r\n");
      out.write("                url: '/fileupload',\r\n");
      out.write("                clearForm: true,\r\n");
      out.write("                type: 'POST',\r\n");
      out.write("                success: function() {\r\n");
      out.write("                    console.log(arguments);\r\n");
      out.write("                },\r\n");
      out.write("                error: function(request, status, statusMessage) {\r\n");
      out.write("                    var serverSideException = JSON.parse(request.responseText);\r\n");
      out.write("                    var errorMessage = '<div class=\"alert-message block-message error\"><a class=\"close\" href=\"#\">x</a>' +\r\n");
      out.write("                                       '<p><strong>' + serverSideException.errorMessage + '</strong></p>' +\r\n");
      out.write("                                        '<pre>' + serverSideException.errorTrace.join(\"\\n\") + '</pre>' +\r\n");
      out.write("                                       '</div>';\r\n");
      out.write("                    jQuery(errorPlace).html(errorMessage);\r\n");
      out.write("                    jQuery(\".alert-message\").alert();\r\n");
      out.write("                }\r\n");
      out.write("                \r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\twindow.onload = function() {\r\n");
      out.write("\t\t\torg.activemq.Amq.init({ uri: 'amq', logging: true, timeout: 45, clientId:(new Date()).getTime().toString() });\r\n");
      out.write("\t\t\torg.activemq.Chat.init();\r\n");
      out.write("\t\t};\r\n");
      out.write("\t</script> \r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\twindow.onunload = function() {\r\n");
      out.write("\t\t\torg.activemq.Chat.leave();\r\n");
      out.write("\t\t};\r\n");
      out.write("\t</script> \r\n");
      out.write("\t\r\n");
      out.write("</head> \r\n");
      out.write(" \r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"white_box\">    \r\n");
      out.write("    <table border=\"0\"> \r\n");
      out.write("            <tr> \r\n");
      out.write("                <td style=\"overflow: hidden;\" valign=\"top\" width=\"50%\"> \r\n");
      out.write("                    <div class=\"body-content\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div id=\"chatroom\">\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"chat\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"members\" class=\"hidden\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"join\" class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\tUsername:&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"username\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${localUser.localNick}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button id=\"joinB\">Re-Join</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"joined\" class=\"hidden\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\tChat:&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"phrase\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button id=\"sendB\">Send</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button id=\"leaveB\">Leave</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("                    </div> \r\n");
      out.write("                </td> \r\n");
      out.write("            </tr>  \r\n");
      out.write("    </table> \r\n");
      out.write("\t<div id=\"channelName\" title=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${remoteUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></div>\r\n");
      out.write("</div> \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
