package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.entitys.User;
import net.xyz.utils.JdbcUtils;

/**
 * 数据库交互层
 * 
 * @author lenovo
 *
 */
public class UserDao {
	/**
	 * 根据用户名查询用户 如果用户已经存在返回User对象,不存在返回null
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
				// 根据查询结果构造一个user对象
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
	 * 查询数据库是否存在用户的用户名和密码 如果正确返回true 不正确返回flase
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
	 * 向数据库中增加一个用户
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
	 * 查询所有用户数据集
	 * 
	 * @throws SQLException
	 */
	public ResultSet selectUser(String sql) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm.executeQuery();

	}

	/**
	 * 根据用户id删除一个用户
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
