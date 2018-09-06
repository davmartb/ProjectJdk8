/**
 * UtilMAil.java
 */
package com.company.app.services.inter;

import java.net.URL;
import java.util.List;

import com.company.app.beans.PlantillaMailBean;
import com.company.app.commons.exceptions.ServicioException;


/**
 * <p>Nombre Clase: MailServicio</p>
 * <p>Descripcion</p>
 * <p>Metodos de la clase</p>
 * @author 
 * 
 * @d02/03/2010
 */
public interface MailServicio {

	
	/**
	 * Metodo para envio de emial.
	 * @param strTitulo - Titulo del fichero que se adjunta
	 * @param strTo - Dirección de correo a quien se le va a enviar
	 * @param strSubject - Asunto que se adjunta en el email
	 * @param strText - Texto que va en el cuerpo del correo.
	 * @return boolean Indicando si es correcto la adjuntación.
	 * @throws ServicioException
	 */
	public boolean enviarMail(String strTo, String strSubject, String strText)throws ServicioException;
	
	
	/**
	 * Metodo para envio de emial, permite adjunta una lista de ficheros
	 * @param files - Lista de ficheros que se adjuntan
	 * @param strTitulo - Titulo del fichero que se adjunta
	 * @param strTo - Dirección de correo a quien se le va a enviar
	 * @param strSubject - Asunto que se adjunta en el email
	 * @param strText - Texto que va en el cuerpo del correo.
	 * @param strFrom - Dirección de correo desde la que se envia.
	 * @return boolean Indicando si es correcto la adjuntación.
	 * @throws ServicioException
	 */
	public boolean enviarMail(List files, String strTo, String strSubject, String strText,String strFrom) throws ServicioException;
	
	/**
	 * Metodo para envio de emial, permite adjunta un fichero desde una URL
	 * @param url - Url del fichero que se adjunta
	 * @param strTitulo - Titulo del fichero que se adjunta
	 * @param strTo - Dirección de correo a quien se le va a enviar
	 * @param strSubject - Asunto que se adjunta en el email
	 * @param strText - Texto que va en el cuerpo del correo.
	 * @return boolean Indicando si es correcto la adjuntación.
	 * @throws ServicioException
	 */
	public boolean enviarMail(URL url, String strTitulo,String strTo, String strSubject, String strText) throws ServicioException;
	
		
	/**
	 * Metodo para envio de emial, permite adjunta un fichero desde una URL
	 * @param strTo - Dirección de correo a quien se le va a enviar
	 * @param strSubject - Asunto que se adjunta en el email
	 * @param strUrlPlantilla - Ruta de la plantilla HTML a utilizar, ejemplo: WSBSFincom/resources/html/plantillaMail.html
	 * @param strFrom - Dirección de correo desde la que se envía.
	 * @throws ServicioException
	 */
	
	public boolean enviarMailHTML(PlantillaMailBean plantillaMailBean) throws ServicioException;
}
