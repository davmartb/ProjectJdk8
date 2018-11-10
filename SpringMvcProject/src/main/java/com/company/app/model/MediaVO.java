package com.company.app.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class MediaVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8558817688210530494L;
	
	private Integer media_id;
	private String media_ref_id;
	private String media_obj_type;
	private String media_mime;
	private String media_tags;
	private String media_file;
	private String media_title;
	private String media_caption;
	private String media_x;
	private String media_y;
	private Integer media_kb;
	private Timestamp media_udate;
	private Timestamp media_uploaded;
	private Integer media_order;
	private Integer media_hide;
	public Integer getMedia_id() {
		return media_id;
	}
	public void setMedia_id(Integer media_id) {
		this.media_id = media_id;
	}
	public String getMedia_ref_id() {
		return media_ref_id;
	}
	public void setMedia_ref_id(String media_ref_id) {
		this.media_ref_id = media_ref_id;
	}
	public String getMedia_obj_type() {
		return media_obj_type;
	}
	public void setMedia_obj_type(String media_obj_type) {
		this.media_obj_type = media_obj_type;
	}
	public String getMedia_mime() {
		return media_mime;
	}
	public void setMedia_mime(String media_mime) {
		this.media_mime = media_mime;
	}
	public String getMedia_tags() {
		return media_tags;
	}
	public void setMedia_tags(String media_tags) {
		this.media_tags = media_tags;
	}
	public String getMedia_file() {
		return media_file;
	}
	public void setMedia_file(String media_file) {
		this.media_file = media_file;
	}
	public String getMedia_title() {
		return media_title;
	}
	public void setMedia_title(String media_title) {
		this.media_title = media_title;
	}
	public String getMedia_caption() {
		return media_caption;
	}
	public void setMedia_caption(String media_caption) {
		this.media_caption = media_caption;
	}
	public String getMedia_x() {
		return media_x;
	}
	public void setMedia_x(String media_x) {
		this.media_x = media_x;
	}
	public String getMedia_y() {
		return media_y;
	}
	public void setMedia_y(String media_y) {
		this.media_y = media_y;
	}
	public Integer getMedia_kb() {
		return media_kb;
	}
	public void setMedia_kb(Integer media_kb) {
		this.media_kb = media_kb;
	}
	public Timestamp getMedia_udate() {
		return media_udate;
	}
	public void setMedia_udate(Timestamp media_udate) {
		this.media_udate = media_udate;
	}
	public Timestamp getMedia_uploaded() {
		return media_uploaded;
	}
	public void setMedia_uploaded(Timestamp media_uploaded) {
		this.media_uploaded = media_uploaded;
	}
	public Integer getMedia_order() {
		return media_order;
	}
	public void setMedia_order(Integer media_order) {
		this.media_order = media_order;
	}
	public Integer getMedia_hide() {
		return media_hide;
	}
	public void setMedia_hide(Integer media_hide) {
		this.media_hide = media_hide;
	}
	
	
	


}
