package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.CategoryBean;
import la.bean.TextbookBean;
import la.dao.AdminRegistTextbookDAO;

/**
 * Servlet implementation class AdminRegistTextbookServlet
 */
@WebServlet("/AdminRegistTextbookServlet")
public class AdminRegistTextbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminRegistTextbookServlet() {
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
		try {
			// パラメータの解析
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			AdminRegistTextbookDAO dao = new AdminRegistTextbookDAO();
			List<CategoryBean> category_list = null;
			if (action == null || action.length() == 0 || action.equals("registTextbook")) {
				category_list = dao.findCategory();
				request.setAttribute("categoryList", category_list);
				gotoPage(request, response, "/adminRegistTextbook.jsp");
				return;
			} else if (action.equals("registTextbookConfirm")) {
				String isbn = request.getParameter("isbn");
				System.out.print(isbn);
				String title = request.getParameter("title");
				int categoryID = Integer.parseInt(request.getParameter("categoryCheck"));
				String categoryName = dao.findCategoryName(categoryID);
				String author = request.getParameter("author");
				TextbookBean bean = new TextbookBean(isbn, categoryID, categoryName, title, author);
				request.setAttribute("textbook", bean);
				gotoPage(request, response, "/adminRegistTextbookConfirm.jsp");
				return;
			} else if (action.equals("registTextbook")) {
				gotoPage(request, response, "/adminRegistTextbook.jsp");
			} else if (action.equals("registTextbookComplete")) {
				String isbn = request.getParameter("isbn");
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				int category_code = Integer.parseInt(request.getParameter("category_code"));
				dao.addTextbook(isbn, category_code, title, author);
				gotoPage(request, response, "/adminRegistTextbookComplete.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errInternal.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
