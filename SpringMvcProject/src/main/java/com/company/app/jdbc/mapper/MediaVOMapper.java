package com.company.app.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.company.app.model.MediaVO;

public class MediaVOMapper implements RowMapper<MediaVO>{

	public MediaVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MediaVO mediaVO = new MediaVO();
		mediaVO.setMedia_id(rs.getInt("media_id"));
		mediaVO.setMedia_ref_id(rs.getInt("media_ref_id"));
		mediaVO.setMedia_obj_type(rs.getString("media_obj_type"));
		mediaVO.setMedia_mime(rs.getString("media_mime"));
		mediaVO.setMedia_tags(rs.getString("media_tags"));
		mediaVO.setMedia_file(rs.getString("media_file"));
		mediaVO.setMedia_title(rs.getString("media_title"));
		mediaVO.setMedia_caption(rs.getString("media_caption"));
		mediaVO.setMedia_x(rs.getString("media_x"));
		mediaVO.setMedia_y(rs.getString("media_y"));
		mediaVO.setMedia_kb(rs.getInt("media_kb"));
		try {
			mediaVO.setMedia_udate(rs.getTimestamp("media_udate"));
		} catch (Exception e) {
			mediaVO.setMedia_udate(null);
		}
		try {
			mediaVO.setMedia_uploaded(rs.getTimestamp("media_uploaded"));	
		} catch (Exception e) {
			mediaVO.setMedia_uploaded(null);
		}
		mediaVO.setMedia_order(rs.getInt("media_order"));
		mediaVO.setMedia_hide(rs.getInt("media_hide"));
		
		
		return mediaVO;
	}

}
