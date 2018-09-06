/**
 * PlantillaMailBean.java
 */
package com.company.app.beans;

import java.io.Serializable;
import java.util.Map;

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
public class PlantillaMailBean implements Serializable {

    private static final long serialVersionUID = 7542622965387370998L;

    private String strTo;
    private String strFrom;
    private String strSubject;
    private String strUrlPlantilla;
    private String strListaEnlaces;
    
    private Map hmElementos;
    
    
    /**
     * @return the strTo
     */
    public String getStrTo() {
	return strTo;
    }

    /**
     * @param strTo
     *            the strTo to set
     */
    public void setStrTo(String strTo) {
	this.strTo = strTo;
    }

    /**
     * @return the strSubject
     */
    public String getStrSubject() {
	return strSubject;
    }

    /**
     * @param strSubject
     *            the strSubject to set
     */
    public void setStrSubject(String strSubject) {
	this.strSubject = strSubject;
    }

    /**
     * @return the strUrlPlantilla
     */
    public String getStrUrlPlantilla() {
	return strUrlPlantilla;
    }

    /**
     * @param strUrlPlantilla
     *            the strUrlPlantilla to set
     */
    public void setStrUrlPlantilla(String strUrlPlantilla) {
	this.strUrlPlantilla = strUrlPlantilla;
    }

    /**
     * @return the strFrom
     */
    public String getStrFrom() {
	return strFrom;
    }

    /**
     * @param strFrom
     *            the strFrom to set
     */
    public void setStrFrom(String strFrom) {
	this.strFrom = strFrom;
    }

    /**
     * @return the strListaEnlaces
     */
    public String getStrListaEnlaces() {
	return strListaEnlaces;
    }

    /**
     * @param strListaEnlaces
     *            the strListaEnlaces to set
     */
    public void setStrListaEnlaces(String strListaEnlaces) {
	this.strListaEnlaces = strListaEnlaces;
    }
    
    /**
     * @return the hmElementos
     */
    public Map getHmElementos() {
        return hmElementos;
    }

    /**
     * @param hmElementos the hmElementos to set
     */
    public void setHmElementos(Map hmElementos) {
        this.hmElementos = hmElementos;
    }

    
}