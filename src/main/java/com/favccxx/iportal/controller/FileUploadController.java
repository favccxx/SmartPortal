package com.favccxx.iportal.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.favccxx.iportal.model.OcrFile;
import com.favccxx.iportal.service.OcrFileService;

@Controller
public class FileUploadController {

	Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	private static final String FILE_LOCATION = "D://OCRFILE/";

	@Autowired
	OcrFileService fileService;

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public @ResponseBody Object upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws FileNotFoundException, IOException {

		logger.debug("start upload file");

		if (file.isEmpty()) {
			logger.debug("file is empty, need to choose file to upload");
			request.setAttribute("message", "Please select a file to upload");
			return "uploadStatus";
		}

		saveFile2Disk(file);
		saveFile2DB(file);

		return "上传成功";
	}

	private void saveFile2DB(MultipartFile file) {
		OcrFile ocrFile = new OcrFile();

		ocrFile.setFileName(file.getOriginalFilename());
		ocrFile.setFileType(file.getContentType());
		ocrFile.setFileSize(file.getSize());
		ocrFile.setFileLocation(FILE_LOCATION);
		ocrFile.setFileDate(new Date());
		fileService.saveFile(ocrFile);
	}
	
	
	private void saveFile2Disk(MultipartFile file) throws FileNotFoundException, IOException {
		String outputFileName = FILE_LOCATION + file.getOriginalFilename();
		File outFile = new File(FILE_LOCATION);
		if(!outFile.exists()) {
			outFile.mkdirs();
		}
        FileCopyUtils.copy(file.getBytes(), new FileOutputStream( outputFileName));
	}

	// @RequestMapping("upload")
	// @ResponseBody
	// public String getfile(@RequestParam("myfile") MultipartFile file) {
	// System.out.println("file name = " + file.getOriginalFilename());
	//
	// // 获取文件名
	// String fileName = file.getOriginalFilename();
	// // 获取后缀
	// String suffixName = fileName.substring(fileName.lastIndexOf("."));
	// // 文件上产的路径
	// String filePath = "d:/upload/";
	// // fileName处理
	// fileName = filePath + UUID.randomUUID() + fileName;
	// // 文件对象
	// File dest = new File(fileName);
	// // 创建路径
	// if (!dest.getParentFile().exists()) {
	// dest.getParentFile().mkdir();
	// }
	//
	// try {
	// file.transferTo(dest);
	// return "上传成功";
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// return "上传失败";
	// }

}
