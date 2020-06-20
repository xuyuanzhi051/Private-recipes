package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.entitys.UserInfomation;
import net.xyz.utils.JdbcUtils;

/**
 * UserInfomationDao层 用来直接操作用户信息表
 * 
 * @author lenovo
 *
 */
public class UserInfomationDao {
	/**
	 * 向数据库中增加一条记录 当用户注册完用户后向数据库中增加此用户信息只有用户id，和用户电话
	 */
	public void addUserInfomation(int userId, String userTel) {
		try {
			Connection conn = JdbcUtils.getConnection();
			// 拼接sql语句
			String sql = "insert into user_infomation(user_id,user_tel) values(?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userId);
			pstm.setString(2, userTel);
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 根据用户手机号号改变用户个人信息
	 */
	public int updateUserInfomationByTel(UserInfomation userInfomation) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "update user_infomation set user_name=?,user_sex=?,user_hobby=? where user_tel=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, userInfomation.getUserName());
			pstm.setString(2, userInfomation.getUserSex());
			pstm.setString(3, userInfomation.getHobbys());
			pstm.setString(4, userInfomation.getUserTel());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	/**
	 * 根据用户电话向数据库查询用户信息 返回一个用户信息对象
	 * 
	 * @param userTel用户电话
	 * @return
	 */
	public UserInfomation selectUserInfomationByTel(String userTel) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "select * from user_infomation where user_tel=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, userTel);
			ResultSet rs = pstm.executeQuery();
			// 将查询到的结果集封装成一个infomation对象
			UserInfomation userInfomation = new UserInfomation();
			if (rs.next()) {
				userInfomation.setUserId(rs.getInt(1));
				userInfomation.setUserTel(rs.getString(2));
				userInfomation.setUserName(rs.getString(3));
				userInfomation.setUserImg(rs.getString(4));
				userInfomation.setUserSex(rs.getString(5));
				userInfomation.setHobbys(rs.getString(6));
			}

			return userInfomation;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
