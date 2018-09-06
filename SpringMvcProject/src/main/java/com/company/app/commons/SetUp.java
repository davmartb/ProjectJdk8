/**
 * 
 */
package com.company.app.commons;


/**
 * <p>
 * Nombre Clase: SetUp
 * </p>
 * <p>
 * Descripcion:
 * </p>
 * <p>
 * Metodos de la clase
 * </p>
 * 
 * @author 
 * 
 * @d04/05/2013
 */
public class SetUp {
	
	private static String strCodGrupo;
	
	private static String strCodSubGrupo;
	
	private static String strClave;
	
	private static String strNumRegVisualInformes ="";
	
	private static String strNumRegVisualizar;
	
	private static String strFechaArranqueMs;
	
	private static String strIpServidor;
	
	private static long longTimeOutAdjDoc;
	
	private static int timeOutGestOperAFM;
	
	private static int timeOutGestOperMNG;
	
	private static int timeOutGestOperBONPREU;
	
	private static boolean isAdicionalLogs = false;
	
	
	
	
	
	

	public static boolean isAdicionalLogs() {
		return isAdicionalLogs;
	}

	public static void setAdicionalLogs(boolean isAdicionalLogs) {
		SetUp.isAdicionalLogs = isAdicionalLogs;
	}

	public static long getLongTimeOutAdjDoc() {
		return longTimeOutAdjDoc;
	}

	public static void setLongTimeOutAdjDoc(long longTimeOutAdjDoc) {
		SetUp.longTimeOutAdjDoc = longTimeOutAdjDoc;
	}

	public static String getStrIpServidor() {
		return strIpServidor;
	}

	public static void setStrIpServidor(String strIpServidor) {
		SetUp.strIpServidor = strIpServidor;
	}

	public static String getStrFechaArranqueMs() {
		return strFechaArranqueMs;
	}

	public static void setStrFechaArranqueMs(String strFechaArranqueMs) {
		SetUp.strFechaArranqueMs = strFechaArranqueMs;
	}

	public static String getStrClave() {
		return strClave;
	}

	public static void setStrClave(String strClave) {
		SetUp.strClave = strClave;
	}

	public static String getStrCodGrupo() {
		return strCodGrupo;
	}

	public static void setStrCodGrupo(String strCodGrupo) {
		SetUp.strCodGrupo = strCodGrupo;
	}

	public static String getStrCodSubGrupo() {
		return strCodSubGrupo;
	}

	public static void setStrCodSubGrupo(String strCodSubGrupo) {
		SetUp.strCodSubGrupo = strCodSubGrupo;
	}

	public static String getStrNumRegVisualInformes() {
		return strNumRegVisualInformes;
	}

	public static void setStrNumRegVisualInformes(String strNumRegVisualInformes) {
		SetUp.strNumRegVisualInformes = strNumRegVisualInformes;
	}

	/**
	 * @return the strNumRegVisualizar
	 */
	public static String getStrNumRegVisualizar() {
		return strNumRegVisualizar;
	}

	/**
	 * @param strNumRegVisualizar the strNumRegVisualizar to set
	 */
	public static void setStrNumRegVisualizar(String strNumRegVisualizar) {
		SetUp.strNumRegVisualizar = strNumRegVisualizar;
	}

	/**
	 * @return the timeOutGestOperAFM
	 */
	public static int getTimeOutGestOperAFM() {
	    return timeOutGestOperAFM;
	}

	/**
	 * @param timeOutGestOperAFM the timeOutGestOperAFM to set
	 */
	public static void setTimeOutGestOperAFM(int timeOutGestOperAFM) {
	    SetUp.timeOutGestOperAFM = timeOutGestOperAFM;
	}

	/**
	 * @return the timeOutGestOperMNG
	 */
	public static int getTimeOutGestOperMNG() {
	    return timeOutGestOperMNG;
	}

	/**
	 * @param timeOutGestOperMNG the timeOutGestOperMNG to set
	 */
	public static void setTimeOutGestOperMNG(int timeOutGestOperMNG) {
	    SetUp.timeOutGestOperMNG = timeOutGestOperMNG;
	}

	public static int getTimeOutGestOperBONPREU() {
		return timeOutGestOperBONPREU;
	}

	public static void setTimeOutGestOperBONPREU(int timeOutGestOperBONPREU) {
		SetUp.timeOutGestOperBONPREU = timeOutGestOperBONPREU;
	}
	
	
}
