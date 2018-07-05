package com.sdl.dart.yellowpages2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;
import android.widget.Toast;

import java.net.URL;

public class FeedbackActivity extends AppCompatActivity {
    EditText feed;
    Button send;
    String feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        feed=(EditText)findViewById(R.id.feedback);
        send=(Button)findViewById(R.id.feed_but);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedback=feed.getText().toString();
                sendEmail(feedback);
            }
        });

    }
    protected void sendEmail(String feedin) {
        Log.i("Send email", "");

        String[] TO = {"asht123dd@gmail.com","tab281.h@gmail.com","deepaligshinde2104@gmail.com"};
        String[] CC = {"rdebayan22@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
        emailIntent.putExtra(Intent.EXTRA_TEXT, feedin);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Mail sent", "Finished sending email...");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(FeedbackActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
