package net.xyz.entitys;

/**
 * �˵��б��� ������ͻ����ṩ���ݿ��еĲ����б�
 * 
 * @author lenovo
 *
 */
public class MenuList {
	private int menuId;// ����Id
	private String menuImg;// ����ͼƬ
	private String menuName;// ��������
	private String menuType;// ��������
	private String menuDetails;// ��������
	private int menuLikes;// ���׵�������

	public MenuList() {

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
		return "MenuList{" + "menuImg='" + menuImg + '\'' + ", menuName='" + menuName + '\'' + ", menuType='" + menuType
				+ '\'' + ", menuDetails='" + menuDetails + '\'' + ", menuLikes=" + menuLikes + '}';
	}
}
