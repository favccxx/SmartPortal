package com.favccxx.iportal.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.favccxx.iportal.model.PPager;
import com.favccxx.iportal.repository.PageRepository;
import com.favccxx.iportal.service.PagerService;

@Service
public class PagerServiceImpl implements PagerService {
	
	@Autowired
	PageRepository pageRepository;

	@Transactional
	@Override
	public void save(PPager pager) {
		pageRepository.save(pager);
	}

	@Override
	public PPager findById(long id) {
		return pageRepository.findById(id).get();
	}

	@Override
	public List<PPager> listAll() {
		return pageRepository.findAll();
	}

	@Override
	public Page<PPager> pagePagers(String pageTitle, Pageable pageable) {
		if(StringUtils.isBlank(pageTitle)) {
			pageTitle="%%";
		}else {
			pageTitle = "%" + pageTitle + "%";
		}
		return pageRepository.pagePagers(pageTitle, pageable);
	}

}
