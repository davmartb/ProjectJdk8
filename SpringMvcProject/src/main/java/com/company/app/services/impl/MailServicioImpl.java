/**
 * MailServicioImpl.java
 */
package com.company.app.services.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.URLDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.company.app.beans.ElementoHtmlBean;
import com.company.app.beans.PlantillaMailBean;
import com.company.app.commons.Utilidades;
import com.company.app.commons.constants.Constantes;
import com.company.app.commons.exceptions.ServicioException;
import com.company.app.services.inter.MailServicio;


/**
 * <p>Nombre Clase: UtilMAil</p>
 * <p>Descripcion</p>
 * <p>Metodos de la clase</p>
 * @author
 * 
 * @d02/03/2010
 */
@Service
public class MailServicioImpl implements MailServicio{
	
	
	protected static final Logger logger = Logger.getLogger(Thread.currentThread().getClass());
	
	private static final  String CONSTANTE_METHOD_ENVIAR_MAIL ="enviarMail";
	
	private static final  String CONSTANTE_MENSAJE_ENVIO_MAIL ="Envio de mail desde: ";
	
	private static final  String CONSTANTE_MENSAJE_TO =" Para: ";
	
	private static final  String CONSTANTE_MENSAJE_ASUNTO =" Asunto: ";
	
	private static final  String CONSTANTE_MENSAJE_FICHERO = "Fichero '";
	
	private static final  String CONSTANTE_MENSAJE_ADJUNTADO = "' adjuntado.";
	
	private static final  String CONSTANTE_KEY_ERROR_MAIL_ENVIO = "errors.mail.envio";
	
	private static final  String CONSTANTE_METHOD_ENVIAR_MAIL_HTML = "enviarMailHTML";
	
	@Autowired
	private JavaMailSenderImpl mailSender; 
	
	 private String from;   
	 
	 private boolean activo = true;   

	 private static final List lstFiles = null;
	
	 /**
		* <{@inheritDoc}
		*/
	 public boolean enviarMail(String strTo, String strSubject, String strText) throws ServicioException{			
			return enviarMail(lstFiles,  strTo, strSubject, strText, null);			
		}

	/**
	* <{@inheritDoc}
	*/
	public boolean enviarMail(List files, String strTo, String strSubject, String strText, String strFrom) throws ServicioException{
		boolean isOk = false;
	   
		StringBuffer stbMensaje = null;
		String[] strTos = null;				
		try {
			Utilidades.escribirLogInfo(logger, this.getClass().getName(), "enviarMail", "#I#To: "+strTo+" strFrom:"+strFrom+" strSubject:"+strSubject+" strText:"+((strText!=null)?strText.replaceAll("\n", " "):""));
			final MimeMessage message = mailSender.createMimeMessage();   
			if (strTo != null){
				strTos = strTo.split(Constantes.CONSTANTE_SIMBOLO_COMA);
			}
			 final MimeMessageHelper helper = new MimeMessageHelper(message, true);   
			 //Se inicializa el helper con los datos de envio del correo electronico
			 helper.setTo(strTos);   
	         helper.setSubject(strSubject);   
	         if (strFrom != null && strFrom.trim().length()>0){
	        	 helper.setFrom(strFrom);
	         } else {
	        	 helper.setFrom(this.getFrom());
	         }
	           
	         helper.setText(strText);  
	         if (logger.isDebugEnabled()) {   
             	stbMensaje = new StringBuffer();
             	stbMensaje.append(Constantes.CONSTANTE_CLASE);
     			stbMensaje.append(this.getClass().getName());
     			stbMensaje.append(Constantes.CONSTANTE_METODO);
     			stbMensaje.append(CONSTANTE_METHOD_ENVIAR_MAIL);
     			stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
     			stbMensaje.append(CONSTANTE_MENSAJE_ENVIO_MAIL);
     			stbMensaje.append(this.getFrom());
     			stbMensaje.append(CONSTANTE_MENSAJE_TO);
     			stbMensaje.append(strTo);
     			stbMensaje.append(CONSTANTE_MENSAJE_ASUNTO);
     			stbMensaje.append(strSubject);     
     			logger.debug(stbMensaje.toString());  
     		}
	         
	         if (logger.isDebugEnabled()) {   
             	stbMensaje = new StringBuffer();
             	stbMensaje.append(Constantes.CONSTANTE_CLASE);
     			stbMensaje.append(this.getClass().getName());
     			stbMensaje.append(Constantes.CONSTANTE_METODO);
     			stbMensaje.append(CONSTANTE_METHOD_ENVIAR_MAIL);
     			stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
     			stbMensaje.append("Se empieza a adjuntar los ficheros");     			     			
     			logger.debug(stbMensaje.toString());  
             }   
	         // adjuntando los ficheros   
	            if (files != null) {   
	                for (int i = 0; i < files.size(); i++) {   
	                    FileSystemResource file = new FileSystemResource((File)files.get(i));   
	                    helper.addAttachment(((File)files.get(i)).getName(), file);   
	                    if (logger.isDebugEnabled()) {   
	                    	stbMensaje = new StringBuffer();
	                    	stbMensaje.append(Constantes.CONSTANTE_CLASE);
	            			stbMensaje.append(this.getClass().getName());
	            			stbMensaje.append(Constantes.CONSTANTE_METODO);
	            			stbMensaje.append(CONSTANTE_METHOD_ENVIAR_MAIL);
	            			stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
	            			stbMensaje.append(CONSTANTE_MENSAJE_FICHERO);
	            			stbMensaje.append(file);
	            			stbMensaje.append(CONSTANTE_MENSAJE_ADJUNTADO);
	            			logger.debug(stbMensaje.toString());  
	                    }   
	                }   
	            }   

	            Utilidades.escribirLogInfo(logger, this.getClass().getName(), "enviarMail", "#I#To: "+strTo+" strFrom:"+((strFrom!=null && strFrom.length()>0)?strFrom:this.getFrom())+" strSubject:"+strSubject+" strText:"+((strText!=null)?strText.replaceAll("\n", " "):""));
	         this.getMailSender().send(message);
//		 Send message
				
		isOk = true;
		Utilidades.escribirLogInfo(logger, this.getClass().getName(), "enviarMail", "#O#To: "+strTo+" strFrom:"+strFrom);
		} catch (MessagingException e) {	
			stbMensaje = new StringBuffer();						
			stbMensaje.append(Constantes.CONSTANTE_CLASE);
			stbMensaje.append(this.getClass().getName());
			stbMensaje.append(Constantes.CONSTANTE_METODO);
			stbMensaje.append(CONSTANTE_METHOD_ENVIAR_MAIL);
			stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
			stbMensaje.append(e.getMessage());			
			logger.error(stbMensaje.toString());
			throw new ServicioException(this.getClass().getName(), CONSTANTE_METHOD_ENVIAR_MAIL, CONSTANTE_KEY_ERROR_MAIL_ENVIO,1);			 
		} catch (Exception e) {			
			stbMensaje = new StringBuffer();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			
			stbMensaje.append(Constantes.CONSTANTE_CLASE);
			stbMensaje.append(this.getClass().getName());
			stbMensaje.append(Constantes.CONSTANTE_METODO);
			stbMensaje.append(CONSTANTE_METHOD_ENVIAR_MAIL);
			stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
			stbMensaje.append(e.getMessage());
			stbMensaje.append(Constantes.CONSTANTE_STACKTRACE);
			stbMensaje.append(sw.toString());
			logger.error(stbMensaje.toString());
			throw new ServicioException(this.getClass().getName(), CONSTANTE_METHOD_ENVIAR_MAIL, Constantes.CONSTANTE_KEY_ERROR_GENERAL,1);
		}
		return isOk;
	}
	
	
		
	/**
	 * <{@inheritDoc}
	 */
	public boolean enviarMail(URL url, String strTitulo,String strTo, String strSubject, String strText) throws ServicioException{
		boolean isOk = false;
		final MimeMessage message = mailSender.createMimeMessage();   
		StringBuffer stbMensaje = null;
		String[] strTos = null;		
		try {
			if (strTo != null){
				strTos = strTo.split(Constantes.CONSTANTE_SIMBOLO_COMA);
			}
			 final MimeMessageHelper helper = new MimeMessageHelper(message, true);   
			 //Se inicializa el helper con los datos de envio del correo electronico
			 helper.setTo(strTos);   
	         helper.setSubject(strSubject);   
	         helper.setFrom(this.getFrom());   
	         helper.setText(strText);  
	         
	         if (logger.isDebugEnabled()) {   
	             	stbMensaje = new StringBuffer();
	             	stbMensaje.append(Constantes.CONSTANTE_CLASE);
	     			stbMensaje.append(this.getClass().getName());
	     			stbMensaje.append(Constantes.CONSTANTE_METODO);
	     			stbMensaje.append(CONSTANTE_METHOD_ENVIAR_MAIL);
	     			stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
	     			stbMensaje.append(CONSTANTE_MENSAJE_ENVIO_MAIL);
	     			stbMensaje.append(this.getFrom());
	     			stbMensaje.append(CONSTANTE_MENSAJE_TO);
	     			stbMensaje.append(strTo);
	     			stbMensaje.append(CONSTANTE_MENSAJE_ASUNTO);
	     			stbMensaje.append(strSubject);     
	     			logger.debug(stbMensaje.toString());  
	     		}
	         
	         //Create the message part 
	         BodyPart messageBodyPart = new MimeBodyPart();
	         //Fill the message
	         messageBodyPart.setText(strTitulo);

	         Multipart multipart = new MimeMultipart();
	         multipart.addBodyPart(messageBodyPart);

	         //		 Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         
		
	         URLDataSource source = new URLDataSource(url);		
	         
	         if (logger.isDebugEnabled()) {   
             	stbMensaje = new StringBuffer();
             	stbMensaje.append(Constantes.CONSTANTE_CLASE);
     			stbMensaje.append(this.getClass().getName());
     			stbMensaje.append(Constantes.CONSTANTE_METODO);
     			stbMensaje.append(CONSTANTE_METHOD_ENVIAR_MAIL);
     			stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
     			stbMensaje.append(CONSTANTE_MENSAJE_FICHERO);
     			stbMensaje.append(url);
     			stbMensaje.append(CONSTANTE_MENSAJE_ADJUNTADO);
     			logger.debug(stbMensaje.toString());  
             }   
	         
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         		
	         messageBodyPart.setFileName(strTitulo);
		
	         multipart.addBodyPart(messageBodyPart);

	         //		 Put parts in message
	         message.setContent(multipart);

	         this.getMailSender().send(message);
//		 Send message
				
		isOk = true;
		} catch (MessagingException e) {			
			stbMensaje = new StringBuffer();						
			stbMensaje.append(Constantes.CONSTANTE_CLASE);
			stbMensaje.append(this.getClass().getName());
			stbMensaje.append(Constantes.CONSTANTE_METODO);
			stbMensaje.append(CONSTANTE_METHOD_ENVIAR_MAIL);
			stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
			stbMensaje.append(CONSTANTE_KEY_ERROR_MAIL_ENVIO);			
			logger.error(stbMensaje.toString());
			throw new ServicioException(this.getClass().getName(), CONSTANTE_METHOD_ENVIAR_MAIL, CONSTANTE_KEY_ERROR_MAIL_ENVIO,1);
		} catch (Exception e) {
			stbMensaje = new StringBuffer();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			
			stbMensaje.append(Constantes.CONSTANTE_CLASE);
			stbMensaje.append(this.getClass().getName());
			stbMensaje.append(Constantes.CONSTANTE_METODO);
			stbMensaje.append(CONSTANTE_METHOD_ENVIAR_MAIL);
			stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
			stbMensaje.append(e.getMessage());
			stbMensaje.append(Constantes.CONSTANTE_STACKTRACE);
			stbMensaje.append(sw.toString());
			logger.error(stbMensaje.toString());
			throw new ServicioException(this.getClass().getName(), CONSTANTE_METHOD_ENVIAR_MAIL, Constantes.CONSTANTE_KEY_ERROR_GENERAL,1);
		}
		return isOk;
	}
	
    /**
     * <{@inheritDoc}
     */
    public boolean enviarMailHTML(PlantillaMailBean plantillaMailBean) throws ServicioException {
	boolean isOk = false;
	final MimeMessage message = mailSender.createMimeMessage();
	String[] strTos = null;
	String strTo = null;
	InputStream in = null;
	BufferedReader bufferedReader = null;

	StringBuffer msjHTML = null;
	InputStream is = null;
	ByteArrayResource byteArrayResource = null;
	Map hmSlementos = null;
	ElementoHtmlBean elementoHtmlBean = null;
	String strFrom = null;
	try {
	    if (plantillaMailBean.getStrTo() != null) {
		strTos = plantillaMailBean.getStrTo().split(Constantes.CONSTANTE_SIMBOLO_COMA);
		strTo  = plantillaMailBean.getStrTo();
	    }
	   
	    final MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    // Se inicializa el helper con los datos de envio del correo electronico
	    helper.setTo(strTos);
	    helper.setSubject(plantillaMailBean.getStrSubject());
	    if (plantillaMailBean.getStrFrom() != null && plantillaMailBean.getStrFrom().trim().length() > 0) {
		helper.setFrom(plantillaMailBean.getStrFrom());
		strFrom = plantillaMailBean.getStrFrom();
	    } else {
		helper.setFrom(this.getFrom());
		strFrom = this.getFrom();
	    }
	    Utilidades.escribirLogInfo(logger, this.getClass().getName(), "enviarMailHTML", "#I#To: "+strTo+" strFrom:"+strFrom+" strSubjet: "+plantillaMailBean.getStrSubject());
	    
	    // Cargamos la plantilla HTML
	    // Ejemplo de url: "WSBSFincom/resources/html/plantillaMail.html"
	    in = Utilidades.class.getClassLoader().getResourceAsStream(plantillaMailBean.getStrUrlPlantilla());
	    if (in != null) {
		bufferedReader = new BufferedReader(new InputStreamReader(in));

		// Almacenar el contenido de la plantilla en un StringBuffer
		String strLine;
		msjHTML = new StringBuffer();
		hmSlementos = plantillaMailBean.getHmElementos();
		while ((strLine = bufferedReader.readLine()) != null) {

		    for (Iterator iterator = hmSlementos.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			if (strLine.indexOf(key) >= 0) {
			    elementoHtmlBean = (ElementoHtmlBean) hmSlementos.get(key);
			    if (!"image/jpeg".equals(elementoHtmlBean.getStrTipo())){
			    	strLine = strLine.replaceAll(key, elementoHtmlBean.getStrValor());
			    }
			}
		    }

		    msjHTML.append(strLine);
		}
		// Convertimos el stringbuffer a string para el helper
		// True = formato html
		helper.setText(msjHTML.toString(), true);

		for (Iterator iterator = hmSlementos.keySet().iterator(); iterator.hasNext();) {
		    String key = (String) iterator.next();

		    elementoHtmlBean = (ElementoHtmlBean) hmSlementos.get(key);
		    if ("image/jpeg".equals(elementoHtmlBean.getStrTipo())) {
				is = Utilidades.class.getClassLoader().getResourceAsStream(elementoHtmlBean.getStrRuta());
				if (is != null) {
				    byteArrayResource = new ByteArrayResource(IOUtils.toByteArray(is));
				    if (byteArrayResource != null) {
					helper.addInline(key, byteArrayResource, elementoHtmlBean.getStrTipo());
				    }
				} else {
				    Utilidades.escribirLogDistException(logger, this.getClass().getName(), CONSTANTE_METHOD_ENVIAR_MAIL_HTML,
					    "No encontrado recurso: "+elementoHtmlBean.getStrRuta());
	
				}
		    }

		}

	    } else {
		Utilidades.escribirLogDistException(logger, this.getClass().getName(), CONSTANTE_METHOD_ENVIAR_MAIL_HTML,
			"No encontrado recurso: " + plantillaMailBean.getStrUrlPlantilla());
		helper.setText("No encontrado recurso: " + plantillaMailBean.getStrUrlPlantilla());
	    }

	    if (logger.isDebugEnabled()) {
		Utilidades.escribirLogDebug(logger, this.getClass().getName(), CONSTANTE_METHOD_ENVIAR_MAIL_HTML,
			CONSTANTE_MENSAJE_ENVIO_MAIL + this.getFrom() + CONSTANTE_MENSAJE_TO + plantillaMailBean.getStrTo()
				+ CONSTANTE_MENSAJE_ASUNTO + plantillaMailBean.getStrSubject());
	    }

	    this.getMailSender().send(message);
	    // Send message

	    isOk = true;
	    Utilidades.escribirLogInfo(logger, this.getClass().getName(), "enviarMailHTML", "#O#To: "+strTo+" strFrom:"+strFrom+" strSubjet: "+plantillaMailBean.getStrSubject());
	} catch (MessagingException e) {
	    Utilidades.escribirLogDistException(e, logger, this.getClass().getName(), CONSTANTE_METHOD_ENVIAR_MAIL_HTML);

	} catch (Exception e) {
	    Utilidades.escribirLogException(e, logger, this.getClass().getName(), CONSTANTE_METHOD_ENVIAR_MAIL_HTML);

	}
	return isOk;
    }
	
	
	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the mailSender
	 */
	public JavaMailSenderImpl getMailSender() {
		return mailSender;
	}

	/**
	 * @param mailSender the mailSender to set
	 */
	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}
}
