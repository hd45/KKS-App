package com.example.kks_meinplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {
    SwitchCompat switch1;
    SwitchCompat switch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        findViewById(R.id.toolbar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Einstellungen");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Zurückknopf
        //todo onRestart für MainActivity hat nicht geklappt, Lösung finden!

        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);


        SharedPreferences preferences = getSharedPreferences("save", MODE_PRIVATE);
        switch1.setChecked(preferences.getBoolean("value", true));


        //Die Switches
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch1.isChecked()){

                    SharedPreferences.Editor editor  = getSharedPreferences("save",
                            MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    switch1.setChecked(true);
                }else {
                    SharedPreferences.Editor editor  = getSharedPreferences("save",
                            MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    switch1.setChecked(false);
                }
            }


        });

        SharedPreferences preferences2 = getSharedPreferences("save2", MODE_PRIVATE);
        switch2.setChecked(preferences2.getBoolean("value2", true));

        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch2.isChecked()){

                    SharedPreferences.Editor editor  = getSharedPreferences("save2",
                            MODE_PRIVATE).edit();
                    editor.putBoolean("value2", true);
                    editor.apply();
                    switch2.setChecked(true);
                }else {
                    SharedPreferences.Editor editor  = getSharedPreferences("save2",
                            MODE_PRIVATE).edit();
                    editor.putBoolean("value2", false);
                    editor.apply();
                    switch2.setChecked(false);
                }
            }


        });
    }
}
