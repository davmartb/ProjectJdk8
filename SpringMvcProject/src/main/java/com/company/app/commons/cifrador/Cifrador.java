package com.company.app.commons.cifrador; 

import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.company.app.commons.Utilidades;



/**
 * <p>Nombre Clase: Cifrador</p>
 * <p>Descripcion</p>
 * <p>Metodos de la clase</p>
 * @author A161496 - ATOS Origin
 * 
 * @d29/07/2011
 */ 
 
public class Cifrador {
	
	public static String encriptar(String passPhrase, String str, String entidad) {
		return getCifrador(passPhrase, entidad).encrypt(str);
	}
	public static String desencriptar(String passPhrase, String str,String entidad) {
		 return getCifrador (passPhrase, entidad).decrypt(str);
	}
	
	protected static final Logger logger = Logger.getLogger(Cifrador.class);

	private static final String CONSTANTE_KEY_CLAVE = "cifrador.clave.";
	
	private static final String CONSTANTE_RUTA_CIFRADOR_PROPERTIES = "cifrador.properties";
	
	private static final String ALGORITMO_ENCRIPTACION = "PBEWITHSHAAND3-KEYTRIPLEDES-CBC";
	//
	private static final String METHOD_CIFRADOR ="Cifrador";
	
	private static final String METHOD_ENCRIPT ="encrypt";
	
	private static final String METHOD_DECRIPT ="decrypt";
	
	// 8-bytes Salt
	private static byte[] SALT_BYTES = {
	  (byte)0xA2, (byte)0x98, (byte)0xC8, (byte)0x12,
	  (byte)0x46, (byte)0xA1, (byte)0xE9, (byte)0x13
	};
	
	// Iteration count
    private static int ITERATION_COUNT = 19;
	
	Cipher ecipher;
	Cipher dcipher;
	
	private static Provider bouncy = null;
	
	
	
	public static Provider getBouncy() {
		return bouncy;
	}
	public static void setBouncy(Provider bouncy) {
		Cifrador.bouncy = bouncy;
	}
	private Cifrador (String passPhrase, String alg, String entidad) {
		try {
			// Crear la key
			String clave = "fNLBEMGxm2Cm05W8j7nejMm08fJobYTv";
			//String clave = null;
			
			if (entidad!= null){
				//clave = Utilidades.obtenerValorFicheroProperties(CONSTANTE_KEY_CLAVE+entidad, CONSTANTE_RUTA_CIFRADOR_PROPERTIES);
			}
			if (clave!=null){
//				
	//	        System.out.println("Algoritmo: "+ALGORITMO_ENCRIPTACION);
	//	        System.out.println("salt: "+SALT_BYTES.toString());
	//	        System.out.println("clave: "+ clave);
		        KeySpec keySpec = new PBEKeySpec(clave.toCharArray(), SALT_BYTES, ITERATION_COUNT);
			
			    SecretKey key = SecretKeyFactory.getInstance(alg, bouncy).generateSecret(keySpec);
				ecipher = Cipher.getInstance(alg,bouncy);
				dcipher = Cipher.getInstance(alg,bouncy); 
				
				AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT_BYTES, ITERATION_COUNT);
	
				ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
				dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
			}
		} catch (Exception e) {
			Utilidades.escribirLogException(e, logger, this.getClass().getName(), METHOD_CIFRADOR);
		}		
	}
	
	public static final Cifrador getCifrador(String passPhrase, String entidad) {
		return new Cifrador (passPhrase, ALGORITMO_ENCRIPTACION, entidad);
	}
	
	private String encrypt(String str) {
		try {
			if (ecipher != null){
				// Encode the string into bytes using utf-8
				byte[] utf8 = str.getBytes("UTF8");
	
				// Encrypt
				byte[] enc = ecipher.doFinal(utf8);
	
				// Encode bytes to base64 to get a string
				return new String (Base64.getEncoder().encode(enc));
			}

		} catch (Exception e) {
			Utilidades.escribirLogException(e, logger, this.getClass().getName(), METHOD_ENCRIPT);
		}
		return null;
	}
	private String decrypt(String str) {

		try {
			if (dcipher!= null){
				// Decode base64 to get bytes
				byte[] dec = Base64.getDecoder().decode(str);
	
				// Decrypt
				byte[] utf8 = dcipher.doFinal(dec);
	
				// Decode using utf-8
				return new String(utf8, "UTF8");
			}
		} catch (Exception e) {
			Utilidades.escribirLogException(e, logger, this.getClass().getName(), METHOD_DECRIPT);
		}
		return null;
	}

	public static void main(String[] args) {

//		Provider[] provs = Security.getProviders();
//		for (int i = 0; i < provs.length; i++) {
//			Iterator it = provs[i].keySet().iterator();
//			while (it.hasNext()) {
//				String key = (String) it.next();
//				if (key.startsWith("Alg.Alias.SecretKeyFactory")) {
//					System.out.println(key.substring(27));
//				} else if (key.startsWith("SecretKeyFactory")) {
//					System.out.println(key.substring(17));
//				}
//			}
//		}
		BouncyCastleProvider provider = new BouncyCastleProvider();
		
			Cifrador.setBouncy(provider);
				
			String entidad =  "VIVANTA";
			System.out.println("Entidad:   "+entidad);
			//System.out.println("Clave Pre:   "+Utilidades.obtenerValorFicheroProperties(CONSTANTE_KEY_CLAVE+entidad, CONSTANTE_RUTA_CIFRADOR_PROPERTIES));
			System.out.println("******************************************************************************");
			imprimirDatosUsuarios("ws45622001", "WS3RV1", entidad);
			System.out.println("******************************************************************************");
			imprimirDatosUsuarios("ws45622004", "WS3RV1", entidad);
			
		
					
			
			
			
		}
	
	public static void imprimirDatosUsuarios(String strUsuario, String strPassword, String entidad){
		
		if (strUsuario!=null){
			System.out.println("Datos Usuario:   "+strUsuario);
			imprimirDatosEncriptados(strUsuario, entidad);
			System.out.println("------------------------------------------------------------------------------");
		}
		if (strPassword!=null){
			System.out.println("Datos Password:   "+strPassword);
			imprimirDatosEncriptados(strPassword, entidad);
			System.out.println("------------------------------------------------------------------------------");
		}
	}
	
	public static void imprimirDatosEncriptados(String cad, String entidad){
		if (cad!=null){
			System.out.println("Cadena Original:   "+cad);			
			String cadena_cif = Cifrador.encriptar(null, cad, entidad);
			System.out.println("Cadena Cifrada: "+cadena_cif);
			
			String cadena_original = Cifrador.desencriptar(null,cadena_cif,entidad);

			System.out.println("Cadena restaurada: "+cadena_original);
			
			String strHex = HexSupport.byteArrayToHexString(Base64.getDecoder().decode(cadena_cif));
			
			System.out.println("Cadena hEX: "+strHex);
		}
	}
}

