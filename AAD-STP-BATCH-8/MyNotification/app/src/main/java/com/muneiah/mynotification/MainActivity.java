package com.muneiah.mynotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager nm;
    NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createChannel();
    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel nc=new NotificationChannel("CHANNEL_ID","Apssdc",
                    NotificationManager.IMPORTANCE_HIGH);
            nc.enableVibration(true);
            nc.setLightColor(Color.BLUE);
            nm.createNotificationChannel(nc);
        }
    }

    public void showNotifcation(View view) {
        builder=new NotificationCompat.Builder(this,"CHANNEL_ID");
        builder.setContentTitle("My Notification");
        builder.setContentText("This My own Notification");
        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
        builder.setDefaults(Notification.DEFAULT_ALL);
        nm.notify(1234,builder.build());


    }
}

/*3 componets for design
    Icon
    Title
    Text
* (Above 26 or oreo )3
creation two classes (Below api level 26)
*   Notification Manager
*   NoticationCampact.Builder
*   NotificationChannel*/
