package com.example.firstapp;

import static com.example.firstapp.R.id.textView3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EspressoPractical extends AppCompatActivity {
    EditText Text;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.espressopractical);

    }


    public void showText(View view) {
        Text = findViewById(R.id.editTextTextPersonName);
        result=findViewById(textView3);
        result.setText(Text.getText());
    }
}