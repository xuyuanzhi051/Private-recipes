package net.xyz.entitys;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息类，用来保存用户的个人信息
 * 
 * @author lenovo
 *
 */
public class UserInfomation {
	private int userId;// 用户Id
	private String userTel;// 用户账号
	private String userName;// 用户昵称
	private String userImg;// 用户头像
	private String userSex;// 用户性别
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
