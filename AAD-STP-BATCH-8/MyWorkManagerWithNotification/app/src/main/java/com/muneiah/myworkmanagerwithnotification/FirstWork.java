package com.muneiah.myworkmanagerwithnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class FirstWork extends Worker {
    NotificationManager nm;
    NotificationCompat.Builder builder;
    NotificationChannel nc;
    public static final String CHANNEL_ID="muneiahtellaakula.apssdc";
    PendingIntent pi;
    Intent i;
    public FirstWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        i=new Intent(getApplicationContext(),MainActivity.class);
        pi=PendingIntent.getActivity(getApplicationContext(),123,i,
                PendingIntent.FLAG_UPDATE_CURRENT);
        nm= (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        createChannel();
        showNotification();
        return Result.success();
    }
    public void createChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            nc=new NotificationChannel(CHANNEL_ID,"workshopChannel",NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);

        }
    }
    public void showNotification(){
        builder=new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
        builder.setContentTitle("Apssdc Notification");
        builder.setContentText("this is our Workshop notification");
        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        nm.notify(12,builder.build());

    }
}
