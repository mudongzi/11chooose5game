package org.lot.lotfilter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lot.lotfilter.dao.mybatis.AdminUserMapper;
import org.lot.lotfilter.pojo.AdminUser;
import org.lot.lotfilter.pojo.UserExt;
import org.lot.lotfilter.service.AdminUserService;
import org.lot.lotfilter.util.DateFormatUtil;
import org.springframework.stereotype.Service;

@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {

	@Resource
	private AdminUserMapper adminUserMapper;

	@Override
	public AdminUser userLogin(String loginName, String loginPassword) {
		AdminUser user = new AdminUser();
		user.setLoginName(loginName);
		user.setLoginPassword(loginPassword);
		List<AdminUser> list = findAdminUser(user);
		if (list != null && list.size() > 0) {
			list.get(0).setLastLoginTime(DateFormatUtil.getCurrentTime());
			adminUserMapper.updateAdminUser(list.get(0));
			return list.get(0);
		}
		return null;
	}

	@Override
	public AdminUser findAdminUserById(Integer id) {
		AdminUser user = new AdminUser();
		user.setId(id);
		List<AdminUser> list = findAdminUser(user);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<AdminUser> findAdminUser(AdminUser adminUser) {
		List<AdminUser> list = adminUserMapper.selectAdminUser(adminUser);
		return list;
	}

	@Override
	public List<AdminUser> findAdminUserx(UserExt userExt) {
		System.out.println(userExt);
		List<AdminUser> list = adminUserMapper.selectConditionAdminUser(userExt);
		return list;
	}

	@Override
	public List<AdminUser> findAdminUser() {
		return findAdminUser(new AdminUser());
	}


	
	@Override
	public boolean userRegister(AdminUser adminUser) {
		int num = adminUserMapper.insertAdminUser(adminUser);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifiAdminUser(AdminUser adminUser) {
		int num = adminUserMapper.updateAdminUser(adminUser);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifiAdminUserStatus(Integer id, Integer type) {
		if (type != null) {
			if (type == 1) {
				type = 0;
				System.out.println("禁用该账户");
			}else if (type == 2) {
				type = 1;
				System.out.println("恢复该账户");
			}else {
				System.out.println("解锁该账户");
				type = 1;
			}
			AdminUser adminUser = new AdminUser();
			adminUser.setId(id);
			adminUser.setStatus(type);
			return  modifiAdminUser(adminUser);
		}
		return false;
	}



}
