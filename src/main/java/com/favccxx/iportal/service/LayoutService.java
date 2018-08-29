package com.favccxx.iportal.service;

import java.util.List;

import com.favccxx.iportal.model.PLayout;

public interface LayoutService {

	/**
	 * 新建或更新页面布局
	 * @param layout
	 */
	void save(PLayout layout);

	/**
	 * 根据页面Id顺序查询页面布局
	 * @param pageId
	 * @return
	 */
	List<PLayout> listByPageId(long pageId);
	
	/**
	 * 根据Id删除页面布局
	 * @param id
	 */
	void deleteById(long id);
}
