package in.co.phoenixenterprise.transapp.services;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

import in.co.phoenixenterprise.transapp.dao.TransAppDatabase;
import in.co.phoenixenterprise.transapp.entity.Credentials;

public class LoginService {

    static Credentials credentials;
    public static boolean loginUser(final String userId, String password){
        boolean result = false;

        new Thread(new Runnable() {
            @Override
            public void run() {
                TransAppDatabase transAppDatabase = TransAppDatabase.getDatabase();
                List<Credentials> credentialsList = Arrays.asList( transAppDatabase
                        .credentialsDao().loadCredentialsOfUserId(userId));

                if(credentialsList.size() > 0){
                    credentials = credentialsList.get(0);
                }

                Log.d("TransApp", "got cred from db : "+credentials);
            }
        }).start();

        if(credentials != null && credentials.getPassword().equals(password)){
            result = true;
        }
        return result;
    }
}
