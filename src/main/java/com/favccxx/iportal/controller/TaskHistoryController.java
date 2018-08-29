package com.favccxx.iportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.favccxx.iportal.model.OcrFile;
import com.favccxx.iportal.service.OcrFileService;
import com.favccxx.iportal.utils.datatables.DataTableRequest;
import com.favccxx.iportal.utils.datatables.DataTableResponse;

@Controller
public class TaskHistoryController {

	@Autowired
	OcrFileService ocrFileService;
	
	@RequestMapping(value = { "history" })
	public String history(Model model) {
		return "history";
	}
	
	
	@RequestMapping("/pageFiles")
	@ResponseBody
	public DataTableResponse<OcrFile> pageFiles(HttpServletRequest request) {
		DataTableRequest input = new DataTableRequest(request);
		DataTableResponse<OcrFile> dataTables = new DataTableResponse<OcrFile>();

		String searchValue = input.getSearch().getValue();

		Sort sort = new Sort(Direction.DESC, "fileDate");
		if (input.getOrder() != null) {
			if ("asc".equals(input.getOrder().getSortDir())) {
				sort = new Sort(Direction.ASC, input.getOrder().getData());
			} else {
				sort = new Sort(Direction.DESC, input.getOrder().getData());
			}
		}
		Pageable pageable = PageRequest.of(input.getStart(), input.getLength(), sort);
		Page<OcrFile> page = ocrFileService.pageFiles(searchValue, pageable);
		
		dataTables.setData(page.getContent());
		dataTables.setDraw(input.getDraw());
		dataTables.setRecordsTotal(page.getTotalElements());
		
		return dataTables;
	}
}
