package system.actions;

import application.configuration.Config;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class RequestError {

    public void showError(String error, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            Config conf = new Config();

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>JSP Framework Error</title>");
            out.println("</head>");
            out.println("<style type=\"text/css\">");
            out.println("body {background:#e8e8e8;font-family:sans-serif;font-size:13px;color:#4F5155;}");
            out.println("h1 {text-align:center;color:#444;border-bottom:1px solid #D0D0D0;font-size:19px;font-weight:normal;margin: 0 0 14px 0;padding:14px 15px 10px 15px;}");
            out.println("#container {position:fixed;left:50%;top:50%;transform:translate(-50%,-50%);border:1px solid #D0D0D0;background:#f8f8f8;box-shadow:0px 0px 8px #d0d0d0;}");
            out.println("</style>");
            out.println("<body>");
            out.println("<div id='container'>");
            out.println("<h1>JSP Framework Error</h1>");
            out.println("<p style='margin: 12px 15px;'>" + error + "</p>");
            out.println("<b style='text-align: right;float: right;margin: 12px 15px;'> - " + conf.websiteName + "</b>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
