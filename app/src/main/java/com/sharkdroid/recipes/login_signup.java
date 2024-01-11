package com.sharkdroid.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class login_signup extends AppCompatActivity {
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.login_signup);

        Button loginBtn=findViewById(R.id.login);
        Button signBtn=findViewById(R.id.signUp);

        loginBtn.setOnClickListener(v -> {

            Intent intent=new Intent(login_signup.this, Login.class);
            startActivity(intent);

        });

        signBtn.setOnClickListener(v -> {
            Intent intent=new Intent(login_signup.this, signup.class);
            startActivity(intent);
        });

    }
}
