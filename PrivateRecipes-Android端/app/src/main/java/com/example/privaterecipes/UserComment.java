package com.example.privaterecipes;

/**
 * 用户评论实体类
 */
public class UserComment {
    private int commentId;//评论id
    private int menuId;//菜谱id
    private int userId;//用户id
    private String menuComment;//用户评论
    public UserComment(){

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
