package net.xyz.entitys;

/**
 * ����Աʵ���෽����ɶԹ���Ա�Ĳ���
 * 
 * @author lenovo
 *
 */
public class Administrator {
	private String administratorName;// ����Ա�˺�
	private String administratorPassword;// ����Ա����

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
