package com.example.examples.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.examples.R;

public class HistoryActivity2 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);
        Intent intent = getIntent();

        ListView mListView =(ListView)findViewById(R.id.lisHistory);

        historyAdapter adapter=new historyAdapter(this,R.layout.history_item,intent.<historyItem>getParcelableArrayListExtra("history"));
        mListView.setAdapter(adapter);
    }


}