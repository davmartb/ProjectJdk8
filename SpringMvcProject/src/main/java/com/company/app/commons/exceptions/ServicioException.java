/**
 * <p>
 * Nombre Clase: ServicioException
 * </p>
 * <p>
 * Descripcion
 * </p>
 * <p>
 * Metodos de la clase
 * </p>
 * 
 * @author A161496 - ATOS Origin
 * 
 * @d08/07/2008
 */
package com.company.app.commons.exceptions;


public class ServicioException extends GeneralException{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -314825159444037076L;


	/**
	 * @param strNombreClase
	 * @param strNombreMetodo
	 * @param strMensaje
	 * @param intNivel
	 */
	public ServicioException(String strNombreClase, String strNombreMetodo, String strMensaje,int intNivel) {
		super(ServicioException.class.getName(), strNombreMetodo, strMensaje, intNivel);
	 
	}

	/**
	 * @param strNombreClase
	 * @param strNombreMetodo
	 */
	public ServicioException(String strNombreClase, String strNombreMetodo) {
		super(ServicioException.class.getName(), strNombreClase, strNombreMetodo);
	
	}

	/**
	 * @param strMensaje Mensaje 
	 */
	public ServicioException(String strMessage){
		super(ServicioException.class.getName(), strMessage);
	
	}

	/**
	 * @param strNombreClase
	 * @param strNombreMetodo
	 * @param intNivel
	 */
	public ServicioException(String strNombreClase, String strNombreMetodo, int intNivel) {
		super(ServicioException.class.getName(), strNombreClase, strNombreMetodo, intNivel);
		
	}
	
	
}