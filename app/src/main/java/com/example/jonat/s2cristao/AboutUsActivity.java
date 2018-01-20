package com.example.jonat.s2cristao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutUsActivity extends AppCompatActivity {

    Button btnHome;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        btnHome = (Button) findViewById(R.id.btn_about_home_screen);
        btnShare = (Button) findViewById(R.id.btn_about_share_app);

        //Buttons Config
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(AboutUsActivity.this, MainActivity.class);
                AboutUsActivity.this.startActivity(myIntent);

            }

        });

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
    }
}
