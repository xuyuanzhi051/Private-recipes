package net.xyz.service;

import net.xyz.dao.AdministratorDao;
import net.xyz.entitys.Administrator;

/**
 * ����Աҵ���߼��� �����������Ա��ҵ���߼�
 * 
 * @author lenovo
 *
 */
public class AdministratorService {
	private AdministratorDao administratorDao;

	public AdministratorService() {
		administratorDao = new AdministratorDao();
	}

	/**
	 * �жϵ�ǰ����Ա�Ƿ���� ���ڷ���true �����ڷ���false
	 * 
	 * @param admin
	 * @return
	 */
	public boolean isExistAdministrator(Administrator admin) {
		if (administratorDao.isExistAdministrator(admin) != null) {
			return true;// ��ǰ����Ա����
		}
		return false;// ��ǰ����Ա������
	}

}
