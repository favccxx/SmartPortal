package com.favccxx.iportal.service;

import java.util.List;

import com.favccxx.iportal.model.PDiget;

public interface DigetService {

	/**
	 * 保存或更新公共组件
	 * @param diget
	 */
	void save(PDiget diget);
	
	
	void findById(long id);
	
	
	List<PDiget> listAll();
	
}
