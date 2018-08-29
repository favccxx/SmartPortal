package com.favccxx.iportal.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.favccxx.iportal.model.PLayout;
import com.favccxx.iportal.model.PPager;
import com.favccxx.iportal.model.PWidget;
import com.favccxx.iportal.service.LayoutService;
import com.favccxx.iportal.service.PagerService;
import com.favccxx.iportal.service.WidgetService;
import com.favccxx.iportal.utils.RestResult;
import com.favccxx.iportal.utils.datatables.DataTableRequest;
import com.favccxx.iportal.utils.datatables.DataTableResponse;

@Controller
public class PagerController {

	Logger logger = LoggerFactory.getLogger(PagerController.class);
	DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	
	@Autowired
	PagerService pagerService;
	@Autowired
	LayoutService layoutService;
	@Autowired
	WidgetService widgetService;
	
	
	@RequestMapping("pager")
	public String pager(Model model) {
		return "page/list";
	}
	
	
	@RequestMapping("page/view")
	public String view(Model model, long pageId) {
		List<PLayout> layoutList = layoutService.listByPageId(pageId);
		for(int i=0; i<layoutList.size(); i++) {
			long layoutId = layoutList.get(i).getLayoutId();
			List<PWidget> widgetList = widgetService.listByLayoutId(layoutId);
			layoutList.get(i).setWidgetList(widgetList);
		}
		model.addAttribute("layoutList", layoutList);
		return "page/view";
	}
	
	
	@RequestMapping("/pagePagers")
	@ResponseBody
	public DataTableResponse<PPager> pagePagers(HttpServletRequest request) {
		DataTableRequest input = new DataTableRequest(request);
		DataTableResponse<PPager> dataTables = new DataTableResponse<PPager>();

		String searchValue = input.getSearch().getValue();

		Sort sort = new Sort(Direction.DESC, "updateTime");
		if (input.getOrder() != null) {
			if ("asc".equals(input.getOrder().getSortDir())) {
				sort = new Sort(Direction.ASC, input.getOrder().getData());
			} else {
				sort = new Sort(Direction.DESC, input.getOrder().getData());
			}
		}
		Pageable pageable = PageRequest.of(input.getStart(), input.getLength(), sort);
		Page<PPager> page = pagerService.pagePagers(searchValue, pageable);
		
		dataTables.setData(page.getContent());
		dataTables.setDraw(input.getDraw());
		dataTables.setRecordsTotal(page.getTotalElements());
		
		return dataTables;
	}
	
	
	
	@RequestMapping("addPage")
	public String addPage(Model model) {
		PPager pager = new PPager();
		pager.setCreateTime(new Date());
		pager.setUpdateTime(new Date());
		String fileName = df.format(new Date()).replaceAll(":", "").replaceAll(" ", "");
		pager.setPageTitle("新页面" + fileName);
		pagerService.save(pager);
		model.addAttribute("pager", pager);
		return "page/pager";
	}
	
	
	@ResponseBody
	@RequestMapping("/page/addWidget")
	public String addWidget(Model model) {
		
		
		return RestResult.success("");
	}
	
	
	
	@ResponseBody
	@RequestMapping("/page/addLayout")
	public String addLayout(Model model, PLayout layout) {
		logger.info("layout:  " + layout.getLayoutName());
		
		String layoutName = layout.getLayoutName();
		int columnSum = 0;
		String[] layouts = layoutName.split(" ");
		for(int i=0; i<layouts.length; i++) {
			columnSum += Integer.valueOf(layouts[i]);
		}
		if(columnSum != 12) {
			return RestResult.error("页面布局不符合规范");
		}
		
		layoutService.save(layout);
		
		
		//设置widget
		List<PWidget> widgetList = new ArrayList<PWidget>();
		for(int i=0; i<layouts.length; i++) {
			PWidget widget = new PWidget();
			
			widget.setLayoutId(layout.getLayoutId());
			widget.setPageId(layout.getPageId());
			widget.setLayoutIndex(i);
			widget.setLayoutWidth("100%");
			widget.setLayoutHeight("300px");
			widget.setColumnNum(Integer.valueOf(layouts[i]));
			widgetService.save(widget);
			
			widgetList.add(widget);
		}
		
		layout.setWidgetList(widgetList);
		
		
		
		return RestResult.success(layout);
	}
	
	
	@ResponseBody
	@RequestMapping("/page/savePage")
	public String savePage(Model model, PPager pager) {
		PPager page = pagerService.findById(pager.getPageId());
		page.setPageTitle(pager.getPageTitle());
		page.setUpdateTime(new Date());
		page.setStatus(1);
		pagerService.save(page);
		return RestResult.success(page);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/page/viewWidget", method = RequestMethod.POST)
	public String viewWidget(Model model, String widgetId) {		
		PWidget widget = widgetService.findById(Long.valueOf(widgetId));			
		return RestResult.success(widget);
	}
	

	
	
	@ResponseBody
	@RequestMapping(value="/page/saveWidget", method = RequestMethod.POST)
	public String saveWidget(Model model, PWidget widget) {	
		PWidget oldWidget = widgetService.findById(widget.getWidgetId());
		oldWidget.setLayoutWidth(widget.getLayoutWidth());
		oldWidget.setLayoutHeight(widget.getLayoutHeight());
		oldWidget.setWidgetUrl(widget.getWidgetUrl());
		oldWidget.setScrolled(widget.getScrolled());
		widgetService.save(oldWidget);
		return RestResult.success(oldWidget);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/page/deleteLayout", method = RequestMethod.POST)
	public String deleteLayout(Model model, long layoutId) {	
//		PWidget oldWidget = widgetService.findById(widget.getWidgetId());
//		oldWidget.setLayoutWidth(widget.getLayoutWidth());
//		oldWidget.setLayoutHeight(widget.getLayoutHeight());
//		oldWidget.setWidgetUrl(widget.getWidgetUrl());
		layoutService.deleteById(layoutId);
		return RestResult.success("");
	}
	
	
}
