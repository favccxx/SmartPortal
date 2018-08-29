package com.favccxx.iportal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.favccxx.iportal.model.OcrFile;

public interface OcrFileRepository extends JpaRepository<OcrFile, Long> {
	
	
	@Query(value = "from OcrFile ocrf where ocrf.fileName like ?1", countQuery = "select count(ocrf) from OcrFile ocrf where ocrf.fileName like ?1")
	Page<OcrFile> pageFiles(String fileName, Pageable pageable);

//	List<OcrFile> listFiles();

//	OcrFile getFile(Long id);

//	OcrFile saveFile(OcrFile ocrFile);
}
