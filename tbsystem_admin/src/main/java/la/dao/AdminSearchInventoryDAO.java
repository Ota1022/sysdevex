package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import la.bean.InventoryBean;

public class AdminSearchInventoryDAO {
	// URL、ユーザ名、パスワードの準備
	private String url = "jdbc:postgresql:tbsystem";
	private String user = "student";
	private String pass = "himitu";

	// コンストラクタ
	public AdminSearchInventoryDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}

	public List<InventoryBean> findAll() throws DAOException {
		// SQL文の作成（code昇順）
		String sql = "SELECT * FROM inventory";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
				// SQLの実行
				ResultSet rs = st.executeQuery();) {
			// 結果の取得
			List<InventoryBean> list = new ArrayList<InventoryBean>();
			while (rs.next()) {
				int inventory_id = rs.getInt("inventory_id");
				String isbn = rs.getString("isbn");
				System.out.println(isbn);
				String title = findTitle(isbn);
				int user_id = rs.getInt("user_id");
				String user_name = findUserName(user_id);
				int price = rs.getInt("price");
				int isin_inventory_code = rs.getInt("isin_inventory_code");
				String inventory_name = findInventoryName(isin_inventory_code);
				int state_code = rs.getInt("state_code");
				String state_name = findStateName(state_code);
				String note = rs.getString("note");
				InventoryBean bean = new InventoryBean(inventory_id, title, null, price, user_id, user_name, -1, null,
						state_code, state_name, -1, null, isin_inventory_code, inventory_name, note,
						new Date(0),
						new Date(0), new Date(0));
				// リストへ追加
				list.add(bean);
			}
			// カテゴリ一覧をListとして返す
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	public String findTitle(String isbn) throws DAOException {
		String sql = "SELECT * FROM textbook WHERE isbn LIKE ? ";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
		// SQLの実行
		) {
			st.setString(1, isbn);
			ResultSet rs = st.executeQuery();
			String title = null;
			// 結果の取得
			while (rs.next()) {
				title = rs.getString("title");
			}
			return title;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	public String findUserName(int user_id) throws DAOException {
		String sql = "SELECT * FROM user_table WHERE user_id=? ";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
		// SQLの実行
		) {
			st.setInt(1, user_id);
			ResultSet rs = st.executeQuery();
			String name = null;
			// 結果の取得
			while (rs.next()) {
				name = rs.getString("name");
			}
			return name;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	public String findInventoryName(int code) throws DAOException {
		String sql = "SELECT * FROM state_inventory WHERE isin_inventory_code=? ";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
		// SQLの実行
		) {
			st.setInt(1, code);
			ResultSet rs = st.executeQuery();
			String name = null;
			// 結果の取得
			while (rs.next()) {
				name = rs.getString("isin_inventory_name");
			}
			return name;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	public String findStateName(int code) throws DAOException {
		String sql = "SELECT * FROM state WHERE state_code=? ";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
		// SQLの実行
		) {
			st.setInt(1, code);
			ResultSet rs = st.executeQuery();
			String name = null;
			// 結果の取得
			while (rs.next()) {
				name = rs.getString("state_name");
			}
			return name;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

}
