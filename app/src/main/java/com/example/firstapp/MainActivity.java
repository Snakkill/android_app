package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    EditText nameText;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.etName);
        nameText.setOnFocusChangeListener(this);

    }

    public void toastName(View view) {
        Toast.makeText(this,nameText.getText().toString(),Toast.LENGTH_SHORT).show();
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
       Intent varIntent = new Intent(this,homeActivity.class);
       startActivity(varIntent);
    }
}