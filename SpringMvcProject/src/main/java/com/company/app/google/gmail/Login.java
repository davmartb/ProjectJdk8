/**
 * 
 */
package com.company.app.google.gmail;

import com.google.api.Page;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Lists;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.storage.model.Bucket;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Login {
    public static Gmail service = null;
    /**
     * Application name.
     */
    private static final String APPLICATION_NAME =
            "Amail";

    /**
     * Directory to store user credentials for this application.
     */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/Amail");

    /**
     * Global instance of the {@link FileDataStoreFactory}.
     */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY =
            JacksonFactory.getDefaultInstance();

    /**
     * Global instance of the HTTP transport.
     */
    private static HttpTransport HTTP_TRANSPORT;

    /**
     * Global instance of the scopes required by this quickstart.
     * <p>
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/gmail-java-quickstart
     */
    private static final List<String> SCOPES =
            Arrays.asList(GmailScopes.MAIL_GOOGLE_COM);

    static {
        try {
            HTTP_TRANSPORT = new ApacheHttpTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     *
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in =
                Login.class.getResourceAsStream("/liquid-force-215806-34a43f92a5ce.json");
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                        .setDataStoreFactory(DATA_STORE_FACTORY)
                        .setAccessType("offline")
                        .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("me");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    public static Credential  authorize2() throws Exception{
    	
     
    	 GoogleCredential cr = GoogleCredential
                 .fromStream(new FileInputStream("C://desarrollo//Proyectos//datos//dmbproject-216714-9df7ffae0618.json"))
                 .createScoped(SCOPES);
           return new GoogleCredential.Builder()
                 .setTransport(HTTP_TRANSPORT)
                 .setJsonFactory(JSON_FACTORY)
                 .setServiceAccountScopes(SCOPES)
                 .setServiceAccountId(cr.getServiceAccountId())
                 .setServiceAccountPrivateKey(cr.getServiceAccountPrivateKey())
                 .setServiceAccountPrivateKeyId(cr.getServiceAccountPrivateKeyId())
                 .setTokenServerEncodedUrl(cr.getTokenServerEncodedUrl())
                 .setServiceAccountUser("davidmartinb@dmbprojects.net").build();
//            Directory directory = new Directory.Builder(
//                  httpTransport, jsonFactory, builder.build()) 
//                 .setApplicationName(config.getProperty("google.application.name")).build();
    }
    
    
    /**
     * Build and return an authorized Gmail client service.
     *
     * @return an authorized Gmail client service
     * @throws IOException
     */
    public static void startAuthentication() throws Exception {
        Credential credential = authorize2();
        String accestoken = credential.getAccessToken();
        service =  new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
        ListMessagesResponse listMensajes=  service.users().messages().list("me").execute();
        if (listMensajes!=null && !listMensajes.isEmpty() && listMensajes.getMessages()!=null) {
        	for (Iterator iterator = listMensajes.getMessages().iterator(); iterator.hasNext();) {
				Message message = (Message) iterator.next();
				if (message!=null) {
					Message msg= service.users().messages().get("me",  message.getId()).execute();
					System.out.println("punto");
				}
			}
        	
        }
        System.out.println("prueba");
    }
    
    public static void startauthentication3(){
    	try {
			
		
    	 InputStream in =
                 Login.class.getResourceAsStream("/liquid-force-215806-34a43f92a5ce.json");
    		  // You can specify a credential file by providing a path to GoogleCredentials.
    		  // Otherwise credentials are read from the GOOGLE_APPLICATION_CREDENTIALS environment variable.
    		  Credentials  credentials = GoogleCredentials.fromStream(in)
    		        .createScoped(com.google.common.collect.Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
    		  Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
    		  com.google.api.gax.paging.Page<com.google.cloud.storage.Bucket> buckets =  storage.list();
    		  for (com.google.cloud.storage.Bucket bucket : buckets.iterateAll()) {
  		    System.out.println(bucket.toString());
  		  }
    		  
//    		  System.out.println("Buckets:");
//    		  Page<Bucket> buckets = storage.list();
//    		  for (Bucket bucket : buckets.iterateAll()) {
//    		    System.out.println(bucket.toString());
//    		  }
    		
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    public static void startAuthentication2() throws Exception{
    	
    	String CLIENT_SECRET_FILE = "/path/to/client_secret.json";

    	String authCode =null;
    	
    	// Exchange auth code for access token
    	GoogleClientSecrets clientSecrets =
    	    GoogleClientSecrets.load(
    	        JacksonFactory.getDefaultInstance(), new FileReader(CLIENT_SECRET_FILE));
    	GoogleTokenResponse tokenResponse =
    	          new GoogleAuthorizationCodeTokenRequest(
    	              new NetHttpTransport(),
    	              JacksonFactory.getDefaultInstance(),
    	              "https://www.googleapis.com/oauth2/v4/token",
    	              clientSecrets.getDetails().getClientId(),
    	              clientSecrets.getDetails().getClientSecret(),
    	              authCode,
    	              null)  // Specify the same redirect URI that you use with your web
    	                             // app. If you don't have a web version of your app, you can
    	                             // specify an empty string.
    	              .execute();

    	String accessToken = tokenResponse.getAccessToken();
    }
public static void main(String[] args){
    	
    	try {
    		startAuthentication();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    }

    /*public static Gmail getService(){
        return service;
    }
*/
}