package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.entitys.MenuDetails;
import net.xyz.utils.JdbcUtils;

/**
 * ������������dao��
 * 
 * @author lenovo
 *
 */
public class MenuDetailsDao {
//	/**
//	 * ͨ��id�ҵ����׵���ϸ��Ϣ
//	 * @param menuId
//	 * @return
//	 */
//	public MenuDetails selectMenuDetailsByMenuId(int menuId) {
//		try {
//			Connection conn1=JdbcUtils.getConnection();
//			String sql1="SELECT menu.*,menu_likes.menu_likenumber FROM menu,menu_likes WHERE menu.menu_id=menu_likes.menu_id AND menu.menu_id=?";
//			PreparedStatement pstm1=conn1.prepareStatement(sql1);
//			pstm1.setInt(1, menuId);
//			ResultSet rs1=pstm1.executeQuery();
//			String menuImg=rs1.getString(4);
//			System.out.println("ͼƬ��"+menuImg);
//			String menuName=rs1.getString(2);
//			String menuType=rs1.getString(3);
//			int menuLikeNumber=rs1.getInt(7);
//			String menuMeterial=rs1.getString(5);
//			String menuSteps=rs1.getString(6);
//			while(rs1.next()) {
//				 menuImg=rs1.getString(4);
//				 menuName=rs1.getString(2);
//				 menuType=rs1.getString(3);
//				 menuLikeNumber=rs1.getInt(7);
//				menuMeterial=rs1.getString(5);
//				menuSteps=rs1.getString(6);
//			}
//			
////			String menuComments="";//���׵�������Ҫ�ٴδ�����ѯ
////			String sql2="SELECT * FROM menu_comments WHERE menu_id=?";
////			Connection conn2=JdbcUtils.getConnection();
////			PreparedStatement pstm2=conn2.prepareStatement(sql2);
////			pstm2.setInt(1,menuId);
////			ResultSet rs2=pstm2.executeQuery();
////			while(rs2.next()) {
////				menuComments+=rs2.getString(3)+"&&&";
////			}
////			//����һ��MenuDetails����
////			MenuDetails menuDetails=new MenuDetails(menuImg,menuName,menuType,menuLikeNumber+"",menuMeterial,menuSteps,menuComments,"a");
//			return null;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//		
//	}
	/**
	 * ����Id��ѯ�������
	 * 
	 * @throws SQLException
	 */
	public ResultSet selectMenuDetailsByMenuId(int menuId) throws SQLException {

		Connection conn = JdbcUtils.getConnection();
		String sql = "SELECT menu.*,menu_likes.menu_likenumber FROM menu,menu_likes WHERE (menu.menu_id=menu_likes.menu_id) AND (menu.menu_id=?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, menuId);
		return pstm.executeQuery();

	}

	/*
	 * ����id��ѯ���˵����۽����
	 */
	public ResultSet selectMenuCommonsByMenuId(int menuId) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from menu_comments where menu_id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, menuId);
		return pstm.executeQuery();
	}
}
