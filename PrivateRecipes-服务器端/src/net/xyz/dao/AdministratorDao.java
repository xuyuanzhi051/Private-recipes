package net.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.xyz.entitys.Administrator;
import net.xyz.utils.JdbcUtils;

/**
 * ����Ա�ӿڲ㣬����ֱ�ӶԹ���Ա��Ĳ���
 * 
 * @author lenovo
 *
 */
public class AdministratorDao {
	/**
	 * ��ѯ���ݿ����Ƿ���ڹ���Ա���� ������ڷ���һ������Ա���� ��������ڷ���null
	 * 
	 * @param admin
	 * @return
	 */
	public Administrator isExistAdministrator(Administrator admin) {
		try {
			// ��ȡ���ݿ����Ӷ���
			Connection conn = JdbcUtils.getConnection();
			String sql = "select * from administrator where administrator_name=? and administrator_password=?";// ƴ��sql���
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, admin.getAdministratorName());
			pstm.setString(2, admin.getAdministratorPassword());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String administratorName = rs.getString(2);
				String administratorPassword = rs.getString(3);
				// ����һ������Ա����
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
