package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class AsynchActivity<S, I extends Number, V> extends AppCompatActivity {

    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynch);

        progressBar = findViewById(R.id.progressBar);




    }

    public void StartDoInBackground(View view) {

        DownloadTask downloadTask = new DownloadTask(progressBar);
        downloadTask.execute("http://youtube.com/movie");
    }

    public static class DownloadTask extends AsyncTask<String,Integer,Void> {
        public  static  String TAG =  AsynchActivity.class.getSimpleName();

        ProgressBar myProgressBar;

        public DownloadTask(ProgressBar progressBar) {
            myProgressBar = progressBar;
        }

        //this method will execute on a seperate thread in the background
        //so i plan to download the movie in this method
        @Override
        protected Void doInBackground(String... url) {
            Log.i(TAG,"downloading movie from the url"+ url[0]);
            for (int i=0;i<100;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
                i=i+10;
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            myProgressBar.setProgress(values[0]);
        }
    }
}