/**
 * PlantillaMailBean.java
 */
package com.company.app.beans;

import java.io.Serializable;

/**
 * <p>
 * Nombre Clase: PlantillaMailBean
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
 * @24/07/2013
 */
public class ElementoHtmlBean implements Serializable {

    private static final long serialVersionUID = 7542622965387370998L;

    private String strRuta;
    private String strTipo;
    private String strValor;

    /**
     * @return the strRuta
     */
    public String getStrRuta() {
	return strRuta;
    }

    /**
     * @param strRuta
     *            the strRuta to set
     */
    public void setStrRuta(String strRuta) {
	this.strRuta = strRuta;
    }

    /**
     * @return the strTipo
     */
    public String getStrTipo() {
	return strTipo;
    }

    /**
     * @param strTipo
     *            the strTipo to set
     */
    public void setStrTipo(String strTipo) {
	this.strTipo = strTipo;
    }

    /**
     * @return the strValor
     */
    public String getStrValor() {
	return strValor;
    }

    /**
     * @param strValor
     *            the strValor to set
     */
    public void setStrValor(String strValor) {
	this.strValor = strValor;
    }

}