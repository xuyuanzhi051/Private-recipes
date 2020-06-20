package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.entitys.User;
import net.xyz.utils.JdbcUtils;

/**
 * ���ݿ⽻����
 * 
 * @author lenovo
 *
 */
public class UserDao {
	/**
	 * �����û�����ѯ�û� ����û��Ѿ����ڷ���User����,�����ڷ���null
	 * 
	 * @return
	 */
	public User selectUserByUserName(String userName) {
		try {
			Connection conn = JdbcUtils.getConnection();

			String sql = "select * from users where username=?";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, userName);

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				// ���ݲ�ѯ�������һ��user����
				User user = new User();
				int id = rs.getInt(1);
				String userName1 = rs.getString(2);
				String passWord1 = rs.getString(3);
				user.setId(id);
				user.setUsername(userName1);
				user.setPassword(passWord1);
				return user;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ѯ���ݿ��Ƿ�����û����û��������� �����ȷ����true ����ȷ����flase
	 * 
	 * @param user
	 * @return
	 */
	public User isExistUser(User user) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "select * from users where username=? and password=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				User user1 = new User();
				user1.setId(id);
				user1.setUsername(username);
				user1.setPassword(password);
				return user;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * �����ݿ�������һ���û�
	 */
	public void addUser(User user) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "insert into users(username,password) values(?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			pstm.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ѯ�����û����ݼ�
	 * 
	 * @throws SQLException
	 */
	public ResultSet selectUser(String sql) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm.executeQuery();

	}

	/**
	 * �����û�idɾ��һ���û�
	 */
	public void deleteUserbyId(int id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "delete  from users where id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
