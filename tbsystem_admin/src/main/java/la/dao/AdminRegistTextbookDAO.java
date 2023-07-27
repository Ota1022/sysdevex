
package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import la.bean.CategoryBean;

public class AdminRegistTextbookDAO {
	// URL、ユーザ名、パスワードの準備
	private String url = "jdbc:postgresql:tbsystem";
	private String user = "student";
	private String pass = "himitu";

	// コンストラクタ
	public AdminRegistTextbookDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}

	public List<CategoryBean> findCategory() throws DAOException {
		String sql = "SELECT * FROM category";
		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
		// SQLの実行
		) {
			List<CategoryBean> list = new ArrayList<CategoryBean>();
			ResultSet rs = st.executeQuery();
			String name = null;
			// 結果の取得
			while (rs.next()) {
				name = rs.getString("category_name");
				int code = rs.getInt("category_code");
				list.add(new CategoryBean(code, name));
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	public String findCategoryName(int code) throws DAOException {
		String sql = "SELECT * FROM category WHERE category_code = ? ";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
		// SQLの実行
		) {
			st.setInt(1, code);
			ResultSet rs = st.executeQuery();
			String name = null;
			while (rs.next()) {
				name = rs.getString("category_name");
			}
			return name;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	public int addTextbook(String isbn, int category_code, String title, String author) throws DAOException {
		// SQL文の作成
		String sql = "INSERT INTO textbook  VALUES(?,?,?,?)";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// プレースホルダの指定
			st.setString(1, isbn);
			st.setInt(2, category_code);
			st.setString(3, title);
			st.setString(4, author);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

}
