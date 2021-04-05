package com.example.examples.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.examples.R;
import com.example.examples.viewmodel.FileProcessor;

public class ShowFile extends AppCompatActivity {
    private int STORAGE_PERMISSION_CODE=1;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_file);
        textView=(TextView)findViewById(R.id.show_text);
        if(ContextCompat.checkSelfPermission(ShowFile.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestStoragePermission();

        }
    }
    public void OnClickShow(View v){

       textView.setText(FileProcessor.loadFileContent());

    }
    private void requestStoragePermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){

        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==STORAGE_PERMISSION_CODE){
            if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){

            }
        }
    }
}