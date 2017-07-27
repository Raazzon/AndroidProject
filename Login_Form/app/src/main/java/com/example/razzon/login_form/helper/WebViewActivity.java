package com.example.razzon.login_form.helper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.razzon.login_form.R;

public class WebViewActivity extends AppCompatActivity {

    String url="https://broadwayinfosys.com/";
    WebView webView;
    ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView= (WebView) findViewById(R.id.webview);
        webView.loadUrl("url");
       //webView.loadUrl("file:///android_asset/aboutus.html");

          progress= (ProgressBar) findViewById(R.id.progress);

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progress.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                webView.loadUrl("file:///android_asset/aboutus.html");
            }
        });
    }
}
