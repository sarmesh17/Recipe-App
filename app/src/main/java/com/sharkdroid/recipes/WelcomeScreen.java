package com.sharkdroid.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Button getStarted=findViewById(R.id.getStarted);

        getStarted.setOnClickListener(v -> {

            Intent intent=new Intent(WelcomeScreen.this, login_signup.class);
            startActivity(intent);


        });



    }
}
