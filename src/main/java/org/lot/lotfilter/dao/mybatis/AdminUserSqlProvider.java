package org.lot.lotfilter.dao.mybatis;

import org.apache.ibatis.jdbc.SQL;
import org.lot.lotfilter.pojo.AdminUser;
import org.lot.lotfilter.pojo.UserExt;

/**
 * Description: 动态生成AdminUser的SQL语句
 *
 * @Title: AdminUserSqlProvider
 * @author moinros
 * @date 2019年1月22日 下午7:22:18
 */
public class AdminUserSqlProvider {

	/** USER_SQL */
	private final String USER_SQL = "u.id AS id, u.login_name AS loginName, u.login_password AS loginPassword, u.phone AS phone, u.email AS email, u.statusx AS 'status', u.failure_num AS failureNum, u.failure_time AS failure, u.Last_login_time AS LastLoginTime";

	/**
	 * Description:动态生成AdminUser的查询SQL语句
	 *
	 * @Method selectCreateAdminUserSQL
	 *
	 * @param user
	 * @return String
	 */
	public String selectCreateAdminUserSQL(AdminUser userEXt) {
		return new SQL() {
			{
				SELECT(USER_SQL);
				FROM("admin_user AS u");
				if (userEXt.getId() != null && userEXt.getId() > 0) {
					WHERE("id = #{id}");
				}
				if (userEXt.getLoginName() != null) {
					WHERE("login_name LIKE CONCAT('%', #{loginName}, '%')");
				}
				if (userEXt.getLoginPassword() != null) {
					WHERE("login_password = #{loginPassword}");
				}
				if (userEXt.getStatus() != null) {
					WHERE("statusx = #{status}");
				}
			}
		}.toString();

	}

	/**
	 * Description:
	 *
	 * @Method 方法名 <selectConditionAdminUserSQL>
	 * @param user
	 * @return [String]
	 */
	public String selectConditionAdminUserSQL(UserExt user) {
		String sql = new SQL() {
			{
				SELECT(USER_SQL);
				FROM("admin_user AS u");
				if (user.getLoginName() != null) {
					WHERE("login_name LIKE CONCAT('%', #{loginName}, '%')");
				}
				if (user.getStatus() != null && user.getStatus() >= 0) {
					WHERE("statusx = #{status}");
				}
				if (user.getStartTime() != null && !"".equals(user.getStartTime())) {
					WHERE("UNIX_TIMESTAMP(u.Last_login_time) >= UNIX_TIMESTAMP(#{startTime})");
				}
				if (user.getEndTime() != null  && !"".equals(user.getEndTime())) {
					WHERE("UNIX_TIMESTAMP(u.Last_login_time) <= UNIX_TIMESTAMP(#{endTime})");
				}
			}
		}.toString();
		//System.out.println(sql);
		return sql;
	}

	/**
	 * Description:动态生成AdminUser的添加SQL语句
	 *
	 * @Method insertCreateAdminUserSQL
	 *
	 * @param user
	 * @return String
	 */
	public String insertCreateAdminUserSQL(AdminUser adminUser) {
		return new SQL() {
			{
				INSERT_INTO("admin_user");
				if (adminUser.getLoginName() != null) {
					VALUES("login_name", "#{loginName}");
				}
				if (adminUser.getLoginPassword() != null) {
					VALUES("login_password", "#{loginPassword}");
				}
				if (adminUser.getEmail() != null) {
					VALUES("email", "#{email}");
				}
				if (adminUser.getStatus() != null) {
					VALUES("statusx", "#{status}");
				}
				if (adminUser.getEmail() != null) {
					VALUES("email", "#{email}");
				}
				if (adminUser.getFailureNum() != null) {
					VALUES("failure_num", "#{failureNum}");
				}
				if (adminUser.getFailureTime() != null) {
					VALUES("failure_time", "#{failureTime}");
				}
				if (adminUser.getLastLoginTime() != null) {
					VALUES("Last_login_time", "#{lastLoginTime}");
				}
				if (adminUser.getPhone() != null) {
					VALUES("phone", "#{phone}");
				}
			}
		}.toString();
	}

	/**
	 * Description: 动态生成AdminUser的修改SQL语句
	 *
	 * @Method updateSql
	 *
	 * @param adminUser
	 * @return String
	 */
	public String updateCreateAdminUserSQL(AdminUser adminUser) {
		return new SQL() {
			{
				UPDATE("admin_user");
				if (adminUser.getLoginPassword() != null) {
					SET("login_password = #{loginPassword}");
				}
				if (adminUser.getPhone() != null) {
					SET("phone = #{phone}");
				}
				if (adminUser.getEmail() != null) {
					SET("email = #{email}");
				}
				if (adminUser.getStatus() != null) {
					SET("statusx = #{status}");
				}
				if (adminUser.getFailureNum() != null) {
					SET("failure_num = #{failureNum}");
				}
				if (adminUser.getFailureTime() != null) {
					SET("failure_time = #{failureTime}");
				}
				if (adminUser.getLastLoginTime() != null) {
					SET("Last_login_time = #{lastLoginTime}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}

}
