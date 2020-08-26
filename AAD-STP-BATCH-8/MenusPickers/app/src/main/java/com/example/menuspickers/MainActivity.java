package com.example.menuspickers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   Button b_alertdialog,b_datepicker,b_timepicker;
   int year_c,month_m,date_m;
   int mhours,mminutes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_alertdialog=findViewById(R.id.alertdialog);
        b_datepicker=findViewById(R.id.datepicker);
        b_timepicker=findViewById(R.id.timepicker);
        b_alertdialog.setOnClickListener(this);
        b_datepicker.setOnClickListener(this);
        b_timepicker.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(this, "Selected setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.favorites:
                Toast.makeText(this, "Favourites has selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                Toast.makeText(this, "Selected add", Toast.LENGTH_SHORT).show();
                 break;
            case R.id.search:
                Toast.makeText(this, "Selected search", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.alertdialog:
                openAlertDialog();
                break;
            case R.id.datepicker:
                openDatePicker();
                break;
            case R.id.timepicker:
                timepicker();
                break;
        }

    }

    private void timepicker() {
    Calendar c= Calendar.getInstance();
    mhours=c.get(Calendar.HOUR_OF_DAY);
    mminutes=c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                String mytime=i+":"+i1;
                Toast.makeText(MainActivity.this, mytime, Toast.LENGTH_SHORT).show();
            }
        },mhours,mminutes,false);
        timePickerDialog.show();
    }


    private void openDatePicker() {
        Calendar c = Calendar.getInstance();
         year_c= c.get(Calendar.YEAR);
        month_m=c.get(Calendar.MONTH);
        date_m=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            String mydate=i+"-"+(i1+1)+"-"+i2;
                Toast.makeText(MainActivity.this, mydate, Toast.LENGTH_SHORT).show();
            }
        },year_c,month_m,date_m);
        datePickerDialog.show();
    }

    private void openAlertDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Welcome");
        builder.setIcon(R.drawable.ic_launcher_background);
        builder.setMessage("Are you sure to exit");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              finish();
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}
