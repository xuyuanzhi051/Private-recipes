package net.xyz.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.xyz.dao.MenuListDao;
import net.xyz.entitys.MenuList;

/**
 * menuListService层
 * 
 * @author lenovo
 *
 */
public class MenuListService {
	private MenuListDao menuListDao;
	private List<MenuList> menuLists;

	public MenuListService() {
		menuListDao = new MenuListDao();
		menuLists = new ArrayList<>();
	}

	/**
	 * 得到数据库中所有的菜谱列表
	 * 
	 * @return
	 */
	public List<MenuList> getMenuLists() {
		String sql = "SELECT  menu.*,menu_likes.menu_likenumber FROM menu,menu_likes WHERE menu.menu_id=menu_likes.menu_id";
		try {
			ResultSet rs = menuListDao.selectAllMenuList(sql);
			while (rs.next()) {
				int menuId = rs.getInt(1);
				String menuImg = rs.getString(4);
				String menuName = rs.getString(2);
				String menuType = rs.getString(3);
				int menuLikes = rs.getInt(7);
				MenuList menuList = new MenuList(menuId, menuImg, menuName, menuType, "菜谱详情", menuLikes);
				menuLists.add(menuList);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuLists;

	}

	/**
	 * 根据菜谱名称得到一个菜谱对象
	 * 
	 * @param menuName
	 * @return
	 */
	public MenuList searchMenuListByMenuName(String menuName) {
		return menuListDao.searchMenuListByMenuName(menuName);
	}
}
