package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.bean.UserBean;

public class AdminUserDAO {
    // URL、ユーザ名、パスワードの準備
    private String url = "jdbc:postgresql:tbsystem";
    private String user = "student";
    private String pass = "himitu";

    public AdminUserDAO() throws DAOException {
	try {
	    // JDBCドライバの登録
	    Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	    throw new DAOException("JDBCドライバの登録の失敗しました。");
	}
    }

    public UserBean findByEmailAndPassword(String email, String password) throws DAOException {
	// SQL
	String sql = "SELECT * FROM user_table WHERE email = ? AND password = ?";

	try (// Connect DB
		Connection con = DriverManager.getConnection(url, user, pass);
		// Get Prepared Statement
		PreparedStatement st = con.prepareStatement(sql);) {
	    // Place holder
	    st.setString(1, email);
	    st.setString(2, password);

	    try (// Execute sql
		    ResultSet rs = st.executeQuery();) {
		// Get Result
		if (rs.next()) {
		    UserBean result = new UserBean(rs.getInt("user_id"), rs.getString("name"), rs.getString("password"),
			    email, rs.getString("address"), rs.getString("tel"), rs.getDate("regist_date"),
			    rs.getDate("delete_date"), rs.getDate("birthday"));
		    return result;
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

    public int addUser(UserBean userBean) throws DAOException {
	// SQL
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

	    // java.util.Date javaDate = userBean.getRegist_date();
	    // java.sql.Date sqlDate = new
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