package com.muneiah.sharedprefarencestest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.muneiah.sharedprefarencestest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        sp=getSharedPreferences("muni",MODE_PRIVATE);
        binding.showData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,  binding.name.getText().toString() + "\n" +
                        binding.password.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        editor=sp.edit();
        editor.putString("n",binding.name.getText().toString());
        editor.putString("p",binding.password.getText().toString());
        editor.apply();
        super.onPause();
    }

    @Override
    protected void onResume() {
        binding.name.setText(sp.getString("n",""));
        binding.password.setText(sp.getString("p",""));
        super.onResume();
    }
}
