package org.lot.lotfilter.pojo;

import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Title: UserExt
 * @author moinros
 * @date 2019年1月23日 下午2:54:29
 */
@Component("userExt")
public class UserExt {

	/** loginName 登录名 */
	private String loginName;

	/** status 状态 */
	private Integer status;

	/** startTime 最后登录时间>=开始时间 */
	private String startTime;

	/** endTime 最后登录时间<=结束时间 */
	private String endTime;

	public UserExt() {
		//
	}
	
	public UserExt(String loginName, Integer status, String startTime, String endTime) {
		this.loginName = loginName;
		this.status = status;
		if (startTime != null) {
			this.startTime = startTime.replace('/', '-');
		}
		if (endTime != null) {
			this.endTime = endTime.replace('/', '-');
		}
	}

	@Override
	public String toString() {
		return "UserExt [loginName=" + loginName + ", status=" + status + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {

		this.startTime = startTime.replace('/', '-');
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime.replace('/', '-');
	}

}
