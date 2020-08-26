package com.muneiah.retrofitconfig;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView rec;
MyAdapter adapter;
ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec=findViewById(R.id.recycler);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Data Fetching from internet ");
        dialog.setMessage("Please wait ..Loading..!");
        dialog.show();
        Endpoint endpoint=RetrofitInstance.getInstance().create(Endpoint.class);
        Call<List<Repo>> call=endpoint.getAll();
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Total : "+response.body().size(), Toast.LENGTH_SHORT).show();
            adapter=new MyAdapter(MainActivity.this,response.body());
            rec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            rec.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong while fetching data ", Toast.LENGTH_SHORT).show();

            }
        });



    }
}
