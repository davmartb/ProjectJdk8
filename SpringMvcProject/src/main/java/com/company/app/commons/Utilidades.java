/*
$Author: A161496 $
$Date: 2017/10/23 15:42:56 $
$Revision: 1.21 $
$State: Exp $
*/      
package com.company.app.commons;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.company.app.beans.UsuarioBean;
import com.company.app.commons.cifrador.Cifrador;
import com.company.app.commons.constants.Constantes;
import com.company.app.model.UsuarioVO;


public class Utilidades {

	protected static final Logger logger = Logger.getLogger(Thread.currentThread().getClass());
	
	public static final String FORMATO_FECHA_VISUAL = "dd/MM/yyyy";
	
	public static final String CONSTANTE_FORMATO_FECHA_HOST  = "yyyymmdd";
	
	public static final String CONSTANTE_RUTA_PROPERTIES_CASTELLANO = "bsfincom/resources/ApplicationResources_es_ES.properties";
	
	public static final String CONSTANTE_RUTA_PROPERTIES_CATALAN = "bsfincom/resources/ApplicationResources_ca_ES.properties";
	
	public static final String CONSTANTE_IDIOMA_CASTELLANO = "ES";
	
	public static final String CONSTANTE_IDIOMA_CATALAN = "CA";
	
	public static final String CONSTANTE_ERROR_PROPERTIES = "Error al abrir el fichero properties.";
	
	public static final String CONSTANTE_ERROR_KEY = "En el fichero properties no se encuentra la key: ";
	
	public static final String CONSTANTE_ERROR_PARSE = "Error al parsear la fecha: ";
	
	public static final String ASOCIACION_NIF_STRING = "TRWAGMYFPDXBNJZSQVHLCKET";
	
	public static final String CONSTANTES_T_RESIDENCIA_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static final String CONSTANTE_COMA = ",";
	
	public static final String CONSTANTE_PUNTO = ".";
	
	public static final String CONSTANTE_SEPARACION_DECIMAL = ",00";
	
	public static final String CONSTANTE_RELLENO_DECIMAL = "0";
	
	public static final String CONSTANTE_ERROR_PARSE_NUMERO = "Error al parsear el número: ";
	
	public static final String CONSTANTE_FORMATO_ENTRADA = " Formato de entrada: ";
	
	public static final String CONSTANTE_FORMATO_SALIDA = " Formato de salida: ";
	
	public static final String CONSTANTE_FECHA_A_FORMATEAR = " Fecha a formatear: ";
	
	public static final String CONSTANTE_METHOD_OBTENERIPSERVIDORLOCAL="obtenerIpServidorLocal";
	
	public static final char CONSTANTE_MODO_ENCRIPTAR = 'E';
	
	public static final char CONSTANTE_MODO_DESENCRIPTAR = 'D';
	
	public static final String CONSTANTE_TIMESTAMP_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss.sssZ"; //2012-07-27T08:12:12.514+02:00
	
	public static final String CONSTANTE_DATE_ISO_8601 = "yyyy-MM-dd";
	
	public static final String CONSTANTE_DATE_ISO_8601_CON_Z = "yyyy-MM-ddZ";
	
	public static final String CONSTANTE_FORMATO_FECHA_yyyyMMdd  = "yyyyMMdd";
	
	public static final int BUFFER_SIZE = 1024;	

	//MIGRACION
	
	public static final String CONSTANTE_METHOD_OBTENERMAP = "obtenerMap";
	
	
	public static final String CONSTANTE_IDIOMA_CASTELLANO_2 = "ES_ES";
	
	public static final String CONSTANTE_IDIOMA_CASTELLANO_3 = "ESP";
	
	
	public static final String CONSTANTE_IDIOMA_CATALAN_3 = "CAT";
	
	public static final String CONSTANTE_IDIOMA_CATALAN_2 = "ES_CA,ES-CA";

	public static final String CONSTANTE_IDIOMA_INGLES = "EN";
		
	public static final String CONSTANTE_IDIOMA_INGLES_2 = "EN_EN,EN-EN";
	
	public static final String CONSTANTE_IDIOMA_INGLES_3 = "ENG";
	
	public static final String CONSTANTE_IDIOMA_INGLES_JSP = "en-EN";
	
	public static final String CONSTANTE_IDIOMA_CATALAN_JSP ="es-CA";
	
	public static final String CONSTANTE_IDIOMA_CASTELLANO_JSP ="es-ES";
	
	private static final String CONSTANTE_IP_PROD_WS0 = "192.168.135.50";
	private static final String CONSTANTE_IP_PROD_WS1 = "192.168.135.51";
	private static final String CONSTANTE_IP_PRE = "192.168.135.43";
	private static final String CONSTANTE_IP_DES = "192.168.135.43";	
	
	private static final String CONSTANTE_PROD_WS0 = "WS0";
	private static final String CONSTANTE_PROD_WS1 = "WS1";
	private static final String CONSTANTE_PRE = "PRE";
	private static final String CONSTANTE_DES = "DES";
	private static final String CONSTANTE_LOCAL = "LOC";
	
	/**
	 * @param fecha Fecha a formatear
	 * @return La fecha con formato entero (yyyyMMdd)
	 */
	public static Date formateoFecha(String fecha){
		try{
			
			//Si la fecha no es nula se formatea 
			if (fecha != null){
				if (!(fecha.equals(""))){
					//Se convierte la fecha string en fecha date	
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMATO_FECHA_VISUAL);
					return simpleDateFormat.parse(fecha);
				}else{
					logger.error(CONSTANTE_ERROR_PARSE);
					return null;
				}
			}else{
				logger.error(CONSTANTE_ERROR_PARSE);
				return null;			
			}
		}
		catch (ParseException e) {
	
			logger.error(CONSTANTE_ERROR_PARSE);
			return null;
		}		
	}
	
	/**
	 * @param fechaFormatear Fecha a formatear
	 * @param formatoEntrada formato de entrada
	 * @param formatoSalida formato de salida
	 * @return La fecha con el formato definido en formatoSalida
	 */
	public static String utilidadesFecha(String formatoEntrada,String formatoSalida,String fechaFormatear){
		
			StringBuilder stBuffer = null;
		
			char[] tempEntrada=new char[10];
			char[] tempSalida=new char[10];
			char[] tempFecha=new char[10];
			char anterior=' ';
			int tamAnioE=0; //Si el año entra con 2 o 4 cifras
			int tamAnioS=0; //Si el año sale con 2 o 4 cifras
			String anio="";
			String mes="";
			String dia="";
			boolean isError = false;			
			String fechaFinal="";	
			
			
			//Si la fecha no es nula se formatea 
			if (fechaFormatear!=null && formatoSalida!=null && formatoEntrada!=null){
				if(!fechaFormatear.equals("") && !formatoSalida.equals("") && !formatoEntrada.equals("")){
					if(comprobarValidezFecha(formatoEntrada, formatoSalida, fechaFormatear)){
					formatoEntrada.getChars(0,formatoEntrada.length(), tempEntrada, 0);
					formatoSalida.getChars(0,formatoSalida.length(), tempSalida, 0);
					fechaFormatear.getChars(0,fechaFormatear.length(), tempFecha, 0);
					
					for(int e=0;e<formatoEntrada.length();e++){ //Cuenta las cifras del anio de entrada
						if(tempEntrada[e]=='y' || tempEntrada[e]=='Y')
							tamAnioE++;
					}
					for(int s=0;s<formatoSalida.length();s++){ //Cuenta las cifras del anio de salida
						if(tempSalida[s]=='y' || tempSalida[s]=='Y')
							tamAnioS++;
					}
					
					for(int i=0;i<formatoEntrada.length();i++){
						if(tempEntrada[i]=='y' || tempEntrada[i]=='Y'){ //Viene anio
							anio=anio+tempFecha[i];
						}else if(tempEntrada[i]=='d' || tempEntrada[i]=='D'){ //Viene dia
							dia=dia+tempFecha[i];
						}else if(tempEntrada[i]=='m' || tempEntrada[i]=='M'){ //Viene mes
							mes=mes+tempFecha[i];
						} 
					}
					for(int j=0;j<formatoSalida.length();j++){
						if((tempSalida[j]=='y' || tempSalida[j]=='Y')&& tempSalida[j]!=anterior){ //Sale anio
							anterior=tempSalida[j];
							if(tamAnioS==tamAnioE){
								fechaFinal = fechaFinal + anio;
							}else if(tamAnioS>tamAnioE){ //Si recibimos anio de 2 cifras y lo sacamos de 4
								anio= "20"+anio;
								fechaFinal = fechaFinal + anio;
							}else if(tamAnioS<tamAnioE){ //Si recibimos anio de 4 cifras y lo sacamos de 2
								fechaFinal = fechaFinal + anio.substring(2,4);
							}
						}else if((tempSalida[j]=='d' || tempSalida[j]=='D')&& tempSalida[j]!=anterior){ //Sale dia
							anterior=tempSalida[j];
							fechaFinal = fechaFinal + dia;
						}else if((tempSalida[j]=='m' || tempSalida[j]=='M')&& tempSalida[j]!=anterior){ //Sale mes
							anterior=tempSalida[j];
							fechaFinal = fechaFinal + mes;
						}else if(tempSalida[j]!=anterior){  //Caracter separador
							fechaFinal = fechaFinal + tempSalida[j];
						}
					}
					
					} else {
						isError = true;
						
					}
				}else{
					isError = true;
					
				}
			}else{
				isError = true;
				
			}
			if (isError){
				if ((fechaFormatear != null && !("0").equals(fechaFormatear))||fechaFormatear==null){					
					stBuffer = new StringBuilder();
					stBuffer.append(CONSTANTE_ERROR_PARSE);
					stBuffer.append(CONSTANTE_FORMATO_ENTRADA);
					stBuffer.append(formatoEntrada);
					stBuffer.append(CONSTANTE_FORMATO_SALIDA);
					stBuffer.append(formatoSalida);
					stBuffer.append(CONSTANTE_FECHA_A_FORMATEAR);
					stBuffer.append(fechaFormatear);
					logger.debug(stBuffer.toString());
				}
				return "";			
			}
			return fechaFinal;
	}
	
	private static boolean comprobarValidezFecha(String formatoEntrada,String formatoSalida,String fechaFormatear){
		boolean isValido = false;
			if (formatoEntrada.indexOf("-")>=0){
				formatoEntrada = formatoEntrada.replaceAll("-", "");
			} else {
				if (formatoEntrada.indexOf("/")>=0){
					formatoEntrada = formatoEntrada.replaceAll("/", "");
				}
			}
			if (formatoSalida.indexOf("-")>=0){
				formatoSalida = formatoSalida.replaceAll("-", "");
			} else {
				if (formatoSalida.indexOf("/")>=0){
					formatoSalida = formatoSalida.replaceAll("/", "");
				}
			}
			if ((fechaFormatear.length()>=formatoEntrada.length())||(fechaFormatear.length()>=formatoSalida.length())){
				isValido= true;
			}
			
		return isValido;
	}
	/**
	 * Esta función obtiene el mensaje traducido por la key que entra por strKey.
	 * @param strKey Key para buscar en el fichero ApplicationResource
	 * @param strIdioma idioma utilizado por el usuario
	 * @param strValores Valores que hay que rellenar
	 * @return El mensaje traducido al idioma.
	 */
	public static String obtenerKeyResourceConValoresProperties(String strKey, String strIdioma, String[] strValores){

	    InputStream reportSource = null;
	    Properties properties = new Properties();
	    String strResult = null;
	    StringBuilder stbBuffer = null;
	    String strIdiomaUp = null;
	    String strValor = null;
	    boolean isOut = false;
	    int posCad = 0;
	    if (strIdioma != null){
		strIdiomaUp = strIdioma.toUpperCase();
	    }
	    if (CONSTANTE_IDIOMA_CATALAN.equals(strIdiomaUp)){
		reportSource = Utilidades.class.getClassLoader().getResourceAsStream(CONSTANTE_RUTA_PROPERTIES_CATALAN);
	    } else {
		reportSource = Utilidades.class.getClassLoader().getResourceAsStream(CONSTANTE_RUTA_PROPERTIES_CASTELLANO);
	    }
		
	    try {
		properties.load(reportSource);
		strResult = properties.getProperty(strKey);
		if (strResult == null){
		    logger.warn(CONSTANTE_ERROR_KEY+strKey);
		} else {
		    stbBuffer = new StringBuilder();
		    for (int j = 0; j < strValores.length && !isOut; j++) {
			String string = strValores[j];
			strValor = "{"+j+"}";
			if ((posCad = strResult.indexOf(strValor)) >=0){
			    if (j==0){
				stbBuffer.append(strResult.substring(0,posCad));
				stbBuffer.append(string);
			    } else {
				stbBuffer.append(string);
			    }
			    if (strValores.length > 1 && strValores.length > (j+1)){
				stbBuffer.append(strResult.substring(posCad+strValor.length(),strResult.indexOf("{"+(j+1)+"}")));
			    } else {
				stbBuffer.append(strResult.substring(posCad+strValor.length(),strResult.length()));
			    }
			} else {
			    isOut = true;
			}
		    }
		    strResult = stbBuffer.toString();
		}
	    } catch (IOException e) {
		logger.error(CONSTANTE_ERROR_PROPERTIES);
	    }
	    return strResult;
	}
	
	/**
	 * Esta función obtiene el mensaje traducido por la key que entra por strKey.
	 * @param strKey Key para buscar en el fichero ApplicationResource
	 * @param strIdioma idioma utilizado por el usuario
	 * @return El mensaje traducido al idioma.
	 */
	public static String obtenerKeyResourceProperties(String strKey, String strIdioma){

		
		InputStream reportSource = null;
		Properties properties = new Properties();
		String strResult = null;
		String strIdiomaUp = null;
		if (strIdioma != null){
			strIdiomaUp = strIdioma.toUpperCase();
		}
		if (CONSTANTE_IDIOMA_CATALAN.equals(strIdiomaUp)){
			reportSource = Utilidades.class.getClassLoader()
				.getResourceAsStream(CONSTANTE_RUTA_PROPERTIES_CATALAN);
			} else {
				reportSource = Utilidades.class.getClassLoader()
				.getResourceAsStream(CONSTANTE_RUTA_PROPERTIES_CASTELLANO);
			}
		
		try {
			properties.load(reportSource);
			strResult = properties.getProperty(strKey);
			if (strResult == null){
				logger.warn(CONSTANTE_ERROR_KEY+strKey);
			}
		} catch (IOException e) {
			logger.error(CONSTANTE_ERROR_PROPERTIES);
		}
		return strResult;
	}
	/**
	 * Esta función obtiene el mensaje traducido por la key que entra por strKey.
	 * @param strKey Key para buscar en el fichero que entra por parametro strRutaProperties
	 * @param strRutaProperties fichero de recursos donde buscar
	 * @return El mensaje traducido al idioma.
	 */	
	
	public static String obtenerValorFicheroProperties(String strKey, String strRutaProperties){
			
			InputStream reportSource = null;
			Properties properties = new Properties();
			String strResult = null;		
			
				reportSource = Utilidades.class.getClassLoader()
					.getResourceAsStream(strRutaProperties);			
			try {
				properties.load(reportSource);
				strResult = properties.getProperty(strKey);
				if (strResult == null){
					logger.warn(CONSTANTE_ERROR_KEY+strKey);
				}
			} catch (IOException e) {
				logger.error(CONSTANTE_ERROR_PROPERTIES);
			}
			return strResult;
		}
	/**
	 * Esta función obtiene el usuario host(tam. 11), en funcion del usuario(Tam. 12).
	 * @param strUsuario Usuario (tam. 12) con tipo de usuario
	 * @return El Usuario en formato host (tam 11) sin tipo de usuario.
	 */	
	public static String obtenerUsuarioHost(String strUsuario){
		String strUsuarioHost = null;
		if (strUsuario != null && strUsuario.length() > 1){
			strUsuarioHost = strUsuario.substring(0,strUsuario.length()-1);
		}
		return strUsuarioHost;
	}
	
	/**
	 * Esta función concatea dos List.
	 * @param List lOrigen, List lDestino
	 * @return lDestino con los valores de la lista origen añadidos
	 */	
	public static List concatenarList(List lDestino,List lOrigen){
		
		for ( Iterator iterador = lOrigen.listIterator(); iterador.hasNext(); ) 
		{				
			lDestino.add(iterador.next());
		}
		return lDestino;
	}
	/**
	* Construye el formato de fechas segun de donde venga,si el id=1 viene de construirCommareaCaptacion
	* y el formato debe de ser yymmdd,si es 2 viene de cargarFormFromCommareaCaptacion y el formato debe
	* de ser ddmmyy.
	* @param fecha que queremos cambiar su formato,id para saber de donde viene.
	* @return String.
	*/
	public static String formatoFechas (String fecha, int id){
		
		String formatoFecha = "";
		String ano;
		String mes;
		String dia;
		if (fecha != null && fecha.length()>=8){
			if(id == 1){
				dia = fecha.substring(0,2); 	
				mes = fecha.substring(2,4);
				ano = fecha.substring(4,8);
				formatoFecha = ano + mes + dia;
			}else{
				dia = fecha.substring(0,4);
				mes = fecha.substring(4,6);
				ano = fecha.substring(6,8);
				formatoFecha = dia + mes + ano;
			}
		}
		return formatoFecha;
	}
	
	/**
	* Comprueba si una cadena es numérica.
	* @param cadena que queremos cambiar su formato,id para saber de donde viene.
	* @return boolean.
	*/
	public static boolean esNumerico(String cadena){
		boolean isValido = false;
		if (cadena!= null){
			try {
				Integer.parseInt(cadena);
				isValido=true;
			} catch (NumberFormatException nfe){
				//No es necesario hacer nada.
			}
		} 
		return isValido;
	}
	
	/**
	* Comprueba si un nif, solo si tiene parte numerica y letra.
	* @param strDni nif a comprobar.
	* @return boolean.
	*/
	 public static boolean esNif(String strDni) {
	
	   boolean isNif = false;
	   if (strDni == null){
		   return isNif;
		  }
	   String inicio = strDni.substring(0,strDni.length()-1);
		
	   if (Utilidades.esNumerico(inicio)){
		   isNif = true;
		}
	   
	   return isNif;
	 }
	
	 /**
	  * Comprueba un nif es Valido.
	  * @param strNif nif a validar.
	  * @return boolean.
	  */
	public static boolean esNifValido(String strNif){
	    String documento = null;
	    String letraDocumento = null;
	    boolean isValido = false;
	    if (strNif == null)
		return isValido;
	    documento = strNif.substring(0, strNif.length() - 1);
        
	    letraDocumento = strNif.substring(strNif.length() - 1);
	    if (("X").equalsIgnoreCase(documento.substring(0, 1)) 
		    || ("Y").equalsIgnoreCase(documento.substring(0, 1))
		    || ("Z").equalsIgnoreCase(documento.substring(0, 1))) {
		// tiene XYZ delante, es un NIE
		return false;
	    } else {
	    
		char letraResultado = ASOCIACION_NIF_STRING.charAt(Integer.parseInt(documento) % 23);

		if (letraResultado == letraDocumento.charAt(0)){
		    return true;
		}
	    }
	    return isValido;
	}
	
	 /**
	* Comprueba si una tarjeta de residencia ó nif es Valido.
	* @param strNif nif a validar.
	* @return boolean.
	*/
	public static boolean esTarjetaResidenciaValida(String strNif){
		String documento = null;
	    String letraDocumento = null;
	    boolean isValido = false;
	    String strNumSuma="";
	    
	    if (strNif == null || esNif(strNif))
	    	return isValido;
	    
	    if (("Y").equalsIgnoreCase(strNif.substring(0,1))){
       		 strNumSuma="1";
	 	 }
	 	if (("Z").equalsIgnoreCase(strNif.substring(0,1))){
	 		strNumSuma="2";
	 	 }
        
        documento = strNumSuma+strNif.substring(1, strNif.length() - 1);	    	    
	    letraDocumento = strNif.substring(strNif.length() - 1);
	    	    
	    char letraResultado = ASOCIACION_NIF_STRING.charAt(Integer.parseInt(documento) % 23);
	
	    if (letraResultado == letraDocumento.charAt(0)){
	         isValido = true;
	    }
	    return isValido;
	 }
	 /**
	* Comprueba un nif o tarjeta de residencia es Valida.
	* @param strNif nif a validar.
	* @return boolean.
	*/
	public static boolean nifNieValido(String strNif) {
		 
         String documento = null;
         String letraDocumento = null;
         boolean isNif = false; 
         boolean isValido = false;
         String strNumSuma="";
         try {
					
	         if (strNif == null || strNif.length()<2){
	        	 return isValido;
	         }
	         
	         isNif = esNif(strNif);
	         
	         if (isNif){
	        	 documento = strNif.substring(0, strNif.length() - 1);
	         }else{
	        	 if (("Y").equalsIgnoreCase(strNif.substring(0,1))){
	        		 strNumSuma="1";
	          	 }
	          	 if (("Z").equalsIgnoreCase(strNif.substring(0,1))){
	          		strNumSuma="2";
	          	 }
	             documento = strNumSuma+strNif.substring(1, strNif.length() - 1);
	         }
	         
	         letraDocumento = strNif.substring(strNif.length() - 1);
	        
	         char letraResultado = ASOCIACION_NIF_STRING.charAt(Integer.parseInt(documento) % 23);
	
	         if (letraResultado == letraDocumento.charAt(0)){
	        	 isValido = true;
	         }
         } catch (Exception e) {
 			//No se hace nada ya que se retorna isValido=false        	 
 		}
         return isValido;
    }
		
	/**
	 * Retorna un importe formateado con puntos y comas.
	 * 
	 * @param strImporte
	 *            nif a validar.
	 * @return String.
	 */
	public static String obtenerImportePresentacion(String strImporte) {
		StringBuilder stbResult = new StringBuilder("");
		String strResultAux = null;
		String strValor = null;
		String strComa = null;		
		int posComa = 0;
		int posFinal = 0;
		
		if (strImporte != null && strImporte.compareTo("")!=0) {
		try {
			
			//si viene un numero empezando con una comma ponemos un 0 delante
			if (strImporte.charAt(0) == ',') {
				stbResult = new StringBuilder();
				stbResult.append(strImporte);
				stbResult.insert(0, '0');
				strImporte = stbResult.toString();
			}

				posComa = strImporte.indexOf(',');
				stbResult = new StringBuilder();
				if (posComa >= 0) {
					if (strImporte.length() > posComa + 2) {
						posFinal = posComa+3;						
					} else {
						posFinal = strImporte.length();
					}
					strComa = strImporte.substring(posComa, posFinal);
					if (strComa.length() < 3) {
						strComa = strComa.concat(CONSTANTE_RELLENO_DECIMAL);
					}

				} else {
					strComa = CONSTANTE_SEPARACION_DECIMAL;
				}

				stbResult.insert(0, strComa);
				if (posComa<0){
					posComa = strImporte.length();
				}
				strResultAux = strImporte.substring(0, posComa);
				Double.parseDouble(strResultAux);

				int longCad = strResultAux.length();

				while (longCad > 3) {
					strValor = strResultAux.substring(longCad - 3, longCad);
					stbResult.insert(0, strValor);
					stbResult.insert(0, CONSTANTE_PUNTO);
					longCad -= 3;
				}
				if (longCad > 0) {
					strValor = strResultAux.substring(0, longCad);
					stbResult.insert(0, strValor);
				}
			
		} catch (NumberFormatException e) {
			logger.error(CONSTANTE_ERROR_PARSE_NUMERO+strImporte);
		}
	}
		return stbResult.toString();
	}
	
	/**
	 * 	 Esta función Recibe un String con un contenido de formato numérico 
	 *     y lo devuelve como un formato compatible para transformarlo en un double.
	 *   @param strCadenaSinFormatear 
	 *   @return strCadenaFormateada
	 */
	public static String formatearADouble(String strCadenaSinFormatear){
		
		String strCadenaFormateada="";
		
		String[] strPruebas = strCadenaSinFormatear.split(",");
		if (strPruebas.length>0){
			strPruebas[0] = strPruebas[0].replaceAll("\\.", "");
		}
		if(strPruebas.length==1)
		{
			strCadenaFormateada = strPruebas[0];
		}else
			strCadenaFormateada = strPruebas[0] +"." + strPruebas[1];
		return strCadenaFormateada;		
	}
	
	public static String formatoFechaSistema (){
		
		Calendar c1 = Calendar.getInstance();
		String dia ="";
		String mes ="";
		String annio ="";
		String fecha ="";
		dia = Integer.toString(c1.get(Calendar.DATE));
		if(dia.length()==1){
			dia = "0"+dia;
		}
		mes = Integer.toString(c1.get(Calendar.MONTH)+1);
		if(mes.length()==1){				
			mes = "0"+mes;
		}
		annio = Integer.toString(c1.get(Calendar.YEAR));
		fecha = dia + "/" + mes + "/" + annio;
		
		return fecha;
	}
	
	public static String formatoFechaHoraSistema(){
		
		Calendar c1 = Calendar.getInstance();
		StringBuilder stbFecha = new StringBuilder();
		String dia ="";
		String mes ="";	
		String hora="";
		String min ="";
		String seg = "";
		
		try {
					
			stbFecha.append(Integer.toString(c1.get(Calendar.YEAR)));			
			
			mes = Integer.toString(c1.get(Calendar.MONTH)+1);
			if(mes.length()==1){				
				mes = "0"+mes;
			}
			stbFecha.append(mes);
			
			dia = Integer.toString(c1.get(Calendar.DATE));
			if(dia.length()==1){
				dia = "0"+dia;
			}		
			stbFecha.append(dia);
			
			hora =Integer.toString(c1.get(Calendar.HOUR_OF_DAY));
			if(hora.length()==1){
				hora = "0"+hora;
			}
			stbFecha.append(hora);
			
			min =Integer.toString(c1.get(Calendar.MINUTE));
			if(min.length()==1){
				min = "0"+min;
			}
			stbFecha.append(min);
			
			seg =Integer.toString(c1.get(Calendar.SECOND));
			if(seg.length()==1){
				seg = "0"+seg;
			}
			stbFecha.append(seg);
			
		} catch (Exception e) {
			Utilidades.escribirLogException(e, logger, Utilidades.class.getName(), "formatoFechaHoraSistema");
		}
		return stbFecha.toString();
	}
	
	public static int obtenerMinDifconFechSistema(String strFechComparar){
		String strFechSistema = null;
		int min = -1;
		int horaSistema = 0;
		int horaComparar = 0;
		int minSistema = 0;
		int minComparar = 0;
		try {
			
			if (strFechComparar!= null && strFechComparar.length()>=14){
				strFechSistema = formatoFechaHoraSistema();
				
				//verificamos siempre que la fecha de sistema es superior, y tambien que corresponden al mismo día
				if (strFechSistema!= null && strFechSistema.length()>=14 && strFechSistema.compareTo(strFechComparar)>=0 && strFechSistema.substring(0,8).equals(strFechComparar.substring(0,8))){						
						horaSistema = Integer.parseInt(strFechSistema.substring(8, 10));
						horaComparar = Integer.parseInt(strFechComparar.substring(8, 10));
						minComparar = Integer.parseInt(strFechComparar.substring(10, 12));
						minSistema = Integer.parseInt(strFechSistema.substring(10, 12));
						// se pasa la hora del sistem a minutos y se le suman los minutos
						horaSistema = (horaSistema* 60)+ minSistema;
						horaComparar = (horaComparar*60)+ minComparar;
						min = horaSistema-horaComparar;											
					
				}
			}						
		} catch (Exception e) {
			 Utilidades.escribirLogException(e, logger, Utilidades.class.getName(), "obtenerMinDifconFechSistema");
		}
		return min;
	}
	/**
	 * 	 Esta función escribe en el log, si se produce una excepción del tipo
	 * 	 Exception, se diferencia porque tratar el stacktrace
	 *   @param e
	 *   @param log 
	 *   @param strClase 
	 *   @param strMetodo
	 */
	public static String escribirLogException(Exception e, Logger log, String strClase, String strMetodo){
		StringBuilder stbMensaje = new StringBuilder();
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		
		stbMensaje.append(Constantes.CONSTANTE_CLASE);
		stbMensaje.append(strClase);
		stbMensaje.append(Constantes.CONSTANTE_METODO);
		stbMensaje.append(strMetodo);
		stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
		stbMensaje.append(e.getMessage());
		stbMensaje.append(Constantes.CONSTANTE_STACKTRACE);
		stbMensaje.append(sw.toString());
		log.error(stbMensaje.toString());
		return stbMensaje.toString();
	}
	
	/**
	 * 	 Esta función escribe en el log, si se produce una excepción del tipo
	 * 	 distinta a Exception, se diferencia porque tratar el stacktrace
	 *   @param e 
	 *   @param strClase 
	 *   @param strMetodo
	 *   @param strMensaje  
	 */
	public static void escribirLogDistException(Exception e, Logger log, String strClase, String strMetodo){
		StringBuilder stbMensaje = new StringBuilder();		
		
		stbMensaje.append(Constantes.CONSTANTE_CLASE);
		stbMensaje.append(strClase);
		stbMensaje.append(Constantes.CONSTANTE_METODO);
		stbMensaje.append(strMetodo);
		stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
		stbMensaje.append(e.getMessage());		
		log.error(stbMensaje.toString());
	}
	
	/**
	 * 	 Esta función escribe en el log, si se produce una excepción del tipo
	 * 	 distinta a Exception, se diferencia porque tratar el stacktrace
	 *   @param log 
	 *   @param strClase 
	 *   @param strMetodo
	 *   @param strMensaje  
	 */
	public static void escribirLogDistException(Logger log, String strClase, String strMetodo, String strMensaje){
		StringBuilder stbMensaje = new StringBuilder();		
		
		stbMensaje.append(Constantes.CONSTANTE_CLASE);
		stbMensaje.append(strClase);
		stbMensaje.append(Constantes.CONSTANTE_METODO);
		stbMensaje.append(strMetodo);
		stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
		stbMensaje.append(strMensaje);		
		log.error(stbMensaje.toString());
	}
	
	/**
	 * 	 Esta función escribe en el log, cuando en necesario un comentario
	 *   @param log 
	 *   @param strClase 
	 *   @param strMetodo
	 *   @param strMensaje  
	 */
	public static void escribirLogInfo(Logger log, String strClase, String strMetodo, String strMensaje){
		StringBuilder stbMensaje = new StringBuilder();		
		
		stbMensaje.append(Constantes.CONSTANTE_CLASE);
		stbMensaje.append(strClase);
		stbMensaje.append(Constantes.CONSTANTE_METODO);
		stbMensaje.append(strMetodo);
		stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
		stbMensaje.append(strMensaje);		
		stbMensaje.append("#free memory: "+Runtime.getRuntime().freeMemory()/1024+" Kb");
		stbMensaje.append("#max memory: "+Runtime.getRuntime().maxMemory()/1024+" Kb");
		stbMensaje.append("#total memory: "+Runtime.getRuntime().totalMemory()/1024+" Kb");	
		stbMensaje.append("#free total memory: "+(Runtime.getRuntime().freeMemory() + (Runtime.getRuntime().maxMemory()- Runtime.getRuntime().totalMemory()))/1024+" Kb");
		log.info(stbMensaje.toString());
	}

	
	/**
	 * 	 Esta función escribe en el log, cuando en necesario un comentario
	 *   @param log 
	 *   @param strClase 
	 *   @param strMetodo
	 *   @param strMensaje  
	 */
	public static void escribirLogDebug(Logger log, String strClase, String strMetodo, String strMensaje){
		StringBuilder stbMensaje = new StringBuilder();		
		
		stbMensaje.append(Constantes.CONSTANTE_CLASE);
		stbMensaje.append(strClase);
		stbMensaje.append(Constantes.CONSTANTE_METODO);
		stbMensaje.append(strMetodo);
		stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
		stbMensaje.append(strMensaje);		
		log.debug(stbMensaje.toString());
	}
	
		/**
	 * 	 Esta función Recibe un String que es un cif o nif 
	 *   y devuelve true o false dependiendo de si es correcto o no.
	 *   @param strCif 
	 *   @return boolean
	 */
	public static boolean cifValido(String strCif){
		int temp = 0;
		int digito = 0;
		String[] letras = new String[]{"A","B","C","D","E","F","G","H","J","P","Q","R","S","U","V","N","W"};
		String[] numeros = new String[]{"0","2","4","6","8","1","3","5","7","9"};
		boolean isOk= false;
		boolean isValido = false;
		
		String letra = strCif.substring(0, 1);
		String dc = strCif.substring(8);
		
		try{
			digito = Integer.parseInt(dc);
			if (digito == 0)
			{
				digito = 10;
			}
		}catch(NumberFormatException e){
			//digito = dc. hashCode(); 			
			digito = 0;				
		}

		if (nifNieValido(strCif)){
			return true;
		}else if (strCif.length() < 9){			
			return false;
		}else{			
			for(int i=0; i< letras.length; i++){
				if(letra.equals(letras[i])){
					isOk= true;
				}
			}
			if(!isOk){
				return false;
			}
		}		
		if(isOk){
			for(int i=2; i<=6; i+=2){	
				String valor = numeros[Integer.parseInt(strCif.substring(i-1,(i)))];
				temp = temp + Integer.parseInt(valor);		
				temp = temp +Integer.parseInt(strCif.substring(i,i+1));
			}
			
			String valorFinal = numeros[Integer.parseInt((strCif.substring(7,8)))];
			temp = temp + Integer.parseInt(valorFinal);
			temp = (10 - ( temp % 10));
			int suma = 64 + temp;						
			
			if(temp == 10 && (strCif.charAt(strCif.length()-1) == 'J' || strCif.charAt(strCif.length()-1) == 0)){
				return true;
			}else if (digito == temp || strCif.charAt(strCif.length()-1) == (char)suma){
				return true;
			}else{
				return false;
			}
		}
		return isValido;
	}
	
	
	
	
	public static String obtenerIpServidorLocal(){
		String strIp = "";
		byte[] ipAdress = null;
		try {		
			InetAddress inetAddress = InetAddress.getLocalHost();
			ipAdress = inetAddress.getAddress();
			for (int x=0; x<ipAdress.length; x++) { 
				if (x > 0) { 
				// A todos los numeros les anteponemos    
				// un punto menos al primero    
				strIp += ".";  
				} 
				 strIp += ipAdress[x] & 255;
			}
		} catch (Exception e) {
			Utilidades.escribirLogException(e, logger, Utilidades.class.getName(), CONSTANTE_METHOD_OBTENERIPSERVIDORLOCAL);
		}
		return strIp;
	}
	//Version 1. Este método recorre un VO y va cifrando todos los valores, estos tienen que ser String y existe un array de objetos
	//lo recorre, cuando encuentra información la encripta si no la informa con null.
	public static String obtenerStringVO(Object object, String entidad, boolean isEncrip){
		
		StringBuilder stbCadena = new StringBuilder();
		if (object!=null){
			Field[] fields = object.getClass().getDeclaredFields();
			String strField = null;
			Method method = null;		
			for (int i = 0; i < fields.length; i++) {			
				if (fields[i] != null 
						&& (String.class.equals(fields[i].getType()) || 
								fields[i].getType().isArray())){
					//System.out.println(fields[i].getName());
					strField = fields[i].getName();
					String MetodoGet = "get"+strField.substring(0,1).toUpperCase()+strField.substring(1);
					
					//System.out.println(MetodoGet);
					try {
						try {
							method = object.getClass().getMethod(MetodoGet, null);
						} catch (Exception e) {
						   method=null;
						}
						if (method ==null){
							MetodoGet = "get"+strField;
							try {
								method = object.getClass().getMethod(MetodoGet, null);
							} catch (Exception e) {
								Utilidades.escribirLogDistException(logger, Utilidades.class.getName(), "obtenerStringVO", "No encontrado método: "+MetodoGet);
							}
						}
						if (method!=null){
							//System.out.println(method.getReturnType());
							Object[] objects = {};
							stbCadena.append(strField);
							stbCadena.append("#");
							if (String.class.equals(fields[i].getType()) ){
								String strValor = (String)method.invoke(object, objects);	
								if (strValor!=null && isEncrip){							
									strValor = Cifrador.encriptar(null, strValor, entidad);
								}
								if (strValor!=null && strValor.length()>200){
									strValor = strValor.substring(0, 200);
								}
								stbCadena.append(strValor);
								stbCadena.append("#");
							} else {
								if (fields[i].getType().isArray()){
									Object[] objects2 = (Object[])method.invoke(object, objects);
									if (objects2 != null && objects2.length >0){
										for (int j = 0; j < objects2.length; j++) {
											stbCadena.append("#");
											stbCadena.append(obtenerStringVO(objects2[j], entidad, isEncrip));
											stbCadena.append("#");
										}								
									} else {
										stbCadena.append("null");
									}
									stbCadena.append("#");
									//Object objValor = (Object)method.invoke(object, objects);											
									
									
								}
								
							}
						}
						
					} catch (Exception e) {
						Utilidades.escribirLogException(e, logger, Utilidades.class.getName(), "obtenerStringVO");
					} 
					
				} 
			}
		}
		//System.out.println("Tiempo en ms: "+(System.currentTimeMillis()-timeStart));
		return stbCadena.toString();
		
	}
	
	
	
	
	public static boolean isMovil(String tlf){
		boolean isMovil = false;
		if (tlf!= null && tlf.length()>=9 ){
			if (tlf.charAt(0)=='6' || tlf.charAt(0)=='7'){
				isMovil = true;
			}
		}
		return isMovil;
	}
	
	/**
	 * 	 Esta función Recibe un String con un contenido de formato numérico 
	 *     y lo devuelve como un formato compatible para transformarlo en un double.
	 *   @param strCadenaSinFormatear 
	 *   @return strCadenaFormateada
	 */
	public static String formatearDate(Date fecha, String strFormato){
		String strFecha = null;
		if (fecha != null){
			if (strFormato == null){ 
				strFormato = FORMATO_FECHA_VISUAL;
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormato);
			strFecha = simpleDateFormat.format(fecha);
		}
		return strFecha;
	}
	
	public static String obtenerFechaISO8601(Calendar calendar){
		String strFecha = null;
		if (calendar!=null){
			strFecha = Utilidades.formatearDate(calendar.getTime(), Utilidades.CONSTANTE_TIMESTAMP_ISO_8601);
			if (strFecha!=null && strFecha.length()>26){
				strFecha = strFecha.substring(0, 26) + ":" + strFecha.substring(26);
			}			
		}
		return strFecha;
	}
	
	public static String obtenerFechaISO8601_Z(Calendar calendar){
		String strFecha = null;
		strFecha = Utilidades.formatearDate(calendar.getTime(), Utilidades.CONSTANTE_DATE_ISO_8601_CON_Z);			
		if (strFecha!=null && strFecha.length()>13){
			strFecha = strFecha.substring(0, 13) + ":" + strFecha.substring(13);
		}	
		return strFecha;
	}
	public static String obtenerIpServidor(){
		String strIp = "";
		byte[] ipAdress = null;
		
		InetAddress inetAddress = null;
		try {
			inetAddress = InetAddress.getLocalHost();
		
			ipAdress = inetAddress.getAddress();
			
			for (int x=0; x<ipAdress.length; x++) { 
				if (x > 0) { 
				// A todos los numeros les anteponemos    
				// un punto menos al primero    
				strIp += ".";  
				} 
				 strIp += ipAdress[x] & 255;
			}
		} catch (Exception e) {
			Utilidades.escribirLogException(e, logger, Utilidades.class.getName(),"obtenerIpServidor");
		}
		return strIp;
	}
	
  
    /**
	 * @param fecha Fecha a formatear
	 * @return La fecha con formato entero (yyyyMMdd)
	 */
	public static Date obtenerFechaFormateada(String fecha, String formato){
		try{
			
			//Si la fecha no es nula se formatea 
			if (fecha != null){
				if (!(fecha.equals(""))){
					//Se convierte la fecha string en fecha date	
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
					Date fechaDate = simpleDateFormat.parse(fecha);
					return fechaDate;
				}else{
					logger.error(CONSTANTE_ERROR_PARSE);
					return null;
				}
			}else{
				logger.error(CONSTANTE_ERROR_PARSE);
				return null;			
			}
		}
		catch (ParseException _e) {
	
			logger.error(CONSTANTE_ERROR_PARSE);
			return null;
		}		
	}
	
	
	public static  String formalizarNombreDocumento(String strNombre){
		StringBuilder stbResult = null;
		String[] strNombres = null;		
		
		stbResult = new StringBuilder();
		if (strNombre!=null && strNombre.indexOf(".")>0){
			strNombres = strNombre.split("\\.");
			if (strNombres.length>2){
				for (int i = 0; i < (strNombres.length-1); i++) {
					if (i>0){
						stbResult.append("_");
					}
					stbResult.append(strNombres[i]);
				}
				stbResult.append("."+strNombres[strNombres.length-1]);
			}
		}
		if (stbResult.length()<=0){
			stbResult.append(strNombre);
		}
		return stbResult.toString();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(formatoFechaHoraSistema());
		System.out.println(obtenerMinDifconFechSistema("20130703101354"));
	}
	
	
	
	/**
	 * Retorna un importe formateado con puntos y comas.
	 * 
	 * @param strImporte
	 *            nif a validar.
	 * @return String.
	 */
	public static String obtenerNombreMes(String strMes,String strIdioma) {
		int intMes = Integer.parseInt(strMes);
		String[] aryMeses = {"","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		String[] aryMesesCat = {"","Gener","Febrer","Març","Abril","Maig","Juny","Juliol","Agost","Setembre","Octubre","Novembre","Desembre"};
		String strNomMes = "";
		
		if(null != strIdioma && !("").equals(strIdioma) && ((strIdioma).equals(Constantes.CONSTANTE_IDIOMA_CA) || (strIdioma.toLowerCase()).equals(Constantes.CONSTANTE_IDIOMA_CA) )){
			strNomMes = aryMesesCat[intMes];
		}else{
			strNomMes = aryMeses[intMes];
		}
		
		return strNomMes;
	}
	
	 /**
		 * @param fecha Fecha a formatear
		 * @return La fecha con formato entero (yyyyMMdd)
		 */
		public static Calendar obtenerCalendarFormateada(String fecha, String formato){
			Calendar calendar = null;
			try{
				
				//Si la fecha no es nula se formatea 
				if (fecha != null){
					if (!(fecha.equals(""))){
						//Se convierte la fecha string en fecha date	
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
						calendar = Calendar.getInstance();
						Date fechaDate = simpleDateFormat.parse(fecha);						
						 
						calendar.setTime(fechaDate);

						return calendar;
					}else{
						logger.error(CONSTANTE_ERROR_PARSE);
						return null;
					}
				}else{
					logger.error(CONSTANTE_ERROR_PARSE);
					return null;			
				}
			}
			catch (ParseException _e) {
		
				logger.error(CONSTANTE_ERROR_PARSE);
				return null;
			}		
		}
		

		/**
		 * @param fecha Fecha a formatear
		 * @return La fecha con formato entero ()
		 */
		public static long obtenerFechaEnMilisegundosBSF(String fecha, String strFormato){
			long result=0;
			try{
				
				//Si la fecha no es nula se formatea 
				if (fecha != null){
					if (!(fecha.equals(""))){
						//Se convierte la fecha string en fecha date	
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormato);
						Date fechaDate = simpleDateFormat.parse(fecha);
						result = fechaDate.getTime();
					}else{
						logger.error(CONSTANTE_ERROR_PARSE);
						
					}
				}else{
					logger.error(CONSTANTE_ERROR_PARSE);
						
				}
			}
			catch (ParseException _e) {
		
				logger.error(CONSTANTE_ERROR_PARSE);
				
			}		
			
			return result;	
		}
		
		//MIGRACION
		
		public static String obtenerIdioma(String strIdiomaUp){
			String strResult = null;
			try {
				if (strIdiomaUp!=null){
					strIdiomaUp = strIdiomaUp.toUpperCase();
					if (CONSTANTE_IDIOMA_CASTELLANO.equals(strIdiomaUp) || CONSTANTE_IDIOMA_CASTELLANO_2.indexOf(strIdiomaUp)>=0){
						strResult = CONSTANTE_IDIOMA_CASTELLANO;
					} else if (strIdiomaUp.indexOf(CONSTANTE_IDIOMA_CATALAN_3)>=0 || CONSTANTE_IDIOMA_CATALAN.equals(strIdiomaUp) || CONSTANTE_IDIOMA_CATALAN_2.indexOf(strIdiomaUp)>=0){
						strResult = CONSTANTE_IDIOMA_CATALAN;
						} else if (CONSTANTE_IDIOMA_INGLES.equals(strIdiomaUp) || CONSTANTE_IDIOMA_INGLES_2.indexOf(strIdiomaUp)>=0){
							strResult = CONSTANTE_IDIOMA_INGLES;
						} else {
							strResult = CONSTANTE_IDIOMA_CASTELLANO;
						}
				}
			} catch (Exception e) {
				Utilidades.escribirLogException(e, logger, Utilidades.class.getName(), "obtenerIdioma");
			}
			return strResult;
		}
		
		public static Map obtenerMap(Object object){
			String strAtributo = null;
			String strNombreCampo = null;
			Map map = new HashMap();
			Field[] fields = object.getClass().getDeclaredFields();
			
			try {
				if (fields!= null){
					for (int i = 0; i < fields.length; i++) {
						strAtributo = fields[i].getName();
						if (!"serialVersionUID".equals(strAtributo)){
						
							
							strNombreCampo = strAtributo;
							strNombreCampo = "get"
							+ strNombreCampo.substring(0, 1).toUpperCase()
							+ strNombreCampo.substring(1, strNombreCampo
									.length());
							Class[] TipoClasses2 = {};
				
							Method method2 = object.getClass().getMethod(strNombreCampo,TipoClasses2);
					
							Object[] objects2 = {};
							
							if (method2.getReturnType() == Integer.class) {
								Integer intDato = (Integer) method2.invoke(object, objects2);
								map.put(strAtributo, intDato);
								} 
							if (method2.getReturnType() == String.class) {
								String strDato = (String) method2.invoke(object, objects2);
								map.put(strAtributo, strDato);			
							}
							if (method2.getReturnType() == Float.class) {
								Float fltDato = (Float) method2.invoke(object, objects2);
								map.put(strAtributo, fltDato);			
							}
							if (method2.getReturnType() == Double.class) {
								Double dblDato = (Double) method2.invoke(object, objects2);
								map.put(strAtributo, dblDato);		
							}						
							if (method2.getReturnType() == List.class) {
								List lstDato = (List) method2.invoke(object, objects2);
								map.put(strAtributo, lstDato);		
							}
						}
				}
			}
			} catch (Exception e) {
				Utilidades.escribirLogException(e, logger, Utilidades.class.getName(), CONSTANTE_METHOD_OBTENERMAP);
			} 
			
			return map;		
		}
		 //Sumarle dias a una fecha determinada
	    //@param fch La fecha para sumarle los dias
	    //@param dias Numero de dias a agregar
	    //@return La fecha agregando los dias
	    public static Date sumarFechasDias(Date fch, int dias) {
	        Calendar cal = new GregorianCalendar();
	        cal.setTimeInMillis(fch.getTime());
	        cal.add(Calendar.DATE, dias);
	        return new Date(cal.getTimeInMillis());
	    }
	    public static synchronized Date restarFechasDias(Date fch, int dias) {
	        Calendar cal = new GregorianCalendar();
	        cal.setTimeInMillis(fch.getTime());
	        cal.add(Calendar.DATE, -dias);
	        return new Date(cal.getTimeInMillis());
	    }
	    
	    
	    public static String obtenerTokenSeguimiento (String strUsuario){
	    	String strSegToken = null;
	    	try {
	    		strSegToken = ""+System.currentTimeMillis();
	    		strSegToken = strSegToken+(strUsuario!=null && strUsuario.length()>0?strUsuario:Constantes.CONSTANTE_USUARIO_PUBLICO);
	    		
			} catch (Exception e) {
				Utilidades.escribirLogException(e, logger, Utilidades.class.getName(), "obtenerTokenSeguimiento");
			}
	    	return strSegToken;
	    }
	    
	
	
	
	
		//Borra los 
		 public static boolean borrarArchivoDirectorio(String direccion, long DiasCaducidad) {
		       
		        File directorio = new File(direccion);
		        File f;
		        String archivo = null;
		        boolean isBorrado = false;
		        int numFich = 0;
		        if (directorio.isDirectory()) {
		            String[] files = directorio.list();
		            Utilidades.escribirLogInfo(logger, Utilidades.class.getName(), "borrarArchivoDirectorio", "Nombre directorio: " + directorio.getAbsolutePath());
		            if (files.length > 0) {
		                Utilidades.escribirLogInfo(logger, Utilidades.class.getName(), "borrarArchivoDirectorio", "Nº de ficheros: " + files.length);		               
		                for (int i =0; i < files.length;i++) {
		                	archivo = files[i];
		                    
		                    f = new File(direccion + File.separator + archivo);
		                    if (f.isFile()){
			                    Utilidades.escribirLogInfo(logger, Utilidades.class.getName(), "borrarArchivoDirectorio",  "Borrado fichero: " + archivo + ", Ultima modificación: "+ new Date(f.lastModified()));
			                   
			                    long Time;
			                    Time = (System.currentTimeMillis() - f.lastModified());
			                    long cantidadDia = (Time / 86400000);
			                    Utilidades.escribirLogInfo(logger, Utilidades.class.getName(), "borrarArchivoDirectorio", "Nombre fichero: " + archivo + ", Age of the file is:  "+ cantidadDia + " days");
			                    // Attempt to delete it
			                    //86400000 ms is equivalent to one day
			                    if (cantidadDia > DiasCaducidad) {		                    			                      
			                        Utilidades.escribirLogInfo(logger, Utilidades.class.getName(), "borrarArchivoDirectorio",  "Nombre fichero: " + archivo);
			                        f.delete();
			                        f.deleteOnExit();
			                        numFich++;	
			                        isBorrado = true;
			                    } else {
			                    	//Es cuando uno de los ficheros no se ha borrado
			                    	isBorrado = false;
			                    }
			                 } else {
			                	 if (borrarArchivoDirectorio(f.getAbsolutePath(), DiasCaducidad)){
			                		 Utilidades.escribirLogInfo(logger, Utilidades.class.getName(), "borrarArchivoDirectorio",  "Nombre fichero: " + archivo);
			                        f.delete();
			                        f.deleteOnExit();			                        
			                        numFich++;
			                        isBorrado = true;
			                        } else {
			                        	isBorrado = false;
			                        }
			                 }

		                }
		                Utilidades.escribirLogInfo(logger, Utilidades.class.getName(), "borrarArchivoDirectorio", "Nº de ficheros eliminados: " + numFich);
		            } else {
		            	Utilidades.escribirLogInfo(logger, Utilidades.class.getName(), "borrarArchivoDirectorio", "Directorio vacio: " + directorio.getAbsolutePath());
		            }
		        } else {
		        	Utilidades.escribirLogInfo(logger, Utilidades.class.getName(), "borrarArchivoDirectorio", "No existe el directorio: " + directorio.getAbsolutePath());
		        }
		        return isBorrado;
		    }
		 /**
			 * 	 Esta función escribe en el log, cuando en necesario un comentario
			 *   @param log 
			 *   @param strClase 
			 *   @param strMetodo
			 *   @param strMensaje  
			 */
			public static void escribirLogWarn(Logger log, String strClase, String strMetodo, String strMensaje){
				StringBuilder stbMensaje = new StringBuilder();		
				
				stbMensaje.append(Constantes.CONSTANTE_CLASE);
				stbMensaje.append(strClase);
				stbMensaje.append(Constantes.CONSTANTE_METODO);
				stbMensaje.append(strMetodo);
				stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
				stbMensaje.append(strMensaje);		
				log.warn(stbMensaje.toString());
			}
			
			
			
			//Funcion del proyecto WSBSFincom
			public static long obtenerFechaEnMilisegundosWSBSF(String fecha, String strFormato){
				long result=0;
				int segundos = 0;
				try{
					
					//Si la fecha no es nula se formatea 
					if (fecha != null){
						if (!(fecha.equals(""))){
							//Se convierte la fecha string en fecha date	
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormato);
							Date fechaDate = simpleDateFormat.parse(fecha);
							result = fechaDate.getTime();
							//Insertamos los segundos en la fecha en ms obtenida, yyyy-MM-dd HH:mm:ss.s
							if (fecha.length()>18){
								segundos = Integer.parseInt(fecha.substring(17,19));
							}
							//
							result = result +(32*1000);
						}else{
							logger.error(CONSTANTE_ERROR_PARSE);
							
						}
					}else{
						logger.error(CONSTANTE_ERROR_PARSE);
							
					}
				}
				catch (ParseException _e) {
			
					logger.error(CONSTANTE_ERROR_PARSE);
					
				}		
				
				return result;	
			}
			public static String obtenerDiaSemana(){
			      String[] dias={"7","1","2", "3","4","5","6"};
			        Date hoy=new Date();
			      int numeroDia=0;
			      Calendar cal= Calendar.getInstance();
			      cal.setTime(hoy);
			      numeroDia=cal.get(Calendar.DAY_OF_WEEK);
			      return  dias[numeroDia - 1];
			    }
			
			public static byte[] getFileBytes(File file) throws IOException {
			    ByteArrayOutputStream ous = null;
			    InputStream ios = null;
			    try {
			        byte[] buffer = new byte[4096];
			        ous = new ByteArrayOutputStream();
			        ios = new FileInputStream(file);
			        int read = 0;
			        while ((read = ios.read(buffer)) != -1)
			            ous.write(buffer, 0, read);
			    } finally {
			        try {
			            if (ous != null)
			                ous.close();
			        } catch (IOException e) {
			            // swallow, since not that important
			        }
			        try {
			            if (ios != null)
			                ios.close();
			        } catch (IOException e) {
			            // swallow, since not that important
			        }
			    }
			    return ous.toByteArray();
			}
			
			
			
		
			/**
			 * 
			 * @param UsuarioVO
			 *            filtro de entrada para settear los valores del usuarioBean.
			 * @return UsuarioBean bean con los datos del usuario.
			 */
			public static void setUsuarioBeanFromVO(UsuarioBean usuarioBean,
					UsuarioVO usuarioVO) {

				if (usuarioVO != null) {
					if (usuarioBean == null) {
						usuarioBean = new UsuarioBean();
					}
					if (usuarioVO.getStrClaseUsuario() != null) {
						usuarioBean.setStrClaseUsuario(usuarioVO.getStrClaseUsuario()
								.trim());
					}
					if (usuarioVO.getStrComercialExt() != null) {
						usuarioBean.setStrComercialExt(usuarioVO.getStrComercialExt()
								.trim());
					}
					if (usuarioVO.getStrComercialInt() != null) {
						usuarioBean.setStrComercialInt(usuarioVO.getStrComercialInt()
								.trim());
					}
					if (usuarioVO.getStrTipo() != null) {
						usuarioBean.setStrTipo(usuarioVO.getStrTipo().trim());
					}
					//El usuario del Tipo Financiero no tiene División, se le tiene que borrar si la lleva.
					//Es necesario este paso para poder permitirle seleccionar una división.
					if (usuarioVO.getStrDivision() != null && !Constantes.CONSTANTE_FINANCIERO.equals(usuarioVO.getStrTipo())) {
						usuarioBean.setStrDivision(usuarioVO.getStrDivision().trim());
					}
					if (usuarioVO.getStrIdPadre() != null) {
						usuarioBean.setStrIdPadre(usuarioVO.getStrIdPadre().trim());
					}
					
					if (usuarioVO.getStrTipoPadre() != null) {
						usuarioBean.setStrTipoPadre(usuarioVO.getStrTipoPadre().trim());
					}
					if (usuarioVO.getStrUsuario() != null) {
						usuarioBean.setStrUsuario(usuarioVO.getStrUsuario().trim());
					}
					if (usuarioVO.getStrUsuarioWeb() != null) {
						usuarioBean.setStrUsuarioWeb(usuarioVO.getStrUsuarioWeb()
								.trim());
					}
					if (usuarioVO.getStrUsuarioSuplantado() != null) {
						usuarioBean.setStrUsuarioSuplantado(usuarioVO
								.getStrUsuarioSuplantado().trim());
					}
					if (usuarioVO.getStrDescripUsu() != null) {
						usuarioBean.setStrDescripUsu(usuarioVO
								.getStrDescripUsu().trim());
					}
					if (usuarioVO.getStrDescripUsuSuplantado() != null) {
						usuarioBean.setStrDescripUsuSuplantado(usuarioVO
								.getStrDescripUsuSuplantado().trim());
					}
					if (usuarioVO.getLstAtribuciones() != null
							&& usuarioVO.getLstAtribuciones().size() != 0) {
						usuarioBean.setLstAtribuciones(usuarioVO.getLstAtribuciones());
					}
				}
			}
			
			 private static final char[] LETRAS_NIF = { 'T', 'R', 'W', 'A', 'G', 'M',
		            'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
		            'L', 'C', 'K', 'E' };
		    public static String generaNif() {
		    	
		        String numeroDNI = String.valueOf(Math.random());
		        String fullDNI = numeroDNI.substring(numeroDNI.length() - 8);

		        int dniInt = Integer.valueOf(fullDNI);
		        fullDNI = fullDNI + LETRAS_NIF[dniInt % 23];
		        return fullDNI;
		    }
		    
		    public static String dameCarpeta(String rutacompleta){
				String rutaSinfichero = null;
				String strResult = null;
				
				try {
					int num =  rutacompleta.lastIndexOf("/");
					Utilidades.escribirLogDebug(logger, Utilidades.class.getName(), "dameCarpeta", "lastIndexOf: "+num);
					rutaSinfichero = rutacompleta.substring(0, rutacompleta.lastIndexOf("/"));
					Utilidades.escribirLogDebug(logger, Utilidades.class.getName(), "dameCarpeta", "rutaSinfichero: "+rutaSinfichero);
					strResult = rutaSinfichero.substring(rutaSinfichero.lastIndexOf("/")+1, rutaSinfichero.length());					
					Utilidades.escribirLogDebug(logger, Utilidades.class.getName(), "dameCarpeta", "rutaSinfichero: "+strResult);
					
				} catch (Exception e) {
					Utilidades.escribirLogException(e, logger, Utilidades.class.getName(), "dameCarpeta - "+rutacompleta);
				}
				return strResult;
			}
		    
		    public static String obtenerServidor(){
				String strIp=null;
				String strServ = null;
				try {
					strIp = Utilidades.obtenerIpServidor();
					if (CONSTANTE_IP_PROD_WS0.equals(strIp)){
						strServ = CONSTANTE_PROD_WS0;
					} else if (CONSTANTE_IP_PROD_WS1.equals(strIp)){
						strServ = CONSTANTE_PROD_WS1;
					} else if (CONSTANTE_IP_PRE.equals(strIp)){
						strServ = CONSTANTE_PRE;
					} else if (CONSTANTE_IP_DES.equals(strIp)){
						strServ = CONSTANTE_DES;
					} else {
						strServ = CONSTANTE_LOCAL;
					}
				} catch (Exception e) {
					Utilidades.escribirLogException(e, logger, Utilidades.class.getName(), "obtenerServidor");
				}
				return strServ;
			}
		    
		    /**
			 * 	 Esta función escribe en el log, cuando en necesario un comentario
			 *   @param log 
			 *   @param strClase 
			 *   @param strMetodo
			 *   @param strMensaje  
			 */
			public static void escribirLogInfoAdicional(Logger log, String strClase, String strMetodo, String strMensaje){
				if (SetUp.isAdicionalLogs()){
					StringBuilder stbMensaje = new StringBuilder();		
					
					stbMensaje.append(Constantes.CONSTANTE_CLASE);
					stbMensaje.append(strClase);
					stbMensaje.append(Constantes.CONSTANTE_METODO);
					stbMensaje.append(strMetodo);
					stbMensaje.append(Constantes.CONSTANTE_MENSAJE);
					stbMensaje.append(strMensaje);		
					stbMensaje.append("#free memory: "+Runtime.getRuntime().freeMemory()/1024+" Kb");
					stbMensaje.append("#max memory: "+Runtime.getRuntime().maxMemory()/1024+" Kb");
					stbMensaje.append("#total memory: "+Runtime.getRuntime().totalMemory()/1024+" Kb");	
					stbMensaje.append("#free total memory: "+(Runtime.getRuntime().freeMemory() + (Runtime.getRuntime().maxMemory()- Runtime.getRuntime().totalMemory()))/1024+" Kb");
					log.info(stbMensaje.toString());
				}
			}
			
			
			public static String formateoImagenes(String rutaImagen, String delimitador)
			{
				String imagen = null;
				
				StringTokenizer st = new StringTokenizer(rutaImagen,delimitador); 
				
				while(st.hasMoreTokens()) 
				{
					String token = st.nextToken().toString();
					
					if(token.contains(Constantes.CONSTANTE_IMAGEN_JPG) || 
					   token.contains(Constantes.CONSTANTE_IMAGEN_PNG) || 
					   token.contains(Constantes.CONSTANTE_IMAGEN_ICO))
					{
						imagen = token;
						break;
					}
				}
				
				return imagen;
			}
			
			
			
			
			
			public static String crearIdCarpeta()
		    {
		        Date fechaHoy = new Date();
		        SimpleDateFormat formatoFechaHoraCompleto = new SimpleDateFormat("yyyyMMddHHmmss");
		        String fechaCreacion = null;
		     
		        fechaCreacion = formatoFechaHoraCompleto.format(fechaHoy);
		        
		        return fechaCreacion;
		    }
			
			public static boolean eliminarCarpetaTemporal(String ruta) throws IOException
			{
				boolean isOk = false;
				File folder = null;
				
				folder = new File(ruta);
				
				if(folder.exists())
				{
					File[] ficheros = folder.listFiles();
					
					for(int i = 0; i < ficheros.length; i++)
					{
						ficheros[i].delete();
					}
				}
				
				return isOk;
			}
			
			public static String formatoFechaSistema (String strFormato){
				
				Date fechaHoy = new Date();
		        SimpleDateFormat formatoFechaHoraCompleto = new SimpleDateFormat(strFormato);
		        String fechaCreacion = null;
		     
		        fechaCreacion = formatoFechaHoraCompleto.format(fechaHoy);
		        
		        return fechaCreacion;
								
			}
}