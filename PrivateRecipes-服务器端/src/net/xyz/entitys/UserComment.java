package net.xyz.entitys;

/**
 * �û�������
 * 
 * @author lenovo
 *
 */
public class UserComment {
	private int commentId;// ����id
	private int menuId;// ����id
	private int userId;// �û�id
	private String menuComment;// �û�����

	public UserComment() {

	}

	public UserComment(int commentId, int menuId, int userId, String menuComment) {
		this.commentId = commentId;
		this.menuId = menuId;
		this.userId = userId;
		this.menuComment = menuComment;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMenuComment() {
		return menuComment;
	}

	public void setMenuComment(String menuComment) {
		this.menuComment = menuComment;
	}
}
