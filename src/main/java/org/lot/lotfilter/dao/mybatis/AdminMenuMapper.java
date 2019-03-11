package org.lot.lotfilter.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.lot.lotfilter.pojo.AdminMenu;

/**
 * Description:
 *
 * @Title: AdminMenuMapper
 * @author moinros
 * @date 2019年1月28日 下午9:26:44
 */
public interface AdminMenuMapper {

	/**
	 * Description:
	 *
	 * @Method 方法名 <selectAdminMenu>
	 * @param adminMenu
	 * @return [List<AdminMenu>]
	 */
	@SelectProvider(method = "selectCreateAdminMenuSQL", type = AdminMenuSqlProvider.class)
	public List<AdminMenu> selectAdminMenu(AdminMenu adminMenu);

	/**
	 * Description:
	 *
	 * @Method 方法名 <insertAdminMenu>
	 * @param adminMenu
	 * @return [Integer]
	 */
	@InsertProvider(method = "insertCreateAdminMenuSQL", type = AdminMenuSqlProvider.class)
	public Integer insertAdminMenu(AdminMenu adminMenu);

	/**
	 * Description: 
	 *
	 * @Method 方法名 <updateAdminMenu>
	 * @param adminMenu
	 * @return [Integer]
	 */
	@UpdateProvider(method = "updateCreateAdminMenuSQL", type = AdminMenuSqlProvider.class)
	public Integer updateAdminMenu(AdminMenu adminMenu);

}
