package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import la.bean.TextbookBean;

public class DisplayDAO {
	// URL、ユーザ名、パスワードの準備
	private String url = "jdbc:postgresql:tbsystem";
	private String user = "student";
	private String pass = "himitu";

	public DisplayDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}

	public TextbookBean findByPrimaryKey(String isbn) throws DAOException {
		//SQL textbookとinventoryをisbnで、inventoryとstateをstate_codeで結合する
		String sql = "SELECT * FROM textbook INNER JOIN category ON textbook.category_code = category.category_code WHERE isbn = ?";

		try (//Connect DB
				Connection con = DriverManager.getConnection(url, user, pass);
				//Get Prepared Statement
				PreparedStatement st = con.prepareStatement(sql);) {
			//Place holder
			st.setString(1, isbn);

			try (//Execute sql
					ResultSet rs = st.executeQuery();) {
				//Get Result
				if (rs.next()) {
					TextbookBean bean = new TextbookBean(rs.getString("isbn"), rs.getInt("category_code"),
							rs.getString("category_name"),
							rs.getString("title"), rs.getString("author"));
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

	public List<TextbookBean> findByCategory(int categoryCode) throws DAOException {
		//SQL textbookとinventoryをisbnで、inventoryとstateをstate_codeで結合する
		String sql = "SELECT * FROM textbook INNER JOIN category ON textbook.category_code = category.category_code WHERE textbook.category_code = ?";

		try (//Connect DB
				Connection con = DriverManager.getConnection(url, user, pass);
				//Get Prepared Statement
				PreparedStatement st = con.prepareStatement(sql);) {
			//Place holder
			st.setInt(1, categoryCode);
			List<TextbookBean> list = new ArrayList<TextbookBean>();

			try (//Execute sql
					ResultSet rs = st.executeQuery();) {
				//Get Result
				while (rs.next()) {
					TextbookBean bean = new TextbookBean(rs.getString("isbn"), rs.getInt("category_code"),
							rs.getString("category_name"),
							rs.getString("title"), rs.getString("author"));
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

	public List<TextbookBean> findByIsbnAndTitleAndAuthor(String isbn, String title, String author)
			throws DAOException {
		//SQL textbookとinventoryをisbnで、inventoryとstateをstate_codeで結合する
		String sql = "SELECT * FROM textbook INNER JOIN category ON textbook.category_code = category.category_code WHERE textbook.isbn LIKE ? AND textbook.title LIKE ? AND textbook.author LIKE ?";

		try (//Connect DB
				Connection con = DriverManager.getConnection(url, user, pass);
				//Get Prepared Statement
				PreparedStatement st = con.prepareStatement(sql);) {
			//Place holder
			st.setString(1, "%" + isbn + "%");
			st.setString(2, "%" + title + "%");
			st.setString(3, "%" + author + "%");
			List<TextbookBean> list = new ArrayList<TextbookBean>();

			try (//Execute sql
					ResultSet rs = st.executeQuery();) {
				//Get Result
				while (rs.next()) {
					TextbookBean bean = new TextbookBean(rs.getString("isbn"), rs.getInt("category_code"),
							rs.getString("category_name"),
							rs.getString("title"), rs.getString("author"));
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

	public List<TextbookBean> findByCategoryAndIsbnAndTitleAndAuthor(int categoryCode, String isbn, String title,
			String author)
			throws DAOException {
		//SQL textbookとinventoryをisbnで、inventoryとstateをstate_codeで結合する
		String sql = "SELECT * FROM textbook INNER JOIN category ON textbook.category_code = category.category_code WHERE textbook.isbn LIKE ? AND textbook.title LIKE ? AND textbook.author LIKE ? AND textbook.category_code = ?";

		try (//Connect DB
				Connection con = DriverManager.getConnection(url, user, pass);
				//Get Prepared Statement
				PreparedStatement st = con.prepareStatement(sql);) {
			//Place holder
			st.setString(1, "%" + isbn + "%");
			st.setString(2, "%" + title + "%");
			st.setString(3, "%" + author + "%");
			st.setInt(4, categoryCode);
			List<TextbookBean> list = new ArrayList<TextbookBean>();

			try (//Execute sql
					ResultSet rs = st.executeQuery();) {
				//Get Result
				while (rs.next()) {
					TextbookBean bean = new TextbookBean(rs.getString("isbn"), rs.getInt("category_code"),
							rs.getString("category_name"),
							rs.getString("title"), rs.getString("author"));
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

	public int addInventory(String isbn, int user_id, int state_code, int price, int isin_inventory_code, String note,
			Date inventory_regist_date, Date inventory_update_date) throws DAOException {
		//SQL
		String sql = "INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				// PreparedStatementオブジェクトの取得
				PreparedStatement st = con.prepareStatement(sql);) {
			// 商品名と値段の指定
			st.setString(1, isbn);
			st.setInt(2, user_id);
			st.setInt(3, state_code);
			st.setInt(4, price);
			st.setInt(5, isin_inventory_code);
			st.setString(6, note);
			st.setDate(7, new java.sql.Date(inventory_regist_date.getTime()));
			st.setDate(8, new java.sql.Date(inventory_update_date.getTime()));

			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}

	}

}
