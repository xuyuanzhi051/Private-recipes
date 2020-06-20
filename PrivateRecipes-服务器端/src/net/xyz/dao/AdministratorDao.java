package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.entitys.Administrator;
import net.xyz.utils.JdbcUtils;

/**
 * 管理员接口层，用于直接对管理员表的操作
 * 
 * @author lenovo
 *
 */
public class AdministratorDao {
	/**
	 * 查询数据库中是否存在管理员对象 如果存在返回一个管理员对象 如果不存在返回null
	 * 
	 * @param admin
	 * @return
	 */
	public Administrator isExistAdministrator(Administrator admin) {
		try {
			// 获取数据库连接对象
			Connection conn = JdbcUtils.getConnection();
			String sql = "select * from administrator where administrator_name=? and administrator_password=?";// 拼接sql语句
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, admin.getAdministratorName());
			pstm.setString(2, admin.getAdministratorPassword());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String administratorName = rs.getString(2);
				String administratorPassword = rs.getString(3);
				// 构建一个管理员对象
				Administrator admin1 = new Administrator();
				admin1.setAdministratorName(administratorName);
				admin1.setAdministratorPassword(administratorPassword);
				return admin1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
