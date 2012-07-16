package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import net.blogracy.model.hashes.Hashes;
import net.blogracy.model.users.Users;
import net.blogracy.controller.FileSharing;
import net.blogracy.controller.ChatController;
import net.blogracy.config.Configurations;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

String userHash = request.getParameter("user");
if (userHash == null || userHash.length() == 0) {
    userHash = Configurations.getUserConfig().getUser().getHash().toString();
} else if (userHash.length() != 32) {
	userHash = Hashes.hash(userHash); // TODO: remove
}

pageContext.setAttribute("application", "Blogracy");
pageContext.setAttribute("user", Users.newUser(Hashes.fromString(userHash)));
pageContext.setAttribute("feed", FileSharing.getFeed(userHash));
pageContext.setAttribute("friends", Configurations.getUserConfig().getFriends());
pageContext.setAttribute("localUser", Configurations.getUserConfig().getUser());
pageContext.setAttribute("loc",  Configurations.getUserConfig().getUser().getHash().toString());
pageContext.setAttribute("rem", userHash);

String loc = Configurations.getUserConfig().getUser().getHash().toString();
ChatController.setLocalUser(loc);
ChatController.setRemoteUser(userHash);

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${application}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</title>\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("    <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("    <link href=\"/css/bootstrap.css\" rel=\"stylesheet\"/>\n");
      out.write("\n");
      out.write("\t<script src=\"/scripts/jquery-1.7.js\"></script>\n");
      out.write("    <script src=\"/scripts/jquery.form.js\"></script>\n");
      out.write("    <script src=\"/scripts/bootstrap-alerts.js\"></script>\n");
      out.write("\t\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        // wait for the DOM to be loaded\n");
      out.write("        jQuery(function() {\n");
      out.write("            jQuery('#message-send').ajaxForm({\n");
      out.write("                url: '/fileupload',\n");
      out.write("                clearForm: true,\n");
      out.write("                type: 'POST',\n");
      out.write("                success: function() {\n");
      out.write("                    console.log(arguments);\n");
      out.write("                },\n");
      out.write("                error: function(request, status, statusMessage) {\n");
      out.write("                    var serverSideException = JSON.parse(request.responseText);\n");
      out.write("                    var errorMessage = '<div class=\"alert-message block-message error\"><a class=\"close\" href=\"#\">x</a>' +\n");
      out.write("                                       '<p><strong>' + serverSideException.errorMessage + '</strong></p>' +\n");
      out.write("                                        '<pre>' + serverSideException.errorTrace.join(\"\\n\") + '</pre>' +\n");
      out.write("                                       '</div>';\n");
      out.write("                    jQuery(errorPlace).html(errorMessage);\n");
      out.write("                    jQuery(\".alert-message\").alert();\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\tfunction openChat(){\n");
      out.write("\t\tdocument.getElementById('chatbody').innerHTML = '<iframe src=\"chatform.jsp\" id=\"iframe\" width=\"300\" height=\"300\"></iframe>';\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\tfunction closeChat(){\n");
      out.write("\t\tdocument.getElementById('chatbody').innerHTML = '';\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\tfunction privateChat(){\n");
      out.write("\t\tdocument.getElementById('privbody').innerHTML = '<iframe src=\"chatform3.jsp\" id=\"iframe3\" width=\"300\" height=\"300\"></iframe>';\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\tfunction privateChat2(){\n");
      out.write("\t\tdocument.getElementById('privbody').innerHTML = '<iframe src=\"chatform4.jsp\" id=\"iframe4\" width=\"300\" height=\"300\"></iframe>';\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\tfunction closePrivateChat(){\n");
      out.write("\t\tdocument.getElementById('privbody').innerHTML = '';\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\tfunction resizeChat2(){\n");
      out.write("\t\tdocument.getElementById('chatlink2').innerHTML = 'Close';\n");
      out.write("\t\tdocument.getElementById('iframe2').height = 300;\n");
      out.write("\t\tdocument.getElementById('iframe2').width = 300;\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\tfunction closeChat2(){\n");
      out.write("\t\tdocument.getElementById('chatlink2').innerHTML = '';\n");
      out.write("\t\tdocument.getElementById('chatbody2').innerHTML = '<iframe src=\"chatform2.jsp\" id=\"iframe2\" width=\"0\" height=\"0\"></iframe>';\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\twindow.onload = function() {\n");
      out.write("\t\t\tvar local = document.getElementById('localUser').getAttribute('title');\n");
      out.write("\t\t\tvar remote = document.getElementById('remoteUser').getAttribute('title');\n");
      out.write("\t\t\tif (local == remote) {\n");
      out.write("\t\t\t\tdocument.getElementById('openlink').innerHTML = '';\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tdocument.getElementById('chatbody2').innerHTML = '<iframe src=\"chatform2.jsp\" id=\"iframe2\" width=\"0\" height=\"0\"></iframe>';\n");
      out.write("\t\t\tdocument.getElementById('openlink2').innerHTML = '';\n");
      out.write("\t\t};\n");
      out.write("\t</script> \n");
      out.write("\t\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("            /* Override some defaults */\n");
      out.write("        html, body {\n");
      out.write("            background-color: #eee;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        body {\n");
      out.write("            padding-top: 40px; /* 40px to make the container go all the way to the bottom of the topbar */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container > footer p {\n");
      out.write("            text-align: center; /* center align it with the container */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            width: 820px; /* downsize our container to make the content feel a bit tighter and more cohesive.\n");
      out.write("                           * NOTE: this removes two full columns from the grid, meaning you only go to\n");
      out.write("                           * 14 columns and not 16.\n");
      out.write("                           */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("            /* The white background content wrapper */\n");
      out.write("        .content {\n");
      out.write("            background-color: #fff;\n");
      out.write("            padding: 20px;\n");
      out.write("            margin: 0 -20px; /* negative indent the amount of the padding to maintain the grid system */\n");
      out.write("            -webkit-border-radius: 0 0 6px 6px;\n");
      out.write("            -moz-border-radius: 0 0 6px 6px;\n");
      out.write("            border-radius: 0 0 6px 6px;\n");
      out.write("            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);\n");
      out.write("            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);\n");
      out.write("            box-shadow: 0 1px 2px rgba(0, 0, 0, .15);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("            /* Page header tweaks */\n");
      out.write("        .page-header {\n");
      out.write("            background-color: #f5f5f5;\n");
      out.write("            padding: 20px 20px 10px;\n");
      out.write("            margin: -20px -20px 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("            /* Styles you shouldn't keep as they are for displaying this base example only */\n");
      out.write("        .content .span10,\n");
      out.write("        .content .span4 {\n");
      out.write("            min-height: 500px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("            /* Give a quick and non-cross-browser friendly divider */\n");
      out.write("        .content .span4 {\n");
      out.write("            margin-left: 0;\n");
      out.write("            padding-left: 19px;\n");
      out.write("            border-left: 1px solid #eee;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .topbar .btn {\n");
      out.write("            border: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("    <!-- Le fav and touch icons -->\n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/favicon.ico\">\n");
      out.write("    <link rel=\"apple-touch-icon\" href=\"images/apple-touch-icon.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"images/apple-touch-icon-72x72.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"images/apple-touch-icon-114x114.png\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"topbar\">\n");
      out.write("    <div class=\"fill\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <a class=\"brand\" href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${application}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("            <ul class=\"nav\">\n");
      out.write("                <li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("                <li><a href=\"#about\">About</a></li>\n");
      out.write("                <li><a href=\"#contact\">Contact</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("\n");
      out.write("    <div class=\"content\">\n");
      out.write("        <div class=\"page-header\">\n");
      out.write("            <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.localNick}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                <small>(hardcoded email)</small>\n");
      out.write("            </h1>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div id=\"errorPlace\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("\n");
      out.write("            <div class=\"span10\">\n");
      out.write("                <h2>Messages</h2>\n");
      out.write("\n");
      out.write("                <form class=\"span10\" id=\"message-send\">\n");
      out.write("                    <input type=\"hidden\" name=\"user\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.hash}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\n");
      out.write("                    <fieldset class=\"form-stacked\">\n");
      out.write("                        <div class=\"clearfix\">\n");
      out.write("                            <label for=\"messageArea\">Send a new message</label>\n");
      out.write("                            <div class=\"input\">\n");
      out.write("                                <textarea class=\"xxlarge\" name=\"usertext\" id=\"messageArea\" rows=\"3\"></textarea>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </fieldset>\n");
      out.write("                    <fieldset class=\"form-stacked\">\n");
      out.write("                        <div class=\"clearfix\">\n");
      out.write("                            <label for=\"fileArea\">Share a new file</label>\n");
      out.write("                            <div class=\"input\">\n");
      out.write("                                <input class=\"xylarge\" name=\"userfile\" id=\"fileArea\" type=\"file\" />\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </fieldset>\n");
      out.write("                    <fieldset>\n");
      out.write("                        <div class=\"actions\">\n");
      out.write("                            <input type=\"submit\" class=\"btn primary\" value=\"Send message\">&nbsp;\n");
      out.write("                            <button type=\"reset\" class=\"btn\">Cancel</button>\n");
      out.write("                        </div>\n");
      out.write("                    </fieldset>\n");
      out.write("                </form>\n");
      out.write("\t\t\t\t\n");
      out.write("                <div class=\"span10\" id=\"user-feed\">\n");
      out.write("                    <ul>\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"span4\">\n");
      out.write("                <h3>Local user</h3>\n");
      out.write("                <ul>\n");
      out.write("\t\t\t\t\t<li><a href=\"/user.jsp?user=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${localUser.hash}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${localUser.localNick}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("                \n");
      out.write("                <h3>Followers</h3>\n");
      out.write("\n");
      out.write("                <h3>Followees</h3>\n");
      out.write("                <ul id=\"user-friends\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("                <h3>Tags</h3>\n");
      out.write("\t\t\t\t<br/>\n");
      out.write("\t\t\t\t<h3>Chat</h3>\n");
      out.write("\t\t\t\t<a href='#self' id='openlink' onclick='openChat()' style='font-size: 10px;'>Chat with ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.localNick}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <footer>\n");
      out.write("        <p>&copy; University of Parma 2011</p>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"span10\" id=\"chatframe2\" style=\"width:310px; position:fixed; bottom:0; left:0;\">\t\n");
      out.write("\t<div id=\"chathead2\" style=\"text-align: left;\"> \n");
      out.write("\t\t<a href='#self' id=\"chatlink2\" onclick='closeChat2()'> </a>\n");
      out.write("\t</div>\n");
      out.write("\t<div id=\"chatbody2\"> </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"span10\" id=\"privatechat\" style=\"width:310px; position:fixed; bottom:0; left:50%; margin-left: -100px;\">\t\n");
      out.write("\t<div id=\"privbody\"> </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"span10\" id=\"chatframe\" style=\"width:310px; position:fixed; bottom:0; right:0;\">\t\n");
      out.write("\t<div id=\"chatbody\"> </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"localUser\" title=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loc}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></div>\n");
      out.write("<div id=\"remoteUser\" title=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${rem}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></div>\n");
      out.write("<div id=\"localNick\" title=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${localUser.localNick}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></div>\n");
      out.write("\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("entry");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${feed}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t\t<li>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${entry.content}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</li>\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("friend");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${friends}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<li><a href=\"/user.jsp?user=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${friend.hash}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${friend.localNick}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
