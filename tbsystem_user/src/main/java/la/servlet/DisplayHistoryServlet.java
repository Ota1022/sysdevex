package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.InventoryBean;
import la.bean.UserBean;
import la.dao.DAOException;
import la.dao.MyPageDAO;

//import la.dao.DAOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/DisplayHistoryServlet")
public class DisplayHistoryServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// パラメータの解析
			String action = request.getParameter("action");
			if (action == null || action.length() == 0) {
				gotoPage(request, response, "/myPage.jsp");
			} else if (action.equals("updateItem")) {
				int inventoryID = Integer.parseInt(request.getParameter("inventory_id"));
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				int price = Integer.parseInt(request.getParameter("price"));
				String note = request.getParameter("note");
				request.setAttribute("inventory_id", inventoryID);
				request.setAttribute("title", title);
				request.setAttribute("author", author);
				request.setAttribute("price", price);
				request.setAttribute("note", note);
				gotoPage(request, response, "/updateItem.jsp");
			} else if (action.equals("updateItemConfirm")) {
				int inventoryID = Integer.parseInt(request.getParameter("inventory_id"));
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				int stateCode = Integer.parseInt(request.getParameter("state_code"));
				int price = Integer.parseInt(request.getParameter("price"));
				String note = request.getParameter("note");
				InventoryBean item = new InventoryBean(inventoryID, title, author, stateCode, price, note);
				request.setAttribute("item", item);
				gotoPage(request, response, "/updateItemConfirm.jsp");
			} else if (action.equals("updateItemComplete")) {
				MyPageDAO dao = new MyPageDAO();
				int inventoryID = Integer.parseInt(request.getParameter("inventory_id"));
				int stateCode = Integer.parseInt(request.getParameter("state_code"));
				int price = Integer.parseInt(request.getParameter("price"));
				String note = request.getParameter("note");
				dao.updateItem(inventoryID, stateCode, price, note);
				gotoPage(request, response, "/updateItemComplete.jsp");
			} else if (action.equals("deleteItemConfirm")) {
				int inventoryID = Integer.parseInt(request.getParameter("inventory_id"));
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				int price = Integer.parseInt(request.getParameter("price"));
				request.setAttribute("inventory_id", inventoryID);
				request.setAttribute("title", title);
				request.setAttribute("author", author);
				request.setAttribute("price", price);
				gotoPage(request, response, "/deleteItemConfirm.jsp");
			} else if (action.equals("deleteItemComplete")) {
				MyPageDAO dao = new MyPageDAO();
				int inventoryID = Integer.parseInt(request.getParameter("inventory_id"));
				dao.deleteByPrimaryKey(inventoryID);
				gotoPage(request, response, "/deleteItemComplete.jsp");

			} else if (action.equals("updateUserConfirm")) {
				//土屋君のコードを基に修正必要
				HttpSession session = request.getSession(true);
				UserBean bean = (UserBean) session.getAttribute("user");
				String address = request.getParameter("address");
				String tel1 = request.getParameter("tel1");
				String tel2 = request.getParameter("tel2");
				String tel3 = request.getParameter("tel3");
				String tel = tel1 + "-" + tel2 + "-" + tel3;
				String password = request.getParameter("password");
				String passwordConfirm = request.getParameter("password_confirm");
				String name = bean.getName();
				String email = bean.getEmail();
				if (password.equals(passwordConfirm)) {
					UserBean user = new UserBean(name, email, address, tel, password);
					request.setAttribute("user", user);
					gotoPage(request, response, "/updateUserConfirm.jsp");
				} else {
					request.setAttribute("message", "確認用パスワードが一致しません");
					gotoPage(request, response, "/updateUser.jsp");
				}

			} else if (action.equals("updateUserComplete")) {
				MyPageDAO dao = new MyPageDAO();
				HttpSession session = request.getSession(true);
				UserBean bean = (UserBean) session.getAttribute("user");
				int userID = bean.getUserID();
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				String password = request.getParameter("password");
				dao.updateUser(userID, address, tel, password);
				gotoPage(request, response, "/updateUserComplete.jsp");
			} else if (action.equals("deleteUserForm")) {
				HttpSession session = request.getSession(true);
				UserBean user = (UserBean) session.getAttribute("user");
				request.setAttribute("user", user);
				gotoPage(request, response, "/deleteUserForm.jsp");
			} else if (action.equals("deleteUserConfirm")) {
				HttpSession session = request.getSession(true);
				UserBean user = (UserBean) session.getAttribute("user");
				String password = user.getPassword();
				String passwordConfirm = request.getParameter("password");
				if (password.equals(passwordConfirm)) {
					request.setAttribute("user", user);
					gotoPage(request, response, "/deleteUserConfirm.jsp");
				} else {
					request.setAttribute("message", "パスワードが正しくありません");
					gotoPage(request, response, "/deleteUserForm.jsp");
				}
			} else if (action.equals("deleteUserComplete")) {
				HttpSession session = request.getSession(true);
				UserBean user = (UserBean) session.getAttribute("user");
				MyPageDAO dao = new MyPageDAO();
				int userID = user.getUserID();
				dao.updateDeleteDateByPrimaryKey(userID);
				request.setAttribute("user", user);
				gotoPage(request, response, "/deleteUserComplete.jsp");
			} else {
				//actionの値が不正
				request.setAttribute("message", "正しく操作してください。");
				gotoPage(request, response, "/errInternal.jsp");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errInternal.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}