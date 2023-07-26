package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.TextbookBean;

public class AdminSearchTextbookDAO {

	private String url = "jdbc:postgresql:tbsystem";
	private String user = "student";
	private String pass = "himitu";

	public AdminSearchTextbookDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}

	public List<TextbookBean> findAll() throws DAOException {

		String sql = "SELECT * FROM textbook INNER JOIN category ON textbook.category_code = category.category_code";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
				// SQLの実行
				ResultSet rs = st.executeQuery();) {
			// 結果の取得
			List<TextbookBean> list = new ArrayList<TextbookBean>();
			while (rs.next()) {
				String isbn = rs.getString("isbn");
				//System.out.println(isbn);
				int categoryCode = rs.getInt("category_code");
				String categoryName = rs.getString("category_name");
				String title = rs.getString("title");
				String author = rs.getString("author");

				TextbookBean bean = new TextbookBean(isbn, categoryCode, categoryName, title, author);

				list.add(bean);
			}
			// 商品一覧をListとして返す
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	public TextbookBean findIsbn(String isbn) throws DAOException {

		String sql = "SELECT * FROM textbook INNER JOIN category ON textbook.category_code = category.category_code WHERE textbook.isbn LIKE ?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 結果の取得
			st.setString(1, isbn);
			ResultSet rs = st.executeQuery();
			TextbookBean bean = new TextbookBean();
			while (rs.next()) {
				int categoryCode = rs.getInt("category_code");
				String categoryName = rs.getString("category_name");
				String title = rs.getString("title");
				String author = rs.getString("author");
				bean = new TextbookBean(isbn, categoryCode, categoryName, title, author);
			}
			// 商品一覧をListとして返す
			return bean;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	public boolean CheckInventory(String isbn) throws DAOException {
		String sql = "SELECT * FROM inventory INNER JOIN textbook ON inventory.isbn = textbook.isbn WHERE textbook.isbn LIKE ? ";
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 結果の取得
			st.setString(1, isbn);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int isin_inventory_code = rs.getInt("isin_inventory_code");
				System.out.println(isin_inventory_code);
				if (isin_inventory_code == 1) {
					return false;
				}
			}

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	public int deleteTextbook(String isbn) throws DAOException {
		// SQL文の作成
		String sql = "DELETE FROM textbook WHERE isbn LIKE ?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダの指定
			st.setString(1, isbn);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

}
