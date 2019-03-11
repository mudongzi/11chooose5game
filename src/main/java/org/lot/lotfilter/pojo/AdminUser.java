package org.lot.lotfilter.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * Description:用户表（admin_user)实体类
 *
 * @Title: AdminUser
 * @author moinros
 * @date 2019年1月22日 下午6:23:03
 */
@Component("adminUser")
public class AdminUser implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** id userId */
	private Integer id;

	/** loginName 登陆名 */
	private String loginName;

	/** loginPassword 登录密码 */
	private String loginPassword;

	/** phone 电话号码 */
	private String phone;

	/** email 邮箱 */
	private String email;

	/** STATUS 状态 0:禁用,1:正常,2:锁定 */
	private Integer status;

	/** failureNum 登录失败次数 */
	private Integer failureNum;

	/** failureTime 每次登录失败的时间 */
	private String failureTime;

	/** LastLoginTime 最后登录时间 */
	private String LastLoginTime;

	public AdminUser() {
		//
	}

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", loginName=" + loginName + ", loginPassword=" + loginPassword + ", phone="
				+ phone + ", email=" + email + ", status=" + status + ", failureNum=" + failureNum + ", failureTime="
				+ failureTime + ", LastLoginTime=" + LastLoginTime + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getFailureNum() {
		return failureNum;
	}

	public void setFailureNum(Integer failureNum) {
		this.failureNum = failureNum;
	}

	public String getFailureTime() {
		return failureTime;
	}

	public void setFailureTime(String failureTime) {
		this.failureTime = failureTime;
	}

	public String getLastLoginTime() {
		return LastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		LastLoginTime = lastLoginTime;
	}

}
