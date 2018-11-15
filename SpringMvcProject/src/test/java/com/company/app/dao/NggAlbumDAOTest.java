/**
 * 
 */
package com.company.app.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.company.app.dao.interfaz.NggAlbumDAO;
import com.company.app.model.NggAlbumVO;
/**
 * @author davidPort
 *
 */
@ContextConfiguration(locations = "classpath:spring/application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class NggAlbumDAOTest {

	@Autowired
	private NggAlbumDAO nggAlbumDAO;
	
	@Test
    public void testSave() throws Exception{		
        
		NggAlbumVO nggAlbumVO = getNggAlbumVO();
		
		nggAlbumDAO.save(nggAlbumVO);;
		
        //assertNotNull(list);
    }
	
	private NggAlbumVO getNggAlbumVO(){
		NggAlbumVO nggAlbumVO = new NggAlbumVO();
		
		nggAlbumVO.setId(1234);
		nggAlbumVO.setName("Prueba descripcion");
		nggAlbumVO.setSlug("filename");
		nggAlbumVO.setAlbumdesc("Prueba imagen");
		nggAlbumVO.setSortorder("Title imagen");
		nggAlbumVO.setPageid(12);
		nggAlbumVO.setPreviewpic(13);
		nggAlbumVO.setExtras_post_id(2);
		
		return nggAlbumVO;
	}

}
