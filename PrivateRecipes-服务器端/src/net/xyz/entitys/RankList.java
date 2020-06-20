package net.xyz.entitys;

/**
 * ²ËÆ×ÅÅĞĞÊµÌåÀà
 * 
 * @author lenovo
 *
 */
public class RankList {
	private int rankNum;// ²ËÆ×ÅÅÃû
	private String menuImg;// ²ËÆ×Í¼Æ¬
	private String menuName;// ²ËÆ×Ãû³Æ
	private String menuType;// ²ËÆ×ÀàĞÍ
	private int likenumber;// ²ËÆ×µãÔŞÊıÁ¿

	public RankList() {

	}

	public RankList(int rankNum, String menuImg, String menuName, String menuType, int likenumber) {
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

	public int getLikenumber() {
		return likenumber;
	}

	public void setLikenumber(int likenumber) {
		this.likenumber = likenumber;
	}
}
