package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.UserBean;
import la.dao.AdminUserDAO;
import la.dao.DAOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	try {
	    String action = request.getParameter("action");

	    if (action == null || action.length() == 0) {
		// ログインページへ
		gotoPage(request, response, "/adminLogin.jsp");

	    } else if (action.equals("login")) {
		// ログイン
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		AdminUserDAO userDAO = new AdminUserDAO();
		UserBean user = userDAO.findByEmailAndPassword(email, password);

		if (user == null) {
		    // ログイン失敗
		    request.setAttribute("message", "再度入力をお願いします");
		    gotoPage(request, response, "/adminLogin.jsp");
		} else {
		    // ログイン成功
		    HttpSession session = request.getSession();
		    session.setAttribute("user", user);

		    gotoPage(request, response, "/adminTop.jsp");
		}
	    } else if (action.equals("logout")) {
		// ログアウト
		HttpSession session = request.getSession(false);
		if (session != null) {
		    session.invalidate();
		}
		gotoPage(request, response, "/adminLogin.jsp");
	    }

	} catch (DAOException e) {
	    e.printStackTrace();
	    request.setAttribute("message", "内部エラーが発生しました。");
	    gotoPage(request, response, "/errInternal.jsp");
	}
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
	    throws ServletException, IOException {
	RequestDispatcher rd = request.getRequestDispatcher(page);
	rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }
}