package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    EditText nameText;
    String TAG = MainActivity.class.getSimpleName();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.etName);
        nameText.setOnFocusChangeListener(this);

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(
                new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        String token = task.getResult().toString();
                        Log.i(TAG,"token is------"+token);
                    }
                }
        );
    }

    public void toastName(View view) {
        Toast.makeText(this,nameText.getText().toString(),Toast.LENGTH_SHORT).show();
        add(10,20);
    }

    private void add(int k, int i1) {
        int c = 110;
        for (int i = 0; i <10 ; i++) {
            c = c+ i * 20 + 5;
        }
    }


    public void onFocusChange(View view,boolean focus) {


        if(focus){
            Toast.makeText(this,"focus",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"lost focus",Toast.LENGTH_SHORT).show();
        }
    }

    public void EventHandler(View view) {
       //String value = nameText.getText().toString();
       Intent varIntent = new Intent(this,EspressoPractical.class);
       startActivity(varIntent);
    }


    public void DownloadIntent(View view) {
        Intent varIntent = new Intent(this,AsynchActivity.class);
        startActivity(varIntent);
    }
}