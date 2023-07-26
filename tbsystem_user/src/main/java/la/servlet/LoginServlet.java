package la.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.UserBean;
import la.dao.DAOException;
import la.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");

			if (action == null || action.length() == 0) {
				//ログインページへ
				gotoPage(request, response, "/login.jsp");

			} else if (action.equals("login")) {
				//ログイン
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				UserDAO userDAO = new UserDAO();
				UserBean user = userDAO.findByEmailAndPassword(email, password);

				if (user == null) {
					//ログイン失敗
					request.setAttribute("message", "再度入力をお願いします");
					gotoPage(request, response, "/login.jsp");
				} else {
					//ログイン成功
					HttpSession session = request.getSession();
					session.setAttribute("user", user);

					gotoPage(request, response, "/top.jsp");
				}
			} else if (action.equals("logout")) {
				//ログアウト
				HttpSession session = request.getSession(false);
				if (session != null) {
					session.invalidate();
				}
				gotoPage(request, response, "/login.jsp");
			} else if (action.equals("registUserForm")) {
				//ユーザ登録フォームへ遷移
				gotoPage(request, response, "/registUserForm.jsp");
			} else if (action.equals("registUserConfirm")) {
				String password = request.getParameter("password");
				String password_confirm = request.getParameter("password_confirm");

				//パスワードチェック
				if (password.equals(password_confirm)) {
					request.setAttribute("message", "パスワードが一致していません");
					gotoPage(request, response, "/registUserForm.jsp");
				}

				String name = request.getParameter("name");
				//String birthday = request.getParameter("birthday_year") + '/' + request.getParameter("birthday_month")
				//		+ '/' + request.getParameter("birthday_day");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel1") + '-' + request.getParameter("tel2")
						+ '-' + request.getParameter("tel3");

				List<String> domainList = makeDomainList();
				//メアドドメインチェック
				boolean is_in_domainList = false;
				System.out.println(getMailDomain(email));
				for (String domain : domainList) {
					if (getMailDomain(email).equals(domain)) {
						is_in_domainList = true;
						break;
					}
				}
				if (is_in_domainList == false) {
					request.setAttribute("message", "メールアドレスが不正です");
					gotoPage(request, response, "/registUserForm.jsp");
				}

				request.setAttribute("password", password);
				request.setAttribute("email", email);
				request.setAttribute("name", name);
				request.setAttribute("address", address);
				request.setAttribute("tel", tel);
				gotoPage(request, response, "/registUserConfirm.jsp");

			} else if (action.equals("sendEmail")) {
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				Date registDate = new Date();
				//birthday

				UserBean user = new UserBean(-1, name, password, email, address, tel, registDate, new Date(0),
						new Date(0));

				UserDAO userDAO = new UserDAO();

				userDAO.addUser(user);
				gotoPage(request, response, "/sendEmail.jsp");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private List<String> makeDomainList() throws ServletException {
		/* 初期化処理 */
		// カテゴリ一覧は最初にアプリケーションスコープへ入れる
		List<String> mailDomainList = new ArrayList<String>();
		mailDomainList.add("@test.ac.jp");
		return mailDomainList;
	}

	private String getMailDomain(String email) throws ServletException {
		int pos = email.indexOf("@");
		return email.substring(pos).strip();
	}

}
