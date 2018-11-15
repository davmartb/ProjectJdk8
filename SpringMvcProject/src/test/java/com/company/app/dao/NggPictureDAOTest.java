/**
 * 
 */
package com.company.app.dao;


import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.company.app.dao.interfaz.NggPictureDAO;
import com.company.app.model.NggPictureVO;
/**
 * @author davidPort
 *
 */
@ContextConfiguration(locations = "classpath:spring/application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class NggPictureDAOTest {

	@Autowired
	private NggPictureDAO nggPictureDAO;
	
	@Test
    public void testSave() throws Exception{		
        
		NggPictureVO nggPictureVO = getNggPictureVO();
		
		nggPictureDAO.save(nggPictureVO);;
		
        //assertNotNull(list);
    }
	
	private NggPictureVO getNggPictureVO(){
		NggPictureVO nggPictureVO = new NggPictureVO();
		
		nggPictureVO.setPid(1234);
		nggPictureVO.setDescription("Prueba descripcion");
		nggPictureVO.setFilename("filename");
		nggPictureVO.setImage_slug("Prueba imagen");
		nggPictureVO.setPost_id(12);
		nggPictureVO.setGalleryid(13);
		nggPictureVO.setImagedate(new Timestamp(System.currentTimeMillis()));
		nggPictureVO.setSortorder(1);
		nggPictureVO.setExtras_post_id(2);
		
		return nggPictureVO;
	}

}
