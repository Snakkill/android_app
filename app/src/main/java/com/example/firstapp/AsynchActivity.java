package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
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
    //------------------------Notifications practical--------------------------------------//

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Ayman's Channel";
            String description = "First App's Notifcation channel";

            // set importance to high
            int importance = NotificationManager.IMPORTANCE_HIGH;

            //gave channel id of Channel1
            NotificationChannel channel = new NotificationChannel("Channel1", name, importance);
            channel.setDescription(description);

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void showNotification(View view) {
        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "Channel1")
                .setSmallIcon(R.drawable.happy_icon)
                .setContentTitle("The App Is Giving an Alert!")
                .setContentText("This is the first alert I have ever made")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("I am happy to be here!"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(007, builder.build());

    }


    //-------------------------------------------------------------------------------------//

    public void StartDoInBackground(View view) {

        DownloadTask downloadTask = new DownloadTask(progressBar);
        downloadTask.execute("http://youtube.com/movie");
    }

    public void ServiceHandler(View view) {
        Intent serviceIntent = new Intent(this,MyService.class);
        switch(view.getId()){

            case R.id.stServicebtn:
                startService(serviceIntent);
                break;


            case R.id.stpServicebtn:
                stopService(serviceIntent);
                break;
        }
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

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            myProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            myProgressBar.setVisibility(View.INVISIBLE);
        }
    }
}