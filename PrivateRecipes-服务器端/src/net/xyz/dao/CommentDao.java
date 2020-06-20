package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.utils.JdbcUtils;

/**
 * 菜单评论管理层
 * 
 * @author lenovo
 *
 */
public class CommentDao {
	/**
	 * 向数据库中插入评论信息
	 * 
	 * @param menuId菜谱id
	 * @param userId用户id
	 * @param menuComment菜谱评论
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
	 * 根据指定用户id得到用户数据集
	 */
	public ResultSet getCommentsByUserId(int userId) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "SELECT * FROM menu_comments WHERE user_id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, userId);
		return pstm.executeQuery();
	}

	/**
	 * 获取数据库中所有的菜谱评论数据集
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
	 * 通过评论ID来删除评论
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
	 * 根据用户id和菜谱id来删除评论信息
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
