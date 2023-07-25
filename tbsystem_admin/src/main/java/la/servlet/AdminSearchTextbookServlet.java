package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.TextbookBean;
import la.dao.AdminSearchTextbookDAO;
import la.dao.DAOException;

/**
 * Servlet implementation class AdminSearchTextbookServlet
 */
@WebServlet("/AdminSearchTextbookServlet")
public class AdminSearchTextbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSearchTextbookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		//System.out.println("aaa");

		if (action == null || action.length() == 0 || action.equals("SearchTextbook")) {
			// showまたはパラメータなしの場合はカートページを表示
			try {

				AdminSearchTextbookDAO dao = new AdminSearchTextbookDAO();

				//UserBean bean = dao.findAll();
				List<TextbookBean> list = dao.findAll();

				request.setAttribute("textbook", list);
				//System.out.println("bbb");

				gotoPage(request, response, "/adminSearchTextbook.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック

				e.printStackTrace();
			}

		} else if (action.equals("returnSearchTextbook")) {

		}
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
