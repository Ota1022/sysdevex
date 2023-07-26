package la.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.CategoryBean;
import la.bean.TextbookBean;
import la.bean.UserBean;
import la.dao.DAOException;
import la.dao.DisplayDAO;
import la.dao.PurchaseDAO;

/**
 * Servlet implementation class DisplayItemServlet
 */
@WebServlet("/DisplayItemServlet")
public class DisplayItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String action = request.getParameter("action");

			if (action == null || action.length() == 0 || action.equals("displayItemSearch")) {
				//検索ページへ
				gotoPage(request, response, "/displayItemSearch.jsp");

			} else if (action.equals("displayItemSearchResult")) {

				String isbn = request.getParameter("isbn");
				String title = request.getParameter("title");
				String categoryCode = request.getParameter("category_code");
				String author = request.getParameter("author");

				//categoryCodeがnullか判定必要
				//author, titleは一致検索
				if (categoryCode == null || categoryCode.length() == 0) {
					DisplayDAO dao = new DisplayDAO();
					List<TextbookBean> textbookList = dao.findByIsbnAndTitleAndAuthor(isbn, title, author);

					request.setAttribute("textbookList", textbookList);
					gotoPage(request, response, "/displayItemSearchResult.jsp");

				} else {
					DisplayDAO dao = new DisplayDAO();

					//場合分け必要 isbn, category_codeの有無で
					//isbnは一致検索でもよいかも
					List<TextbookBean> textbookList = dao.findByCategoryAndIsbnAndTitleAndAuthor(
							Integer.parseInt(categoryCode), isbn, title, author);

					request.setAttribute("textbookList", textbookList);
					gotoPage(request, response, "/displayItemSearchResult.jsp");
				}

			} else if (action.equals("displayItem")) {
				//セッション判定
				HttpSession session = request.getSession(false);
				if (session == null) {
					request.setAttribute("message", "セッションが切れています。もう一度ログインをお願いします。");
					gotoPage(request, response, "/login.jsp");
				}

				String isbn = request.getParameter("isbn");
				DisplayDAO dao = new DisplayDAO();
				TextbookBean textbook = dao.findByPrimaryKey(isbn);

				request.setAttribute("textbook", textbook);
				gotoPage(request, response, "/displayItem.jsp");

			} else if (action.equals("returnDisplayHistory")) {
				String isbn = request.getParameter("isbn");
				int stateCode = Integer.parseInt(request.getParameter("state_code"));
				int price = Integer.parseInt(request.getParameter("price"));
				String note = request.getParameter("note");

				DisplayDAO dao = new DisplayDAO();

				//セッション判定
				HttpSession session = request.getSession(false);
				if (session == null) {
					request.setAttribute("message", "セッションが切れています。もう一度ログインをお願いします。");
					gotoPage(request, response, "/login.jsp");
				}

				UserBean user = (UserBean) session.getAttribute("user");

				dao.addInventory(isbn, user.getUserID(), stateCode, price, 1, note,
						new Date(), new Date());

				gotoPage(request, response, "/displayHistoryNotSold.jsp");

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

	public void init() throws ServletException {
		try {
			// カテゴリ一覧は最初にアプリケーションスコープへ入れる
			PurchaseDAO dao = new PurchaseDAO();
			List<CategoryBean> list = dao.findAllCategory();
			getServletContext().setAttribute("categoryList", list);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServletException();
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

}
