package org.lot.lotfilter.dao.mybatis;

import org.apache.ibatis.jdbc.SQL;
import org.lot.lotfilter.pojo.IssueBean;

/**
 * Description:
 *
 * @Title: IssueBeanSqlProvider
 * @author moinros
 * @date 2019年1月28日 下午10:52:06
 */
public class IssueBeanSqlProvider {

	/** ISSUE_SQL */
	private final String ISSUE_SQL = "ise.issue AS issue, ise.id AS id, ise.issue_main AS issueMain, ise.issue_son AS issueSon, ise.open_time AS openTime, ise.open_code AS openCode, ise.begin_sale_time AS beginSaleTime, ise.stop_sale_time AS stopSaleTime, ise.`STATUS` AS 'status'";
	private final String Q1BONUS_SQL = ", ise.sc_q1_bonus AS q1Bonus, ise.sc_q2_bonus AS q2Bonus, ise.sc_q3_bonus AS q3Bonus";
	private final String Q2BONUS_SQL = ", ise.bj_q1_bonus AS q1Bonus, ise.bj_q2_bonus AS q2Bonus, ise.bj_q3_bonus AS q3Bonus";
	private final String Q3BONUS_SQL = ", ise.sh_q1_bonus AS q1Bonus, ise.sh_q2_bonus AS q2Bonus, ise.sh_q3_bonus AS q3Bonus";

	/**
	 * Description:
	 *
	 * @Method 方法名 <selectCreateAdminMenuSQL>
	 * @param issueBean
	 * @return [String]
	 */
	public String selectCreateIssueBeanSQL(IssueBean issueBean) {
		return new SQL() {
			{
				if (issueBean.getType() != null) {
					// 根据type值;查询不同地区的期号信息表
					if (issueBean.getType() == 1) {
						SELECT(ISSUE_SQL + Q1BONUS_SQL);
						FROM("issue_11x5_sc AS ise");
					}
					if (issueBean.getType() == 2) {
						SELECT(ISSUE_SQL + Q2BONUS_SQL);
						FROM("issue_11x5_bj AS ise");
					}
					if (issueBean.getType() == 3) {
						SELECT(ISSUE_SQL + Q3BONUS_SQL);
						FROM("issue_11x5_sh AS ise");
					}
				}
				if (issueBean.getId() != null && issueBean.getId() > 0) {
					WHERE("id = #{id}");
				}
			}
		}.toString();
	}

	/**
	 * Description:
	 *
	 * @Method 方法名 <selectCreateIssueSonSQL>
	 * @param type
	 * @return [String]
	 */
	public String selectCreateIssueSonSQL(Integer type) {
		return new SQL() {
			{
				SELECT("ise.issue_main");
				if (type == 1) {
					FROM("issue_11x5_sc AS ise");
				}
				if (type == 2) {
					FROM("issue_11x5_bj AS ise");
				}
				if (type == 3) {
					FROM("issue_11x5_sh AS ise");
				}
				ORDER_BY("issue_main DESC");
			}
		}.toString() + " LIMIT 0 , 1";
	}

	/**
	 * Description:
	 *
	 * @Method 方法名 <insertCreateIssueBeanSQL>
	 * @param issueBean
	 * @return [String]
	 */
	public String insertCreateIssueBeanSQL(IssueBean issueBean) {
		return new SQL() {
			{
				if (issueBean.getType() != null) {
					// 根据type值;查询不同地区的期号信息表
					if (issueBean.getType() == 1) {
						INSERT_INTO("issue_11x5_sc");
					} else if (issueBean.getType() == 2) {
						INSERT_INTO("issue_11x5_bj");
					} else if (issueBean.getType() == 3) {
						INSERT_INTO("issue_11x5_sh");
					}
				}
				if (issueBean.getId() != null && issueBean.getId() > 0) {
					VALUES("id", "#{id}");
				}
				if (issueBean.getIssue() != null) {
					VALUES("issue", "#{issue}");
				}
				if (issueBean.getIssueMain() != null && issueBean.getIssueMain() > 0) {
					VALUES("issue_main", "#{issueMain}");
				}
				if (issueBean.getIssueSon() != null && issueBean.getIssueSon() > 0) {
					VALUES("issue_son", "#{issueSon}");
				}
				if (issueBean.getOpenTime() != null) {
					VALUES("open_time", "#{openTime}");
				}
				if (issueBean.getOpenCode() != null) {
					VALUES("open_code", "#{openCode}");
				}
				if (issueBean.getBeginSaleTime() != null) {
					VALUES("begin_sale_time", "#{beginSaleTime}");
				}
				if (issueBean.getStopSaleTime() != null) {
					VALUES("stop_sale_time", "#{stopSaleTime}");
				}
				if (issueBean.getStatus() != null && issueBean.getStatus() > 0) {
					VALUES("STATUS", "#{status}");
				}
				if (issueBean.getType() == 1) {
					VALUES("sc_q1_bonus", "#{q1Bonus}");
					VALUES("sc_q2_bonus", "#{q2Bonus}");
					VALUES("sc_q3_bonus", "#{q3Bonus}");
				} else if (issueBean.getType() == 2) {
					VALUES("bj_q1_bonus", "#{q1Bonus}");
					VALUES("bj_q2_bonus", "#{q2Bonus}");
					VALUES("bj_q3_bonus", "#{q3Bonus}");
				} else if (issueBean.getType() == 3) {
					VALUES("sh_q1_bonus", "#{q1Bonus}");
					VALUES("sh_q2_bonus", "#{q2Bonus}");
					VALUES("sh_q3_bonus", "#{q3Bonus}");
				}
			}
		}.toString();
	}

	/**
	 * Description:
	 *
	 * @Method 方法名 <updateCreateIssueBeanSQL>
	 * @param issueBean
	 * @return [String]
	 */
	public String updateCreateIssueBeanSQL(IssueBean issueBean) {
		return new SQL() {
			{
				if (issueBean.getType() != null) {
					// 根据type值;查询不同地区的期号信息表
					if (issueBean.getType() == 1) {
						UPDATE("issue_11x5_sc");
					} else if (issueBean.getType() == 2) {
						UPDATE("issue_11x5_bj");
					} else if (issueBean.getType() == 3) {
						UPDATE("issue_11x5_sh");
					}
				}
				if (issueBean.getOpenTime() != null) {
					SET("open_time = #{openTime}");
				}
				if (issueBean.getStopSaleTime() != null) {
					SET("stop_sale_time = #{stopSaleTime}");
				}
				if (issueBean.getBeginSaleTime() != null) {
					SET("begin_sale_time = #{beginSaleTime}");
				}
				if (issueBean.getStatus() != null) {
					SET("STATUS = #{status}");
				}
				if (issueBean.getType() == 1) {
					if (issueBean.getQ1Bonus() > 0) {
						SET("bj_q1_bonus = #{q1Bonus}");
					}
					if (issueBean.getQ2Bonus() > 0) {
						SET("bj_q2_bonus = #{q2Bonus}");
					}
					if (issueBean.getQ3Bonus() > 0) {
						SET("bj_q3_bonus = #{q3Bonus}");
					}
				} else if (issueBean.getType() == 1) {
					if (issueBean.getQ1Bonus() > 0) {
						SET("sc_q1_bonus = #{q1Bonus}");
					}
					if (issueBean.getQ2Bonus() > 0) {
						SET("sc_q2_bonus = #{q2Bonus}");
					}
					if (issueBean.getQ3Bonus() > 0) {
						SET("sc_q3_bonus = #{q3Bonus}");
					}
				} else if (issueBean.getType() == 1) {
					if (issueBean.getQ1Bonus() > 0) {
						SET("sh_q1_bonus = #{q1Bonus}");
					}
					if (issueBean.getQ2Bonus() > 0) {
						SET("sh_q2_bonus = #{q2Bonus}");
					}
					if (issueBean.getQ3Bonus() > 0) {
						SET("sh_q3_bonus = #{q3Bonus}");
					}
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}

	/**
	 * Description:
	 *
	 * @Method 方法名 <deleteCreateIssueBeanSQL>
	 * @param issueBean
	 * @return [String]
	 */
	public String deleteCreateIssueBeanSQL(IssueBean issueBean) {
		return new SQL() {
			{
				if (issueBean.getType() != null) {
					// 根据type值;查询不同地区的期号信息表
					if (issueBean.getType() == 1) {
						DELETE_FROM("issue_11x5_sc");
					} else if (issueBean.getType() == 2) {
						DELETE_FROM("issue_11x5_bj");
					} else if (issueBean.getType() == 3) {
						DELETE_FROM("issue_11x5_sh");
					}
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}

}
