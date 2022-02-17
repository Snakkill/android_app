package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class SpeechToText extends AppCompatActivity {
    TextView ResultsToSpeech;
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");

        ResultsToSpeech = findViewById(R.id.ResultsToSpeech);
        ResultsToSpeech.setText(text);





    }

    public void Speak(View view) {
        TextView text;
        text= findViewById(R.id.ResultsToSpeech);

        // create an object textToSpeech and adding features into it
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                // if No error is found then only it will run
                if (i != TextToSpeech.ERROR) {
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

        textToSpeech.speak(String.valueOf(text),TextToSpeech.QUEUE_ADD, null);
    }
}