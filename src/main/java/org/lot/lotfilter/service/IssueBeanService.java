package org.lot.lotfilter.service;

import java.util.List;

import org.lot.lotfilter.pojo.IssueBean;

/**
 * Description:
 *
 * @Title: IssueBeanService
 * @author moinros
 * @date 2019年1月28日 下午11:16:11
 */
public interface IssueBeanService {

	/**
	 * Description:
	 *
	 * @Method 方法名 <findIssueBean>
	 * @return [List<IssueBean>]
	 */
	public List<IssueBean> findIssueBean(Integer type);

	/**
	 * Description: 根据期号 ID 查询单个期号的详细信息
	 *
	 * @Method 方法名 <findIssueBean>
	 * @param issueId 期号 ID
	 * @param type    地区类型 1: 四川 2:北京 3:上海
	 * @return [IssueBean]
	 */
	public IssueBean findIssueBean(Integer issueId, Integer type);

	/**
	 * Description:
	 *
	 * @Method 方法名 <getIssueSon>
	 * @param type
	 * @return [Integer]
	 */
	public Integer getIssueSon(Integer type);

	/**
	 * Description:
	 *
	 * @Method 方法名 <addIssueBean>
	 * @param issueBean
	 * @return [boolean]
	 */
	public boolean addIssueBean(IssueBean issueBean);

	/**
	 * Description: 发布期号
	 *
	 * @Method 方法名 <publish>
	 * @param issueId 期号 ID
	 * @param type    地区类型 1: 四川 2:北京 3:上海
	 * @return [boolean]
	 */
	public boolean publish(Integer issueId, Integer type);

	/**
	 * Description: 删除期号
	 *
	 * @Method 方法名 <deleteIssue>
	 * @param issueId 期号 ID
	 * @param type    地区类型 1: 四川 2:北京 3:上海
	 * @return [boolean]
	 */
	public boolean deleteIssue(Integer issueId, Integer type);

}
