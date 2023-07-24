package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import la.bean.UserBean;

public class AdminSearchUserDAO {

	private String url = "jdbc:postgresql:tbsystem";
	private String user = "student";
	private String pass = "himitu";

	public AdminSearchUserDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}

	public List<UserBean> findAll() throws DAOException {

		String sql = "SELECT * FROM user_table";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
				// SQLの実行
				ResultSet rs = st.executeQuery();) {
			// 結果の取得
			List<UserBean> list = new ArrayList<UserBean>();
			while (rs.next()) {
				int user_id = rs.getInt("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				Date regist_date = rs.getDate("regist_date");
				Date delete_date = rs.getDate("delete_date");
				Date birthday = rs.getDate("birthday");

				UserBean bean = new UserBean(user_id, name, email, password, address, tel, regist_date, delete_date,
						birthday);
				System.out.print(user_id);
				list.add(bean);
			}
			// 商品一覧をListとして返す
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	public List<UserBean> findByUser(String category, String text) throws DAOException {

		String sql = "";
		System.out.println(category);
		Boolean i = true;
		if (category.equals("user_id")) {

			int num;

			try {
				num = Integer.parseInt(text);
				i = true;
				sql = "SELECT * FROM user_table WHERE user_id = ?  ";
			} catch (NumberFormatException e) {
				sql = "SELECT * FROM user_table WHERE name";
				//sql = "SELECT * FROM user_table WHERE name LIKE ? ORDER BY user_id ";
				i = false;
			}

			sql = "SELECT * FROM user_table WHERE user_id = ?  ";
		} else if (category.equals("name")) {
			text = '%' + text + '%';
			sql = "SELECT * FROM user_table WHERE name LIKE ? ORDER BY user_id ";
		} else if (category.equals("address")) {
			text = '%' + text + '%';
			sql = "SELECT * FROM user_table WHERE address LIKE ? ORDER BY user_id ";
		} else if (category.equals("tel")) {
			text = '%' + text + '%';
			sql = "SELECT * FROM user_table WHERE tel LIKE ? ORDER BY user_id ";
		} else if (category.equals("email")) {
			text = '%' + text + '%';
			sql = "SELECT * FROM user_table WHERE email LIKE ? ORDER BY user_id ";
		} else if (category.equals("birthday")) {
			text = '%' + text + '%';
			sql = "SELECT * FROM user_table WHERE birthday LIKE ? ORDER BY user_id ";
		} else if (category.equals("regist_day")) {
			text = '%' + text + '%';
			sql = "SELECT * FROM user_table WHERE regist_day LIKE ? ORDER BY user_id ";
		}

		//sql = "SELECT * FROM user_table WHERE name LIKE ? ORDER BY user_id ";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
		// SQLの実行
		) {

			if (category.equals("user_id")) {
				int num;
				if (i == true) {
					num = Integer.parseInt(text);
					st.setInt(1, num);

				} else {

				}
				//int num;
				//try {
				//	num = Integer.parseInt(text);
				//	st.setInt(1, num);
				//} catch (NumberFormatException e) {
				//	num = 0;
				//}

				//st.setInt(1, num);
			} else {
				st.setString(1, text);
			}

			System.out.println(text);

			try (ResultSet rs = st.executeQuery();) {

				List<UserBean> list = new ArrayList<UserBean>();
				while (rs.next()) {
					// 結果の取得

					int user_id = rs.getInt("user_id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String password = rs.getString("password");
					String address = rs.getString("address");
					String tel = rs.getString("tel");
					Date regist_date = rs.getDate("regist_date");
					Date delete_date = rs.getDate("delete_date");
					Date birthday = rs.getDate("birthday");

					UserBean bean = new UserBean(user_id, name, email, password, address, tel, regist_date,
							delete_date,
							birthday);
					//	System.out.print(user_id);
					list.add(bean);

					// 商品一覧をListとして返す

				}
				return list;
			} catch (SQLException e) {

				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

}
