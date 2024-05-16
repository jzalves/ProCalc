package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {
    EditText inputsalario, inputdatainicio, inputdatafinal;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputsalario = (EditText) findViewById(R.id.inputsalario);
        inputdatainicio = (EditText) findViewById(R.id.inputdatainicio);
        inputdatafinal = (EditText) findViewById(R.id.inputdatafinal);


    }


    }
