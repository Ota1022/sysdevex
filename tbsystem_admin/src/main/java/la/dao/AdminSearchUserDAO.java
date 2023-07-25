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

		String sql = "SELECT * FROM user_table where delete_date IS NULL";

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

				UserBean bean = new UserBean(user_id, name, password, email, address, tel, regist_date, delete_date,
						birthday);

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
		//Boolean i = true;
		if (category.equals("user_id")) {

			sql = "SELECT * FROM user_table WHERE user_id = ?  ";
		} else if (category.equals("name")) {
			text = '%' + text + '%';
			sql = "SELECT * FROM user_table WHERE name LIKE ? AND delete_date IS NULL ORDER BY user_id ";
		} else if (category.equals("address")) {
			text = '%' + text + '%';
			sql = "SELECT * FROM user_table WHERE address LIKE ? AND delete_date IS NULL ORDER BY user_id ";
		} else if (category.equals("tel")) {
			text = '%' + text + '%';
			sql = "SELECT * FROM user_table WHERE tel LIKE ? AND delete_date IS NULL ORDER BY user_id ";
		} else if (category.equals("email")) {

			text = '%' + text + '%';
			sql = "SELECT * FROM user_table WHERE email LIKE ? AND delete_date IS NULL ORDER BY user_id ";
		} else if (category.equals("birthday")) {
			text = '%' + text + '%';
			sql = "SELECT * FROM user_table WHERE birthday LIKE ? AND delete_date IS NULL ORDER BY user_id ";
		} else if (category.equals("regist_day")) {
			text = '%' + text + '%';
			sql = "SELECT * FROM user_table WHERE regist_day LIKE ? AND delete_date IS NULL ORDER BY user_id ";
		}

		//sql = "SELECT * FROM user_table WHERE name LIKE ? ORDER BY user_id ";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);
		// SQLの実行
		) {
			st.setString(1, text);

			try (ResultSet rs = st.executeQuery();) {

				List<UserBean> list = new ArrayList<UserBean>();
				System.out.println(sql);
				while (rs.next()) {
					// 結果の取得

					int user_id = rs.getInt("user_id");
					String name = rs.getString("name");
					String password = rs.getString("password");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String tel = rs.getString("tel");
					Date regist_date = rs.getDate("regist_date");
					Date delete_date = rs.getDate("delete_date");
					Date birthday = rs.getDate("birthday");
					System.out.println(address);

					UserBean bean = new UserBean(user_id, name, password, email, address, tel, regist_date,
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

	public UserBean findByPrimaryKey(int key) throws DAOException {
		// SQL文の作成
		String sql = "SELECT * FROM user_table WHERE user_id = ?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// カテゴリの設定
			st.setInt(1, key);

			try (// SQLの実行
					ResultSet rs = st.executeQuery();) {
				// 結果の取得および表示
				if (rs.next()) {
					int user_id = rs.getInt("user_id");
					String name = rs.getString("name");
					String password = rs.getString("password");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String tel = rs.getString("tel");
					Date regist_date = rs.getDate("regist_date");
					Date delete_date = rs.getDate("delete_date");
					Date birthday = rs.getDate("birthday");
					System.out.println(address);

					UserBean bean = new UserBean(user_id, name, password, email, address, tel, regist_date,
							delete_date,
							birthday);
					return bean; // 主キーに該当するレコードを返す
				} else {
					return null; // 主キーに該当するレコードなし
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	public int updateUser(int user_id, String name, String address, String tel, String email) throws DAOException {

		String sql = "UPDATE user_table "
				+ "SET name=?, address=?, tel=?, email=? "
				+ "WHERE user_id = ?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 商品名と値段の指定

			st.setString(1, name);
			st.setString(2, address);
			st.setString(3, tel);
			st.setString(4, email);
			st.setInt(5, user_id);

			//java.util.Date javaDate = userBean.getRegist_date();
			//java.sql.Date sqlDate = new 

			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

	public int deleteUser(int user_id) throws DAOException {

		String sql = "UPDATE user_table "
				+ "SET delete_date=?"
				+ "WHERE user_id = ?";
		Date date2 = new Date();
		java.sql.Date date = new java.sql.Date(date2.getTime());

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 商品名と値段の指定

			st.setDate(1, date);

			st.setInt(2, user_id);

			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}

}
