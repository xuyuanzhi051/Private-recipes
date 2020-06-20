package net.xyz.entitys;

/**
 * 管理员实体类方便完成对管理员的操作
 * 
 * @author lenovo
 *
 */
public class Administrator {
	private String administratorName;// 管理员账号
	private String administratorPassword;// 管理员密码

	public String getAdministratorName() {
		return administratorName;
	}

	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}

	public String getAdministratorPassword() {
		return administratorPassword;
	}

	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}

	@Override
	public String toString() {
		return "Administrator [administratorName=" + administratorName + ", administratorPassword="
				+ administratorPassword + "]";
	}

}
