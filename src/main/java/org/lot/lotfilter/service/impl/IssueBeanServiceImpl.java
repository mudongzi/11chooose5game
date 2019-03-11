package org.lot.lotfilter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lot.lotfilter.dao.mybatis.IssueBeanMapper;
import org.lot.lotfilter.pojo.IssueBean;
import org.lot.lotfilter.service.IssueBeanService;
import org.lot.lotfilter.util.UidUtil;
import org.springframework.stereotype.Service;

@Service("issueBeanService")
public class IssueBeanServiceImpl implements IssueBeanService {

	@Resource
	private IssueBeanMapper issueBeanMapper;

	@Override
	public List<IssueBean> findIssueBean(Integer type) {
		IssueBean issueBean = new IssueBean();
		issueBean.setType(type);
		List<IssueBean> list = findIssueBean(issueBean);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public IssueBean findIssueBean(Integer issueId, Integer type) {
		IssueBean issueBean = new IssueBean();
		issueBean.setId(issueId);
		issueBean.setType(type);
		List<IssueBean> list = findIssueBean(issueBean);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	private List<IssueBean> findIssueBean(IssueBean issueBean) {
		List<IssueBean> list = issueBeanMapper.selectIssueBean(issueBean);
		return list;
	}

	@Override
	public Integer getIssueSon(Integer type) {
		Integer son = issueBeanMapper.getIssueSon(type);
		return son;
	}

	@Override
	public boolean addIssueBean(IssueBean issueBean) {
		issueBean.setIssue(UidUtil.getTimeId());
		int num = issueBeanMapper.insertIssueBean(issueBean);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean publish(Integer issueId, Integer type) {
		IssueBean issueBean = new IssueBean();
		issueBean.setId(issueId);
		issueBean.setType(type);
		issueBean.setStatus(1);
		Integer num = issueBeanMapper.updateIssueBean(issueBean);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteIssue(Integer issueId, Integer type) {
		IssueBean issueBean = new IssueBean();
		issueBean.setId(issueId);
		issueBean.setType(type);
		Integer num =	issueBeanMapper.deleteIssueBean(issueBean);
		if (num > 0) {
			return true;
		}
		return false;
	}

}
