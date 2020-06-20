package net.xyz.service;

import net.xyz.dao.UserInfomationDao;
import net.xyz.entitys.UserInfomation;

/**
 * userInfomationService�� ���������û���Ϣ��ҵ���߼�
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
	 * �����ݿ��м���һ����¼��Ϣ
	 * 
	 * @param UserId�û�Id
	 * @param userTel�û��˺�
	 */
	public void adduserInfomation(int userId, String userTel) {
		userInfomationDao.addUserInfomation(userId, userTel);
	}

	/*
	 * �����û��ֻ����������û���Ϣ
	 */
	public int updateUserInfomationServiceByTel(UserInfomation userInfomation) {
		return userInfomationDao.updateUserInfomationByTel(userInfomation);
	}

	/**
	 * �����û��绰��ѯ���û��ĸ�����Ϣ ����һ��������Ϣ����
	 * 
	 * @param userTel�û��绰
	 * @return
	 */
	public UserInfomation selectUserInfomationByTel(String userTel) {
		return userInfomationDao.selectUserInfomationByTel(userTel);

	}
}
