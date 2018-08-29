package com.favccxx.iportal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.favccxx.iportal.model.PPager;

public interface PageRepository extends JpaRepository<PPager, Long> {
	
	@Query(value = "from PPager pg where pg.pageTitle like ?1", countQuery = "select count(pg) from PPager pg where pg.pageTitle like ?1")
	Page<PPager> pagePagers(String pageTitle, Pageable pageable);
	
	
	
}
