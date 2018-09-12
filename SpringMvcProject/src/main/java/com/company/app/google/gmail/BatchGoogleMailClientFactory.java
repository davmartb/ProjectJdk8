/**
 * 
 */
package com.company.app.google.gmail;

/**
 * @author david
 *
 */

import java.util.Collection;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.Gmail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BatchGoogleMailClientFactory  {
    private static final Logger LOG = LoggerFactory.getLogger(BatchGoogleMailClientFactory.class);
    private NetHttpTransport transport;
    private JacksonFactory jsonFactory;

    public BatchGoogleMailClientFactory() {
        this.transport = new NetHttpTransport();
        this.jsonFactory = new JacksonFactory();
    }

    
    public Gmail makeClient(String clientId, String clientSecret, Collection<String> scopes, String applicationName, String refreshToken, String accessToken) {
        Credential credential;
        try {
            credential = authorize(clientId, clientSecret, scopes);

            if (refreshToken != null && !"".equals(refreshToken)) {
                credential.setRefreshToken(refreshToken);
            }
            if (accessToken != null && !"".equals(accessToken)) {
                credential.setAccessToken(accessToken);
            }
            return new Gmail.Builder(transport, jsonFactory, credential).setApplicationName(applicationName).build();
        } catch (Exception e) {
            LOG.error("Could not create Google Drive client.", e);
        }
        return null;
    }

    // Authorizes the installed application to access user's protected data.
    private Credential authorize(String clientId, String clientSecret, Collection<String> scopes) throws Exception {
        // authorize
        return new GoogleCredential.Builder().setJsonFactory(jsonFactory).setTransport(transport).setClientSecrets(clientId, clientSecret).build();
    }
    
   
    
    public void main(String[] args){
    	
    	BatchGoogleMailClientFactory bacth = new BatchGoogleMailClientFactory();
    	
 
    }
}