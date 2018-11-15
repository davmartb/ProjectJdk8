package com.company.app.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.dao.interfaz.NggGalleryDAO;
import com.company.app.model.NggGalleryVO;

@Repository
public class NggGalleryDAOImpl implements NggGalleryDAO {

	private JdbcTemplate jdbcTemplate;

	final static String CONSTANT_SQL_QUERY = "INSERT INTO wordpress.wp_ngg_gallery (gid,name,slug,path,title,galdesc,pageid,previewpic,author,extras_post_id) VALUES (?,?,?,?,?,?,?,?,?,?)";

	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	public void save(NggGalleryVO nggGalleryVO) {
		try {
			
			int count = jdbcTemplate.update(CONSTANT_SQL_QUERY,getMapObjects(nggGalleryVO));
			System.out.println("rows insert: "+count);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Object[] getMapObjects(NggGalleryVO nggGalleryVO) {
		Object[] objects = new Object[]{nggGalleryVO.getGid(),nggGalleryVO.getName(),nggGalleryVO.getSlug(), nggGalleryVO.getPath(),
				nggGalleryVO.getTitle(),nggGalleryVO.getGaldesc(),nggGalleryVO.getPageid(),nggGalleryVO.getPreviewpic(),nggGalleryVO.getAuthor(),
				nggGalleryVO.getExtras_post_id()};
		
		return objects;
	}


}
