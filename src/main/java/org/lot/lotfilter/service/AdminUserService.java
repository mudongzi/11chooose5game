package org.lot.lotfilter.service;

import java.util.List;

import org.lot.lotfilter.pojo.AdminUser;
import org.lot.lotfilter.pojo.UserExt;

/**
 * Description: AdminUser 的业务处理层的service接口
 *
 * @Title: AdminUserService
 * @author moinros
 * @date 2019年1月22日 下午7:18:09
 */
public interface AdminUserService {

	/**
	 * Description: AdminUser的登录方法
	 *
	 * @Method userLogin
	 *
	 * @param loginName     登录名
	 * @param loginPassword 登录密码
	 * @return AdminUser AdminUser.实体类
	 */
	public AdminUser userLogin(String loginName, String loginPassword);

	public AdminUser findAdminUserById(Integer id);

	/**
	 * Description:
	 *
	 * @Method findAdminUser
	 *
	 * @param adminUser
	 * @return List<AdminUser>
	 */
	public List<AdminUser> findAdminUser(AdminUser adminUser);

	/**
	 * Description:
	 *
	 * @Method 方法名 <findAdminUser>
	 * @param userExt
	 * @return [List<AdminUser>]
	 */
	public List<AdminUser> findAdminUserx(UserExt userExt);

	/**
	 * Description:
	 *
	 * @Method findAdminUser
	 *
	 * @return List<AdminUser>
	 */
	public List<AdminUser> findAdminUser();

	/**
	 * Description: 新用户注册
	 *
	 * @Method userRegister
	 *
	 * @param adminUser AdminUser.实体类
	 * @return boolean
	 */
	public boolean userRegister(AdminUser adminUser);

	/**
	 * Description: 修改AdminUser信息
	 *
	 * @Method modifiAdminUser
	 *
	 * @param adminUser AdminUser.实体类
	 * @return boolean
	 */
	public boolean modifiAdminUser(AdminUser adminUser);

	/**
	 * Description: 修改AdminUser登录状态
	 *
	 * @Method 方法名 <modifiAdminUserStatus>
	 * @param id   UserID
	 * @param type 状态ID
	 * @return [boolean]
	 */
	public boolean modifiAdminUserStatus(Integer id, Integer type);

}
