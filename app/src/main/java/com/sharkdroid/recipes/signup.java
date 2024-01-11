package com.sharkdroid.recipes;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class signup extends AppCompatActivity {


    private static final String  Channel_id="sign up";
    private static final int id=0;
    Notification notify;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.singup);

        Button nextBtn=findViewById(R.id.nextBtn);

        Drawable draw= ResourcesCompat.getDrawable(getResources(), R.drawable.check,null);
        BitmapDrawable bm=(BitmapDrawable) draw;
        assert bm != null;
        Bitmap largeIcon=bm.getBitmap();


        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nextBtn.setOnClickListener(v -> {

            notify = new Notification.Builder(signup.this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.logo_color)
                    .setContentText("Sign up Successfully")
                    .setChannelId(Channel_id)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(Channel_id,"Sign up Notification",NotificationManager.IMPORTANCE_HIGH));

            nm.notify(id,notify);

        });




    }
}
