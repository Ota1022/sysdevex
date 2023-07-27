package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.InventoryBean;
import la.dao.AdminSearchInventoryDAO;

/**
 * Servlet implementation class AdminSearchInventoryServlet
 */
@WebServlet("/AdminSearchInventoryServlet")
public class AdminSearchInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSearchInventoryServlet() {
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
			List<InventoryBean> list = null;
			AdminSearchInventoryDAO dao = new AdminSearchInventoryDAO();
			if (action == null || action.length() == 0 || action.equals("searchInventory")) {
				list = dao.findAll();
				request.setAttribute("inventory", list);
				gotoPage(request, response, "/adminSearchInventory.jsp");
			} else if (action.equals("stopInventoryComplete")) {
				int inventory_id = Integer.parseInt(request.getParameter("inventory_id"));
				dao.stopInventory(inventory_id);
				gotoPage(request, response, "/adminStopInventoryComplete.jsp");
				return;

			} else if (action.equals("updateInventory")) {
				int inventory_id = Integer.parseInt(request.getParameter("inventory_id"));
				InventoryBean bean = dao.findInventoryID(inventory_id);
				request.setAttribute("inventory", bean);
				gotoPage(request, response, "/adminUpdateInventory.jsp");
				return;

			} else if (action.equals("stopInventoryConfirm")) {
				int inventory_id = Integer.parseInt(request.getParameter("inventory_id"));
				InventoryBean bean = dao.findInventoryID(inventory_id);
				request.setAttribute("inventory", bean);
				gotoPage(request, response, "/adminStopInventoryConfirm.jsp");
				return;

			} else if (action.equals("searchInventory")) {
				list = dao.findAll();
				request.setAttribute("inventory", list);
				gotoPage(request, response, "/adminSearchInventory.jsp");
				return;
			} else if (action.equals("returnSearchInventory")) {
				String pull = request.getParameter("pull");
				String query = request.getParameter("query");
				list = dao.findSearchWord(pull, query);
				request.setAttribute("inventory", list);
				gotoPage(request, response, "/adminSearchInventory.jsp");
				return;
			} else if (action.equals("updateInventoryConfirm")) {
				int inventory_id = Integer.parseInt(request.getParameter("inventory_id"));
				int price = Integer.parseInt(request.getParameter("price"));
				int state_code = Integer.parseInt(request.getParameter("state_name"));
				String state_name = dao.findStateName(state_code);
				String note = request.getParameter("note");
				InventoryBean bean = dao.findInventoryID(inventory_id);
				request.setAttribute("inventory", bean);
				request.setAttribute("price", price);
				request.setAttribute("state_name", state_name);
				request.setAttribute("note", note);
				gotoPage(request, response, "/adminUpdateInventoryConfirm.jsp");
				return;
			} else if (action.equals("updateInventoryComplete")) {
				int inventory_id = Integer.parseInt(request.getParameter("inventory_id"));
				int price = Integer.parseInt(request.getParameter("price"));
				String state_name = request.getParameter("state_name");
				int state_code = dao.findStateCode(state_name);
				String note = request.getParameter("note");
				dao.updateInventory(inventory_id, price, state_code, note);
				gotoPage(request, response, "/adminUpdateInventoryComplete.jsp");
				return;
			} else if (action.equals("adminSearchInventory")) {
				list = dao.findAll();
				request.setAttribute("inventory", list);
				gotoPage(request, response, "/adminSearchInventory.jsp");
				return;
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
