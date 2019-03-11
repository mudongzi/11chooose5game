package org.lot.lotfilter.pojo;

/**
 * Description:
 *
 * @Title: IssueBean
 * @author moinros
 * @date 2019年1月28日 下午10:21:12
 */
public class IssueBean {

	/** type 地区类型 1: 四川 2:北京 3:上海 */
	private Integer type;
	/** issue 期号 */
	private String issue;
	/** id 期号 ID */
	private Integer id;
	/** issueMain 主期号 */
	private Integer issueMain;
	/** issueSon 子期号 */
	private Integer issueSon;
	/** openTime 开奖时间 */
	private String openTime;
	/** openCode 开奖号码 */
	private String openCode;
	/** beginSaleTime 开售时间 */
	private String beginSaleTime;
	/** stopSaleTime 停售时间 */
	private String stopSaleTime;
	/** status 状态 0:未发布,1:已发布 */
	private Integer status;
	/** q1Bonus 前一奖金 */
	private double q1Bonus;
	/** q2Bonus 前二奖金 */
	private double q2Bonus;
	/** q3Bonus 前三奖金 */
	private double q3Bonus;

	public IssueBean() {
		//
	}

	@Override
	public String toString() {
		return "IssueBean [type=" + type + ", issue=" + issue + ", id=" + id + ", issueMain=" + issueMain
				+ ", issueSon=" + issueSon + ", openTime=" + openTime + ", openCode=" + openCode + ", beginSaleTime="
				+ beginSaleTime + ", stopSaleTime=" + stopSaleTime + ", status=" + status + ", q1Bonus=" + q1Bonus
				+ ", q2Bonus=" + q2Bonus + ", q3Bonus=" + q3Bonus + "]";
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIssueMain() {
		return issueMain;
	}

	public void setIssueMain(Integer issueMain) {
		this.issueMain = issueMain;
	}

	public Integer getIssueSon() {
		return issueSon;
	}

	public void setIssueSon(Integer issueSon) {
		this.issueSon = issueSon;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getOpenCode() {
		return openCode;
	}

	public void setOpenCode(String openCode) {
		this.openCode = openCode;
	}

	public String getBeginSaleTime() {
		return beginSaleTime;
	}

	public void setBeginSaleTime(String beginSaleTime) {
		this.beginSaleTime = beginSaleTime;
	}

	public String getStopSaleTime() {
		return stopSaleTime;
	}

	public void setStopSaleTime(String stopSaleTime) {
		this.stopSaleTime = stopSaleTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public double getQ1Bonus() {
		return q1Bonus;
	}

	public void setQ1Bonus(double q1Bonus) {
		this.q1Bonus = q1Bonus;
	}

	public double getQ2Bonus() {
		return q2Bonus;
	}

	public void setQ2Bonus(double q2Bonus) {
		this.q2Bonus = q2Bonus;
	}

	public double getQ3Bonus() {
		return q3Bonus;
	}

	public void setQ3Bonus(double q3Bonus) {
		this.q3Bonus = q3Bonus;
	}

}
