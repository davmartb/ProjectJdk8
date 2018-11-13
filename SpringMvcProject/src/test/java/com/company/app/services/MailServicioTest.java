/**
 * MailServicioTest.java
 */
package com.company.app.services;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.company.app.SpringEnableTest;
import com.company.app.services.inter.MailServicio;

/**
 * <p>Nombre Clase: MailServicioTest</p>
 * <p>Descripcion</p>
 * <p>Metodos de la clase</p>
 * @author 
 * 
 * @d10/05/2010
 */
  
public class MailServicioTest extends TestCase  {
	
	/**
	 * Logger usado para los mensajes.
	 */
	protected static final Logger logger = Logger.getLogger(MailServicioTest.class);
	private MailServicio mailServicio = null;
	
	public MailServicioTest(String nombre) throws Exception 
	{
		super(nombre);
	}
	protected void setUp() throws Exception{
		mailServicio = (MailServicio)SpringEnableTest.getApplicationContext().getBean("servicio.MailServicio");
	}

	protected void tearDown() throws Exception {
		mailServicio = null;
	}

	protected static void main(String[] args) 
	{
		logger.info("Lanzando Test....");
		junit.textui.TestRunner.run(MailServicioTest.class);

	}
	
	public void testEnviarMail() throws Exception {
		String strTo = "davmartb@gmail.com";
		String strSubject = "Prueba de correo.";
		String strText = "Esto es una prueba de correo";
		assertTrue(mailServicio.enviarMail(strTo, strSubject, strText));
		
	}
	
	

   

}
