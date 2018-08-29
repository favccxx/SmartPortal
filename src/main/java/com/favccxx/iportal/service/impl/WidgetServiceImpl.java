package com.favccxx.iportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.favccxx.iportal.model.PWidget;
import com.favccxx.iportal.repository.WidgetRepository;
import com.favccxx.iportal.service.WidgetService;

@Service
public class WidgetServiceImpl implements WidgetService {
	
	@Autowired
	WidgetRepository widgetRepository;

	@Transactional
	@Override
	public void save(PWidget widget) {
		widgetRepository.save(widget);
	}

	@Override
	public PWidget findById(long id) {
		return widgetRepository.findById(id).get();
	}

	@Override
	public List<PWidget> listAll() {
		return widgetRepository.findAll();
	}

	@Override
	public List<PWidget> listByLayoutId(long layoutId) {
		return widgetRepository.listByLayoutId(layoutId);
	}

	@Override
	public void deleteByWidgetId(long widgetId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PWidget> listByWidgetId(long widgetId) {
//		List<PWidget> list = new ArrayList<PWidget>();
//		PWidget parent = widgetRepository.findById(widgetId).get();
//		if(parent != null) {
//			list.add(parent);
//			
//			List<PWidget> children = widgetRepository.
//		}
		return null;
	}

}
