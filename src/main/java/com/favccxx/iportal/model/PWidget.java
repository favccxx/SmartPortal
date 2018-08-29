package com.favccxx.iportal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 页面引用组件
 * 该组件必须指定来源公共组件diget
 * 
 * @author favccxx
 *
 */
@Entity
@Table(name = "P_Widget")
public class PWidget implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="widgetSeq")
	@SequenceGenerator(name="widgetSeq",initialValue = 1, allocationSize = 1, sequenceName = "WIDGET_SEQ" )
	private long widgetId;
	
	
	private long parentId;
	
	
	private long layoutId;
	
	
	private int layoutIndex;
	
	private int columnNum;
	
	/**
	 * 组件Id
	 */
	private long digetId;
	
	/**
	 * 组件名称
	 */
	private String widgetName;
	
	
	private String widgetMore;
	
	
	private String widgetUrl;
	
	
	private String widgetType;
	
	
	private String widgetContent;
	
	
	
	/*****************以上属性均来自于Diget*********************/
	
	/**
	 * 该组件被哪个页面引用
	 */
	private long pageId;
	
	/**
	 * 页面水平布局位置
	 */
	private String layoutX;
	
	/**
	 * 页面垂直布局位置
	 */
	private String layoutY;
	
	/**
	 * 自动布局或固定宽高
	 */
	private String position;
	
	
	private String layoutWidth;
	
	
	private String layoutHeight;

	private String scrolled = "no";

	public long getWidgetId() {
		return widgetId;
	}


	public void setWidgetId(long widgetId) {
		this.widgetId = widgetId;
	}


	public long getDigetId() {
		return digetId;
	}


	public void setDigetId(long digetId) {
		this.digetId = digetId;
	}


	public String getWidgetName() {
		return widgetName;
	}


	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}


	public String getWidgetMore() {
		return widgetMore;
	}


	public void setWidgetMore(String widgetMore) {
		this.widgetMore = widgetMore;
	}


	public String getWidgetUrl() {
		return widgetUrl;
	}


	public void setWidgetUrl(String widgetUrl) {
		this.widgetUrl = widgetUrl;
	}


	public String getWidgetType() {
		return widgetType;
	}


	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}


	public String getWidgetContent() {
		return widgetContent;
	}


	public void setWidgetContent(String widgetContent) {
		this.widgetContent = widgetContent;
	}


	public long getPageId() {
		return pageId;
	}


	public void setPageId(long pageId) {
		this.pageId = pageId;
	}


	public String getLayoutX() {
		return layoutX;
	}


	public void setLayoutX(String layoutX) {
		this.layoutX = layoutX;
	}


	public String getLayoutY() {
		return layoutY;
	}


	public void setLayoutY(String layoutY) {
		this.layoutY = layoutY;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getLayoutWidth() {
		return layoutWidth;
	}


	public void setLayoutWidth(String layoutWidth) {
		this.layoutWidth = layoutWidth;
	}


	public String getLayoutHeight() {
		return layoutHeight;
	}


	public void setLayoutHeight(String layoutHeight) {
		this.layoutHeight = layoutHeight;
	}


	public long getLayoutId() {
		return layoutId;
	}


	public void setLayoutId(long layoutId) {
		this.layoutId = layoutId;
	}


	public int getLayoutIndex() {
		return layoutIndex;
	}


	public void setLayoutIndex(int layoutIndex) {
		this.layoutIndex = layoutIndex;
	}


	public int getColumnNum() {
		return columnNum;
	}


	public void setColumnNum(int columnNum) {
		this.columnNum = columnNum;
	}


	public long getParentId() {
		return parentId;
	}


	public void setParentId(long parentId) {
		this.parentId = parentId;
	}


	public String getScrolled() {
		return scrolled;
	}


	public void setScrolled(String scrolled) {
		this.scrolled = scrolled;
	}







	
	
	
	
	
}
