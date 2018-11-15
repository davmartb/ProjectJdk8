package com.company.app.dao.impl;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.dao.interfaz.NggPictureDAO;
import com.company.app.model.NggPictureVO;

@Repository
public class NggPictureDAOImpl implements NggPictureDAO {

	private JdbcTemplate jdbcTemplate;

	final static String CONSTANT_SQL_QUERY = "INSERT INTO wordpress.wp_ngg_pictures (pid,image_slug,post_id,galleryid,filename,description,alttext,imagedate,exclude,sortorder,meta_data,extras_post_id,updated_at) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	public void save(NggPictureVO nggPictureVO) {
		try {
			//int count = jdbcTemplate.update(CONSTANT_SQL_QUERY,getMapObjects(nggPictureVO), getMapTypes(nggPictureVO));
			
			int count = jdbcTemplate.update(CONSTANT_SQL_QUERY,getMapObjects(nggPictureVO));
			System.out.println("rows insert: "+count);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Object[] getMapObjects(NggPictureVO nggPictureVO) {
		Object[] objects = new Object[]{nggPictureVO.getPid(),nggPictureVO.getImage_slug(),nggPictureVO.getPost_id(), nggPictureVO.getGalleryid(),
				nggPictureVO.getFilename(),nggPictureVO.getDescription(),nggPictureVO.getAlttext(),nggPictureVO.getImagedate(),nggPictureVO.getExclude(),
				nggPictureVO.getSortorder(),nggPictureVO.getMeta_data(),nggPictureVO.getExtras_post_id(),nggPictureVO.getUpdated_at()};
		
		return objects;
	}

	private Object[] getMapTypes(NggPictureVO nggPictureVO) {
		Object[] objects = new Object[NggPictureVO.class.getDeclaredFields().length - 1];
		Field[] fields = NggPictureVO.class.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (!"serialVersionUID".equalsIgnoreCase(fields[i].getName())) {
				objects[i - 1] = getType(fields[i].getType());
			}
		}
		return objects;
	}

	private Object getType(Class type) {
		if (String.class.equals(type)) {
			return Types.VARCHAR;
		}
		if (Integer.class.equals(type)) {
			return Types.INTEGER;
		}
		if (Timestamp.class.equals(type)) {
			return Types.TIMESTAMP;
		}
		return 0;
	}

}
