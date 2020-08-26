package com.muneiah.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText inputName,inputUrl;
Button mybutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName= findViewById(R.id.et_username);
        mybutton=(Button) findViewById(R.id.btn);
        inputUrl=findViewById(R.id.et_url);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent syntax
                String name=inputName.getText().toString();
                Intent intentObj=new Intent(MainActivity.this,ScondActivity.class);
                intentObj.putExtra("keyname",name);
                startActivity(intentObj);
            }
        });

    }

    public void showWebpage(View view) {
        String input=inputUrl.getText().toString();
        Uri uri=Uri.parse("https://www."+input+".in");
        Intent i=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }
}
