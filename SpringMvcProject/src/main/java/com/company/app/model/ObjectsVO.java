package com.company.app.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ObjectsVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3676052016954037090L;
	
	
	private Integer id; // int(11) AI PK 
	private String object; // varchar(100) 
	private Integer obj_ref_id; //  int(4) 
	private String title; //  varchar(255) 
	private String anho; //  varchar(255) 
	private String content; //  mediumtext 
	private String tags; //  varchar(250) 
	private String header; //  text 
	private Timestamp udate; //  datetime 
	private Timestamp pdate; //  datetime 
	private Integer creator; //  tinyint(3) 
	private Integer status; //  tinyint(1) 
	private Integer process; //  tinyint(1) 
	private Integer page_cache; //  tinyint(1) 
	private Integer section_id; //  tinyint(3) 
	private String url; //  varchar(250) 
	private Integer ord; //  smallint(3) 
	private String color; //  varchar(7) 
	private String bgimg; //  varchar(255) 
	private Integer hidden; //  tinyint(1) 
	private Integer current; //  tinyint(1) 
	private Integer images; //  smallint(4) 
	private Integer thumbs; //  smallint(4) 
	private String format; //  varchar(100) 
	private Integer _break; //  smallint(2) 
	private Integer tiling; //  tinyint(1) 
	private String year; //  varchar(4) 
	private Integer report; //  tinyint(1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public Integer getObj_ref_id() {
		return obj_ref_id;
	}
	public void setObj_ref_id(Integer obj_ref_id) {
		this.obj_ref_id = obj_ref_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAnho() {
		return anho;
	}
	public void setAnho(String anho) {
		this.anho = anho;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public Timestamp getUdate() {
		return udate;
	}
	public void setUdate(Timestamp udate) {
		this.udate = udate;
	}
	public Timestamp getPdate() {
		return pdate;
	}
	public void setPdate(Timestamp pdate) {
		this.pdate = pdate;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getProcess() {
		return process;
	}
	public void setProcess(Integer process) {
		this.process = process;
	}
	public Integer getPage_cache() {
		return page_cache;
	}
	public void setPage_cache(Integer page_cache) {
		this.page_cache = page_cache;
	}
	public Integer getSection_id() {
		return section_id;
	}
	public void setSection_id(Integer section_id) {
		this.section_id = section_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getOrd() {
		return ord;
	}
	public void setOrd(Integer ord) {
		this.ord = ord;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBgimg() {
		return bgimg;
	}
	public void setBgimg(String bgimg) {
		this.bgimg = bgimg;
	}
	public Integer getHidden() {
		return hidden;
	}
	public void setHidden(Integer hidden) {
		this.hidden = hidden;
	}
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		this.current = current;
	}
	public Integer getImages() {
		return images;
	}
	public void setImages(Integer images) {
		this.images = images;
	}
	public Integer getThumbs() {
		return thumbs;
	}
	public void setThumbs(Integer thumbs) {
		this.thumbs = thumbs;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Integer get_break() {
		return _break;
	}
	public void set_break(Integer _break) {
		this._break = _break;
	}
	public Integer getTiling() {
		return tiling;
	}
	public void setTiling(Integer tiling) {
		this.tiling = tiling;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Integer getReport() {
		return report;
	}
	public void setReport(Integer report) {
		this.report = report;
	}
	
	
	
	


}
