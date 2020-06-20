package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.entitys.UserInfomation;
import net.xyz.utils.JdbcUtils;

/**
 * UserInfomationDao�� ����ֱ�Ӳ����û���Ϣ��
 * 
 * @author lenovo
 *
 */
public class UserInfomationDao {
	/**
	 * �����ݿ�������һ����¼ ���û�ע�����û��������ݿ������Ӵ��û���Ϣֻ���û�id�����û��绰
	 */
	public void addUserInfomation(int userId, String userTel) {
		try {
			Connection conn = JdbcUtils.getConnection();
			// ƴ��sql���
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
	 * �����û��ֻ��źŸı��û�������Ϣ
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
	 * �����û��绰�����ݿ��ѯ�û���Ϣ ����һ���û���Ϣ����
	 * 
	 * @param userTel�û��绰
	 * @return
	 */
	public UserInfomation selectUserInfomationByTel(String userTel) {
		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "select * from user_infomation where user_tel=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, userTel);
			ResultSet rs = pstm.executeQuery();
			// ����ѯ���Ľ������װ��һ��infomation����
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
