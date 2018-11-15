package com.company.app.model;

import java.io.Serializable;

public class NggGalleryVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3716431691954095432L;
	/**
	 * 
	 */

	private Integer gid;
	private String name;
	private String slug;
	private String path;
	private String title;
	private String galdesc;
	private Integer pageid;
	private Integer previewpic;
	private Integer author;
	private Integer extras_post_id;
	
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGaldesc() {
		return galdesc;
	}
	public void setGaldesc(String galdesc) {
		this.galdesc = galdesc;
	}
	public Integer getPageid() {
		return pageid;
	}
	public void setPageid(Integer pageid) {
		this.pageid = pageid;
	}
	public Integer getPreviewpic() {
		return previewpic;
	}
	public void setPreviewpic(Integer previewpic) {
		this.previewpic = previewpic;
	}
	public Integer getAuthor() {
		return author;
	}
	public void setAuthor(Integer author) {
		this.author = author;
	}
	public Integer getExtras_post_id() {
		return extras_post_id;
	}
	public void setExtras_post_id(Integer extras_post_id) {
		this.extras_post_id = extras_post_id;
	}
	

}
