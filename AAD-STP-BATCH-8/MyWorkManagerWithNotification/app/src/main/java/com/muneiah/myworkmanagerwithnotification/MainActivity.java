package com.muneiah.myworkmanagerwithnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
OneTimeWorkRequest one;
PeriodicWorkRequest second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=new OneTimeWorkRequest.Builder(FirstWork.class).build();
        second=new PeriodicWorkRequest.Builder(SecondWork.class,1, TimeUnit.MINUTES).build();
    }

    public void showMyNotification(View view) {
        WorkManager.getInstance(this).enqueue(one);
        WorkManager.getInstance(this).enqueue(second);
    }
}
