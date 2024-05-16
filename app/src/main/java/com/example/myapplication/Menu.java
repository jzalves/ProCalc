package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity implements View.OnClickListener{
    TextView txtMENUser;

    ImageButton btMENFgts, btMENRescisao, btMENFerias;

    String _email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        String _email = parametros.getString("email");



        txtMENUser = (TextView) findViewById(R.id.txtMENUser);
        btMENFgts = (ImageButton) findViewById(R.id.btMENFgts);
        btMENRescisao = (ImageButton) findViewById(R.id.btMENRescisao);
        btMENFerias = (ImageButton) findViewById(R.id.btMENFerias);

        txtMENUser.setText("Usuário: " + _email);
        btMENFgts.setOnClickListener(this);
        btMENRescisao.setOnClickListener(this);
        btMENFerias.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if (view.getId()==R.id.btMENFgts){
            Intent tela = new Intent(this, MainActivity.class);
            startActivity(tela);
        }
        if (view.getId()==R.id.btMENRescisao){
            Intent tela = new Intent(this, Rescisao.class);
            startActivity(tela);
        }
        if (view.getId()==R.id.btMENFerias){
            Intent tela = new Intent(this, Rescisao.class);
            startActivity(tela);
        }
    }
}