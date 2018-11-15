package com.company.app.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class NggPictureVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3716431691954095432L;
	/**
	 * 
	 */

	private Integer pid;
	private String image_slug;
	private Integer post_id;
	private Integer galleryid;
	private String filename;
	private String description;
	private String alttext;
	private Timestamp imagedate;
	private Integer exclude;
	private Integer sortorder;
	private String meta_data;
	private Integer extras_post_id;
	private Integer updated_at;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getImage_slug() {
		return image_slug;
	}
	public void setImage_slug(String image_slug) {
		this.image_slug = image_slug;
	}
	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
	public Integer getGalleryid() {
		return galleryid;
	}
	public void setGalleryid(Integer galleryid) {
		this.galleryid = galleryid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAlttext() {
		return alttext;
	}
	public void setAlttext(String alttext) {
		this.alttext = alttext;
	}
	public Timestamp getImagedate() {
		return imagedate;
	}
	public void setImagedate(Timestamp imagedate) {
		this.imagedate = imagedate;
	}
	public Integer getExclude() {
		return exclude;
	}
	public void setExclude(Integer exclude) {
		this.exclude = exclude;
	}
	public Integer getSortorder() {
		return sortorder;
	}
	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}
	public String getMeta_data() {
		return meta_data;
	}
	public void setMeta_data(String meta_data) {
		this.meta_data = meta_data;
	}
	public Integer getExtras_post_id() {
		return extras_post_id;
	}
	public void setExtras_post_id(Integer extras_post_id) {
		this.extras_post_id = extras_post_id;
	}
	public Integer getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Integer updated_at) {
		this.updated_at = updated_at;
	}
	
	
	


}
