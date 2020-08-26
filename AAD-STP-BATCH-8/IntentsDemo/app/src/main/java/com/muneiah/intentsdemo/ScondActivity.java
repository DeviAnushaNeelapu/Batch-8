package com.muneiah.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScondActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scond);
        tv=findViewById(R.id.tv_data);
        Intent i=getIntent();
        String res=i.getStringExtra("keyname");
        tv.setText(res);
    }
}
