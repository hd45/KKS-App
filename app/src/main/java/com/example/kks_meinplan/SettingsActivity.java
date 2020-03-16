package com.example.kks_meinplan;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity{
    SwitchCompat switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Einstellungen");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        switch1 = findViewById(R.id.switch1);


        SharedPreferences preferences = getSharedPreferences("save", MODE_PRIVATE);
        switch1.setChecked(preferences.getBoolean("value", true));


        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch1.isChecked()) {

                    SharedPreferences.Editor editor = getSharedPreferences("save",
                            MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    switch1.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save",
                            MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    switch1.setChecked(false);
                }
            }


        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

        /*if (savedInstances == null){
            getSupportFragmentManager().beginTransaction().replace()
        }*/
    }

    //todo go to last opened fragment after returning from settingsActivity
}
