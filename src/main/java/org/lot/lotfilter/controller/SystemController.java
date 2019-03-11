package org.lot.lotfilter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.lot.lotfilter.pojo.AdminMenu;
import org.lot.lotfilter.pojo.AdminUser;
import org.lot.lotfilter.pojo.Menu;
import org.lot.lotfilter.pojo.UserExt;
import org.lot.lotfilter.service.AdminMenuService;
import org.lot.lotfilter.service.AdminUserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: 系统功能控制器
 *
 * @Title: SystemController
 * @author moinros
 * @date 2019年1月22日 上午9:42:48
 */
@Controller
@RequestMapping("/system")
public class SystemController {

	@Resource
	private AdminUserService adminUserService;
	@Resource
	private AdminMenuService adminMenuService;

	/**
	 * Description: 登录方法
	 *
	 * @Method userLogin//
	 *
	 * @param usercode  账号
	 * @param passwd    密码
	 * @param kaptchald 验证码
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("login/checkLogin")
	public Map<String, Object> userLogin(String usercode, String passwd, String kaptchald, HttpSession session) {
		String checkcode = (String) session.getAttribute("checkcode");
		System.out.println(checkcode + " == " + kaptchald);

		if (kaptchald != null) {
			// if (kaptchald.equalsIgnoreCase(checkcode)) {
			AdminUser adminUser = adminUserService.userLogin(usercode, passwd);
			if (adminUser != null) {
				session.setAttribute("adminUser", adminUser);
				return showMap("success", "登录成功", null);
			}
			// }
		}
		return showMap("error", "登录失败", null);
	}

	/**
	 * Description: 注册方法
	 *
	 * @Method register
	 *
	 * @param usercode   登录名
	 * @param passwd     登录密码
	 * @param rePassword 确认密码
	 * @return Map<String,String>
	 */
	@ResponseBody
	@RequestMapping("login/register")
	public Map<String, Object> register(String usercode, String passwd, String rePassword) {
		AdminUser adminUser = new AdminUser();
		adminUser.setLoginName(usercode);
		adminUser.setLoginPassword(passwd);
		boolean falg = adminUserService.userRegister(adminUser);
		if (falg) {
			return showMap("success", "注册成功", null);
		}
		return showMap("error", "注册失败", null);
	}

	/**
	 * Description: 登出模块
	 *
	 * @Method loginOut
	 *
	 * @param session void
	 */
	@ResponseBody
	@RequestMapping("login//loginOut")
	public Map<String, Object> loginOut(HttpSession session) {
		session.setAttribute("adminUser", null);
		return showMap("success", "退出登录", null);
	}

	/**
	 * Description: 修改密码
	 *
	 * @Method changePwd
	 *
	 * @param oldPwd   原密码
	 * @param newPwd   新密码
	 * @param reNewPwd 新密码确认
	 * @return Map<String,String>
	 */
	@ResponseBody
	@RequestMapping("manager/changePwd")
	public Map<String, Object> changePwd(String oldPwd, String newPwd, String reNewPwd, HttpSession session) {
		AdminUser adminUser = (AdminUser) session.getAttribute("adminUser");
		if (adminUser != null) {
			if (adminUser.getLoginPassword().equals(oldPwd)) {
				adminUser.setLoginPassword(newPwd);
				boolean flag = adminUserService.modifiAdminUser(adminUser);
				if (flag) {
					return showMap("success", "修改成功", null);
				}
			}
		}
		return showMap("error", "修改失败", null);
	}

	/**
	 * Description:
	 *
	 * @Method addOrUpdate
	 *
	 * @return Map<String,String>
	 */
	@ResponseBody
	@RequestMapping("manager/addOrUpdate")
	public Map<String, Object> addOrUpdate(String loginName, String password, String rePassword, String phone,
			String email) {
		AdminUser adminUser = adminUserService.userLogin(loginName, password);
		if (adminUser != null) {
			adminUser.setPhone(phone);
			adminUser.setEmail(email);
			boolean flag = adminUserService.modifiAdminUser(adminUser);
			if (flag) {
				return showMap("success", "保存成功", null);
			}
		}
		return showMap("error", "保存失败", null);
	}

	/**
	 * Description: 主页面查询接口
	 *
	 * @Method managerToMain
	 *
	 * @param loginName 登录名
	 * @param status    状态
	 * @param startTime 最后登录时间>=开始时间
	 * @param endTime   最后登录时间<=结束时间
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping("manager/toMain")
	public Map<String, Object> managerToMain(String loginName, Integer status, String startTime, String endTime) {
		System.out.println("进入manager/toMain方法");

		// UserExt userExt = new UserExt(loginName, status, startTime, endTime);
		// UserExt userExt = new UserExt(null, null, "2019/01/25", null);
		// List<AdminUser> lsit = adminUserService.findAdminUserx(userExt);

		UserExt userExt = new UserExt(loginName, status, startTime, endTime);
		List<AdminUser> list = adminUserService.findAdminUserx(userExt);

		return showMap("success", "查询成功", list);
	}

	/**
	 * Description:
	 *
	 * @Method getManager
	 *
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping("manager/getManager")
	public Map<String, Object> getManager(Integer id, Integer type) {
		System.out.println("id==" + id);
		System.out.println("type==" + type);
		AdminUser adminUser = adminUserService.findAdminUserById(id);
		return showMap("success", "", adminUser);
	}

	/**
	 * Description:
	 *
	 * @Method changeStatus
	 *
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping("manager/changeStatus")
	public Map<String, Object> changeStatus(Integer id, Integer type) {
		adminUserService.modifiAdminUserStatus(id, type);
		return showMap("success", "", null);
	}

	/**
	 * Description:
	 *
	 * @Method queryMenu void
	 */
	@ResponseBody
	@RequestMapping("menu/queryMenu")
	public Map<String, Object> queryMenu() {
		System.out.println("进入queryMenu方法");

		
		List<AdminMenu> adminMenuList = adminMenuService.findAdminMenu();

		for (AdminMenu adminMenu : adminMenuList) {
			System.out.println(adminMenu);
		}
		
		List<AdminMenu> Level1List = new ArrayList<AdminMenu>();

		for (int i = 0; i < adminMenuList.size(); i++) {
			if (adminMenuList.get(i).getParentId() == 0) {
				Level1List.add(adminMenuList.get(i));
			}
		}

		Map<String, Object> showMap = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();

		for (int i = 0; i < Level1List.size(); i++) {
			// 设置父级目录
			Map<String, Object> levelMap = new HashMap<String, Object>();
			levelMap.put("Level1", Level1List.get(i).getName());

			// 设置子目录
			List<Menu> level2List = new ArrayList<Menu>();
			for (int j = 0; j < adminMenuList.size(); j++) {
				if (adminMenuList.get(j).getParentId() == Level1List.get(i).getId()) {
					Menu menu = new Menu();
					menu.setItem(adminMenuList.get(j).getName());
					menu.setUrl(adminMenuList.get(j).getUrl());
					level2List.add(menu);
				}
			}
			levelMap.put("Level2", level2List);
			showList.add(levelMap);
		}

		showMap.put("menuInfo", showList);
		

//		[
//			{
//				"Level2":
//					[
//						{"item":"目录管理", "url":"/system/menu/toMain"},
//						{"item":"用户管理", "url":"/system/user/toMain"}
//					],
//				"Level1":"系统管理"
//			}
//		]	
		
		
//		{
//			"message":"查询成功",
//			"content":
//						{"menuInfo":
//								[
//									{"Level2":
//											[
//												{"item":"用户管理","url":"/system/manager/toMain"},
//												{"item":"目录管理","url":"/system/menu/toMain"}
//											],
//									 "Level1":"系统管理"
//									},
		
//									{"Level2":
//											[
//		 										{"item":"期号管理","url":"/lottery/choose/toMain"},
//		 										{"item":"走势图","url":"/lottery/trend/toMain"}
//		 									],
//									 "Level1":"11选5"
//									},
		
//									{"Level2":
//											[
//		 										{"item":"密码修改","url":"/system/manager/changePwd"}
//											],
//									 "Level1":"个人设置"
//									}
//				 				]
//						 },
//			"status":"success"
//		}
		
		
		return showMap("success", "查询成功", showMap);

	}

	/**
	 * Description:主页面查询接口
	 *
	 * @Method menuToMain
	 *
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping("menu/toMain")
	public Map<String, Object> menuToMain() {
		System.out.println("进入menu/toMain方法");

		List<AdminMenu> list = adminMenuService.findAdminMenu();

		return showMap("success", "保存成功", list);
	}

	/**
	 * Description: 新增菜单、修改菜单以及新增菜单下级目录接口
	 *
	 * @Method 方法名 <menuAddOrUpdate>
	 * @return [Map<String,Object>]
	 */
	@ResponseBody
	@RequestMapping("menu/AddOrUpdate")
	public Map<String, Object> menuAddOrUpdate(AdminMenu adminMenu) {
		System.out.println("进入menu/AddOrUpdate方法");
		System.out.println(adminMenu);
		boolean flag = false;
		if (adminMenu != null) {
			if (adminMenu.getId() != null) {
				flag = adminMenuService.updateAdminMenu(adminMenu);
			}else {
				flag = adminMenuService.addAdminMenu(adminMenu);
			}
		}
		
		if (flag) {
			return showMap("success", "保存成功", null);
		}
		return showMap("error", "保存失败", null);
	}

	/**
	 * Description:
	 *
	 * @Method 方法名 <menuGetMenu>
	 * @param id
	 * @return [Map<String,Object>]
	 */
	@ResponseBody
	@RequestMapping("menu/getMenu")
	public Map<String, Object> menuGetMenu(Integer id) {
		System.out.println("进入menu/getMenu方法");
		AdminMenu adminMenu = adminMenuService.findAdminMenu(id);
		return showMap("success", "保存成功", adminMenu);
	}

	/**
	 * Description: 设置回显信息
	 *
	 * @Method 方法名 <showMap>
	 * @param status  成功！失败
	 * @param value   回显信息
	 * @param content 回显的数据
	 * @return [Map<String,Object>]
	 */
	private Map<String, Object> showMap(String status, String value, Object content) {
		Map<String, Object> map = new HashMap<String, Object>();
		// success error
		map.put("status", "success");
		map.put("message", value);
		map.put("content", content);
		System.out.println("返回的数据 content==" + content);

		return map;
	}

}
