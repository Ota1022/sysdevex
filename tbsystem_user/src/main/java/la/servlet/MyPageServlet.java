package la.servlet;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// パラメータの解析
			String action = request.getParameter("action");
			//System.out.println(action);
			if (action == null || action.length() == 0) {
				gotoPage(request, response, "/myPage.jsp");
			} else if (action.equals("purchaseHistory")) {
				MyPageDAO dao = new MyPageDAO();
				HttpSession session = request.getSession(true);
				UserBean user = (UserBean) session.getAttribute("user");
				int userID = user.getUserID();
				List<InventoryBean> items = dao.findPurchaseHistory(userID);
				request.setAttribute("items", items);
				gotoPage(request, response, "/purchaseHistory.jsp");
			} else if (action.equals("displayHistory")) {
				MyPageDAO dao = new MyPageDAO();
				HttpSession session = request.getSession(true);
				UserBean user = (UserBean) session.getAttribute("user");
				int userID = user.getUserID();
				int isinInventoryCode = Integer.parseInt(request.getParameter("isin_inventory_code"));
				List<InventoryBean> items = dao.findByIsinInventory(userID, isinInventoryCode);
				request.setAttribute("items", items);
				request.setAttribute("isin_inventory_code", isinInventoryCode);
				gotoPage(request, response, "/displayHistory.jsp");
			} else if (action.equals("userInfo")) {
				MyPageDAO dao = new MyPageDAO();
				HttpSession session = request.getSession(true);
				UserBean bean = (UserBean) session.getAttribute("user");
				int userID = bean.getUserID();
				UserBean user = dao.findByPrimaryKey(userID);
				request.setAttribute("user", user);
				gotoPage(request, response, "/userinfo.jsp");
			} else if (action.equals("updateUser")) {
				HttpSession session = request.getSession(true);
				UserBean user = (UserBean) session.getAttribute("user");
				request.setAttribute("user", user);
				gotoPage(request, response, "/updateUser.jsp");
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
				bean.setAddress(address);
				String tel = request.getParameter("tel");
				bean.setTel(tel);
				String password = request.getParameter("password");
				bean.setPassword(password);
				dao.updateUser(userID, address, tel, password);
				/*String name = bean.getName();
				String email = bean.getEmail();
				Date registDate = bean.getRegist_date();
				Date deleteDate = bean.getDelete_date();
				Date birthday = bean.getBirthday();
				UserBean newBean = new UserBean(userID, name, password, email, address, tel, registDate, deleteDate,
						birthday);
				session.setAttribute("user", newBean);*/
				session.setAttribute("user", bean);
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