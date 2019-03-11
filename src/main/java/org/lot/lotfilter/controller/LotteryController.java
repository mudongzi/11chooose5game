package org.lot.lotfilter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.lot.lotfilter.pojo.IssueBean;
import org.lot.lotfilter.pojo.IssueTrendChart;
import org.lot.lotfilter.service.IssueBeanService;
import org.lot.lotfilter.service.IssueTrendChartService;
import org.lot.lotfilter.util.PageBean;
import org.lot.lotfilter.util.RandomNumber;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: 期号管理控制器
 *
 * @Title: LotteryController
 * @author moinros
 * @date 2019年1月28日 下午10:02:20
 */
@Controller
@RequestMapping("/lottery")
public class LotteryController {

	@Resource
	private IssueBeanService issueBeanService;
	@Resource
	private IssueTrendChartService issueTrendChartService;

	/**
	 * Description: 走势图主页面查询
	 *
	 * @Method 方法名 <trendToMain>
	 * @param type     地区类型 1: 四川 2:北京 3:上海
	 * @param playType 1:前一玩法 2:前二玩法 3:前三玩法
	 * @return [Map<String,String>]
	 */
	@ResponseBody
	@RequestMapping("trend/toMain")
	public Map<String, Object> trendToMain(Integer type, Integer playType) {
		System.out.println("进入lottery/trend/toMain方法");
		List<IssueTrendChart> trendList = issueTrendChartService.fiadIssueTrendChart(type, playType);
		if (trendList != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("trendList", trendList);
			// int[] bingo = { 10, 2, 1, 1, 1, 1, 11, 6, 8, 12, 01 };
			// int[] miss = { 10, 2, 1, 1, 15, 1, 11, 6, 8, 12, 0 };

			int[] bingo = new int[11];
			int[] miss = new int[11];

			// 计算走势图
			trendCode(bingo, miss, trendList);

			map.put("bingo", bingo);
			map.put("miss", miss);
			return showMap("success", "发布成功", map);
		}
		return showMap("error", "发布失败", null);
	}

	/**
	 * Description: 计算中奖号码的最大连中次数
	 *
	 * @Method 方法名 <bingoCode>
	 * @param bingo
	 * @param miss
	 * @param trendList [void]
	 */
	private void trendCode(int[] bingo, int[] miss, List<IssueTrendChart> trendList) {
		for (int i = 0; i < trendList.size(); i++) {
			bingoCode(bingo, trendList.get(i).getOpenCode());
			if (i > 50) {
				break;
			}
		}
		if (trendList.size() <= 50) {
			for (int i = 0; i < miss.length; i++) {
				miss[i] = trendList.size() - bingo[i];
			}
		} else {
			for (int i = 0; i < miss.length; i++) {
				miss[i] = 50 - bingo[i];
			}
		}
	}

	/**
	 * Description: 
	 *
	 * @Method 方法名 <bingoCode>
	 * @param bingo
	 * @param code [void]
	 */
	private void bingoCode(int[] bingo, String code) {
		String[] arr = code.split(",");
		for (String str : arr) {
			switch (str) {
			case "01":
				bingo[0]++;
				break;
			case "02":
				bingo[1]++;
				break;
			case "03":
				bingo[2]++;
				break;
			case "04":
				bingo[3]++;
				break;
			case "05":
				bingo[4]++;
				break;
			case "06":
				bingo[5]++;
				break;
			case "07":
				bingo[6]++;
				break;
			case "08":
				bingo[7]++;
				break;
			case "09":
				bingo[8]++;
				break;
			case "10":
				bingo[9]++;
				break;
			case "11":
				bingo[10]++;
				break;
			}
		}
	}

	/**
	 * Description:
	 *
	 * @Method 方法名 <choosedToMain>
	 * @param type
	 * @param pageNo
	 * @param pageSize
	 * @return [Map<String,Object>]
	 */
	@ResponseBody
	@RequestMapping("choose/toMain")
	public Map<String, Object> choosedToMain(Integer type, Integer pageNo, Integer pageSize) {
		System.out.println("进入lottery/choose/toMain方法");
		System.out.println("type==" + type);
		System.out.println("pageNo==" + pageNo);
		System.out.println("pageSize==" + pageSize);
		List<IssueBean> list = issueBeanService.findIssueBean(type);
		if (list != null) {
			PageBean<IssueBean> pageBean = new PageBean<>(pageSize, pageNo, list);
			Map<String, PageBean<IssueBean>> map = new HashMap<String, PageBean<IssueBean>>();
			map.put("page", pageBean);
			return showMap("success", "查询成功", map);
		}
		return showMap("error", "查询失败", null);

	}

	/**
	 * Description: 添加期号
	 *
	 * @Method 方法名 <chooseAddOrUpdate>
	 * @param issueBean
	 * @return [Map<String,Object>]
	 */
	@ResponseBody
	@RequestMapping("choose/addOrUpdate")
	public Map<String, Object> chooseAddOrUpdate(IssueBean issueBean) {
		System.out.println("进入lottery/choose/addOrUpdate方法");
		boolean flag = issueBeanService.addIssueBean(issueBean);
		if (flag) {
			IssueTrendChart trendChart = new IssueTrendChart();
			trendChart.setType(issueBean.getType());
			trendChart.setOpenCode(issueBean.getOpenCode());
			trendChart.setIssue(issueBean.getIssue());
			issueTrendChartService.addIssueTrendChart(trendChart);
			return showMap("success", "添加成功", null);
		}
		return showMap("error", "添加失败", null);
	}

	/**
	 * Description: 查询最新主期号
	 *
	 * @Method 方法名 <chooseQueryIssueMain>
	 * @param type 地区类型 1: 四川 2:北京 3:上海
	 * @return [Map<String,Object>]
	 */
	@ResponseBody
	@RequestMapping("choose/queryIssueMain")
	public Map<String, Object> chooseQueryIssueMain(Integer type) {
		System.out.println("进入lottery/choose/queryIssueMain方法");
		System.out.println("type==" + type);
		Integer son = issueBeanService.getIssueSon(type);
		if (son == null || son == 0) {
			son = 20190202;
		}
		return showMap("success", "", son + 1);
	}

	/**
	 * Description:
	 *
	 * @Method 方法名 <chooseQueryIssueSon>
	 * @param type
	 * @return [Map<String,Object>]
	 */
	@ResponseBody
	@RequestMapping("choose/queryIssueSon")
	public Map<String, Object> chooseQueryIssueSon(Integer issue, Integer type) {
		System.out.println("进入lottery/choose/queryIssueSon方法");
		System.out.println("issue==" + issue);
		System.out.println("type==" + type);

		return showMap("success", "添加成功", "01");
	}

	/**
	 * Description: 根据期号 ID 查询单个期号的详细信息
	 *
	 * @Method 方法名 <getIssue>
	 * @param id   期号 ID
	 * @param type 地区类型 1: 四川 2:北京 3:上海
	 * @return [Map<String,Object>]
	 */
	@ResponseBody
	@RequestMapping("choose/getIssue")
	public Map<String, Object> getIssue(Integer id, Integer type) {
		IssueBean ib = issueBeanService.findIssueBean(id, type);
		return showMap("success", "添加成功", ib);
	}

	/**
	 * Description: 发布期号
	 *
	 * @Method 方法名 <publish>
	 * @param id   期号 ID
	 * @param type 地区类型 1: 四川 2:北京 3:上海
	 * @return [Map<String,Object>]
	 */
	@ResponseBody
	@RequestMapping("choose/publish")
	public Map<String, Object> publish(Integer id, Integer type) {
		boolean flag = issueBeanService.publish(id, type);
		if (flag) {
			return showMap("success", "发布成功", "");
		}
		return showMap("error", "发布失败", "");
	}

	/**
	 * Description: 删除期号
	 *
	 * @Method 方法名 <deleteIssue>
	 * @param id   期号 ID
	 * @param type 地区类型 1: 四川 2:北京 3:上海
	 * @return [Map<String,Object>]
	 */
	@ResponseBody
	@RequestMapping("choose/deleteIssue")
	public Map<String, Object> deleteIssue(Integer id, Integer type) {
		boolean flag = issueBeanService.deleteIssue(id, type);
		if (flag) {
			return showMap("success", "删除成功", "");
		}
		return showMap("error", "删除失败", "");
	}

	/**
	 * Description: 随机开奖号码
	 *
	 * @Method 方法名 <randomNumber>
	 * @return [String]
	 */
	@ResponseBody
	@RequestMapping("choose/randomNumber")
	public Map<String, Object> randomNumber() {
		String[] code = RandomNumber.getIssueCode();
		return showMap("success", "生成随机开奖号码", code);
	}

	/**
	 * Description: 设置回显信息
	 *
	 * @Method 方法名 <showMap>
	 * @param status  成功！失败
	 * @param value   回显信息
	 * @param content 回显的数据
	 * @return [Map<String,Object>]
	 */
	private Map<String, Object> showMap(String status, String value, Object content) {
		Map<String, Object> map = new HashMap<String, Object>();
		// success error
		map.put("status", status);
		map.put("message", value);
		map.put("content", content);
		System.out.println("测试::返回的数据::" + content);

		return map;
	}

}
