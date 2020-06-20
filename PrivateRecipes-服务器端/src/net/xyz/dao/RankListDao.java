package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.entitys.RankList;
import net.xyz.utils.JdbcUtils;

/**
 * �������dao�� ��ȡ���ݿ������в�����Ϣ�����ݼ�
 * 
 * @author lenovo
 *
 */
public class RankListDao {
	/**
	 * ��ѯ���в����б����ݼ�
	 * 
	 * @throws SQLException
	 */
	public ResultSet selectAllRankList(String sql) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm.executeQuery();
	}

	/**
	 * ͨ��������������ȡ���׵ĵ������
	 */
	public RankList selectRankByMenuName(String menuName) {
		try {
			Connection conn = JdbcUtils.getConnection();
			// ƴ��sql���
			String sql = "SELECT menu.*,menu_likes.menu_likenumber FROM menu,menu_likes WHERE (menu.menu_id=menu_likes.menu_id) AND (menu.menu_name=?)";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, menuName);
			ResultSet rs = pstm.executeQuery();
			String menuName1 = rs.getString(2);
			int menuLikeNumber = rs.getInt(7);
			RankList rk = new RankList();
			rk.setMenuName(menuName1);
			rk.setLikenumber(menuLikeNumber);
			return rk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����ĳ�˵�id��ȡĳ�˵ĵ�����Ϣ
	 * 
	 * @throws SQLException
	 */
	public ResultSet selectLikeByUserId(int userId) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		// ƴ��sql���
		String sql = "SELECT * FROM user_menulike WHERE user_id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, userId);
		return pstm.executeQuery();
	}

}
