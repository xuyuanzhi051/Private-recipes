package net.xyz.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.dao.MenuDetailsDao;
import net.xyz.entitys.MenuDetails;

public class MenuDetailsService {
	private MenuDetailsDao menuDetailsDao;

	public MenuDetailsService() {
		menuDetailsDao = new MenuDetailsDao();
	}

	/**
	 * 将数据库中查询出的结果集封装成一个菜谱对象
	 * 
	 * @param menuId
	 * @return
	 */
	public MenuDetails selectMenuDetailsByMenuId(int menuId) {
		try {
			ResultSet rs1 = menuDetailsDao.selectMenuDetailsByMenuId(menuId);
			ResultSet rs2 = menuDetailsDao.selectMenuDetailsByMenuId(menuId);
			MenuDetails menuDetails = new MenuDetails();
			while (rs1.next()) {
				String menuImg = rs1.getString(4);
				System.out.println("图片是" + menuImg);
				String menuName = rs1.getString(2);
				String menuType = rs1.getString(3);
				int menuLikeNumber = rs1.getInt(7);
				String menuMeterial = rs1.getString(5);
				String menuSteps = rs1.getString(6);
				menuDetails.setDetailsMenuImg(menuImg);
				menuDetails.setDetailsMenuName(menuName);
				menuDetails.setDetailsMenuType(menuType);
				menuDetails.setDetailsMenuLikeNumber(menuLikeNumber + "");
				menuDetails.setDetailsMenuMeterial(menuMeterial);
				menuDetails.setDetailsMenuSteps(menuSteps);
			}

			// 菜谱的评论需要再次创建查询
			while (rs2.next()) {
				String menuComments = rs2.getString(3) + "&&&";
				menuDetails.setDetailsMenuCommonts(menuComments);

			}
			// 构建一个MenuDetails对象
			// MenuDetails menuDetails=new
			// MenuDetails(menuImg,menuName,menuType,menuLikeNumber+"",menuMeterial,menuSteps,menuComments,"a");
			return menuDetails;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
