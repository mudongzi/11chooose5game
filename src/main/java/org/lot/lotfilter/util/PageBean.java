package org.lot.lotfilter.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 物理分页的工具类
 *
 * 使用方法 ： 1.获取到数据的总记录的集合 List<Object> list = objectServiceList();
 * 
 * 2.设置每页显示的记录数;当前页码数;以及获取到数据的总记录的集合;PageBean内部会自动对List集合进行分页处理 。
 * PageBean<Object> pageBean = new PageBean<Object>(5,2,list);
 * 
 * 3.此时获取到的已经是分页后的;list集合 pageBean.getListData();
 *
 * @Title: PageBean
 * @author moinros
 * @date 2019年1月21日09:51:36
 * @param <T>需要显示到客户端的数据类型
 */
public class PageBean<T> {

	/** pageNo 当前页码数 */
	private Integer pageNo;
	/** size 每页显示的记录数 */
	private int pageSize;
	/** dataSize 总记录数 */
	private int totalCoun;
	/** pageLength 总页码数 */
	private int totalPage;
	/** listData 需要显示到客户端的数据的List集合 */
	private List<T> entities;

	/**
	 * Description: PageBean<T>构造方法
	 * 
	 * @param pageSize 每页显示的最大记录数
	 * @param pageNo   当前页码数
	 * @param listData 需要显示的数据集合
	 */
	public PageBean(int pageSize, Integer pageNo, List<T> entities) {

		this.pageSize = pageSize;

		// 设置总记录数
		this.totalCoun = entities.size();

		// 设置最大页码数
		if (totalCoun % pageSize == 0) {
			this.totalPage = totalCoun / this.pageSize;
		} else {
			this.totalPage = totalCoun / this.pageSize + 1;
		}

		// 设置当前页码数
		if (pageNo == null || pageNo < 1) {
			this.pageNo = 1;
		} else if (pageNo > totalPage) {
			this.pageNo = totalPage;
		} else {
			this.pageNo = pageNo;
		}

		// 设置需要显示的数据的List集合
		setEntities(entities);

	}

	public Integer getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalCoun() {
		return totalCoun;
	}

	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * Description: 获取分页后的list集合
	 *
	 * @Method getEntities
	 *
	 * @return List<T>
	 */
	public List<T> getEntities() {
		return entities;
	}

	/**
	 * Description: 设置list集合
	 *
	 * @Method setListData
	 *
	 * @param list void
	 */
	private void setEntities(List<T> list) {
		List<T> datalist = new ArrayList<T>();
		for (int i = 0; i < list.size(); i++) {
			datalist.add(list.get(i));
		}
		if (pageNo == 1) {
			for (int i = pageSize; datalist.size() > pageSize;) {
				datalist.remove(i);
			}
			entities = datalist;
			return;
		}

		if (pageNo == totalPage) {

			for (int i = 0; i < (totalPage - 1) * pageSize; i++) {
				datalist.remove(0);
			}
			entities = datalist;
			return;
		}

		for (int i = 0; i < pageNo * pageSize - pageSize; i++) {
			datalist.remove(0);
		}
		for (int i = pageSize; datalist.size() > pageSize;) {
			datalist.remove(i);
		}
		entities = datalist;
	}

}
