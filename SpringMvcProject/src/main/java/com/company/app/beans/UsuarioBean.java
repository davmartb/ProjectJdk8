/**
 * UsuarioBean.java
 */
package com.company.app.beans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.company.app.commons.Utilidades;
import com.company.app.model.UsuarioAtribucionVO;

/**
 * <p>
 * Nombre Clase: UsuarioBean
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
 * @d24/06/2008
 */
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2576820900296854550L;

	private String strIdSession;

	private String strUsuario;

	private String strLenguaje;

	private String strTipo;

	private String strIdPadre;

	private String strTipoPadre;

	private String strDivision;

	private String strClaseUsuario;

	private String strComercialExt;

	private String strComercialInt;

	private String strUsuarioWeb;

	private String strUsuarioHost;

	private String strUsuarioSuplantado;

	private String strPadreUsuarioSuplantado;

	private String strDescripUsu;

	private String strDescripUsuSuplantado;

	private String strUsuarioReal;

	private List lstAtribuciones;

	private boolean bolTieneAtribucion;

	// Migracion

	private String strFecExp;

	private String strFecCaducidad;

	private String strFecBloqueo;

	private String strTipoAcceso;

	private String strEstado;

	private String strNumIntentos;

	private String strCambiarPassword;

	private String strAceptoCondiciones;

	private String strNif;

	private String strIdiomaJsp;

	private String strIdiomaSelectJsp;

	private boolean bolPrimeraVez;

	private String lastConnection;

	private boolean userMig;

	private String strOperativa;

	private String strUrlCurso;

	private List lstComunicados;

	public String getStrUrlCurso() {
		return strUrlCurso;
	}

	public void setStrUrlCurso(String strUrlCurso) {
		this.strUrlCurso = strUrlCurso;
	}

	public String getStrOperativa() {
		return strOperativa;
	}

	public void setStrOperativa(String strOperativa) {
		this.strOperativa = strOperativa;
	}

	public boolean isUserMig() {
		return userMig;
	}

	public void setUserMig(boolean userMig) {
		this.userMig = userMig;
	}

	public boolean isBolPrimeraVez() {
		return bolPrimeraVez;
	}

	public void setBolPrimeraVez(boolean bolPrimeraVez) {
		this.bolPrimeraVez = bolPrimeraVez;
	}

	/**
	 * @return the strIdiomaSelectJsp
	 */
	public String getStrIdiomaSelectJsp() {
		String strIdioma = null;
		strIdioma = Utilidades.obtenerIdioma(this.strLenguaje);
		if (Utilidades.CONSTANTE_IDIOMA_CASTELLANO.equals(strIdioma)) {
			strIdiomaSelectJsp = Utilidades.CONSTANTE_IDIOMA_CASTELLANO_3;
		} else if (Utilidades.CONSTANTE_IDIOMA_CATALAN.equals(strIdioma)) {
			strIdiomaSelectJsp = Utilidades.CONSTANTE_IDIOMA_CATALAN_3;
		} else if (Utilidades.CONSTANTE_IDIOMA_INGLES.equals(strIdioma)) {
			strIdiomaSelectJsp = Utilidades.CONSTANTE_IDIOMA_INGLES_3;
		} else {
			strIdiomaSelectJsp = Utilidades.CONSTANTE_IDIOMA_CASTELLANO_3;
		}

		return strIdiomaSelectJsp;
	}

	/**
	 * @param strIdiomaSelectJsp
	 *            the strIdiomaSelectJsp to set
	 */
	public void setStrIdiomaSelectJsp(String strIdiomaSelectJsp) {
		this.strIdiomaSelectJsp = strIdiomaSelectJsp;
	}

	/**
	 * @return the strIdiomaJsp
	 */
	public String getStrIdiomaJsp() {

		String strIdioma = null;
		strIdioma = Utilidades.obtenerIdioma(this.strLenguaje);
		if (Utilidades.CONSTANTE_IDIOMA_CASTELLANO.equals(strIdioma)) {
			strIdiomaJsp = Utilidades.CONSTANTE_IDIOMA_CASTELLANO_JSP;
		} else if (Utilidades.CONSTANTE_IDIOMA_CATALAN.equals(strIdioma)) {
			strIdiomaJsp = Utilidades.CONSTANTE_IDIOMA_CATALAN_JSP;
		} else if (Utilidades.CONSTANTE_IDIOMA_INGLES.equals(strIdioma)) {
			strIdiomaJsp = Utilidades.CONSTANTE_IDIOMA_INGLES_JSP;
		} else {
			strIdiomaJsp = Utilidades.CONSTANTE_IDIOMA_CASTELLANO_JSP;
		}

		return strIdiomaJsp;
	}

	/**
	 * @param strIdiomaJsp
	 *            the strIdiomaJsp to set
	 */
	public void setStrIdiomaJsp(String strIdiomaJsp) {
		this.strIdiomaJsp = strIdiomaJsp;
	}

	/**
	 * @return the lastConnection
	 */
	public String getLastConnection() {
		return lastConnection;
	}

	/**
	 * @param lastConnection
	 *            the lastConnection to set
	 */
	public void setLastConnection(String lastConnection) {
		this.lastConnection = lastConnection;
	}

	public String getStrNif() {
		return strNif;
	}

	public void setStrNif(String strNif) {
		this.strNif = strNif;
	}

	public String getStrCambiarPassword() {
		return strCambiarPassword;
	}

	public void setStrCambiarPassword(String strCambiarPassword) {
		this.strCambiarPassword = strCambiarPassword;
	}

	public String getStrAceptoCondiciones() {
		return strAceptoCondiciones;
	}

	public void setStrAceptoCondiciones(String strAceptoCondiciones) {
		this.strAceptoCondiciones = strAceptoCondiciones;
	}

	public String getStrFecExp() {
		return strFecExp;
	}

	public void setStrFecExp(String strFecExp) {
		this.strFecExp = strFecExp;
	}

	public String getStrFecCaducidad() {
		return strFecCaducidad;
	}

	public void setStrFecCaducidad(String strFecCaducidad) {
		this.strFecCaducidad = strFecCaducidad;
	}

	public String getStrFecBloqueo() {
		return strFecBloqueo;
	}

	public void setStrFecBloqueo(String strFecBloqueo) {
		this.strFecBloqueo = strFecBloqueo;
	}

	public String getStrTipoAcceso() {
		return strTipoAcceso;
	}

	public void setStrTipoAcceso(String strTipoAcceso) {
		this.strTipoAcceso = strTipoAcceso;
	}

	public String getStrEstado() {
		return strEstado;
	}

	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}

	public String getStrNumIntentos() {
		return strNumIntentos;
	}

	public void setStrNumIntentos(String strNumIntentos) {
		this.strNumIntentos = strNumIntentos;
	}

	public boolean isBolTieneAtribucion() {
		return bolTieneAtribucion;
	}

	/**
	 * @return the strUsuarioSuplantado
	 */
	public String getStrUsuarioSuplantado() {
		return strUsuarioSuplantado;
	}

	/**
	 * @param strUsuarioSuplantado
	 *            the strUsuarioSuplantado to set
	 */
	public void setStrUsuarioSuplantado(String strUsuarioSuplantado) {
		this.strUsuarioSuplantado = strUsuarioSuplantado;
	}

	/**
	 * @return the strUsuarioWeb
	 */
	public String getStrUsuarioWeb() {
		return strUsuarioWeb;
	}

	/**
	 * @param strUsuarioWeb
	 *            the strUsuarioWeb to set
	 */
	public void setStrUsuarioWeb(String strUsuarioWeb) {
		this.strUsuarioWeb = strUsuarioWeb;
	}

	/**
	 * @return the strClaseUsuario
	 */
	public String getStrClaseUsuario() {
		return strClaseUsuario;
	}

	/**
	 * @param strClaseUsuario
	 *            the strClaseUsuario to set
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
	 * @param strComercialExt
	 *            the strComercialExt to set
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
	 * @param strComercialInt
	 *            the strComercialInt to set
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
	 * @param strDivision
	 *            the strDivision to set
	 */
	public void setStrDivision(String strDivision) {
		this.strDivision = strDivision;
	}

	/**
	 * @return the strIdPadre
	 */
	public String getStrIdPadre() {
		if (this.getStrPadreUsuarioSuplantado() != null
				&& this.getStrPadreUsuarioSuplantado().length() > 0) {
			return this.getStrPadreUsuarioSuplantado();
		}
		return strIdPadre;
	}

	/**
	 * @param strIdPadre
	 *            the strIdPadre to set
	 */
	public void setStrIdPadre(String strIdPadre) {
		this.strIdPadre = strIdPadre;
	}

	/**
	 * Si existe usuario suplantado hay que obtener el Tipo de ese usuario
	 * 
	 * @return the strTipo
	 */
	public String getStrTipo() {
		if (this.getStrUsuarioSuplantado() != null
				&& this.getStrUsuarioSuplantado().length() > 0) {
			return this.getStrUsuarioSuplantado().substring(
					this.getStrUsuarioSuplantado().length() - 1,
					this.getStrUsuarioSuplantado().length());
		}
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
	 * Si existe usuario suplantado hay que obtener el Tipo del padre
	 * suplantado.
	 * 
	 * @return the strTipoPadre
	 */
	public String getStrTipoPadre() {
		if (this.getStrPadreUsuarioSuplantado() != null
				&& this.getStrPadreUsuarioSuplantado().length() > 0) {
			return this.getStrPadreUsuarioSuplantado().substring(
					this.getStrPadreUsuarioSuplantado().length() - 1,
					this.getStrPadreUsuarioSuplantado().length());
		}
		return strTipoPadre;
	}

	/**
	 * @param strTipoPadre
	 *            the strTipoPadre to set
	 */
	public void setStrTipoPadre(String strTipoPadre) {
		this.strTipoPadre = strTipoPadre;
	}

	/**
	 * @return the strIdSession
	 */
	public String getStrIdSession() {
		return strIdSession;
	}

	/**
	 * @param strIdSession
	 *            the strIdSession to set
	 */
	public void setStrIdSession(String strIdSession) {
		this.strIdSession = strIdSession;
	}

	/**
	 * @return the strLenguaje
	 */
	public String getStrLenguaje() {
		return strLenguaje;
	}

	/**
	 * @param strLenguaje
	 *            the strLenguaje to set
	 */
	public void setStrLenguaje(String strLenguaje) {
		this.strLenguaje = strLenguaje;
	}

	/**
	 * @return the strUsuario
	 */
	public String getStrUsuario() {
		if (this.getStrUsuarioSuplantado() != null
				&& this.getStrUsuarioSuplantado().length() > 0) {
			return this.getStrUsuarioSuplantado();
		}
		return strUsuario;
	}

	/**
	 * @param strUsuario
	 *            the strUsuario to set
	 */
	public void setStrUsuario(String strUsuario) {
		this.strUsuario = strUsuario;
		this.strUsuarioReal = strUsuario;
		if (strUsuario != null && strUsuario.length() > 1) {
			this.setStrUsuarioHost(strUsuario.substring(0,
					strUsuario.length() - 1));
		}
	}

	public void reset() {
		this.setStrIdSession(null);
		this.setStrLenguaje(null);
		this.setStrUsuario(null);
		this.setStrClaseUsuario(null);
		this.setStrComercialInt(null);
		this.setStrComercialExt(null);
		this.setStrDivision(null);
		this.setStrTipo(null);
		this.setStrTipoPadre(null);
		this.setStrIdPadre(null);
		this.setStrUsuarioWeb(null);
		this.setStrUsuarioHost(null);
		this.setStrUsuarioReal(null);
		this.lstAtribuciones = null;
	}

	/**
	 * @return the strUsuarioHost
	 */
	public String getStrUsuarioHost() {
		if (this.getStrUsuarioSuplantado() != null
				&& this.getStrUsuarioSuplantado().length() > 0) {
			return (this.getStrUsuarioSuplantado().substring(0, this
					.getStrUsuarioSuplantado().length() - 1));
		}
		return strUsuarioHost;
	}

	/**
	 * @param strUsuarioHost
	 *            the strUsuarioHost to set
	 */
	public void setStrUsuarioHost(String strUsuarioHost) {
		this.strUsuarioHost = strUsuarioHost;
	}

	/**
	 * @return the strUsuarioReal
	 */
	public String getStrUsuarioReal() {
		return strUsuarioReal;
	}

	/**
	 * @param strUsuarioReal
	 *            the strUsuarioReal to set
	 */
	public void setStrUsuarioReal(String strUsuarioReal) {
		this.strUsuarioReal = strUsuarioReal;
	}

	/**
	 * @return the strPadreUsuarioSuplantado
	 */
	public String getStrPadreUsuarioSuplantado() {
		return strPadreUsuarioSuplantado;
	}

	/**
	 * @param strPadreUsuarioSuplantado
	 *            the strPadreUsuarioSuplantado to set
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
	 * @param lstAtribuciones
	 *            the lstAtribuciones to set
	 */
	public void setLstAtribuciones(List lstAtribuciones) {
		this.lstAtribuciones = lstAtribuciones;
	}

	/**
	 * @return the bolTieneAtribucion
	 */
	public boolean isBolTieneAtribucion(String strAtribucion) {
		this.bolTieneAtribucion = false;
		if (strAtribucion != null) {
			if (this.getLstAtribuciones() != null) {
				for (Iterator iter = this.getLstAtribuciones().iterator(); iter
						.hasNext();) {
					UsuarioAtribucionVO element = (UsuarioAtribucionVO) iter
							.next();
					if (strAtribucion.indexOf(element.getStrAtribucion()) >= 0) {
						this.bolTieneAtribucion = true;
					}
				}
			}
		}
		return bolTieneAtribucion;
	}

	/**
	 * @param bolTieneAtribucion
	 *            the bolTieneAtribucion to set
	 */
	public void setBolTieneAtribucion(boolean bolTieneAtribucion) {
		this.bolTieneAtribucion = bolTieneAtribucion;
	}

	/**
	 * @return the strDescripUsu
	 */
	public String getStrDescripUsu() {
		return strDescripUsu;
	}

	/**
	 * @param strDescripUsu
	 *            the strDescripUsu to set
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

	/**
	 * @param strDescripUsuSuplantado
	 *            the strDescripUsuSuplantado to set
	 */
	public void setStrDescripUsuSuplantado(String strDescripUsuSuplantado) {
		this.strDescripUsuSuplantado = strDescripUsuSuplantado;
	}

	public List getLstComunicados() {
		return lstComunicados;
	}

	public void setLstComunicados(List lstComunicados) {
		this.lstComunicados = lstComunicados;
	}

}
