package net.xyz.entitys;

/**
 * ��������ʵ������������ĳ�����׵Ĺ���
 * 
 * @author lenovo
 *
 */
public class MenuComment {
	private int commentId;// ����id
	private int menuId;// ����id
	private String menuComment;// ��������

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

	public String getMenuComment() {
		return menuComment;
	}

	public void setMenuComment(String menuComment) {
		this.menuComment = menuComment;
	}

	@Override
	public String toString() {
		return "MenuComments [commentId=" + commentId + ", menuId=" + menuId + ", menuComment=" + menuComment + "]";
	}

}
