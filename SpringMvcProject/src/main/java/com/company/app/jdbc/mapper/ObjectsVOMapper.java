package com.company.app.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.company.app.model.ObjectsVO;

public class ObjectsVOMapper implements RowMapper<ObjectsVO>{

	public ObjectsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ObjectsVO objectsVO = new ObjectsVO();
		objectsVO.setId(rs.getInt("id"));
		objectsVO.setObject(rs.getString("object"));
		objectsVO.setObj_ref_id(rs.getInt("obj_ref_id"));
		objectsVO.setTitle(rs.getString("title"));
		objectsVO.setAnho(rs.getString("anho"));
		objectsVO.setContent(rs.getString("content"));
		objectsVO.setTags(rs.getString("tags"));
		objectsVO.setHeader(rs.getString("header"));
		objectsVO.setUdate(rs.getTimestamp("udate"));
		objectsVO.setPdate(rs.getTimestamp("pdate"));
		objectsVO.setCreator(rs.getInt("creator"));
		objectsVO.setStatus(rs.getInt("status"));
		objectsVO.setProcess(rs.getInt("process"));
		objectsVO.setPage_cache(rs.getInt("page_cache"));
		objectsVO.setSection_id(rs.getInt("section_id"));
		objectsVO.setUrl(rs.getString("url"));
		objectsVO.setOrd(rs.getInt("ord"));
		objectsVO.setColor(rs.getString("color"));
		objectsVO.setBgimg(rs.getString("bgimg"));
		objectsVO.setHidden(rs.getInt("hidden"));
		objectsVO.setCurrent(rs.getInt("current"));
		objectsVO.setImages(rs.getInt("images"));
		objectsVO.setThumbs(rs.getInt("thumbs"));
		objectsVO.setFormat(rs.getString("format"));
		objectsVO.set_break(rs.getInt("break"));
		objectsVO.setTiling(rs.getInt("tiling"));
		objectsVO.setYear(rs.getString("year"));
		objectsVO.setReport(rs.getInt("report"));
		
		
		return objectsVO;
	}

}
