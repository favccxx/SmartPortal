package com.favccxx.iportal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "P_Layout")
public class PLayout implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "layoutSeq")
	@SequenceGenerator(name = "layoutSeq", initialValue = 1, allocationSize = 1, sequenceName = "LAYOUT_SEQ")
	private long layoutId;

	/**
	 * 页面Id
	 */
	private long pageId;

	/**
	 * 页面布局名称 12 6 6 3 9 4 8 ...
	 */
	private String layoutName;

	/**
	 * 相对布局： 0 绝对布局：1
	 */
	private int layoutType = 0;

	/**
	 * 显示顺序
	 */
	private int layoutOrder;

	/**
	 * 父布局
	 */
	private long parentId;

	private String description;

	@Transient
	private List<PWidget> widgetList;

	public long getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(long layoutId) {
		this.layoutId = layoutId;
	}

	public long getPageId() {
		return pageId;
	}

	public void setPageId(long pageId) {
		this.pageId = pageId;
	}

	public String getLayoutName() {
		return layoutName;
	}

	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}

	public int getLayoutType() {
		return layoutType;
	}

	public void setLayoutType(int layoutType) {
		this.layoutType = layoutType;
	}

	public int getLayoutOrder() {
		return layoutOrder;
	}

	public void setLayoutOrder(int layoutOrder) {
		this.layoutOrder = layoutOrder;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PWidget> getWidgetList() {
		return widgetList;
	}

	public void setWidgetList(List<PWidget> widgetList) {
		this.widgetList = widgetList;
	}

}
