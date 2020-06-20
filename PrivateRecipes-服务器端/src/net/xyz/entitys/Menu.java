package net.xyz.entitys;

/**
 * ����ʵ���࣬����Բ��׵Ĳ���
 * 
 * @author lenovo
 *
 */
public class Menu {
	private int menuId;// ����ID
	private String menuName;// ��������
	private String menuType;// ��������
	private String menuImg;// ����ͼƬ
	private String menuMaterial;// ����ԭ����
	private String menuSteps;// ���ײ�������

	public Menu() {

	}

	public Menu(int menuId, String menuName, String menuType, String menuImg, String menuMaterial, String menuSteps) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuType = menuType;
		this.menuImg = menuImg;
		this.menuMaterial = menuMaterial;
		this.menuSteps = menuSteps;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
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

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	public String getMenuMaterial() {
		return menuMaterial;
	}

	public void setMenuMaterial(String menuMaterial) {
		this.menuMaterial = menuMaterial;
	}

	public String getMenuSteps() {
		return menuSteps;
	}

	public void setMenuSteps(String menuSteps) {
		this.menuSteps = menuSteps;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", menuType=" + menuType + ", menuImg=" + menuImg
				+ ", menuMaterial=" + menuMaterial + ", menuSteps=" + menuSteps + "]";
	}

}
