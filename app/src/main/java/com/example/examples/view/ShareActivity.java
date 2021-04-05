package com.example.examples.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.examples.R;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        TextView textView=findViewById(R.id.textShare);
        Intent intent=getIntent();
        if(intent!=null){
            textView.setText(intent.getStringExtra(Intent.EXTRA_TEXT));

        }
    }
}