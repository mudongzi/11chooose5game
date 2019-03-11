package org.lot.lotfilter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lot.lotfilter.dao.mybatis.AdminMenuMapper;
import org.lot.lotfilter.pojo.AdminMenu;
import org.lot.lotfilter.service.AdminMenuService;
import org.springframework.stereotype.Service;

@Service("adminMenuService")
public class AdminMenuServiceImpl implements AdminMenuService {

	@Resource
	private AdminMenuMapper adminMenuMapper;

	@Override
	public List<AdminMenu> findAdminMenu() {
		AdminMenu adminMenu = new AdminMenu();
		List<AdminMenu> list = adminMenuMapper.selectAdminMenu(adminMenu);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public AdminMenu findAdminMenu(Integer id) {
		if (id != null) {
			AdminMenu adminMenu = new AdminMenu();
			adminMenu.setId(id);
			List<AdminMenu> list = adminMenuMapper.selectAdminMenu(adminMenu);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
		}
		return null;
	}

	@Override
	public boolean addAdminMenu(AdminMenu adminMenu) {
		Integer num = adminMenuMapper.insertAdminMenu(adminMenu);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAdminMenu(AdminMenu adminMenu) {
		Integer num = adminMenuMapper.updateAdminMenu(adminMenu);
		if (num > 0) {
			return true;
		}
		return false;
	}

}
