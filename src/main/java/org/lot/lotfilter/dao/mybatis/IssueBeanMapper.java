package org.lot.lotfilter.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.lot.lotfilter.pojo.IssueBean;

/**
 * Description:
 *
 * @Title: IssueBeanMapper
 * @author moinros
 * @date 2019年1月28日 下午10:35:59
 */
public interface IssueBeanMapper {

	/**
	 * Description:
	 *
	 * @Method 方法名 <selectIssueBean>
	 * @return [List<IssueBean>]
	 */
	@SelectProvider(method = "selectCreateIssueBeanSQL", type = IssueBeanSqlProvider.class)
	public List<IssueBean> selectIssueBean(IssueBean issueBean);

	/**
	 * Description: 
	 *
	 * @Method 方法名 <getIssueSon>
	 * @return [Integer]
	 */
	@SelectProvider(method = "selectCreateIssueSonSQL", type = IssueBeanSqlProvider.class)
	public Integer getIssueSon(Integer type);
	/**
	 * Description: 
	 *
	 * @Method 方法名 <insertIssueBean>
	 * @param issueBean
	 * @return [Integer]
	 */
	@InsertProvider(method = "insertCreateIssueBeanSQL", type = IssueBeanSqlProvider.class)
	public Integer insertIssueBean(IssueBean issueBean);

	
	/**
	 * Description: 
	 *
	 * @Method 方法名 <updateIssueBean>
	 * @param issueBean
	 * @return [Integer]
	 */
	@UpdateProvider(method = "updateCreateIssueBeanSQL", type = IssueBeanSqlProvider.class)
	public Integer updateIssueBean(IssueBean issueBean);
	
	/**
	 * Description:  删除期号
	 *
	 * @Method 方法名 <deleteIssueBean>
	 * @param issueBean
	 * @return [Integer]
	 */
	@DeleteProvider(method = "deleteCreateIssueBeanSQL", type = IssueBeanSqlProvider.class)
	public Integer deleteIssueBean(IssueBean issueBean);
}
