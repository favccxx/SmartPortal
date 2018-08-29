package com.favccxx.iportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.favccxx.iportal.model.PWidget;

public interface WidgetRepository extends JpaRepository<PWidget, Long> {

	@Query(value = "from PWidget pw where pw.layoutId=?1 order by pw.widgetId ASC")
	List<PWidget> listByLayoutId(long layoutId);
	
	@Query(value = "from PWidget pw where pw.parentId=?1 order by pw.widgetId ASC")
	List<PWidget> listByParentWidgetId(long parentId);
	
	
	@Modifying
	@Query("delete from PWidget where layoutId=?1")
	void deleteByLayoutId(long layoutId);
	
}
