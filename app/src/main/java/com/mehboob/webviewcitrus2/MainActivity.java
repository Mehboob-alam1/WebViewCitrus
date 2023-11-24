package com.mehboob.webviewcitrus2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mehboob.webviewcitrus2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sharedPref = new SharedPref(this);
        if (sharedPref.fetchUrl() != null) {
            startActivity(new Intent(MainActivity.this, WebviewActivity.class));
        } else {
            binding.line.setVisibility(View.VISIBLE);
            binding.btnSubmit.setOnClickListener(v -> {

                if (binding.etURL.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Add a url", Toast.LENGTH_SHORT).show();
                } else {

                    String url = binding.etURL.getText().toString();
                    sharedPref.saveUrl(url);

                    startActivity(new Intent(MainActivity.this, WebviewActivity.class));
                    finish();
                }
            });

        }


    }

    @Override
    protected void onStart() {
        super.onStart();


    }
}