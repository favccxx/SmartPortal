package com.favccxx.iportal.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.favccxx.iportal.model.OcrFile;

public interface OcrFileService {

	List<OcrFile> listFiles();

	/**
	 * 根据Id查找文件
	 * @param id
	 * @return
	 */
	OcrFile findById(Long id);

	/**
	 * 保存文件
	 * @param ocrFile
	 * @return
	 */
	OcrFile saveFile(OcrFile ocrFile);
	
	
	/**
	 * 分页查询OCR文件
	 * @param fileName
	 * @param pageable
	 * @return
	 */
	Page<OcrFile> pageFiles(String fileName, Pageable pageable);

}
