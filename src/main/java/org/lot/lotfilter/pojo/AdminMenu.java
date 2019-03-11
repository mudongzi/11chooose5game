package org.lot.lotfilter.pojo;

import org.springframework.stereotype.Component;

/**
 * Description: 主页面菜单树实体类
 *
 * @Title: AdminMenu
 * @author moinros
 * @date 2019年1月28日 下午9:14:14
 */
@Component("adminMenu")
public class AdminMenu {

	/** id 菜单 ID */
	private Integer id;
	
	/** name 菜单名称 */
	private String name;
	
	/** url 菜单父 ID 当为父页面时,ID 为 0 */
	private String url;
	
	/** parentId 路径 */
	private Integer parentId;
	
	/** orderby 排序值 */
	private Integer orderby;
	
	/** isShow 是否显示 */
	private Integer isShow;
	
	/** isOpenNew 是否新页面 打开0:否 1:是 */
	private Integer isOpenNew;

	public AdminMenu() {
		//
	}

	@Override
	public String toString() {
		return "AdminMenu [id=" + id + ", name=" + name + ", url=" + url + ", parentId=" + parentId + ", orderby="
				+ orderby + ", isShow=" + isShow + ", isOpenNew=" + isOpenNew + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getOrderby() {
		return orderby;
	}

	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getIsOpenNew() {
		return isOpenNew;
	}

	public void setIsOpenNew(Integer isOpenNew) {
		this.isOpenNew = isOpenNew;
	}

}
