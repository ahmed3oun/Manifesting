package com.pi.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    EditText url_input;
    EditText map_input;
    EditText message_input;
    Button btn_url;
    Button btn_map;
    Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url_input=findViewById(R.id.url_input);
        map_input=findViewById(R.id.map_input);
        message_input=findViewById(R.id.msg_input);

        btn_url=findViewById(R.id.btn_url);
        btn_map=findViewById(R.id.btn_map);
        btn_send=findViewById(R.id.btn_send);

        ////////////////////
        btn_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webPage=Uri.parse("http://"+url_input.getText().toString());
                Intent i =new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(webPage);
                startActivity(i);


            }
        });
        /////////////////
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = map_input.getText().toString();
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+location);
                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");
                // Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);
            }
        });
        /////////////////
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg=message_input.getText().toString();
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:93611028"));
                smsIntent.putExtra("sms_body",msg);
                startActivity(smsIntent);
            }
        });
    }
}