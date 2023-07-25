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
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if (action == null || action.length() == 0 || action.equals("SearchUser")) {
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
				AdminSearchUserDAO dao = new AdminSearchUserDAO();
				List<UserBean> list = dao.findByUser(category, text);
				request.setAttribute("user", list);

				gotoPage(request, response, "/adminSearchUser.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			//gotoPage(request, response, "/adminUpdateUser.jsp");

		} else if (action.equals("updateUser")) {

			try {

				int user_id = Integer.parseInt(request.getParameter("user_id"));
				//String name = request.getParameter("name");
				//String address = request.getParameter("address");
				//String tel = request.getParameter("tel");
				//String email = request.getParameter("email");

				AdminSearchUserDAO dao = new AdminSearchUserDAO();
				UserBean bean = dao.findByPrimaryKey(user_id);
				request.setAttribute("user", bean);

				gotoPage(request, response, "/adminUpdateUser.jsp");

			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("deleteUserConfirm")) {

			int user_id = Integer.parseInt(request.getParameter("user_id"));
			request.setAttribute("user_id", user_id);
			try {

				AdminSearchUserDAO dao = new AdminSearchUserDAO();
				UserBean bean = dao.findByPrimaryKey(user_id);
				request.setAttribute("user", bean);

				gotoPage(request, response, "/adminDeleteUserConfirm.jsp");

			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} else if (action.equals("userConfirm")) {

			String user_id = request.getParameter("user_id");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String tel1 = request.getParameter("tel1");
			String tel2 = request.getParameter("tel2");
			String tel3 = request.getParameter("tel3");
			String tel = tel1 + "-" + tel2 + "-" + tel3;
			String email = request.getParameter("email");

			//System.out.print(email);

			request.setAttribute("user_id", user_id);
			request.setAttribute("name", name);
			request.setAttribute("address", address);
			request.setAttribute("tel", tel);
			request.setAttribute("email", email);

			gotoPage(request, response, "/adminUpdateUserConfirm.jsp");

		} else if (action.equals("updateUserComplete")) {

			try {
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");

				System.out.print(user_id);

				AdminSearchUserDAO dao = new AdminSearchUserDAO();
				dao.updateUser(user_id, name, address, tel, email);

				//request.setAttribute("name", name);

				gotoPage(request, response, "/adminUpdateUserComplete.jsp");
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			//gotoPage(request, response, "/adminUpdateUserComplete.jsp");

		} else if (action.equals("UpdateUser")) {

			gotoPage(request, response, "/adminUpdateUser.jsp");

		} else if (action.equals("deleteUserComplete")) {

			try {

				int user_id = Integer.parseInt(request.getParameter("user_id"));

				AdminSearchUserDAO dao = new AdminSearchUserDAO();
				dao.deleteUser(user_id);
				//request.setAttribute("user", bean);

				gotoPage(request, response, "/adminDeleteUserComplete.jsp");

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
