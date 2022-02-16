package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SpeechToText extends AppCompatActivity {
    TextView ResultsToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text);

        Intent intent = getIntent();
        String text=intent.getStringExtra("text");

        ResultsToSpeech = findViewById(R.id.ResultsToSpeech);
        ResultsToSpeech.setText(text);


    }
}