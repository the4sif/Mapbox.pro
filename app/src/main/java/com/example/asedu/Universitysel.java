package com.example.asedu;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class Universitysel extends AppCompatActivity {

    private MeowBottomNavigation bottomNavigation;
    private FragmentManager fragmentManager;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_universitysel);

        fragmentManager = getSupportFragmentManager ();

        bottomNavigation = findViewById (R.id.bottomNavigation);

        replaceFragment (new home ());

        bottomNavigation.add (new MeowBottomNavigation.Model (2, R.drawable.fav));
        bottomNavigation.add (new MeowBottomNavigation.Model (1, R.drawable.home));
        bottomNavigation.add (new MeowBottomNavigation.Model (3, R.drawable.profile));


        bottomNavigation.setOnClickMenuListener (new Function1<MeowBottomNavigation.Model, Unit> () {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                int itemId = model.getId ();
                if (itemId == 1) {
                    replaceFragment (new home ());
                } else if (itemId == 2) {
                    replaceFragment (new Favorite ());
                } else if (itemId == 3) {
                    replaceFragment (new profile ());
                }
                return null;
            }
        });
        bottomNavigation.show (1, true);

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById (R.id.drawerlayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle (this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener (actionBarDrawerToggle);
        actionBarDrawerToggle.syncState ();

        Toolbar toolbar = findViewById (R.id.custom_toolbar);
        setSupportActionBar (toolbar);
        Objects.requireNonNull (getSupportActionBar ()).setDisplayHomeAsUpEnabled (false);

        // to make the Navigation drawer icon always appear on the action bar

        ImageButton navibtn = findViewById (R.id.navigation);
        ImageButton naviprofile = findViewById (R.id.navprofile);

        //Navigation Controller

        NavigationView navigationView = findViewById (R.id.navigationview);

        navigationView.setNavigationItemSelectedListener (item -> {
            int itemId = item.getItemId ();
            if (itemId == R.id.notes) {
                // Perform action for menu item 1
                // Example: start a new activity
                startActivity (new Intent (this, notes.class));
                // Example: open a fragment
                Toast.makeText(this, "Notes", Toast.LENGTH_SHORT).show();
            } else if (itemId == R.id.course) {
                // Perform action for menu item 2
                // Example: open a fragment
                startActivity (new Intent (this, course.class));
                Toast.makeText(this, "Course", Toast.LENGTH_SHORT).show();
            }else if (itemId == R.id.internal) {
                // Perform action for menu item 2
                // Example: open a fragment
                Toast.makeText(this, "Internal", Toast.LENGTH_SHORT).show();
            }

            // Close the drawer after handling the selection
            drawerLayout.closeDrawer (GravityCompat.START);

            return true; // Return true to indicate the selection was handled
        });

        navibtn.setOnClickListener (view -> {
            // Handle navigation drawer icon click
            if (drawerLayout.isDrawerOpen (GravityCompat.START)) {
                drawerLayout.closeDrawer (GravityCompat.START);
            } else {
                drawerLayout.openDrawer (GravityCompat.START);
            }
        });

        naviprofile.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                bottomNavigation.setVisibility(View.GONE);
                replaceFragment (new profile ());
            }

        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction ();
        transaction.replace (R.id.framelayout, fragment);
        transaction.commit ();
    }

    @Override
    public void onBackPressed() {
        // Perform your custom actions here if needed

        // Navigate back to a specific activity using Intent
        Intent intent = new Intent (this, loginpage.class);
        startActivity (intent);
        // Call finish to close the current activity if you don't want to keep it in the back stack
        finish ();
    }
}
