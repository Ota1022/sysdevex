package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import la.bean.InventoryBean;
import la.bean.UserBean;

public class MyPageDAO {
	// URL、ユーザ名、パスワードの準備
	private String url = "jdbc:postgresql:tbsystem";
	private String user = "student";
	private String pass = "himitu";

	public MyPageDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバの登録に失敗しました。");
		}
	}

	public List<InventoryBean> findPurchaseHistory(int userID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT inventory.inventory_id, sell.sell_date, textbook.title, textbook.author, sell.user_id, inventory.price FROM inventory INNER JOIN SELL ON inventory.inventory_id=sell.inventory_id INNER JOIN textbook ON inventory.isbn=textbook.isbn WHERE sell.user_id=?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, userID);

			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				// 結果の取得
				List<InventoryBean> list = new ArrayList<InventoryBean>();
				while (rs.next()) {
					int inventoryID = rs.getInt("inventory_id");
					Date sellDate = rs.getDate("sell_date");
					String title = rs.getString("title");
					//String categoryName = rs.getString("category_name");
					String author = rs.getString("author");
					int price = rs.getInt("price");
					InventoryBean bean = new InventoryBean(inventoryID, sellDate, title, author, price);
					list.add(bean);
				}
				// 商品一覧をListとして返す
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの操作に失敗しました。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	public List<InventoryBean> findByIsinInventory(int userID, int isinInventoryCode) throws DAOException {
		// SQL文の作成
		String sql = "SELECT inventory.inventory_id, sell.sell_date, textbook.title, textbook.author, inventory.state_code, inventory.price, inventory.note FROM inventory INNER JOIN textbook ON inventory.isbn=textbook.isbn LEFT JOIN sell ON inventory.inventory_id=sell.inventory_id WHERE inventory.user_id=? AND inventory.isin_inventory_code=?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 値段のセット
			st.setInt(1, userID);
			st.setInt(2, isinInventoryCode);

			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				// 結果の取得
				List<InventoryBean> list = new ArrayList<InventoryBean>();
				while (rs.next()) {
					int inventoryID = rs.getInt("inventory_id");
					Date sellDate = rs.getDate("sell_date");
					String title = rs.getString("title");
					String author = rs.getString("author");
					int stateCode = rs.getInt("state_code");
					int price = rs.getInt("price");
					String note = rs.getString("note");
					InventoryBean bean = new InventoryBean(inventoryID, isinInventoryCode, sellDate, title, author,
							stateCode, price, note);
					list.add(bean);
				}
				// 商品一覧をListとして返す
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの操作に失敗しました。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	public UserBean findByPrimaryKey(int userID) throws DAOException {
		// SQL文の作成
		String sql = "SELECT * FROM user_table WHERE user_id=?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 値段のセット
			st.setInt(1, userID);

			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				rs.next();
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				UserBean bean = new UserBean(name, email, address, tel);
				return bean;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの操作に失敗しました。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	public int updateUser(int userID, String address, String tel, String password) throws DAOException {
		// SQL文の作成
		String sql = "UPDATE user_table SET address=?, tel=?, password=? WHERE user_id=?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, address);
			st.setString(2, tel);
			st.setString(3, password);
			st.setInt(4, userID);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	public int updateDeleteDateByPrimaryKey(int userID) throws DAOException {
		// SQL文の作成
		String sql = "UPDATE user_table SET delete_date=CURRENT_DATE WHERE user_id=?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 商品名と値段の指定
			st.setInt(1, userID);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	public int updateItem(int inventoryID, int stateCode, int price, String note) throws DAOException {
		// SQL文の作成
		String sql = "UPDATE inventory SET state_code=?, price=?, note=?, inventory_update_date=CURRENT_DATE WHERE inventory_id=?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, stateCode);
			st.setInt(2, price);
			st.setString(3, note);
			st.setInt(4, inventoryID);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	public int deleteByPrimaryKey(int key) throws DAOException {
		// SQL文の作成
		String sql = "DELETE FROM inventory WHERE inventory_id = ?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 主キーの指定
			st.setInt(1, key);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	public String searchStateName(int stateCode) throws DAOException {
		// SQL文の作成
		String sql = "SELECT * FROM state WHERE state_code = ?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, stateCode);
			// SQLの実行
			ResultSet rs = st.executeQuery();
			rs.next();
			String stateName = rs.getString("state_name");
			return stateName;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}
}