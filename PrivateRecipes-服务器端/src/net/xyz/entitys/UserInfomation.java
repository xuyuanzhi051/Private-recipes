package net.xyz.entitys;

import java.util.ArrayList;
import java.util.List;

/**
 * �û���Ϣ�࣬���������û��ĸ�����Ϣ
 * 
 * @author lenovo
 *
 */
public class UserInfomation {
	private int userId;// �û�Id
	private String userTel;// �û��˺�
	private String userName;// �û��ǳ�
	private String userImg;// �û�ͷ��
	private String userSex;// �û��Ա�
	private String hobbys;

	public String getHobbys() {
		return hobbys;
	}

	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Override
	public String toString() {
		return "UserInfomation{" + "userId=" + userId + ", userTel='" + userTel + '\'' + ", userName='" + userName
				+ '\'' + ", userImg='" + userImg + '\'' + ", userSex='" + userSex + '\'' + ", hobbys=" + hobbys + '}';
	}

}
