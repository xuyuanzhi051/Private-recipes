package net.xyz.service;

import net.xyz.dao.AdministratorDao;
import net.xyz.entitys.Administrator;

/**
 * 管理员业务逻辑层 用来处理管理员的业务逻辑
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
	 * 判断当前管理员是否存在 存在返回true 不存在返回false
	 * 
	 * @param admin
	 * @return
	 */
	public boolean isExistAdministrator(Administrator admin) {
		if (administratorDao.isExistAdministrator(admin) != null) {
			return true;// 当前管理员存在
		}
		return false;// 当前管理员不存在
	}

}
