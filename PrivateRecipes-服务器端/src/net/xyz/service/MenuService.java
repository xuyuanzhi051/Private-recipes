package net.xyz.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.xyz.dao.MenuDao;
import net.xyz.entitys.Menu;

/**
 * 菜谱管理的业务逻辑层
 * 
 * @author lenovo
 *
 */
public class MenuService {
	private MenuDao menuDao;// dao层
	private List<Menu> menus;// 存放所有的菜谱

	public MenuService() {
		menuDao = new MenuDao();
		menus = new ArrayList<>();
	}

	/**
	 * 菜谱管理功能 获取数据库中所有的菜谱
	 * 
	 * @return
	 */
	public List<Menu> getMenus() {
		String sql = "select * from menu";
		try {
			ResultSet rs = menuDao.selectMenus(sql);
			while (rs.next()) {
				// 构造一个菜谱对象
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
	 * 通过菜谱名称得到菜谱对象
	 * 
	 * @param menuName菜谱名称
	 * @return
	 */
	public Menu SearchMenuByMenuName(String menuName) {
		return menuDao.SearchMenuByMenuName(menuName);

	}

	/**
	 * 根据菜谱id删除菜谱
	 * 
	 * @param menuId菜谱Id
	 */
	public void deleteMenuByMenuId(int menuId) {
		menuDao.deleteMenuById(menuId);
	}

	/**
	 * 向数据库中添加一条菜谱记录
	 * 
	 * @param menu菜谱对象
	 */
	public void addMenu(Menu menu) {
		menuDao.addMenu(menu);
	}

	/**
	 * 根据菜谱id来修改菜谱
	 * 
	 * @param menu菜谱对象
	 * @return修改后的记录值
	 */
	public int updateMenuById(Menu menu) {
		return menuDao.upDateMenuById(menu);

	}
}
