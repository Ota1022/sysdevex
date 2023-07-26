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
import la.bean.InventoryBean;
import la.bean.UserBean;
import la.dao.DAOException;
import la.dao.PurchaseDAO;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseServlet() {
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

			if (action == null || action.length() == 0 || action.equals("top")) {
				//セッション判定
				HttpSession session = request.getSession(false);
				if (session == null) {
					request.setAttribute("message", "セッションが切れています。もう一度ログインをお願いします。");
					gotoPage(request, response, "/login.jsp");
				}
				//topページへ
				gotoPage(request, response, "/top.jsp");

			} else if (action.equals("itemList")) {
				//検索結果表示
				String query = request.getParameter("query");
				String categoryCode = request.getParameter("category_code");
				System.out.println(categoryCode);

				if (categoryCode == null || categoryCode.length() == 0) {
					if ((query == null || query.length() == 0)) {
						//(query, category_code)=(null, null)ならtop.jsp表示
						gotoPage(request, response, "/top.jsp");
					} else {
						//(query, category_code)=(exist, null)ならqueryだけで検索
						PurchaseDAO dao = new PurchaseDAO();
						List<InventoryBean> inventoryList = dao.findByTitle(query);
						request.setAttribute("inventoryList", inventoryList);
						gotoPage(request, response, "/itemList.jsp");
					}
				} else {
					//(query, category_code)=(exist, exist)
					//(query, category_code)=(null, exist)なら両方使って検索
					PurchaseDAO dao = new PurchaseDAO();
					List<InventoryBean> inventoryList = dao.findByTitleAndCategory(query,
							Integer.parseInt(categoryCode));
					request.setAttribute("inventoryList", inventoryList);
					gotoPage(request, response, "/itemList.jsp");
				}
			} else if (action.equals("itemDetail")) {
				//商品詳細画面へ
				int inventoryID = Integer.parseInt(request.getParameter("inventory_id"));
				PurchaseDAO dao = new PurchaseDAO();
				InventoryBean inventory = dao.findByPrimaryKey(inventoryID);
				request.setAttribute("inventory", inventory);
				gotoPage(request, response, "/itemDetail.jsp");

			} else if (action.equals("purchaseConfirm")) {
				//購入確認画面へ
				int inventoryID = Integer.parseInt(request.getParameter("inventory_id"));
				PurchaseDAO dao = new PurchaseDAO();
				InventoryBean inventory = dao.findByPrimaryKey(inventoryID);
				request.setAttribute("inventory", inventory);
				gotoPage(request, response, "/purchaseConfirm.jsp");

			} else if (action.equals("purchaseComplete")) {
				//購入完了処理
				int inventoryID = Integer.parseInt(request.getParameter("inventory_id"));
				PurchaseDAO dao = new PurchaseDAO();

				//セッション判定
				HttpSession session = request.getSession(false);
				if (session == null) {
					request.setAttribute("message", "セッションが切れています。もう一度ログインをお願いします。");
					gotoPage(request, response, "/login.jsp");
				}

				UserBean user = (UserBean) session.getAttribute("user");
				Date sellDate = new Date();
				int receiptID = dao.registReceipt(user.getUserID(), inventoryID, sellDate);
				dao.updateInventoryStateCode(inventoryID, 0);
				request.setAttribute("receiptID", receiptID);
				gotoPage(request, response, "/purchaseComplete.jsp");
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
			//System.out.println(list.get(2).getCategoryID());
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
