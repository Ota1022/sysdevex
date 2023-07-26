package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import la.bean.CategoryBean;
import la.bean.InventoryBean;
import la.bean.UserBean;

public class PurchaseDAO {
	// URL、ユーザ名、パスワードの準備
	private String url = "jdbc:postgresql:tbsystem";
	private String user = "student";
	private String pass = "himitu";

	public PurchaseDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}

	public List<CategoryBean> findAllCategory() throws DAOException {
		//SQL textbookとinventoryをisbnで、inventoryとstateをstate_codeで結合する
		String sql = "SELECT * FROM category ORDER BY category_code";
		try (//Connect DB
				Connection con = DriverManager.getConnection(url, user, pass);
				//Get Prepared Statement
				PreparedStatement st = con.prepareStatement(sql);) {

			List<CategoryBean> list = new ArrayList<CategoryBean>();

			try (//Execute sql
					ResultSet rs = st.executeQuery();) {
				//Get Result
				while (rs.next()) {
					CategoryBean bean = new CategoryBean(rs.getInt("category_code"), rs.getString("category_name"));
					list.add(bean);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}
		} catch (SQLException e) {
			throw new DAOException("レコードの取得に失敗しました。");
		}

	}

	public List<InventoryBean> findByTitle(String query) throws DAOException {
		//SQL textbookとinventoryをisbnで、inventoryとstateをstate_codeで結合する
		String sql = "SELECT * FROM inventory INNER JOIN textbook ON inventory.isbn = textbook.isbn INNER JOIN state ON inventory.state_code = state.state_code INNER JOIN category ON textbook.category_code = category.category_code WHERE title LIKE ?";

		try (//Connect DB
				Connection con = DriverManager.getConnection(url, user, pass);
				//Get Prepared Statement
				PreparedStatement st = con.prepareStatement(sql);) {
			//Place holder
			st.setString(1, '%' + query + '%');
			List<InventoryBean> list = new ArrayList<InventoryBean>();

			try (//Execute sql
					ResultSet rs = st.executeQuery();) {
				//Get Result
				while (rs.next()) {
					InventoryBean bean = new InventoryBean(rs.getInt("inventory_id"), rs.getString("title"),
							rs.getString("author"), rs.getInt("price"),
							rs.getInt("user_id"), null, -1, null,
							rs.getInt("state_code"), rs.getString("state_name"), rs.getInt("category_code"),
							rs.getString("category_name"),
							rs.getInt("isin_inventory_code"), null, rs.getString("note"),
							rs.getDate("inventory_regist_date"), new Date(0), new Date(0));
					list.add(bean);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}

		} catch (SQLException e) {
			throw new DAOException("レコードの取得に失敗しました。");
		}

	}

	public List<InventoryBean> findByTitleAndCategory(String query, int categoryCode) throws DAOException {
		//SQL textbookとinventoryをisbnで、inventoryとstateをstate_codeで結合する
		String sql = "SELECT * FROM inventory INNER JOIN textbook ON inventory.isbn = textbook.isbn INNER JOIN state ON inventory.state_code = state.state_code INNER JOIN category ON textbook.category_code = category.category_code WHERE title LIKE ? AND textbook.category_code = ?";

		try (//Connect DB
				Connection con = DriverManager.getConnection(url, user, pass);
				//Get Prepared Statement
				PreparedStatement st = con.prepareStatement(sql);) {
			//Place holder
			st.setString(1, '%' + query + '%');
			st.setInt(2, categoryCode);
			List<InventoryBean> list = new ArrayList<InventoryBean>();

			try (//Execute sql
					ResultSet rs = st.executeQuery();) {
				//Get Result
				while (rs.next()) {
					InventoryBean bean = new InventoryBean(rs.getInt("inventory_id"), rs.getString("title"),
							rs.getString("author"), rs.getInt("price"),
							rs.getInt("user_id"), null, -1, null,
							rs.getInt("state_code"), rs.getString("state_name"), rs.getInt("category_code"),
							rs.getString("category_name"),
							rs.getInt("isin_inventory_code"), null, rs.getString("note"),
							rs.getDate("inventory_regist_date"), new Date(0), new Date(0));
					list.add(bean);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}

		} catch (SQLException e) {
			throw new DAOException("レコードの取得に失敗しました。");
		}

	}

	public InventoryBean findByPrimaryKey(int inventoryID) throws DAOException {
		//SQL textbookとinventoryをisbnで、inventoryとstateをstate_codeで結合する
		String sql = "SELECT * FROM inventory INNER JOIN textbook ON inventory.isbn = textbook.isbn INNER JOIN state ON inventory.state_code = state.state_code INNER JOIN category ON textbook.category_code = category.category_code WHERE inventory_id = ?";

		try (//Connect DB
				Connection con = DriverManager.getConnection(url, user, pass);
				//Get Prepared Statement
				PreparedStatement st = con.prepareStatement(sql);) {
			//Place holder
			st.setInt(1, inventoryID);

			try (//Execute sql
					ResultSet rs = st.executeQuery();) {
				//Get Result
				if (rs.next()) {
					InventoryBean bean = new InventoryBean(rs.getInt("inventory_id"), rs.getString("title"),
							rs.getString("author"), rs.getInt("price"),
							rs.getInt("user_id"), null, -1, null,
							rs.getInt("state_code"), rs.getString("state_name"), rs.getInt("category_code"),
							rs.getString("category_name"),
							rs.getInt("isin_inventory_code"), null, rs.getString("note"),
							rs.getDate("inventory_regist_date"), new Date(0), new Date(0));
					return bean;
				} else {
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}

		} catch (SQLException e) {
			throw new DAOException("レコードの取得に失敗しました。");
		}

	}

	public int registReceipt(int userID, int inventoryID, Date sellDate) throws DAOException {
		// 注文番号の取得 Serial型の暗黙シーケンスから取得
		int receiptID = -1;
		String sql = "SELECT nextval('sell_receipt_id_seq')";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
				// SQLの実行
				ResultSet rs = st.executeQuery();) {
			if (rs.next()) {
				receiptID = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}

		sql = "INSERT INTO sell(user_id, inventory_id, sell_date) VALUES(?, ?, ?)";

		try (//Connect DB
				Connection con = DriverManager.getConnection(url, user, pass);
				//Get Prepared Statement
				PreparedStatement st = con.prepareStatement(sql);) {
			//Place holder
			st.setInt(1, userID);
			st.setInt(2, inventoryID);
			st.setDate(3, new java.sql.Date(sellDate.getTime()));

			//int rows = st.executeUpdate();
			return receiptID;

		} catch (SQLException e) {
			throw new DAOException("レコードの取得に失敗しました。");
		}

	}

	public int updateInventoryStateCode(int inventoryID, int isinInventoryCode) throws DAOException {
		// 注文番号の取得 Serial型の暗黙シーケンスから取得
		String sql = "UPDATE inventory SET isin_inventory_code = 0 WHERE inventory_id = ?";

		try (//Connect DB
				Connection con = DriverManager.getConnection(url, user, pass);
				//Get Prepared Statement
				PreparedStatement st = con.prepareStatement(sql);) {
			//Place holder
			st.setInt(1, inventoryID);
			int rows = st.executeUpdate();
			return rows;

		} catch (SQLException e) {
			throw new DAOException("レコードの取得に失敗しました。");
		}

	}

	public int addUser(UserBean userBean) throws DAOException {
		//SQL
		String sql = "INSERT INTO user_table(name, password, email, address, tel, regist_date) VALUES(?, ?, ?, ?, ?, ?)";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 商品名と値段の指定
			st.setString(1, userBean.getName());
			st.setString(2, userBean.getPassword());
			st.setString(3, userBean.getEmail());
			st.setString(4, userBean.getAddress());
			st.setString(5, userBean.getTel());

			//java.util.Date javaDate = userBean.getRegist_date();
			//java.sql.Date sqlDate = new 
			java.sql.Date sqlDate = new java.sql.Date((userBean.getRegist_date()).getTime());
			st.setDate(6, sqlDate);

			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}

	}
}
