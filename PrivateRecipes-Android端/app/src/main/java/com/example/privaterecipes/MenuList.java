package com.example.privaterecipes;

import android.widget.ImageView;

/**
 * 菜谱列表类
 * 用来展示菜谱列表
 */
public class MenuList {
    private int menuId;//菜谱Id
    private String menuImg;//菜谱图片
    private String menuName;//菜谱名称
    private String menuType;//菜谱类型
    private String menuDetails;//菜谱详情
    private int menuLikes;//菜谱点赞数量

    public MenuList(){

    }

    public MenuList(int menuId, String menuImg, String menuName, String menuType, String menuDetails, int menuLikes) {
        this.menuId = menuId;
        this.menuImg = menuImg;
        this.menuName = menuName;
        this.menuType = menuType;
        this.menuDetails = menuDetails;
        this.menuLikes = menuLikes;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuDetails() {
        return menuDetails;
    }

    public void setMenuDetails(String menuDetails) {
        this.menuDetails = menuDetails;
    }

    public int getMenuLikes() {
        return menuLikes;
    }

    public void setMenuLikes(int menuLikes) {
        this.menuLikes = menuLikes;
    }

    @Override
    public String toString() {
        return "MenuList{" +
                "menuImg='" + menuImg + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuType='" + menuType + '\'' +
                ", menuDetails='" + menuDetails + '\'' +
                ", menuLikes=" + menuLikes +
                '}';
    }
}
