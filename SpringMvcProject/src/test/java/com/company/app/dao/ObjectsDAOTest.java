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

import com.company.app.dao.interfaz.ObjectsDAO;
import com.company.app.model.ObjectsVO;
/**
 * @author davidPort
 *
 */
@ContextConfiguration(locations = "classpath:spring/application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ObjectsDAOTest {

	@Autowired
	private ObjectsDAO objectsDAO;
	
	@Test
    public void testFindAllMediaVO() throws Exception{		
        
		List<ObjectsVO> list = objectsDAO.findAllObjectsVO();
		
        assertNotNull(list);
    }

}
