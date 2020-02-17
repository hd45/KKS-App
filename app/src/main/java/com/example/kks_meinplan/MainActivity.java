package com.example.kks_meinplan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.AGsFragment;
import com.AnkündigungenFragment;
import com.StundenplanFragment;
import com.VertretungsplanFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigatonView = findViewById(R.id.navigation_view);
        setSupportActionBar(toolbar);

        navigatonView.setNavigationItemSelectedListener(this); //select the activated item

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment,
                    new VertretungsplanFragment()).commit();
            navigatonView.setCheckedItem(R.id.nav_vertretungsplan);
        }

        navigatonView.setItemIconTintList(null); //Für die Icon Farben im NavigationView
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);




        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
            getSupportActionBar().setTitle(destination.getLabel());
            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();
        if (id == R.id.nav_einstellungen) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            finish();
        }
        switch (menuItem.getItemId()) {
            case R.id.nav_vertretungsplan:
                getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment,
                        new VertretungsplanFragment()).commit();
                break;
            case R.id.nav_stundenplan:
                getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment,
                        new StundenplanFragment()).commit();
                break;
            case R.id.nav_ankuendigungen:
                getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment,
                        new AnkündigungenFragment()).commit();
                break;
            case R.id.nav_ags:
                getSupportFragmentManager().beginTransaction().replace(R.id.navHostFragment,
                        new AGsFragment()).commit();
                break;
            case R.id.nav_logout:
                AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(this);
                alertDialogBuilder2.setTitle("Logout");
                alertDialogBuilder2
                        .setMessage("Möchtest du dich abmelden?")
                        .setCancelable(false)
                        .setPositiveButton("Abmelden",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        //  moveTaskToBack(true);
                                        i = new Intent(MainActivity.this, StartActivity.class);
                                        startActivity(i);
                                    }
                                })

                        .setNegativeButton("Zurück",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                        dialog.cancel();
                                    }
                                });

                AlertDialog alertDialog = alertDialogBuilder2.create();
                alertDialog.show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("App verlassen");
            alertDialogBuilder
                    .setMessage("Möchtest du die App verlassen?")
                    .setCancelable(false)
                    .setPositiveButton("Ja",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);
                                }
                            })

                    .setNegativeButton("Nein", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }


        //todo 1 alert dialog layout
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}