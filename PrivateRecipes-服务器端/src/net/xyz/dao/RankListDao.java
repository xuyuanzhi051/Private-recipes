package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.entitys.RankList;
import net.xyz.utils.JdbcUtils;

/**
 * 链表操作dao层 获取数据库中所有菜谱信息的数据集
 * 
 * @author lenovo
 *
 */
public class RankListDao {
	/**
	 * 查询所有菜谱列表数据集
	 * 
	 * @throws SQLException
	 */
	public ResultSet selectAllRankList(String sql) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm.executeQuery();
	}

	/**
	 * 通过菜谱名称来获取菜谱的点赞情况
	 */
	public RankList selectRankByMenuName(String menuName) {
		try {
			Connection conn = JdbcUtils.getConnection();
			// 拼接sql语句
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
	 * 根据某人的id获取某人的点赞信息
	 * 
	 * @throws SQLException
	 */
	public ResultSet selectLikeByUserId(int userId) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		// 拼接sql语句
		String sql = "SELECT * FROM user_menulike WHERE user_id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, userId);
		return pstm.executeQuery();
	}

}
