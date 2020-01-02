package com.example.kks_meinplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;

public class EinstellungenActivity extends AppCompatActivity {

    SwitchCompat switch_1, switch_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);


        switch_1 = (SwitchCompat) findViewById(R.id.switch_1);
        switch_2 = (SwitchCompat) findViewById(R.id.switch_2);
    }
}
