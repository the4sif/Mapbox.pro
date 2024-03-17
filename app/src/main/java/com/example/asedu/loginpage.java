package com.example.asedu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.asedu.databinding.ActivityLoginpageBinding;


public class loginpage extends AppCompatActivity {


    public ActivityLoginpageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        binding = ActivityLoginpageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent is used to switch from one activity to another.
                Intent i = new Intent(loginpage.this, Universitysel.class);
                startActivity(i); // invoke the SecondActivity.
                finish(); // the current activity will get finished.
            }


        });


    }


}