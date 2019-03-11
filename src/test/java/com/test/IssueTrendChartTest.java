package com.test;

import org.junit.Test;
import org.lot.lotfilter.dao.mybatis.IssueTrendChartMapper;
import org.lot.lotfilter.pojo.IssueTrendChart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IssueTrendChartTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void test1() {
		IssueTrendChartMapper itcm = (IssueTrendChartMapper) ac.getBean("issueTrendChartMapper");
		IssueTrendChart issueTrendChart = new IssueTrendChart();
		issueTrendChart.setType(1);
		issueTrendChart.setIssue("1234567");
		issueTrendChart.setOpenCode("888888888888");
		itcm.insertIssueTrendChart(issueTrendChart);
		
	}
}
