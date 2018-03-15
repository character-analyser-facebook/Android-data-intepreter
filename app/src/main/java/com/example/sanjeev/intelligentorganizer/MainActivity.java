package com.example.sanjeev.intelligentorganizer;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.FacebookSdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private TextView displayContent;
    private Button settingsButton;

    private String firstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*logKeyHash();
         */

        SingletonCredentials.getSingletonCredentials();

        displayContent = findViewById(R.id.display_content);
        settingsButton = findViewById(R.id.settings_button);

        settingsButton.setOnClickListener(settingListener);

        if(SingletonCredentials.isFbLoggedIn()) {
            firstName = SingletonCredentials.getUserName();
            displayContent.setText(firstName);
        }
    }

    View.OnClickListener settingListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        }
    };


    public void logKeyHash()
    {
        try{
            PackageInfo packageInfo = getPackageManager().getPackageInfo("com.example.sanjeev.intelligentorganizer", PackageManager.GET_SIGNATURES);
            for (Signature signature : packageInfo.signatures)
            {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("Key Hash:", Base64.encodeToString(md.digest(),Base64.DEFAULT));
            }
        }
        catch (PackageManager.NameNotFoundException e) {
        }
        catch (NoSuchAlgorithmException e){
        }
    }

}
