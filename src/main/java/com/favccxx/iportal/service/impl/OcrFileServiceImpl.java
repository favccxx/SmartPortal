package com.favccxx.iportal.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.favccxx.iportal.model.OcrFile;
import com.favccxx.iportal.repository.OcrFileRepository;
import com.favccxx.iportal.service.OcrFileService;

@Service
public class OcrFileServiceImpl implements OcrFileService {

	@Autowired
	OcrFileRepository fileRepository;
	
	@Override
	public List<OcrFile> listFiles() {
		return fileRepository.findAll();
	}

	@Override
	public OcrFile findById(Long id) {
		Optional<OcrFile> opt = fileRepository.findById(id);
		return opt.get();
	}

	@Override
	public OcrFile saveFile(OcrFile ocrFile) {
		return fileRepository.save(ocrFile);
	}

	@Override
	public Page<OcrFile> pageFiles(String fileName, Pageable pageable) {
		if(StringUtils.isBlank(fileName)) {
			fileName="%%";
		}else {
			fileName = "%" + fileName + "%";
		}
		return fileRepository.pageFiles(fileName, pageable);
	}

}
