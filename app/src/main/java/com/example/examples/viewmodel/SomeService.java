package com.example.examples.viewmodel;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.widget.Toast;


import static java.lang.Thread.sleep;

import com.example.examples.view.ActivityService;

import java.util.concurrent.TimeUnit;

public class SomeService extends Service {

    Context context;
    Thread thread;
    boolean running=true;
    String text;
    Intent mIntent;
    Bundle mBundle;

    public void onCreate() {





        super.onCreate();
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        context = getApplicationContext();


        Toast.makeText(this, "Служба запущена",Toast.LENGTH_SHORT).show();
        mIntent = new Intent(this, ActivityService.class);
        mBundle = new Bundle();



        startWork();



        return super.onStartCommand(intent, flags, startId);

    }


    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onDestroy() {
        Toast.makeText(this, "Служба остановлена",Toast.LENGTH_SHORT).show();


        running=false;
        super.onDestroy();

    }

    private void startWork()  {
        final Handler handler=new Handler();
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(context);
                int step=Integer.parseInt(prefs.getString("shag","0"));
                for(int timer=1;timer<512;timer=timer*step){
                    if(!running){
                        break;
                    }
                   FileProcessor.writeToFile(Integer.toString(timer));
                    Intent in = new Intent("progress");
                    in.putExtra("Progress", timer);

                    sendBroadcast(in);

                    text=Integer.toString(timer);
                    handler.post(doUpdateGUI);

                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }


                }

            }

        });
        thread.start();




    }
    private Runnable doUpdateGUI = new Runnable() {
        public void run() {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        }
    };









}
