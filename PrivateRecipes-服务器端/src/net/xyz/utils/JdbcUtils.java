package net.xyz.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC������
 * 
 * @author lenovo
 *
 */
public class JdbcUtils {
	private static Properties props = null;
	private static Connection conn = null;
	static {// ���뾲̬������ֻ��JDBC�౻���ص�ʱ��ִֻ��һ��

		// 1.���������ļ�
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		props = new Properties();
		try {
			props.load(in);// ���ļ������ݷŵ�����
			// 2.����������
			Class.forName(props.getProperty("driver"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		/**
		 * ���������ļ� ���������� ����DriverManager.getConnection()
		 */

		// 3.�õ�Connection
		if (conn != null) {
			return conn;
		}
		return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
				props.getProperty("password"));
	}

	/**
	 * �ر����ݿ�����
	 * 
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException {
		conn.close();
	}
}
