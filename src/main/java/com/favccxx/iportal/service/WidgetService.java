package com.favccxx.iportal.service;

import java.util.List;

import com.favccxx.iportal.model.PWidget;

public interface WidgetService {

	void save(PWidget widget);

	PWidget findById(long id);

	List<PWidget> listAll();
	
	/**
	 * 根据页面布局查询组件列表
	 * @param layoutId
	 * @return
	 */
	List<PWidget> listByLayoutId(long layoutId);
	
	/**
	 * 删除widget及其子组件
	 * @param widgetId
	 */
	void deleteByWidgetId(long widgetId);
	
	/**
	 * 根据组件Id查找当前组件及其子类
	 * @param widgetId
	 * @return
	 */
	List<PWidget> listByWidgetId(long widgetId);
	
	
}
