package com.example.firstapp;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    public MyService() {
    }

    IBinder iBinder = new LocalBinder();

String TAG = MyService.class.getSimpleName();
    @Override
    public void onCreate() {
        Log.i(TAG,"Created");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"Start");
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"Destroyed");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return iBinder;
    }

    @Nullable
    @Override
    public ComponentName startService(Intent service) {
        return super.startService(service);
    }

    public int add(int a, int b){
        return a+b;
    }

    public String Getlocation(){
        return "this is the location";
    }
    public String getScore(){
        return "15 for wildcats";
    }


    class LocalBinder extends Binder {

        MyService getService(){
            return MyService.this;//return current object service
        }

    }
}