package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class AsynchActivity<S, I extends Number, V> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynch);
        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute("http://youtube.com/movie");
    }

    public static class DownloadTask extends AsyncTask<String,Integer,Void> {
        public  static  String TAG =  AsynchActivity.class.getSimpleName();
        //this method will execute on a seperate thread in the background
        //so i plan to download the movie in this method
        @Override
        protected Void doInBackground(String... url) {
            Log.i(TAG,"downloading movie from the url"+ url[0]);
            return null;
        }
    }
}