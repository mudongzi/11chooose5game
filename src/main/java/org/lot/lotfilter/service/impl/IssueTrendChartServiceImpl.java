package org.lot.lotfilter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lot.lotfilter.dao.mybatis.IssueTrendChartMapper;
import org.lot.lotfilter.pojo.IssueTrendChart;
import org.lot.lotfilter.service.IssueTrendChartService;
import org.springframework.stereotype.Service;

@Service("issueTrendChartService")
public class IssueTrendChartServiceImpl implements IssueTrendChartService {

	@Resource
	private IssueTrendChartMapper issueTrendChartMapper;

	@Override
	public List<IssueTrendChart> fiadIssueTrendChart(Integer type, Integer playType) {
		IssueTrendChart trendChart = new IssueTrendChart();
		trendChart.setType(type);
		trendChart.setPlayType(playType);
		List<IssueTrendChart> list = issueTrendChartMapper.selectIssueTrendChart(trendChart);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public boolean addIssueTrendChart(IssueTrendChart issueTrendChart) {
		int num = issueTrendChartMapper.insertIssueTrendChart(issueTrendChart);
		if (num > 0) {
			return true;
		}
		return false;
	}

}
