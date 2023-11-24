package com.mehboob.webviewcitrus2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebViewClient;

import com.mehboob.webviewcitrus2.databinding.ActivityWebviewBinding;

public class WebviewActivity extends AppCompatActivity {
    private ActivityWebviewBinding binding;
    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWebviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPref = new SharedPref(this);



        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.getSettings().getDatabaseEnabled();
        binding.webView.getSettings().getCacheMode();
        binding.webView.getSettings().getAllowContentAccess();
        binding.webView.getSettings().setAllowContentAccess(true);
        binding.webView.getSettings().getAllowFileAccess();


        binding.webView.loadUrl(sharedPref.fetchUrl());
        binding.webView.setWebViewClient(new WebViewClient());


    }

    @Override
    public void onBackPressed() {


        if (binding.webView.canGoBack()){
            binding.webView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}