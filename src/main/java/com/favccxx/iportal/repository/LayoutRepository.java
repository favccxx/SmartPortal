package com.favccxx.iportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.favccxx.iportal.model.PLayout;

public interface LayoutRepository extends JpaRepository<PLayout, Long> {
	
	
	@Query(value = "from PLayout layout where layout.pageId=?1 order by layout.layoutOrder ASC")
	List<PLayout> listByPageId(long pageId);
	


}
