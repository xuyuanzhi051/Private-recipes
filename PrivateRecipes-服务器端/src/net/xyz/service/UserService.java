package net.xyz.service;
/**
 * ҵ���߼���
 * ����������û���ص�ҵ���߼�
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
	private List<User> users;// ��ȡ�����û�����

	public UserService() {
		userDao = new UserDao();
		users = new ArrayList<User>();
	}

	/**
	 * �û�ע�Ṧ�� ������ݿ����Ƿ���ڸ��û���������ڷ�����ʾ��Ϣ �����������ݿ�����Ӵ��û�
	 */
	public boolean registUser(User user) {
		User flag = userDao.selectUserByUserName(user.getUsername());// �ж��û����Ƿ���ڸ��û�
		if (flag != null) {
			System.out.println("���û����Ѿ���ע��");
			return false;
		} else {
			userDao.addUser(user);
			System.out.println("�û�ע��ɹ�");
			return true;
		}

	}

	/*
	 * �û���¼���� ��ѯ���ݿ����Ƿ���ڴ��û� ���ڷ��ش��û� �����ڷ���null
	 */
	public User login(User user) {
		return userDao.isExistUser(user);

	}

	/**
	 * ����Ա�����û����� ���������û���Ϣ
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
				// ����һ��user����
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
	 * �����û�idɾ�����û�
	 * 
	 * @param id�û�id
	 */
	public void deleteUserByUserId(int id) {
		userDao.deleteUserbyId(id);
	}

	/**
	 * ��ѯ�û� �����û����������û� ������ڷ���User����
	 */
	public User searchUserByname(String userName) {
		return userDao.selectUserByUserName(userName);
	}
}
