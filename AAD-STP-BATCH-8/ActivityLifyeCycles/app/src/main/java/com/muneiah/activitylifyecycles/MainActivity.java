package com.muneiah.activitylifyecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView tv_label;
//Default First Acivity Callback Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_label=findViewById(R.id.tv);
        tv_label.append("OnCreate() \n");
        Log.i("MainActivity","onCreate()");
        Toast.makeText(this, "App is created ", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        tv_label.append("OnStart() \n");
        Log.i("MainActivity","onStart()");
        Toast.makeText(this, "App is Started ", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        tv_label.append("OnResume() \n");
        Log.i("MainActivity","onResume()");
        Toast.makeText(this, "App is Resumed ", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        tv_label.append("OnPause() \n");
        Log.i("MainActivity","onPause()");
        Toast.makeText(this, "App is Paused ", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        tv_label.append("OnStop() \n");
        Log.i("MainActivity","onStop()");
        Toast.makeText(this, "App is Stopped ", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv_label.append("OnDestroy() \n");
        Log.i("MainActivity","onDestroy()");
        Toast.makeText(this, "App is Destroyed ", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tv_label.append("OnRestart() \n");
        Log.i("MainActivity","onRestart()");
        Toast.makeText(this, "App is ReStrated ", Toast.LENGTH_SHORT).show();

    }
}
