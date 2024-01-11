package com.sharkdroid.recipes;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;

public class Login extends AppCompatActivity {

    private static final String loginChannel="Login Channel";
    private static final int Notification_id=100;
    Notification notify;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.login);


        Button loginBtn=findViewById(R.id.btnLogin);
        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Drawable draw= ResourcesCompat.getDrawable(getResources(),R.drawable.check,null);
        BitmapDrawable bitmapDrawable=(BitmapDrawable) draw;
        assert bitmapDrawable != null;
        Bitmap largeIcon=bitmapDrawable.getBitmap();


        loginBtn.setOnClickListener(v -> {


            if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) {

                NotificationChannel channel = new NotificationChannel(loginChannel, "newChannel", NotificationManager.IMPORTANCE_HIGH);
                nm.createNotificationChannel(channel);
            }
                notify = new NotificationCompat.Builder(Login.this)
                        .setLargeIcon(largeIcon)
                        .setSmallIcon(R.drawable.logo_color)
                        .setContentText("Login Successfully")
                        .setChannelId(loginChannel)
                        .build();
            intentPassing();

        });


    }


    public void intentPassing(){

        Intent intent=new Intent(Login.this,MainActivity.class);
        startActivity(intent);
        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(Notification_id, notify);


    }

}
