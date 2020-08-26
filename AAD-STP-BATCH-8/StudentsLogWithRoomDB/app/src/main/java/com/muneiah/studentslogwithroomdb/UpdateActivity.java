package com.muneiah.studentslogwithroomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
EditText u_name,u_rollNum;
Students_entity entity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        u_name=findViewById(R.id.et_updatename);
        u_rollNum=findViewById(R.id.et_updaterollNumber);
        Intent myintent=getIntent();
       String rn= myintent.getStringExtra("key_name");
       String rr= myintent.getStringExtra("key_roll");
       u_name.setText(rn);
       u_rollNum.setText(rr);
       u_rollNum.setKeyListener(null);
    }

    public void updatData(View view) {
        String name=u_name.getText().toString();
        String roll=u_rollNum.getText().toString();
        entity=new Students_entity();
        entity.setName(name);
        entity.setRollNumber(roll);
       // MainActivity.dataBase.studentDAO().update(entity);
        MainActivity.viewModel.update(entity);
        Toast.makeText(this, name+" Updated", Toast.LENGTH_SHORT).show();
    Intent i=new Intent(this,MainActivity.class);
    startActivity(i);

    }
}
