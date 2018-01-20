package com.example.jonat.s2cristao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnShare;
    Button btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = (WebView) findViewById(R.id.web_view);
        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl(getString(R.string.site));

        // Enable JavaScript
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Buttons
        btnShare = (Button) findViewById(R.id.btn_share_app);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                // Add data to the intent, the receiving app will decide
                // what to do with it.
                share.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_subject));
                share.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_message) + getString(R.string.site));

                startActivity(Intent.createChooser(share, getString(R.string.share_header_when_clicked)));
            }
        });

        btnAbout = (Button) findViewById(R.id.btn_home_sign_out);
        btnAbout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AboutUsActivity.class);
                MainActivity.this.startActivity(myIntent);

            }
        });
    }
}
