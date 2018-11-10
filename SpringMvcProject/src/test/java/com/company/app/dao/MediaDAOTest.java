/**
 * 
 */
package com.company.app.dao;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.company.app.dao.interfaz.MediaDAO;
import com.company.app.model.MediaVO;
/**
 * @author davidPort
 *
 */
@ContextConfiguration(locations = "classpath:spring/application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MediaDAOTest {

	@Autowired
	private MediaDAO mediaDAO;
	
	@Test
    public void testFindAllMediaVO() throws Exception{		
        
		List<MediaVO> list = mediaDAO.findAllMediaVO();
		
        assertNotNull(list);
    }

}
