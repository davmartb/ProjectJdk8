/**
 * 
 */
package com.company.app.google.gmail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;

import org.apache.taglibs.standard.lang.jstl.PlusOperator;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.plus.Plus;
import com.google.api.services.plus.PlusScopes;
import com.google.common.io.Files;


/**
 * @author david
 *
 */
public class GoogleAccess {

	 /**
	   * Be sure to specify the name of your application. If the application name is {@code null} or
	   * blank, the application will log a warning. Suggested format is "MyCompany-ProductName/1.0".
	   */
	  private static final String APPLICATION_NAME = "";
	  
	  /** E-mail address of the service account. */
	  private static final String SERVICE_ACCOUNT_EMAIL = "Enter service account e-mail from "
	      + "https://code.google.com/apis/console/?api=plus into SERVICE_ACCOUNT_EMAIL in "
	      + GoogleAccess.class;

	  /** Global instance of the HTTP transport. */
	  private static HttpTransport httpTransport;

	  /** Global instance of the JSON factory. */
	  private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	  private static Plus plus;
	  
	  public static void main(String[] args) {
	  try {
		GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream("D:\\desarrollo\\Proyectos\\datos\\My Project-fe62d8b17911.json"))
				    .createScoped(Collections.singleton("https://mail.google.com/"));
		
		plus = new Plus.Builder(httpTransport, JSON_FACTORY, credential)
	    .setApplicationName(APPLICATION_NAME).build();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  }
	  

//	  public static void main(String[] args) {
//	    try {
//	      try {
//	        httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//	        // check for valid setup
//	        if (SERVICE_ACCOUNT_EMAIL.startsWith("Enter ")) {
//	          System.err.println(SERVICE_ACCOUNT_EMAIL);
//	          System.exit(1);
//	        }
//	        String pJsonContent = Files.readFirstLine(new File("D:\\desarrollo\\Proyectos\\datos\\My Project-fe62d8b17911.json"), Charset.defaultCharset());
//	        if (pJsonContent.startsWith("Please")) {
//	          System.err.println(pJsonContent);
//	          System.exit(1);
//	        }
//	        // service account credential (uncomment setServiceAccountUser for domain-wide delegation)
//	        GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
//	            .setJsonFactory(JSON_FACTORY)
//	            .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
//	            //.setServiceAccountScopes(Collections.singleton(Plus))
//	            .setServic(new File("D:\\desarrollo\\Proyectos\\datos\\My Project-fe62d8b17911.json"))
//	            // .setServiceAccountUser("user@example.com")
//	            .build();
//	        // set up global Plus instance
//	        plus = new Plus.Builder(httpTransport, JSON_FACTORY, credential)
//	            .setApplicationName(APPLICATION_NAME).build();
//	        // run commands
//	        getActivity();
//	        // success!
//	        return;
//	      } catch (IOException e) {
//	        System.err.println(e.getMessage());
//	      }
//	    } catch (Throwable t) {
//	      t.printStackTrace();
//	    }
//	    System.exit(1);
//	  }

//	  /** Get an activity for which we already know the ID. */
//	  private static void getActivity() throws IOException {
//	    // A known public activity ID
//	    String activityId = "z12gtjhq3qn2xxl2o224exwiqruvtda0i";
//	    // We do not need to be authenticated to fetch this activity
//	    View.header1("Get an explicit public activity by ID");
//	    Activity activity = plus.activities().get(activityId).execute();
//	    View.show(activity);
//	  }
}
