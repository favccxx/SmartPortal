package com.favccxx.iportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.favccxx.iportal.model.PDiget;
import com.favccxx.iportal.service.DigetService;


@Controller
public class DigetController {	
	
	@Autowired
	DigetService digetService;

	@RequestMapping(value= {"diget"})
	public String diget(Model model) {
		return "diget/list";
	}
	
	
	@RequestMapping(value= {"addDiget"})
	public String addDiget(Model model) {
		return "diget/diget";
	}
	
	
	@RequestMapping("saveDiget")
	public void saveDiget(PDiget diget) {
		digetService.save(diget);
	}
	
	
}
