package com.muneiah.hellotoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView label;
int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label=findViewById(R.id.tv_data);
        if (savedInstanceState !=null && savedInstanceState.containsKey("key")){
            c=savedInstanceState.getInt("key");
            label.setText(String.valueOf(c));
        }

    }

    public void show_ToastMessage(View view) {
        //Toast.makeText(this,"Welcome to App Development",Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Welcome to APP Development ", Toast.LENGTH_SHORT).show();
    }

    public void show_count(View view) {
        c++;
        label.setText(String.valueOf(c));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key",c);
    }
}
