package com.favccxx.iportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.favccxx.iportal.model.PLayout;
import com.favccxx.iportal.repository.LayoutRepository;
import com.favccxx.iportal.repository.WidgetRepository;
import com.favccxx.iportal.service.LayoutService;

@Service
public class LayoutServiceImpl implements LayoutService {

	@Autowired
	LayoutRepository layoutRepository;
	@Autowired
	WidgetRepository widgetRepository;
	
	@Transactional
	@Override
	public void save(PLayout layout) {
		layoutRepository.save(layout);
	}

	@Override
	public List<PLayout> listByPageId(long pageId) {
		return layoutRepository.listByPageId(pageId);
	}

	@Transactional
	@Override
	public void deleteById(long id) {
		widgetRepository.deleteByLayoutId(id);
		layoutRepository.deleteById(id);
		
	}

}
