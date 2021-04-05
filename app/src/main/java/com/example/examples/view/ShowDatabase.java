package com.example.examples.view;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.examples.R;
import com.example.examples.viewmodel.HistoryProcessor;
import com.example.examples.viewmodel.ProcessDB;

public class ShowDatabase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_database);

    }
    public void OnClickShow(View v){
        ProcessDB a=new ProcessDB(this);
        TextView textView=(TextView)findViewById(R.id.showDatabase_textView);
        textView.setText(a.getDb());

    }
}