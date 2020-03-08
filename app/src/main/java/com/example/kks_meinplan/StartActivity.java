package com.example.kks_meinplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    EditText passwort;
    Button anmelden;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        passwort = findViewById(R.id.passwort);
        anmelden = findViewById(R.id.anmelden);

        anmelden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = passwort.getText().toString();
                if (!code.equals("")) {
                    for (int i = 0; i < Database.codes.length; i++) {
                        if (code.equals(Database.codes[i])) {
                            //enter the app
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(StartActivity.this, "Herzlich Willkommen", Toast.LENGTH_SHORT).show();
                            break;
                        } else {
                            if (i == (Database.codes.length - 1) && !code.equals(Database.codes[i])) {
                                Toast.makeText(StartActivity.this, "Falsches Passwort. Bitte versuche es erneut", Toast.LENGTH_SHORT).show();
                                break;
                            }
                        } //end else
                    } //end for
                } //end if
            }
        });
    }

    public void onClick(View v) {
        openMainactivity();
        finish();
    }


    public void openMainactivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //App verlassen nach dem Klicken Zurück
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        // todo stop activity after closing the app bcs splash screen doesn't show after opening the app 2. time
    }
}