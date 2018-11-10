package com.company.app.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.app.dao.interfaz.ObjectsDAO;
import com.company.app.jdbc.mapper.ObjectsVOMapper;
import com.company.app.model.ObjectsVO;

@Repository
public class ObjectsDAOImpl implements ObjectsDAO {
	 

	 private JdbcTemplate jdbcTemplate;

		@Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

		public List<ObjectsVO> findAllObjectsVO() {
			return this.jdbcTemplate.query( "SELECT id, object, obj_ref_id, title, anho, content, tags, header, udate, pdate, creator, status, process, page_cache, section_id, url, ord, color, bgimg, hidden,current, images, thumbs, format, break, tiling, year, report FROM ndxz_objects", new ObjectsVOMapper());
		}

}
