package com.favccxx.iportal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 视图组件
 * 独立的小应用程序，可能是iframe，也可能是图表
 * @author ...
 *
 */
@Entity
@Table(name = "P_Diget")
public class PDiget implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="digetSeq")
	@SequenceGenerator(name="digetSeq",initialValue = 1, allocationSize = 1, sequenceName = "DIGET_SEQ" )
	private long digetId;
	
	
	private String digetTitle;
	
	
	private String digetType;
	
	
	private int digetStatus;
	
	
	private String digetUrl;
	
	
	private String digetContent;
	
	
	private String digetMore;


	public long getDigetId() {
		return digetId;
	}


	public void setDigetId(long digetId) {
		this.digetId = digetId;
	}


	public String getDigetTitle() {
		return digetTitle;
	}


	public void setDigetTitle(String digetTitle) {
		this.digetTitle = digetTitle;
	}


	public String getDigetType() {
		return digetType;
	}


	public void setDigetType(String digetType) {
		this.digetType = digetType;
	}


	public int getDigetStatus() {
		return digetStatus;
	}


	public void setDigetStatus(int digetStatus) {
		this.digetStatus = digetStatus;
	}


	public String getDigetUrl() {
		return digetUrl;
	}


	public void setDigetUrl(String digetUrl) {
		this.digetUrl = digetUrl;
	}


	public String getDigetContent() {
		return digetContent;
	}


	public void setDigetContent(String digetContent) {
		this.digetContent = digetContent;
	}


	public String getDigetMore() {
		return digetMore;
	}


	public void setDigetMore(String digetMore) {
		this.digetMore = digetMore;
	}
	
	
	
	
	

}
