/**
 * MailServicioTest.java
 */
package com.company.app.services;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.company.app.services.inter.OrderAlbumImagesServicio;

/**
 * <p>Nombre Clase: OrderAlbumImagesServicioTest</p>
 * <p>Descripcion</p>
 * <p>Metodos de la clase</p>
 * @author 
 * 
 * @d10/05/2010
 */
@ContextConfiguration(locations = "classpath:spring/application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class OrderAlbumImagesServicioTest extends TestCase  {
	
	@Autowired
	private OrderAlbumImagesServicio orderAlbumImagesServicio;
	
	@Test
    public void testFindAllMediaVO() throws Exception{		
        
		boolean isOk = orderAlbumImagesServicio.orderAlbumImages();
		
        assertTrue(isOk);
    }

	
	

   

}
