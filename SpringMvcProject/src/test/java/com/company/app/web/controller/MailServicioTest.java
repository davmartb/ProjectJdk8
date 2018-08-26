/**
 * MailServicioTest.java
 */
package com.company.app.web.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.gea.bsfincom.general.constantes.ConstantesPresentacion;
import com.gea.bsfincom.servicio.interfaz.MailServicio;

/**
 * <p>Nombre Clase: MailServicioTest</p>
 * <p>Descripcion</p>
 * <p>Metodos de la clase</p>
 * @author A161496 - ATOS Origin
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
		String strTo = "david.martinbarrantes@dominio.com";
		String strSubject = "Prueba de correo.";
		String strText = "Esto es una prueba de correo";
		assertTrue(mailServicio.enviarMail(strTo, strSubject, strText));
		
	}
	
	public void testEnviarMailUrl() throws Exception {
		String strTitulo = null;
		
		String strTo = "david.martinbarrantes@dominio.com";
		String strSubject = "Prueba de correo.";
		String strText = "Esto es una prueba de correo";
		
		Date tmpFechaHoy = new Date();
		SimpleDateFormat tmpFormato = new SimpleDateFormat(ConstantesPresentacion.CONSTANTE_FORMATO_FECHA_HOST);
		String CadenaFecha = tmpFormato.format(tmpFechaHoy);
		strTitulo = "Contrato_201002000003108_"+CadenaFecha+".pdf";
		
		URL url = new URL("http://172.24.30.237:8080/BSFincom/preImprimirContrato.do?NumeroOperacion=201002000003108&PROFIN=2020");
		assertTrue(mailServicio.enviarMail(url, strTitulo, strTo, strSubject, strText));
		
	}

}
