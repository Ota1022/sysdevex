package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet { // HelloServletクラスの定義
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { // doGetメソッドの定義
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<html><head><title>HelloServlet</title></head><body>");
	    out.println("<h1>ようこそ！HelloServletへ</h1>");
	    out.println("</body></html>");
	}
}