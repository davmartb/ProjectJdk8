package com.company.app.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.app.dao.interfaz.MediaDAO;
import com.company.app.jdbc.mapper.MediaVOMapper;
import com.company.app.model.MediaVO;

@Repository
public class MediaDAOImpl implements MediaDAO {
	 

	 private JdbcTemplate jdbcTemplate;

		@Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

		public List<MediaVO> findAllMediaVO() {
			return this.jdbcTemplate.query( "select media_id,media_ref_id,media_obj_type,media_mime,media_tags,media_file,media_title,media_caption,media_x,media_y,media_kb,media_udate,media_uploaded,media_order,media_hide from ndxz_media", new MediaVOMapper());
		}

}
