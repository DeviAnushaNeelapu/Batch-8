package com.muneiah.studentslogwithroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText name,rollnumber;
RecyclerView rec;
StudentAdaper adaper;
static StudentDataBase dataBase;
Students_entity entity;
List<Students_entity> entityList;
static MyViewModel viewModel;
LiveData<List<Students_entity>> liveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.et_name);
        rollnumber=findViewById(R.id.et_rollNumber);
        rec=findViewById(R.id.recyler);
        /*dataBase=Room.databaseBuilder(this,StudentDataBase.class,"ap")
                .allowMainThreadQueries().build();*/ //normal db
        //for Live data
        viewModel=new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.liveData().observe(this, new Observer<List<Students_entity>>() {
            @Override
            public void onChanged(List<Students_entity> students_entities) {
                adaper=new StudentAdaper(MainActivity.this,students_entities);
                rec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rec.setAdapter(adaper);
            }
        });



    }

    public void saveData(View view) {
        String inputName=name.getText().toString();
        String inputrollnum=rollnumber.getText().toString();
        entity=new Students_entity();
        entity.setName(inputName);
        entity.setRollNumber(inputrollnum);
        //dataBase.studentDAO().insert(entity);
        viewModel.insert(entity);
        Toast.makeText(this, "Inserted Successfully"+inputName, Toast.LENGTH_SHORT).show();

    }

    /*public void retriveData(View view) {
        entityList=dataBase.studentDAO().retrive();
        adaper=new StudentAdaper(this,entityList);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adaper);

    }*/
}
