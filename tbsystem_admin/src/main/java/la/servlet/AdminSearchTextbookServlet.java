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

			try {
				String category = request.getParameter("category");
				String text = request.getParameter("text");
				AdminSearchTextbookDAO dao = new AdminSearchTextbookDAO();
				List<TextbookBean> list = dao.findByTextbook(category, text);
				request.setAttribute("textbook", list);

				gotoPage(request, response, "/adminSearchTextbook.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("returnSearchTextbook2")) {
			try {
				AdminSearchTextbookDAO dao = new AdminSearchTextbookDAO();
				List<TextbookBean> list = dao.findAll();
				request.setAttribute("textbook", list);
				gotoPage(request, response, "/adminSearchTextbook.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック

				e.printStackTrace();
			}
		} else if (action.equals("updateTextbook")) {
			try {
				//int user_id = Integer.parseInt(request.getParameter("user_id"));
				String isbn = request.getParameter("isbn");
				//String address = request.getParameter("address");
				//String tel = request.getParameter("tel");
				//String email = request.getParameter("email");
				String isbn_before = request.getParameter("isbn_before");

				AdminSearchTextbookDAO dao = new AdminSearchTextbookDAO();
				TextbookBean bean = dao.findIsbn(isbn);
				request.setAttribute("textbook", bean);
				request.setAttribute("isbn_before", isbn_before);

				gotoPage(request, response, "/adminUpdateTextbook.jsp");

			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("updateTextbookConfirm")) {

			String isbn = request.getParameter("isbn");
			String title = request.getParameter("title");
			String category_code = request.getParameter("category_name");
			String category_name = request.getParameter("category_name");
			String isbn_before = request.getParameter("isbn_before");
			if (category_name.equals("0")) {
				category_name = "文学部";
			} else if (category_name.equals("1")) {
				category_name = "教育学部";
			} else if (category_name.equals("2")) {
				category_name = "法学部";
			} else if (category_name.equals("3")) {
				category_name = "社会学部";
			} else if (category_name.equals("4")) {
				category_name = "経済学部";
			} else if (category_name.equals("5")) {
				category_name = "理学部";
			} else if (category_name.equals("6")) {
				category_name = "医学部";
			} else if (category_name.equals("7")) {
				category_name = "歯学部";
			} else if (category_name.equals("8")) {
				category_name = "薬学部";
			} else if (category_name.equals("9")) {
				category_name = "工学部";
			} else if (category_name.equals("10")) {
				category_name = "農学部";
			}

			String author = request.getParameter("author");
			//System.out.print(email);

			request.setAttribute("isbn", isbn);
			request.setAttribute("title", title);
			request.setAttribute("category_code", category_code);
			request.setAttribute("category_name", category_name);
			request.setAttribute("author", author);
			request.setAttribute("isbn_before", isbn_before);

			gotoPage(request, response, "/adminUpdateTextbookConfirm.jsp");

		} else if (action.equals("returnSearchTextbook")) {
			try {
				AdminSearchTextbookDAO dao = new AdminSearchTextbookDAO();
				List<TextbookBean> list = dao.findAll();
				request.setAttribute("textbook", list);
				gotoPage(request, response, "/adminSearchTextbook.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック

				e.printStackTrace();
			}
		} else if (action.equals("deleteTextbookConfirm")) {
			try {
				AdminSearchTextbookDAO dao = new AdminSearchTextbookDAO();
				String isbn = request.getParameter("isbn");
				TextbookBean bean = dao.findIsbn(isbn);
				request.setAttribute("textbook", bean);
				gotoPage(request, response, "/adminDeleteTextbookConfirm.jsp");
			} catch (DAOException e) {
				e.printStackTrace();
			}
		} else if (action.equals("deleteTextbookComplete")) {
			try {
				AdminSearchTextbookDAO dao = new AdminSearchTextbookDAO();
				String isbn = request.getParameter("isbn");
				if (dao.CheckInventory(isbn)) {
					dao.deleteTextbook(isbn);
					gotoPage(request, response, "/adminDeleteTextbookComplete.jsp");
				} else {
					TextbookBean bean = dao.findIsbn(isbn);
					request.setAttribute("textbook", bean);
					gotoPage(request, response, "/adminDeleteFailed.jsp");

				}
			} catch (DAOException e) {
				e.printStackTrace();
			}
		} else if (action.equals("updateTextbookComplete")) {

			try {
				String isbn = request.getParameter("isbn");
				String title = request.getParameter("title");
				int category_code = Integer.parseInt(request.getParameter("category_code"));
				String author = request.getParameter("author");
				String isbn_before = request.getParameter("isbn_before");

				//String category_name = request.getParameter("category_name");

				//int user_id = Integer.parseInt(request.getParameter("user_id"));
				//String name = request.getParameter("name");
				//String address = request.getParameter("address");
				//String tel = request.getParameter("tel");
				//String email = request.getParameter("email");

				//System.out.print(user_id);

				AdminSearchTextbookDAO dao = new AdminSearchTextbookDAO();
				dao.updateTextbook(isbn, title, category_code, author, isbn_before);

				//request.setAttribute("name", name);

				gotoPage(request, response, "/adminUpdateTextbookComplete.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

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
