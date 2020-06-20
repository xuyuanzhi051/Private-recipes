package com.example.privaterecipes;

/**
 * 这是菜谱排行列表
 */
public class RankList {
    private int rankNum;//菜谱排名
    private String menuImg;//菜谱图片
    private String menuName;//菜谱名称
    private String menuType;//菜谱类型
    private String likenumber;//菜谱点赞数量
    public RankList(){

    }
    public RankList(int rankNum, String menuImg, String menuName, String menuType, String likenumber) {
        this.rankNum = rankNum;
        this.menuImg = menuImg;
        this.menuName = menuName;
        this.menuType = menuType;
        this.likenumber = likenumber;
    }

    public int getRankNum() {
        return rankNum;
    }

    public void setRankNum(int rankNum) {
        this.rankNum = rankNum;
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

    public String getLikenumber() {
        return likenumber;
    }

    public void setLikenumber(String likenumber) {
        this.likenumber = likenumber;
    }
}
