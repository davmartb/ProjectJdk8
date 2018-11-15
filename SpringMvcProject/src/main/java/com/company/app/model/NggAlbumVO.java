package com.company.app.model;

import java.io.Serializable;

public class NggAlbumVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5434459733389115291L;
	/**
	 * 
	 */


	private Integer id;
	private String name;
	private String slug;
	private Integer previewpic;
	private String albumdesc;
	private String sortorder;
	private Integer pageid;
	private Integer extras_post_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getPreviewpic() {
		return previewpic;
	}
	public void setPreviewpic(Integer previewpic) {
		this.previewpic = previewpic;
	}
	public String getAlbumdesc() {
		return albumdesc;
	}
	public void setAlbumdesc(String albumdesc) {
		this.albumdesc = albumdesc;
	}
	public String getSortorder() {
		return sortorder;
	}
	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}
	public Integer getPageid() {
		return pageid;
	}
	public void setPageid(Integer pageid) {
		this.pageid = pageid;
	}
	public Integer getExtras_post_id() {
		return extras_post_id;
	}
	public void setExtras_post_id(Integer extras_post_id) {
		this.extras_post_id = extras_post_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
