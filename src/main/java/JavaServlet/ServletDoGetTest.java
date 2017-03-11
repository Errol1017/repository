package JavaServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Enumeration;

/**
 * Created by Errol on 17/3/9.
 * servlet doGet方法获取参数
 * 需在web.xml配置servlet
 */
public class ServletDoGetTest extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {

    }

    public ServletDoGetTest() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //参数打印测试
        System.out.println(request.getParameter("name"));//打印正常，参数格式就是UTF-8
        System.out.println(new String(request.getParameter("name").getBytes("ISO8859-1"), "utf-8"));//打印??

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        String title = "使用GET方法读取表单数据";
        String name = URLDecoder.decode(request.getParameter("name"), "UTF-8");
        String h5declare = "<!DOCTYPE html> \n";

        Enumeration headerNames = request.getHeaderNames();
        StringBuilder stringBuilder = new StringBuilder("<table>");
        while (headerNames.hasMoreElements()) {
            String paramName = (String) headerNames.nextElement();
            stringBuilder.append("<tr><td>" + paramName + "</td>\n");
            String paramValue = request.getHeader(paramName);
            stringBuilder.append("<td>" + paramValue + "</td></tr>\n");
        }
        stringBuilder.append("</table>");
        printWriter.print(h5declare +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名</b>："
                + name + "\n" +
                "  <li><b>网址</b>："
                + request.getParameter("url") + "\n" +
                "</ul>\n" + stringBuilder +
                "</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void destroy() {

    }

}
