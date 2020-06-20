package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.utils.JdbcUtils;

/**
 * �˵����۹����
 * 
 * @author lenovo
 *
 */
public class CommentDao {
	/**
	 * �����ݿ��в���������Ϣ
	 * 
	 * @param menuId����id
	 * @param userId�û�id
	 * @param menuComment��������
	 * @return
	 */
	public int addComment(int menuId, int userId, String menuComment) {

		try {
			Connection conn = JdbcUtils.getConnection();
			String sql = "INSERT INTO menu_comments(menu_id, user_id,menu_comment) VALUES(?,?,?);";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, menuId);
			pstm.setInt(2, userId);
			pstm.setString(3, menuComment);
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	/*
	 * ����ָ���û�id�õ��û����ݼ�
	 */
	public ResultSet getCommentsByUserId(int userId) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "SELECT * FROM menu_comments WHERE user_id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, userId);
		return pstm.executeQuery();
	}

	/**
	 * ��ȡ���ݿ������еĲ����������ݼ�
	 * 
	 * @throws SQLException
	 */
	public ResultSet getAllComments() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "SELECT * FROM menu_comments";
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm.executeQuery();
	}

	/**
	 * ͨ������ID��ɾ������
	 * 
	 * @param commentId
	 * @throws SQLException
	 */
	public void deleteCommentByCommentId(int commentId) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from menu_comments where comment_id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, commentId);
		pstm.execute();

	}

	/**
	 * �����û�id�Ͳ���id��ɾ��������Ϣ
	 * 
	 * @param UserId
	 * @param MenuId
	 * @throws SQLException
	 */
	public void deleteCommentByUserIdandMenuId(int userId, int menuId) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from menu_comments where (user_id=?) and (menu_id=?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, userId);
		pstm.setInt(2, menuId);
		pstm.execute();

	}
}
