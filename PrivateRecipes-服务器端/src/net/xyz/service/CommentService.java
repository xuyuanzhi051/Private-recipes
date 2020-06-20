package net.xyz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.xyz.dao.CommentDao;
import net.xyz.entitys.UserComment;
import net.xyz.utils.JdbcUtils;

/**
 * 评论管理逻辑层
 * 
 * @author lenovo
 *
 */
public class CommentService {
	private CommentDao commentDao;
	private List<UserComment> userComments;
	private List<UserComment> allComments;

	public CommentService() {
		commentDao = new CommentDao();
		userComments = new ArrayList<>();
		allComments = new ArrayList<>();
	}

	/**
	 * 向数据库中插入查询语句
	 * 
	 * @param menuId菜谱Id
	 * @param userId用户Id
	 * @param menuComment用户评论
	 * @return
	 */
	public int addComment(int menuId, int userId, String menuComment) {
		return commentDao.addComment(menuId, userId, menuComment);
	}

	/*
	 * 根据指定用户id得到用户评论列表
	 */
	public List<UserComment> getCommentsByUserId(int userId) {
		try {
			ResultSet rs = commentDao.getCommentsByUserId(userId);
			while (rs.next()) {

				int menuId = rs.getInt(2);
				String menuComment = rs.getString(4);
				UserComment userComment = new UserComment();
				userComment.setUserId(userId);
				userComment.setMenuId(menuId);
				userComment.setMenuComment(menuComment);
				userComments.add(userComment);
			}
			return userComments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public List<UserComment> getAllComments() {
		try {
			ResultSet rs = commentDao.getAllComments();
			while (rs.next()) {
				int commentId = rs.getInt(1);
				int menuId = rs.getInt(2);
				int userId = rs.getInt(3);
				String menuComment = rs.getString(4);
				UserComment userComment = new UserComment(commentId, menuId, userId, menuComment);
				allComments.add(userComment);
			}
			return allComments;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过评论ID来删除评论
	 * 
	 * @param commentId
	 * @throws SQLException
	 */
	public void deleteCommentByCommentId(int commentId) {
		try {
			commentDao.deleteCommentByCommentId(commentId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 根据用户id和菜谱id来删除评论信息
	 * 
	 * @param UserId
	 * @param MenuId
	 * @throws SQLException
	 */
	public void deleteCommentByUserIdandMenuId(int userId, int menuId) {
		try {
			commentDao.deleteCommentByUserIdandMenuId(userId, menuId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
