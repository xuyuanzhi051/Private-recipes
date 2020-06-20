package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.entitys.Menu;
import net.xyz.utils.JdbcUtils;

/**
 * 菜谱操作dao层，用来直接管理数据库
 * 
 * @author lenovo
 *
 */
public class MenuDao {
	/*
	 * 
	 * 向数据库中新增一条菜谱记录
	 */
	public void addMenu(Menu menu) {
		try {
			// 得到数据库连接
			Connection conn = JdbcUtils.getConnection();
			// 拼接sql语句
			String sql = "insert into menu(menu_name,menu_type,menu_img,menu_material,menu_steps) values (?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, menu.getMenuName());
			pstm.setString(2, menu.getMenuType());
			pstm.setString(3, menu.getMenuImg());
			pstm.setString(4, menu.getMenuMaterial());
			pstm.setString(5, menu.getMenuSteps());
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 根据菜谱Id来修改菜谱信息
	 * 
	 * @param menuId菜谱在数据库中的id
	 * @param menu用户修改后的菜谱信息，但是id没有改变
	 * @return
	 */
	public int upDateMenuById(Menu menu) {

		try {
			// 得到数据库连接
			Connection conn = JdbcUtils.getConnection();
			// 拼接sql语句
			String sql = "update menu set menu_name=?,menu_type=?,menu_img=?,menu_material=?,menu_steps=? where menu_id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, menu.getMenuName());
			pstm.setString(2, menu.getMenuType());
			pstm.setString(3, menu.getMenuImg());
			pstm.setString(4, menu.getMenuMaterial());
			pstm.setString(5, menu.getMenuSteps());
			pstm.setInt(6, menu.getMenuId());

			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	/**
	 * 删除菜谱信息 根据传递的id删除菜谱信息
	 * 
	 * @param menuId菜谱id
	 */
	public void deleteMenuById(int menuId) {
		try {
			Connection conn = JdbcUtils.getConnection();
			// 拼接sql语句
			String sql = "delete from menu where menu_id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, menuId);
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据菜谱名称搜索菜谱，得到菜谱信息
	 * 
	 * @param menuName
	 * @return
	 */
	public Menu SearchMenuByMenuName(String menuName) {
		try {
			Connection conn = JdbcUtils.getConnection();
			// 拼接sql语句
			String sql = "select * from menu where menu_name=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, menuName);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int menuId = rs.getInt(1);
				String menuName1 = rs.getString(2);
				String menuType = rs.getString(3);
				String menuImg = rs.getString(4);
				String menuMaterial = rs.getString(5);
				String menuSteps = rs.getString(6);
				// 构造菜谱对象
				Menu menu = new Menu(menuId, menuName, menuType, menuImg, menuMaterial, menuSteps);
				return menu;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;// 表示没有找到菜谱

	}

	/**
	 * 查询所有菜谱数据集
	 * 
	 * @throws SQLException
	 */
	public ResultSet selectMenus(String sql) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm.executeQuery();

	}

}
