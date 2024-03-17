package com.example.asedu;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN_TIME_OUT = 1500; // After completion of 2000 ms, the next activity will get started.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This method is used so that your splash activity can cover the entire screen.
      /*  getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);*/

        setContentView(R.layout.activity_main); // this will bind your MainActivity.class file with activity_main.

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent is used to switch from one activity to another.
                Intent i = new Intent(MainActivity.this, loginpage.class);
                startActivity(i); // invoke the SecondActivity.
                finish(); // the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}
