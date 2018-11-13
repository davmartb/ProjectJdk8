/**
 * UtilMAil.java
 */
package com.company.app.services.inter;

import com.company.app.commons.exceptions.ServicioException;


/**
 * <p>Nombre Clase: MailServicio</p>
 * <p>Descripcion</p>
 * <p>Metodos de la clase</p>
 * @author 
 * 
 * @d02/03/2010
 */
public interface OrderAlbumImagesServicio {

	
	/**
	 * Metodo para envio de emial.
	 * @param strTitulo - Titulo del fichero que se adjunta
	 * @param strTo - Dirección de correo a quien se le va a enviar
	 * @param strSubject - Asunto que se adjunta en el email
	 * @param strText - Texto que va en el cuerpo del correo.
	 * @return boolean Indicando si es correcto la adjuntación.
	 * @throws ServicioException
	 */
	public boolean orderAlbumImages() throws ServicioException;
	
	
}
