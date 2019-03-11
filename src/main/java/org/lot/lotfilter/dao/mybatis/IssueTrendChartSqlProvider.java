package org.lot.lotfilter.dao.mybatis;

import org.apache.ibatis.jdbc.SQL;
import org.lot.lotfilter.pojo.IssueTrendChart;

/**
 * Description:
 *
 * @Title: IssueTrendChartSqlProvider
 * @author moinros
 * @date 2019年2月2日 下午5:16:49
 */
public class IssueTrendChartSqlProvider {

	private final String PLAY_SQL = "itc.issue AS issue, itc.open_code AS openCode,";
	private final String PLAY1_SQL = "itc.N1 AS one, itc.N2 AS two, itc.N3 AS three, itc.N4 AS four, itc.N5 AS five, itc.N6 AS six, itc.N7 AS seven, itc.N8 AS eight, itc.N9 AS nine, itc.N10 AS ten, itc.N11 AS eleven";
	private final String PLAY2_SQL = "itc.N12 AS one, itc.N13 AS two, itc.N14 AS three, itc.N15 AS four, itc.N16 AS five, itc.N17 AS six, itc.N18 AS seven, itc.N19 AS eight, itc.N20 AS nine, itc.N21 AS ten, itc.N22 AS eleven";
	private final String PLAY3_SQL = "itc.N23 AS one, itc.N24 AS two, itc.N25 AS three, itc.N26 AS four, itc.N27 AS five, itc.N28 AS six, itc.N29 AS seven, itc.N30 AS eight, itc.N31 AS nine, itc.N32 AS ten, itc.N33 AS eleven";

	/**
	 * Description:
	 *
	 * @Method 方法名 <selectCreateIssueTrendChartSQL>
	 * @return [String]
	 */
	public String selectCreateIssueTrendChartSQL(IssueTrendChart trendChart) {
		return new SQL() {
			{
				if (trendChart.getPlayType() == 1) {
					SELECT(PLAY_SQL + PLAY1_SQL);
				} else if (trendChart.getPlayType() == 2) {
					SELECT(PLAY_SQL + PLAY2_SQL);
				} else if (trendChart.getPlayType() == 3) {
					SELECT(PLAY_SQL + PLAY3_SQL);
				}
				FROM("issue_trend_chart itc");
				if (trendChart.getType() != null || trendChart.getType() > 0) {
					WHERE("TYPE = #{type}");
				}

			}
		}.toString();
	}

	public int random() {
		return (int) (Math.random() * 100);
	}

	public String insertCreateIssueTrendChartSQL(IssueTrendChart trendChart) {

		String str = new SQL() {
			{
				INSERT_INTO("issue_trend_chart");
				if (trendChart.getType() != null) {
					VALUES("TYPE", "#{type}");
				}
				if (trendChart.getIssue() != null) {
					VALUES("issue", "#{issue}");
				}
				if (trendChart.getOpenCode() != null) {
					VALUES("open_code", "#{openCode}");
				}
				VALUES("N1", "" + random());
				VALUES("N2", "" + random());
				VALUES("N3", "" + random());
				VALUES("N4", "" + random());
				VALUES("N5", "" + random());
				VALUES("N6", "" + random());
				VALUES("N7", "" + random());
				VALUES("N8", "" + random());
				VALUES("N9", "" + random());
				VALUES("N10", "" + random());
				VALUES("N11", "" + random());
				VALUES("N12", "" + random());
				VALUES("N13", "" + random());
				VALUES("N14", "" + random());
				VALUES("N15", "" + random());
				VALUES("N16", "" + random());
				VALUES("N17", "" + random());
				VALUES("N18", "" + random());
				VALUES("N19", "" + random());
				VALUES("N20", "" + random());
				VALUES("N21", "" + random());
				VALUES("N22", "" + random());
				VALUES("N23", "" + random());
				VALUES("N24", "" + random());
				VALUES("N25", "" + random());
				VALUES("N26", "" + random());
				VALUES("N27", "" + random());
				VALUES("N28", "" + random());
				VALUES("N29", "" + random());
				VALUES("N30", "" + random());
				VALUES("N31", "" + random());
				VALUES("N32", "" + random());
				VALUES("N33", "" + random());
			}
		}.toString();
		return str;
	}

}
