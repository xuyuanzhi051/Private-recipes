package net.xyz.service;

import net.xyz.dao.UserInfomationDao;
import net.xyz.entitys.UserInfomation;

/**
 * userInfomationService层 用来处理用户信息的业务逻辑
 * 
 * @author lenovo
 *
 */
public class UserInfomationService {
	private UserInfomationDao userInfomationDao;

	public UserInfomationService() {
		userInfomationDao = new UserInfomationDao();
	}

	/**
	 * 向数据库中加入一条记录信息
	 * 
	 * @param UserId用户Id
	 * @param userTel用户账号
	 */
	public void adduserInfomation(int userId, String userTel) {
		userInfomationDao.addUserInfomation(userId, userTel);
	}

	/*
	 * 根据用户手机号来更改用户信息
	 */
	public int updateUserInfomationServiceByTel(UserInfomation userInfomation) {
		return userInfomationDao.updateUserInfomationByTel(userInfomation);
	}

	/**
	 * 根据用户电话查询出用户的个人信息 返回一个个人信息对象
	 * 
	 * @param userTel用户电话
	 * @return
	 */
	public UserInfomation selectUserInfomationByTel(String userTel) {
		return userInfomationDao.selectUserInfomationByTel(userTel);

	}
}
