package net.xyz.entitys;

/**
 * ��������ʵ����
 * 
 * @author lenovo
 *
 */
public class RankList {
	private int rankNum;// ��������
	private String menuImg;// ����ͼƬ
	private String menuName;// ��������
	private String menuType;// ��������
	private int likenumber;// ���׵�������

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
