/**
 * UsuarioBean.java
 */
package com.company.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Nombre Clase: UsuarioBean</p>
 * <p>Descripcion</p>
 * <p>Metodos de la clase</p>
 * @author 
 * 
 * @d24/06/2008
 */
public class UsuarioVO implements Serializable{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3414992107792630595L;

	private String strUsuario;
	
	private String strTipo;
	
	private String strIdPadre;
	
	private String strTipoPadre;
	
	private String strDivision;	
	
	private String strClaseUsuario;
	
	private String strComercialInt;
	
	private String strComercialExt;
	
	private String strUsuarioWeb;
	
	private String strDescripUsu;
	
	private String strDescripUsuSuplantado;
	
	private String strUsuarioSuplantado;
	
	private String strPadreUsuarioSuplantado;
	
	private List lstAtribuciones;
	//Modificado para la PM_0154_2011
	private String strPoblacion;
	
	private String strEntidad;

	//Añadidas para el alta de usuarios
		private String strFechaAlta;
		
		private String strNombre;
		
		private String strNif;
		
		private String strPrimerApellido;
		
		private String strSegundoApellido;
		
	private String strMarcaAut;
	
	private String strTelContacto;
	
	private String strMail;
	
	private String strDireccion;
	
	private String strProvincia;
	
	private String strCodPostal;
	
	private String strRazonSocial;
	
	private String strActivado;
	
	private String strMarca;
	
	private String strLogoMarca;
	
	private String strIdioma;
	
	private String strColorCorporativo;
	

	public String getStrTelContacto() {
		return strTelContacto;
	}

	public void setStrTelContacto(String strTelContacto) {
		this.strTelContacto = strTelContacto;
	}

	public String getStrMail() {
		return strMail;
	}

	public void setStrMail(String strMail) {
		this.strMail = strMail;
	}

	public String getStrDireccion() {
		return strDireccion;
	}

	public void setStrDireccion(String strDireccion) {
		this.strDireccion = strDireccion;
	}

	public String getStrProvincia() {
		return strProvincia;
	}

	public void setStrProvincia(String strProvincia) {
		this.strProvincia = strProvincia;
	}

	public String getStrCodPostal() {
		return strCodPostal;
	}

	public void setStrCodPostal(String strCodPostal) {
		this.strCodPostal = strCodPostal;
	}

	public String getStrRazonSocial() {
		return strRazonSocial;
	}

	public void setStrRazonSocial(String strRazonSocial) {
		this.strRazonSocial = strRazonSocial;
	}

	public String getStrActivado() {
		return strActivado;
	}

	public void setStrActivado(String strActivado) {
		this.strActivado = strActivado;
	}

	/**
	 * @return the strMarca
	 */
	public String getStrMarca() {
		return strMarca;
	}

	/**
	 * @param strMarca the strMarca to set
	 */
	public void setStrMarca(String strMarca) {
		this.strMarca = strMarca;
	}

	/**
	 * @return the strEntidad
	 */
	public String getStrEntidad() {
		return strEntidad;
	}

	/**
	 * @param strEntidad the strEntidad to set
	 */
	public void setStrEntidad(String strEntidad) {
		this.strEntidad = strEntidad;
	}

	/**
	 * @return the strPoblacion
	 */
	public String getStrPoblacion() {
		return strPoblacion;
	}

	/**
	 * @param strPoblacion the strPoblacion to set
	 */
	public void setStrPoblacion(String strPoblacion) {
		this.strPoblacion = strPoblacion;
	}

	/**
	 * @return the strClaseUsuario
	 */
	public String getStrClaseUsuario() {
		return strClaseUsuario;
	}

	/**
	 * @param strClaseUsuario the strClaseUsuario to set
	 */
	public void setStrClaseUsuario(String strClaseUsuario) {
		this.strClaseUsuario = strClaseUsuario;
	}

	

	/**
	 * @return the strComercialExt
	 */
	public String getStrComercialExt() {
		return strComercialExt;
	}

	/**
	 * @param strComercialExt the strComercialExt to set
	 */
	public void setStrComercialExt(String strComercialExt) {
		this.strComercialExt = strComercialExt;
	}

	/**
	 * @return the strComercialInt
	 */
	public String getStrComercialInt() {
		return strComercialInt;
	}

	/**
	 * @param strComercialInt the strComercialInt to set
	 */
	public void setStrComercialInt(String strComercialInt) {
		this.strComercialInt = strComercialInt;
	}

	/**
	 * @return the strDivision
	 */
	public String getStrDivision() {
		return strDivision;
	}

	/**
	 * @param strDivision the strDivision to set
	 */
	public void setStrDivision(String strDivision) {
		this.strDivision = strDivision;
	}

	/**
	 * @return the strIdPadre
	 */
	public String getStrIdPadre() {
		return strIdPadre;
	}

	/**
	 * @param strIdPadre the strIdPadre to set
	 */
	public void setStrIdPadre(String strIdPadre) {
		this.strIdPadre = strIdPadre;
	}

	/**
	 * @return the strTipo
	 */
	public String getStrTipo() {
		return strTipo;
	}

	/**
	 * @param strTipo the strTipo to set
	 */
	public void setStrTipo(String strTipo) {
		this.strTipo = strTipo;
	}

	/**
	 * @return the strTipoPadre
	 */
	public String getStrTipoPadre() {
		return strTipoPadre;
	}

	/**
	 * @param strTipoPadre the strTipoPadre to set
	 */
	public void setStrTipoPadre(String strTipoPadre) {
		this.strTipoPadre = strTipoPadre;
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
	

	/**
	 * @return the strUsuarioWeb
	 */
	public String getStrUsuarioWeb() {
		return strUsuarioWeb;
	}

	/**
	 * @param strUsuarioWeb the strUsuarioWeb to set
	 */
	public void setStrUsuarioWeb(String strUsuarioWeb) {
		this.strUsuarioWeb = strUsuarioWeb;
	}
	
	public void reset(){
		
		this.setStrUsuario(null);
		this.setStrUsuarioWeb(null);
		this.setStrClaseUsuario(null);
		this.setStrComercialExt(null);
		this.setStrComercialInt(null);
		this.setStrDivision(null);
		this.setStrTipo(null);
		this.setStrTipoPadre(null);
		this.setStrIdPadre(null);
		this.setStrUsuarioSuplantado(null);
		this.setStrPadreUsuarioSuplantado(null);
		this.lstAtribuciones = new ArrayList();
		
	}

	/**
	 * @return the strUsuarioSuplantado
	 */
	public String getStrUsuarioSuplantado() {
		return strUsuarioSuplantado;
	}

	/**
	 * @param strUsuarioSuplantado the strUsuarioSuplantado to set
	 */
	public void setStrUsuarioSuplantado(String strUsuarioSuplantado) {
		this.strUsuarioSuplantado = strUsuarioSuplantado;
	}

	/**
	 * @return the strPadreUsuarioSuplantado
	 */
	public String getStrPadreUsuarioSuplantado() {
		return strPadreUsuarioSuplantado;
	}

	/**
	 * @param strPadreUsuarioSuplantado the strPadreUsuarioSuplantado to set
	 */
	public void setStrPadreUsuarioSuplantado(String strPadreUsuarioSuplantado) {
		this.strPadreUsuarioSuplantado = strPadreUsuarioSuplantado;
	}

	/**
	 * @return the lstAtribuciones
	 */
	public List getLstAtribuciones() {
		return lstAtribuciones;
	}

	/**
	 * @param lstAtribuciones the lstAtribuciones to set
	 */
	public void setLstAtribuciones(List lstAtribuciones) {
		this.lstAtribuciones = lstAtribuciones;
	}

	/**
	 * @return the strDescripUsu
	 */
	public String getStrDescripUsu() {
		return strDescripUsu;
	}

	/**
	 * @param strDescripUsu the strDescripUsu to set
	 */
	public void setStrDescripUsu(String strDescripUsu) {
		this.strDescripUsu = strDescripUsu;
	}

	/**
	 * @return the strDescripUsuSuplantado
	 */
	public String getStrDescripUsuSuplantado() {
		return strDescripUsuSuplantado;
	}
	
	

	public String getStrFechaAlta() {
		return strFechaAlta;
	}

	public void setStrFechaAlta(String strFechaAlta) {
		this.strFechaAlta = strFechaAlta;
	}

	public String getStrNombre() {
		return strNombre;
	}

	public void setStrNombre(String strNombre) {
		this.strNombre = strNombre;
	}

	public String getStrNif() {
		return strNif;
	}

	public void setStrNif(String strNif) {
		this.strNif = strNif;
	}

	public String getStrPrimerApellido() {
		return strPrimerApellido;
	}

	public void setStrPrimerApellido(String strPrimerApellido) {
		this.strPrimerApellido = strPrimerApellido;
	}

	public String getStrSegundoApellido() {
		return strSegundoApellido;
	}

	public void setStrSegundoApellido(String strSegundoApellido) {
		this.strSegundoApellido = strSegundoApellido;
	}

	/**
	 * @param strDescripUsuSuplantado the strDescripUsuSuplantado to set
	 */
	public void setStrDescripUsuSuplantado(String strDescripUsuSuplantado) {
		this.strDescripUsuSuplantado = strDescripUsuSuplantado;
	}

	public String getStrMarcaAut() {
		return strMarcaAut;
	}

	public void setStrMarcaAut(String strMarcaAut) {
		this.strMarcaAut = strMarcaAut;
	}

	/**
	 * @return the strLogoMarca
	 */
	public String getStrLogoMarca() {
		return strLogoMarca;
	}

	/**
	 * @param strLogoMarca the strLogoMarca to set
	 */
	public void setStrLogoMarca(String strLogoMarca) {
		this.strLogoMarca = strLogoMarca;
	}

	/**
	 * @return the strIdioma
	 */
	public String getStrIdioma() {
		return strIdioma;
	}

	/**
	 * @param strIdioma the strIdioma to set
	 */
	public void setStrIdioma(String strIdioma) {
		this.strIdioma = strIdioma;
	}

	/**
	 * @return the strColorCorporativo
	 */
	public String getStrColorCorporativo() {
		return strColorCorporativo;
	}

	/**
	 * @param strColorCorporativo the strColorCorporativo to set
	 */
	public void setStrColorCorporativo(String strColorCorporativo) {
		this.strColorCorporativo = strColorCorporativo;
	}
	
	
}
