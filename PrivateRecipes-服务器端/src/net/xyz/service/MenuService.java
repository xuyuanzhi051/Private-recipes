package net.xyz.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.xyz.dao.MenuDao;
import net.xyz.entitys.Menu;

/**
 * ���׹����ҵ���߼���
 * 
 * @author lenovo
 *
 */
public class MenuService {
	private MenuDao menuDao;// dao��
	private List<Menu> menus;// ������еĲ���

	public MenuService() {
		menuDao = new MenuDao();
		menus = new ArrayList<>();
	}

	/**
	 * ���׹����� ��ȡ���ݿ������еĲ���
	 * 
	 * @return
	 */
	public List<Menu> getMenus() {
		String sql = "select * from menu";
		try {
			ResultSet rs = menuDao.selectMenus(sql);
			while (rs.next()) {
				// ����һ�����׶���
				int menuId = rs.getInt(1);
				String menuName = rs.getString(2);
				String menuType = rs.getString(3);
				String menuImg = rs.getString(4);
				String menuMaterial = rs.getString(5);
				String menuSteps = rs.getString(6);
				Menu menu = new Menu(menuId, menuName, menuType, menuImg, menuMaterial, menuSteps);
				menus.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
	}

	/**
	 * ͨ���������Ƶõ����׶���
	 * 
	 * @param menuName��������
	 * @return
	 */
	public Menu SearchMenuByMenuName(String menuName) {
		return menuDao.SearchMenuByMenuName(menuName);

	}

	/**
	 * ���ݲ���idɾ������
	 * 
	 * @param menuId����Id
	 */
	public void deleteMenuByMenuId(int menuId) {
		menuDao.deleteMenuById(menuId);
	}

	/**
	 * �����ݿ������һ�����׼�¼
	 * 
	 * @param menu���׶���
	 */
	public void addMenu(Menu menu) {
		menuDao.addMenu(menu);
	}

	/**
	 * ���ݲ���id���޸Ĳ���
	 * 
	 * @param menu���׶���
	 * @return�޸ĺ�ļ�¼ֵ
	 */
	public int updateMenuById(Menu menu) {
		return menuDao.upDateMenuById(menu);

	}
}
