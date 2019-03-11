package com.test;



import java.util.List;

import org.junit.Test;
import org.lot.lotfilter.pojo.AdminUser;
import org.lot.lotfilter.pojo.UserExt;
import org.lot.lotfilter.service.AdminUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void test1() {

		AdminUserService adminUserService = (AdminUserService) ac.getBean("adminUserService");

		//AdminUser adminUser = new AdminUser();
		UserExt userExt = new UserExt("m", null, "", "");
	
		List<AdminUser> lsit = 	adminUserService.findAdminUserx(userExt);
		System.out.println(lsit.size());
		for (AdminUser adminUser : lsit) {
			System.out.println(adminUser);
		}
//		adminUserService.userLogin("moinros", "123456");
//		AdminUser adminUser = new AdminUser();
		
//		adminUserService.modifiAdminUser(adminUser);

	}

}
