package org.lot.lotfilter.service;

import java.util.List;

import org.lot.lotfilter.pojo.AdminMenu;

/**
 * Description: 主页面菜单树查询接口
 *
 * @Title: AdminMenuService
 * @author moinros
 * @date 2019年1月28日 下午9:22:29
 */
public interface AdminMenuService {

	/**
	 * Description:
	 *
	 * @Method 方法名 <findAdminMenu>
	 * @return [List<AdminMenu>]
	 */
	public List<AdminMenu> findAdminMenu();

	/**
	 * Description:
	 *
	 * @Method 方法名 <findAdminMenu>
	 * @param id
	 * @return [AdminMenu]
	 */
	public AdminMenu findAdminMenu(Integer id);

	/**
	 * Description:
	 *
	 * @Method 方法名 <addAdminMenu>
	 * @param adminMenu
	 * @return [boolean]
	 */
	public boolean addAdminMenu(AdminMenu adminMenu);

	/**
	 * Description:
	 *
	 * @Method 方法名 <updateAdminMenu>
	 * @param adminMenu
	 * @return [boolean]
	 */
	public boolean updateAdminMenu(AdminMenu adminMenu);

}
