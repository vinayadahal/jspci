package system;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestFilter implements Filter {

    private static final boolean debug = true;

    private FilterConfig filterConfig = null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI();//gets requested url.
        String rootDir = path.substring(1);//removes "/" from requested url.
        if (rootDir.contains("/")) {//searches for url that contains '/' after a name like "images/".
            rootDir = rootDir.substring(0, rootDir.indexOf("/"));//creates url like "images".
        }
        if (!"/".equals(path) && path.contains(req.getContextPath()) && !req.getContextPath().isEmpty()) {
            if (rootDir.contains("css") || rootDir.contains("js") || rootDir.contains("images")) {
                request.getRequestDispatcher(path).forward(request, response);  // forwards requested url without applying filter.
            } else {
                String[] reqUrl = path.split(req.getContextPath());
                path = reqUrl[1];
                depContextPath(request, response, path);
            }
        } else {
            if (rootDir.contains("css") || rootDir.contains("js") || rootDir.contains("images")) {
                request.getRequestDispatcher(path).forward(request, response);  // forwards requested url without applying filter.
            } else {
                depRootPath(request, response, path, rootDir);
            }
        }
    }

    public void depContextPath(ServletRequest request, ServletResponse response, String path) throws ServletException, IOException {
        if (path.contains("css") || path.contains("js") || path.contains("images")) {
            request.getRequestDispatcher(path).forward(request, response); // forwards requested url without applying filter.
        } else {
            request.getRequestDispatcher("/RequestHandler" + path).forward(request, response); //forwards requested url to servlet.
        }
    }

    public void depRootPath(ServletRequest request, ServletResponse response, String path, String rootDir) throws ServletException, IOException {
        request.getRequestDispatcher("/RequestHandler" + path).forward(request, response); //forwards requested url to servlet.
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("urlFilter:Initializing filter");
            }
        }
    }

    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("urlFilter()");
        }
        StringBuilder sb = new StringBuilder("urlFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
}
