package net.xyz.service;
/**
 * 业务逻辑层
 * 用来处理和用户相关的业务逻辑
 * @author lenovo
 *
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.xyz.dao.UserDao;
import net.xyz.entitys.User;

public class UserService {
	private UserDao userDao;
	private List<User> users;// 获取所有用户对象

	public UserService() {
		userDao = new UserDao();
		users = new ArrayList<User>();
	}

	/**
	 * 用户注册功能 检测数据库中是否存在该用户，如果存在发出提示信息 不存在向数据库中添加此用户
	 */
	public boolean registUser(User user) {
		User flag = userDao.selectUserByUserName(user.getUsername());// 判断用户中是否存在该用户
		if (flag != null) {
			System.out.println("该用户名已经被注册");
			return false;
		} else {
			userDao.addUser(user);
			System.out.println("用户注册成功");
			return true;
		}

	}

	/*
	 * 用户登录功能 查询数据库中是否存在此用户 存在返回此用户 不存在返回null
	 */
	public User login(User user) {
		return userDao.isExistUser(user);

	}

	/**
	 * 管理员管理用户功能 返回所有用户信息
	 * 
	 * @throws SQLException
	 */
	public List<User> getUsers() {
		ResultSet rs;
		try {
			rs = userDao.selectUser("select * from users");
			while (rs.next()) {
				int id = rs.getInt(1);
				String userName = rs.getString(2);
				String passWord = rs.getString(3);
				// 构造一个user对象
				User user = new User();
				user.setId(id);
				user.setUsername(userName);
				user.setPassword(passWord);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * 根据用户id删除该用户
	 * 
	 * @param id用户id
	 */
	public void deleteUserByUserId(int id) {
		userDao.deleteUserbyId(id);
	}

	/**
	 * 查询用户 根据用户姓名查找用户 如果存在返回User对象
	 */
	public User searchUserByname(String userName) {
		return userDao.selectUserByUserName(userName);
	}
}
