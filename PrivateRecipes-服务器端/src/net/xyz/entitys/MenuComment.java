package net.xyz.entitys;

/**
 * 菜谱评论实体层用来方便对某个菜谱的管理
 * 
 * @author lenovo
 *
 */
public class MenuComment {
	private int commentId;// 评论id
	private int menuId;// 菜谱id
	private String menuComment;// 菜谱评论

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
