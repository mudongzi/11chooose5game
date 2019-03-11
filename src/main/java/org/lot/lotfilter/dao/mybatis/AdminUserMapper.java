package org.lot.lotfilter.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.lot.lotfilter.pojo.AdminUser;
import org.lot.lotfilter.pojo.UserExt;

/**
 * Description:
 *
 * @Title: AdminUserMapper
 * @author moinros
 * @date 2019年1月22日 下午6:31:05
 */
public interface AdminUserMapper {

	/**
	 * Description:根据AdminUser中传入的数据查询AdminUser的数据
	 *
	 * @Method selectAdminUser
	 *
	 * @param adminUser
	 * @return List<AdminUser>
	 */
	// @Results({@Result(column="STATUS",property="status")})
	@SelectProvider(method = "selectCreateAdminUserSQL", type = AdminUserSqlProvider.class)
	public List<AdminUser> selectAdminUser(AdminUser adminUser);

	/**
	 * Description: 
	 *
	 * @Method 方法名 <selectConditionAdminUser>
	 * @param userEXt
	 * @return [List<AdminUser>]
	 */
	@SelectProvider(method = "selectConditionAdminUserSQL", type = AdminUserSqlProvider.class)
	public List<AdminUser> selectConditionAdminUser(UserExt userEXt);

	/**
	 * Description: 添加AdminUser的信息
	 *
	 * @Method insertAdminUser
	 *
	 * @param adminUser
	 * @return Integer
	 */
	@InsertProvider(method = "insertCreateAdminUserSQL", type = AdminUserSqlProvider.class)
	public Integer insertAdminUser(AdminUser adminUser);

	/**
	 * Description: 修改AdminUser的信息
	 *
	 * @Method updateAdminUser
	 *
	 * @param adminUser
	 * @return Integer
	 */
	@UpdateProvider(method = "updateCreateAdminUserSQL", type = AdminUserSqlProvider.class)
	public Integer updateAdminUser(AdminUser adminUser);

}
