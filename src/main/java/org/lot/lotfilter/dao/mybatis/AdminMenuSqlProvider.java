package org.lot.lotfilter.dao.mybatis;

import org.apache.ibatis.jdbc.SQL;
import org.lot.lotfilter.pojo.AdminMenu;

/**
 * Description:
 *
 * @Title: AdminMenuSqlProvider
 * @author moinros
 * @date 2019年1月28日 下午9:28:49
 */
public class AdminMenuSqlProvider {

	final String SELECT_SQL = "m.id AS id, m.`NAME` AS name, m.parent_id AS parentId, m.url AS url, m.orderby AS orderby, m.is_show AS isShow, m.is_open_new AS isOpenNew";

	/**
	 * Description:
	 *
	 * @Method 方法名 <selectCreateAdminMenuSQL>
	 * @param adminMenu
	 * @return [String]
	 */
	public String selectCreateAdminMenuSQL(AdminMenu adminMenu) {
		return new SQL() {
			{
				SELECT(SELECT_SQL);
				FROM("admin_menu AS m");
				if (adminMenu.getId() != null && adminMenu.getId() > 0) {
					WHERE("id = #{id}");
				}
			}
		}.toString();
	}

	/**
	 * Description:
	 *
	 * @Method 方法名 <indertCreateAdminMenuSQL>
	 * @param adminMenu
	 * @return [String]
	 */
	public String insertCreateAdminMenuSQL(AdminMenu adminMenu) {
		return new SQL() {
			{
				INSERT_INTO("admin_menu");
				if (adminMenu.getId() != null && adminMenu.getId() > 0) {
					VALUES("id", "#{id}");
				}
				if (adminMenu.getParentId() != null) {
					VALUES("parent_id", "#{parentId}");
				}
				if (adminMenu.getName() != null) {
					VALUES("NAME", "#{name}");
				}
				if (adminMenu.getUrl() != null) {
					VALUES("url", "#{url}");
				}
				if (adminMenu.getOrderby() != null) {
					VALUES("orderby", "#{orderby}");
				}
				if (adminMenu.getIsShow() != null) {
					VALUES("is_show", "#{isShow}");
				}
				if (adminMenu.getIsOpenNew() != null) {
					VALUES("is_open_new", "#{isOpenNew}");
				}
			}
		}.toString();
	}

	/**
	 * Description: 
	 *
	 * @Method 方法名 <updateCreateAdminMenuSQL>
	 * @param adminMenu
	 * @return [String]
	 */
	public String updateCreateAdminMenuSQL(AdminMenu adminMenu) {
		return new SQL() {
			{
				UPDATE("admin_menu");
				if (adminMenu.getName() != null) {
					SET("NAME = #{name}");
				}
				if (adminMenu.getIsShow() != null) {
					SET("is_show = #{isShow}");
				}
				if (adminMenu.getIsOpenNew() != null) {
					SET("is_open_new = #{isOpenNew}");
				}
				if (adminMenu.getUrl() != null) {
					SET("url = #{url}");
				}
				if (adminMenu.getOrderby() != null) {
					SET("orderby = #{orderby}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}

}
