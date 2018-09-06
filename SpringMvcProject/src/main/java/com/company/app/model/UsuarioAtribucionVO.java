/**
 * UsuarioAtribucionVO.java
 */
package com.company.app.model;

import java.io.Serializable;

/**
 * <p>
 * Nombre Clase: UsuarioAtribucionVO
 * </p>
 * <p>
 * Descripcion
 * </p>
 * <p>
 * Metodos de la clase
 * </p>
 * 
 * @author 
 * 
 * @d24/09/2008
 */
public class UsuarioAtribucionVO implements Serializable {
	private static final long serialVersionUID = -2999283330492479793L;

	private String strUsuario;

	private String strAtribucion;

	private String strUrl;
		
	
	private String strDesAtribucion;

	

	public String getStrDesAtribucion() {
		return strDesAtribucion;
	}

	public void setStrDesAtribucion(String strDesAtribucion) {
		this.strDesAtribucion = strDesAtribucion;
	}

	/**
	 * @return the strUrl
	 */
	public String getStrUrl() {
		return strUrl;
	}

	/**
	 * @param strUrl the strUrl to set
	 */
	public void setStrUrl(String strUrl) {
		this.strUrl = strUrl;
	}
	/**
	 * @return the strAtribucion
	 */
	public String getStrAtribucion() {
		return strAtribucion;
	}

	/**
	 * @param strAtribucion the strAtribucion to set
	 */
	public void setStrAtribucion(String strAtribucion) {
		this.strAtribucion = strAtribucion;
	}

	/**
	 * @return the strUsuario
	 */
	public String getStrUsuario() {
		return strUsuario;
	}

	/**
	 * @param strUsuario the strUsuario to set
	 */
	public void setStrUsuario(String strUsuario) {
		this.strUsuario = strUsuario;
	}



}
