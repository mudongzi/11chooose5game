package org.lot.lotfilter.service;

import java.util.List;

import org.lot.lotfilter.pojo.IssueTrendChart;

/**
 * Description:
 *
 * @Title: IssueTrendChartService
 * @author moinros
 * @date 2019年2月2日 下午5:12:21
 */
public interface IssueTrendChartService {

	/**
	 * Description:
	 *
	 * @Method 方法名 <fiadIssueTrendChart>
	 * @param type
	 * @param playType
	 * @return [List<IssueTrendChart>]
	 */
	public List<IssueTrendChart> fiadIssueTrendChart(Integer type, Integer playType);

	/**
	 * Description: 
	 *
	 * @Method 方法名 <addIssueTrendChart>
	 * @param issueTrendChart
	 * @return [boolean]
	 */
	public boolean addIssueTrendChart(IssueTrendChart issueTrendChart);
}
