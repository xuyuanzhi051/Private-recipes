package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.entitys.MenuList;
import net.xyz.utils.JdbcUtils;

public class MenuListDao {
	/**
	 * 查询所有菜谱列表数据集
	 * 
	 * @throws SQLException
	 */
	public ResultSet selectAllMenuList(String sql) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm.executeQuery();
	}

	/**
	 * 根据菜谱名称查询菜谱列表
	 * 
	 * @return
	 */
	public MenuList searchMenuListByMenuName(String menuName) {

		try {
			String sql = "SELECT * FROM menu WHERE menu_name=?";
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, menuName);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int menuId = rs.getInt(1);
				String menuImg = rs.getString(4);
				String menuName1 = rs.getString(2);
				String menuType = rs.getString(3);
				int menuLikes = rs.getInt(7);
				MenuList menuList = new MenuList(menuId, menuImg, menuName, menuType, "菜谱详情", menuLikes);
				return menuList;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
