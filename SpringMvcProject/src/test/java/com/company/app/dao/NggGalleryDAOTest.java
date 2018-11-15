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

import com.company.app.dao.interfaz.NggGalleryDAO;
import com.company.app.model.NggGalleryVO;
/**
 * @author davidPort
 *
 */
@ContextConfiguration(locations = "classpath:spring/application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class NggGalleryDAOTest {

	@Autowired
	private NggGalleryDAO nggGalleryDAO;
	
	@Test
    public void testSave() throws Exception{		
        
		NggGalleryVO nggGalleryVO = getNggGalleryVO();
		
		nggGalleryDAO.save(nggGalleryVO);;
		
        //assertNotNull(list);
    }
	
	private NggGalleryVO getNggGalleryVO(){
		NggGalleryVO nggGalleryVO = new NggGalleryVO();
		
		nggGalleryVO.setGid(1234);
		nggGalleryVO.setName("Prueba descripcion");
		nggGalleryVO.setSlug("filename");
		nggGalleryVO.setPath("Prueba imagen");
		nggGalleryVO.setTitle("Title imagen");
		nggGalleryVO.setGaldesc("Title imagen");
		nggGalleryVO.setPageid(12);
		nggGalleryVO.setPreviewpic(13);
		nggGalleryVO.setAuthor(200);
		nggGalleryVO.setExtras_post_id(2);
		
		return nggGalleryVO;
	}

}
