/**
 * <p>
 * Nombre Clase: GeneralException
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



public class GeneralException extends Exception{
	

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8324044112819050979L;

	private String strMensaje="";
	
	private String strNombreClase;
	
	private String strNombreMetodo;
	/**
	 * Nivel de la excepcion
	 * 	1 - Excepciones inexperadas, EJ. NullPointerException
	 *  2 - Excepciones de conexion
	 *  3 - Excepciones por no haber datos.
	 *  4 - Excepciones de construccion de bean, inicializaciones...
	 */
	private int intNivel;
	
	/**	 
	 * @param strNombreClase
	 * @param strNombreMetodo
	 * @param strMensaje
	 * @param intNivel
	 */
	public GeneralException(String strNombreClase, String strNombreMetodo, String strMensaje, int intNivel) {
		super();
		this.setIntNivel(intNivel);
		this.setStrMensaje(strMensaje);
		this.setStrNombreClase(strNombreClase);
		this.setStrNombreMetodo(strNombreMetodo);
	}

	/**	 
	 * @param strNombreClase
	 * @param strNombreMetodo
	 * @param strMensaje
	 * @param intNivel
	 */
	public GeneralException(String strNombreMetodo, String strMensaje, int intNivel) {
		super();
		this.setIntNivel(intNivel);
		this.setStrMensaje(strMensaje);
		this.setStrNombreClase(this.getClass().getName());
		this.setStrNombreMetodo(strNombreMetodo);
	}

	/**
	 * @param strMensaje
	 * @param nombreClase
	 * @param strNombreMetodo
	 */
	public GeneralException(String strNombreClase, String strNombreMetodo, String strMensaje) {
		super();
		this.strMensaje = strMensaje;
		this.strNombreClase = strNombreClase;
		this.strNombreMetodo = strNombreMetodo;	
		this.setIntNivel(0);
	}
	
	/**
	 * @param strMensaje Mensaje
	 */
	public GeneralException(String strMensaje){
		super(strMensaje);

	}
	
	/**
	 * @param etiqueta Etiqueta identificativa de la excepción
	 * @param message Mensaje
	 */
	public GeneralException(String strEtiqueta, String strMensaje){		
		super(strMensaje);

		this.setStrMensaje(strEtiqueta);
	}
	
	/**
	 * @return the intNivel
	 */
	public int getIntNivel() {
		return intNivel;
	}

	/**
	 * @param nivel the intNivel to set
	 */
	public void setIntNivel(int nivel) {
		intNivel = nivel;
	}

	/**
	 * @param strMensaje the strMensaje to set
	 */
	public void setStrMensaje(String strMensaje) {
		this.strMensaje = strMensaje;
	}

	
	
	/**
	 * @return the strNombreClase
	 */
	public String getStrNombreClase() {
		return strNombreClase;
	}

	/**
	 * @param nombreClase the strNombreClase to set
	 */
	public void setStrNombreClase(String nombreClase) {
		strNombreClase = nombreClase;
	}

	/**
	 * @return the strNombreMetodo
	 */
	public String getStrNombreMetodo() {
		return strNombreMetodo;
	}

	/**
	 * @param nombreMetodo the strNombreMetodo to set
	 */
	public void setStrNombreMetodo(String nombreMetodo) {
		strNombreMetodo = nombreMetodo;
	}
	
	/**
	 * @return Devuelve el strMensaje producido
	 */
	public String getStrMensaje(){
		return this.strMensaje;
	}
}