package com.favccxx.iportal.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.favccxx.iportal.model.PPager;

public interface PagerService {

	void save(PPager pager);

	PPager findById(long id);

	List<PPager> listAll();
	
	/**
	 * 分页查询自定义页面
	 * @param pageTitle
	 * @param pageable
	 * @return
	 */
	Page<PPager> pagePagers(String pageTitle, Pageable pageable);

}
