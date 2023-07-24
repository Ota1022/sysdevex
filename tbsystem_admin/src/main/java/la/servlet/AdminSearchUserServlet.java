package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.UserBean;
import la.dao.AdminSearchUserDAO;
import la.dao.DAOException;

/**
 * Servlet implementation class AdminSearchUserServlet
 */
@WebServlet("/AdminSearchUserServlet")
public class AdminSearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSearchUserServlet() {
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

		String action = request.getParameter("action");
		if (action == null || action.length() == 0) {
			// showまたはパラメータなしの場合はカートページを表示
			try {
				AdminSearchUserDAO dao = new AdminSearchUserDAO();
				//UserBean bean = dao.findAll();
				List<UserBean> list = dao.findAll();
				request.setAttribute("user", list);

				gotoPage(request, response, "/adminSearchUser.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック

				e.printStackTrace();
			}

		} else if (action.equals("returnSearchUser")) {

			try {

				String category = request.getParameter("category");

				String text = request.getParameter("text");
				//System.out.println(category);
				//System.out.println(text);
				AdminSearchUserDAO dao = new AdminSearchUserDAO();
				List<UserBean> list = dao.findByUser(category, text);
				//System.out.println("wwwwww");
				request.setAttribute("user", list);

				gotoPage(request, response, "/adminSearchUser.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				System.out.print("/");
				e.printStackTrace();
			}
			//gotoPage(request, response, "/adminUpdateUser.jsp");

		} else if (action.equals("updateUser")) {

			gotoPage(request, response, "/adminUpdateUser.jsp");

		} else if (action.equals("deleteUserConfirm")) {

			gotoPage(request, response, "/adminDeleteUserConfirm.jsp");

		} else if (action.equals("userConfirm")) {

			System.out.print("aaa");
			gotoPage(request, response, "/adminUpdateUserConfirm.jsp");

		} else if (action.equals("adminSearchUser")) {

			System.out.print("ase");
			gotoPage(request, response, "/adminSearchUser.jsp");

		} else if (action.equals("updateUserComplete")) {

			gotoPage(request, response, "/adminUpdateUserComplete.jsp");

		} else if (action.equals("UpdateUser")) {

			gotoPage(request, response, "/adminUpdateUser.jsp");

		} else if (action.equals("deleteUserComplete")) {
			;
			gotoPage(request, response, "/adminDeleteUserComplete.jsp");

		} else if (action.equals("searchUser")) {

			gotoPage(request, response, "/adminSearchUser.jsp");

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
