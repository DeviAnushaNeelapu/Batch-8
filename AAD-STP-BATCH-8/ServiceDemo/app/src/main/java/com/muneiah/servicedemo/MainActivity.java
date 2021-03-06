package com.muneiah.servicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView img;
int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.iv);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c==0) {
                    Intent is = new Intent(MainActivity.this, MyService.class);
                    startService(is);
                    img.setImageResource(R.drawable.ic_stop_black_24dp);
                    c++;
                }else {
                    Intent is = new Intent(MainActivity.this, MyService.class);
                    stopService(is);
                    img.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    c--;
                }
            }
        });

    }
}
