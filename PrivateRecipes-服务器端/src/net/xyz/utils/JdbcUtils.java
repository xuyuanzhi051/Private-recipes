package net.xyz.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类
 * 
 * @author lenovo
 *
 */
public class JdbcUtils {
	private static Properties props = null;
	private static Connection conn = null;
	static {// 放入静态代码中只在JDBC类被加载的时候只执行一次

		// 1.加载配置文件
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		props = new Properties();
		try {
			props.load(in);// 把文件的内容放到里面
			// 2.加载驱动类
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
		 * 加载配置文件 加载驱动类 调用DriverManager.getConnection()
		 */

		// 3.得到Connection
		if (conn != null) {
			return conn;
		}
		return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
				props.getProperty("password"));
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException {
		conn.close();
	}
}
