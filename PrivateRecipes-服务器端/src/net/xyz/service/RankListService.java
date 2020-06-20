package net.xyz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.xyz.dao.RankListDao;
import net.xyz.entitys.MenuList;
import net.xyz.entitys.RankList;
import net.xyz.utils.JdbcUtils;

/**
 * RankListService��
 * 
 * @author lenovo
 *
 */
public class RankListService {
	private RankListDao rankListDao;
	private List<RankList> rankLists;

	public RankListService() {
		rankListDao = new RankListDao();
		rankLists = new ArrayList<>();
	}

	/**
	 * �õ����ݿ��еĲ���������Ϣ ����������
	 */
	public List<RankList> getRankLists() {
		String sql = "SELECT  menu.*,menu_likes.menu_likenumber FROM menu,menu_likes WHERE menu.menu_id=menu_likes.menu_id ORDER BY menu_likenumber DESC";
		try {
			ResultSet rs = rankListDao.selectAllRankList(sql);
			int i = 0;
			while (rs.next()) {
				// ��ȡ���ݼ�ƴ�ӳ������б����
				String menuImg = rs.getString(4);
				String menuType = rs.getString(3);
				String menuName = rs.getString(2);
				int menuLikes = rs.getInt(7);
				RankList rankList = new RankList(++i, menuImg, menuName, menuType, menuLikes);
				rankLists.add(rankList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rankLists;
	}

	/**
	 * ͨ��������������ȡ���׵ĵ������
	 */
	public RankList selectRankByMenuName(String menuName) {
		return rankListDao.selectRankByMenuName(menuName);
	}

	/**
	 * ����ĳ�˵�id��ȡĳ�˵ĵ�����Ϣ
	 * 
	 * @throws SQLException
	 */
	public String selectLikeByUserId(int userId) throws SQLException {
		ResultSet rs = rankListDao.selectLikeByUserId(userId);
		String str = "";
		while (rs.next()) {
			str += rs.getInt(2) + "!!!" + rs.getInt(3) + "&&&";
		}
		return str;
	}
}
