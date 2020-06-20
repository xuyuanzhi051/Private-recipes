package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.entitys.Menu;
import net.xyz.utils.JdbcUtils;

/**
 * ���ײ���dao�㣬����ֱ�ӹ������ݿ�
 * 
 * @author lenovo
 *
 */
public class MenuDao {
	/*
	 * 
	 * �����ݿ�������һ�����׼�¼
	 */
	public void addMenu(Menu menu) {
		try {
			// �õ����ݿ�����
			Connection conn = JdbcUtils.getConnection();
			// ƴ��sql���
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
	 * ���ݲ���Id���޸Ĳ�����Ϣ
	 * 
	 * @param menuId���������ݿ��е�id
	 * @param menu�û��޸ĺ�Ĳ�����Ϣ������idû�иı�
	 * @return
	 */
	public int upDateMenuById(Menu menu) {

		try {
			// �õ����ݿ�����
			Connection conn = JdbcUtils.getConnection();
			// ƴ��sql���
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
	 * ɾ��������Ϣ ���ݴ��ݵ�idɾ��������Ϣ
	 * 
	 * @param menuId����id
	 */
	public void deleteMenuById(int menuId) {
		try {
			Connection conn = JdbcUtils.getConnection();
			// ƴ��sql���
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
	 * ���ݲ��������������ף��õ�������Ϣ
	 * 
	 * @param menuName
	 * @return
	 */
	public Menu SearchMenuByMenuName(String menuName) {
		try {
			Connection conn = JdbcUtils.getConnection();
			// ƴ��sql���
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
				// ������׶���
				Menu menu = new Menu(menuId, menuName, menuType, menuImg, menuMaterial, menuSteps);
				return menu;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;// ��ʾû���ҵ�����

	}

	/**
	 * ��ѯ���в������ݼ�
	 * 
	 * @throws SQLException
	 */
	public ResultSet selectMenus(String sql) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm.executeQuery();

	}

}
