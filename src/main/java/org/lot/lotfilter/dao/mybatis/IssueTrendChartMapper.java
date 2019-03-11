package org.lot.lotfilter.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.lot.lotfilter.pojo.IssueTrendChart;

/**
 * Description:
 *
 * @Title: IssueTrendChartMapper
 * @author moinros
 * @date 2019年2月2日 下午5:43:10
 */
public interface IssueTrendChartMapper {

	/**
	 * Description:
	 *
	 * @Method 方法名 <select>
	 * @param issueTrendChart
	 * @return [List<IssueTrendChart>]
	 */
	@SelectProvider(method = "selectCreateIssueTrendChartSQL", type = IssueTrendChartSqlProvider.class)
	public List<IssueTrendChart> selectIssueTrendChart(IssueTrendChart issueTrendChart);

	/**
	 * Description: 
	 *
	 * @Method 方法名 <insertIssueTrendChart>
	 * @param issueTrendChart
	 * @return [Integer]
	 */
	@InsertProvider(method = "insertCreateIssueTrendChartSQL", type = IssueTrendChartSqlProvider.class)
	public Integer insertIssueTrendChart(IssueTrendChart issueTrendChart);
}
