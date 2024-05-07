package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity implements View.OnClickListener{
    TextView txtMENUser;

    ImageButton btMENContatos, btMENPedidos;

    String _email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        String _email = parametros.getString("email");



        txtMENUser = (TextView) findViewById(R.id.txtMENUser);
        btMENContatos = (ImageButton) findViewById(R.id.btMENContatos);
        btMENPedidos = (ImageButton) findViewById(R.id.btMENPedidos);

        txtMENUser.setText("Usuário: " + _email);
        btMENContatos.setOnClickListener(this);
        btMENPedidos.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if (view.getId()==R.id.btMENContatos){
            Intent tela = new Intent(this, MainActivity.class);
            startActivity(tela);
        }
        if (view.getId()==R.id.btMENPedidos){
            Intent tela = new Intent(this, Rescisao.class);

            Bundle parametros = new Bundle();
            parametros.putString("email", _email);
            tela.putExtras(parametros);
            startActivity(tela);
        }
    }
}