package com.company.app.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.dao.interfaz.NggAlbumDAO;
import com.company.app.model.NggAlbumVO;

@Repository
public class NggAlbumDAOImpl implements NggAlbumDAO {

	private JdbcTemplate jdbcTemplate;

	final static String CONSTANT_SQL_QUERY = "INSERT INTO wordpress.wp_ngg_album (id,name,slug,previewpic,albumdesc,sortorder,pageid,extras_post_id) VALUES (?,?,?,?,?,?,?,?)";

	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	public void save(NggAlbumVO nggAlbumVO) {
		try {
			
			int count = jdbcTemplate.update(CONSTANT_SQL_QUERY,getMapObjects(nggAlbumVO));
			System.out.println("rows insert: "+count);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Object[] getMapObjects(NggAlbumVO nggAlbumVO) {
		Object[] objects = new Object[]{nggAlbumVO.getId(),nggAlbumVO.getName(),nggAlbumVO.getSlug(), nggAlbumVO.getPreviewpic(),
				nggAlbumVO.getAlbumdesc(),nggAlbumVO.getSortorder(),nggAlbumVO.getPageid(),nggAlbumVO.getExtras_post_id()};
		
		return objects;
	}


}
