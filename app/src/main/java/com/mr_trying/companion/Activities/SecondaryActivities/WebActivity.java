package com.mr_trying.companion.Activities.SecondaryActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.mr_trying.companion.R;

public class WebActivity extends AppCompatActivity {

    ProgressBar progressBar;
    EditText inputUrl;
    WebView webView;
    ImageButton sendButton, forwardButton, backButton, refreshButton;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        progressBar = findViewById(R.id.progressBar);
        inputUrl = findViewById(R.id.autoCompleteTextView);
        webView = findViewById(R.id.webView);
        sendButton = findViewById(R.id.sendButton);
        forwardButton = findViewById(R.id.forwardButton);
        backButton = findViewById(R.id.backButton);
        refreshButton = findViewById(R.id.refreshButton);

        webView.setWebViewClient(new WebViewClient());

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
                if (newProgress == 100)
                    progressBar.setVisibility(View.GONE);
                else
                    progressBar.setVisibility(View.VISIBLE);
            }
        });

        WebSettings webset = webView.getSettings();
        webset.setJavaScriptEnabled(true);

        Intent intent = getIntent();
        String mURL = intent.getStringExtra("url");
        if (mURL != null) {
            webView.loadUrl(mURL);
            System.out.println(mURL);
        }

        sendButton.setOnClickListener(v -> {
            String url = inputUrl.getText().toString();

            if (!url.startsWith("https://")) {
                url = "https://" + url;
            }
            webView.loadUrl(url);

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(webView.getWindowToken(), 0);
        });

        forwardButton.setOnClickListener(v -> {
            if (webView.canGoForward())
                webView.goForward();
        });

        backButton.setOnClickListener(v -> {
            if (webView.canGoBack())
                webView.goBack();
        });

        refreshButton.setOnClickListener(v -> webView.reload());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            overridePendingTransition(0, 0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}