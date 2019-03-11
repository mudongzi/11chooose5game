package com.test;

import org.junit.Test;
import org.lot.lotfilter.pojo.IssueBean;
import org.lot.lotfilter.service.IssueBeanService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IssueBeanTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void test1() {
		IssueBeanService is = (IssueBeanService) ac.getBean("issueBeanService");
		IssueBean issue = new  IssueBean();
		issue.setType(1);
		issue.setIssue("181450");
		issue.setIssueMain(123);
		issue.setIssueSon(123456);
		issue.setStatus(1);
		issue.setStopSaleTime("2019-1-31 21:35:12");
		issue.setBeginSaleTime("2019-1-31 21:36:10");
		issue.setOpenTime("2019-1-31 21:36:15");
		issue.setOpenCode("01,03,05,07,09");
		issue.setQ1Bonus(10000);
		issue.setQ2Bonus(1000);
		issue.setQ3Bonus(100);
		is.addIssueBean(issue);
		
	}
}
