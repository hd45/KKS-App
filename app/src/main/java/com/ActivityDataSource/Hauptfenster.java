package com.ActivityDataSource;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kks_meinplan.R;

public class Hauptfenster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);
        Button lesenBtn = (Button) findViewById(R.id.lesenBtn);
        lesenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ActivityDataSource(textView).execute("someParams");
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu); // todo hier nicht sicher: menu oder drawer menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_vertretungsplan) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}