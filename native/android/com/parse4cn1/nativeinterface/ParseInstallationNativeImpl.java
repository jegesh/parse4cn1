package com.parse4cn1.nativeinterface;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.codename1.impl.android.AndroidNativeUtil;

public class ParseInstallationNativeImpl {
<<<<<<< HEAD
    public void initialize(String applicationId, String clientKey, String parseUrl) {
        Parse.initialize(new Parse.Configuration.Builder(AndroidNativeUtil.getActivity().getApplicationContext())
            .applicationId(applicationId)
            .clientKey(clientKey)
            .server(parseUrl) // Note: Url needs to have a trailing slash 
            .build()
        );
    }
    
    public String getObjectId() {
        ParseInstallation currentInstallation = ParseInstallation.getCurrentInstallation();
        return currentInstallation.getObjectId();
    }

    public String getInstallationId() {
         String installationId = null;
        
        // Save to make sure that the installation can (immediately) be retrieved from Parse by the caller using the installationId
        
=======
    public void initialize(String apiEndPoint, String applicationId, String clientKey) {
        String endPoint = apiEndPoint;
        if (endPoint != null && !endPoint.endsWith("/")) {
            endPoint += "/"; // Note: Url needs to have a trailing slash 
        }
        
        Parse.initialize(new Parse.Configuration.Builder(AndroidNativeUtil.getActivity())
            .applicationId(applicationId)
            .clientKey(clientKey)
            .server(endPoint)
            .build()
        );
    }

    public String getInstallationObjectId() {
        String objectId = null;
        
        // Save to make sure that the installation can (immediately) be retrieved from Parse by the caller using the installationId
>>>>>>> 669bad087a5af33962c2370033d7960b724f8fd5
        ParseInstallation currentInstallation = ParseInstallation.getCurrentInstallation();
        
        // Installation could be null
        // See: https://github.com/ParsePlatform/Parse-SDK-Android/blob/master/Parse/src/main/java/com/parse/ParseInstallation.java
        if (currentInstallation != null) {
<<<<<<< HEAD
            currentInstallation.saveInBackground(); // Avoid blocking; caller will take this into account and retry if needed
            installationId = currentInstallation.getInstallationId();
        }
        
        return installationId;
=======
            // Note: The first time this method is called, the installation is created on the fly
            // and needs to be saved. Other times, this save operation is redundant/without side effects
            currentInstallation.saveInBackground(); // Avoid blocking; caller will take this into account and retry if needed
            objectId = currentInstallation.getObjectId();
        }
        
        return objectId;
>>>>>>> 669bad087a5af33962c2370033d7960b724f8fd5
    }

    public boolean isSupported() {
        return true;
    }

}
