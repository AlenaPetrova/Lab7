package com.example.examples.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.examples.R;
import com.example.examples.viewmodel.SomeService;

import static android.app.PendingIntent.getActivity;

public class ActivityService extends AppCompatActivity {
    ProgressBar progressBar;
    private int STORAGE_PERMISSION_CODE=1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_service);
        progressBar=(ProgressBar)findViewById(R.id.progressBar4);
        super.onCreate(savedInstanceState);
        if(ContextCompat.checkSelfPermission(ActivityService.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestStoragePermission();

        }



    }

    public void onClickStart(View v){


        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("progress");
        BroadcastReceiver receiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
              if(intent.getAction().equals("progress")){
                  progressBar.setProgress(intent.getIntExtra("Progress",0));
              }
            }
        };
        registerReceiver(receiver,intentFilter);


        startService(new Intent(this, SomeService.class));

    }
    public void onClickStop(View v){

        stopService(new Intent(this,SomeService.class));
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
