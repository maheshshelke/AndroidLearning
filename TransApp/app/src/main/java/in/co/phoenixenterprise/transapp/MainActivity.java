package in.co.phoenixenterprise.transapp;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import in.co.phoenixenterprise.transapp.dao.TransAppDatabase;
import in.co.phoenixenterprise.transapp.entity.Credentials;
import in.co.phoenixenterprise.transapp.events.UserIdChangeWatcher;
import in.co.phoenixenterprise.transapp.services.LoginService;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUserId;
    private EditText editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserId = (EditText)findViewById(R.id.editTextLoginId);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);

        editTextUserId.addTextChangedListener(new UserIdChangeWatcher());

        initDB();
    }

    private void initDB(){


        // insert credentials
        new Thread(new Runnable() {
            @Override
            public void run() {
                Credentials credentials = new Credentials();
                credentials.setId(1);
                credentials.setUserId("mahesh");
                credentials.setPassword("mahesh123");

                try {
                    TransAppDatabase transAppDatabase = TransAppDatabase.getDatabase(getApplicationContext());
                    transAppDatabase.credentialsDao().insertCredentials(credentials);
                }catch (SQLiteException e){
                    Log.e("TransApp", "Exception while inserting record in credentials table. Error: "+e.getMessage());
                }
                Log.d("TransApp","Inserting credentials in db");
            }
        }).start();
    }

    public void loginUserClick(View view){
        String userId = editTextUserId.getText().toString();
        String password = editTextPassword.getText().toString();

        Log.d("TransApp","Trying to login with userId: "+userId+" ,Password: "+password);

        if(LoginService.loginUser(userId,password)){
            Log.d("TransApp","Login successful");
        }else{
            Log.d("TransApp","Login failed");
            Toast.makeText(this, "Login Failed",
                    Toast.LENGTH_LONG).show();
        }
    }
}
