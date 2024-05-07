package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText txtLOGEmail, txtLOGSenha;

    Button btLOGAcessar, btLOGCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLOGEmail = (EditText) findViewById(R.id.txtLOGEmail);
        txtLOGSenha = (EditText) findViewById(R.id.txtLOGSenha);
        btLOGAcessar = (Button) findViewById(R.id.btLOGAcessar);
        btLOGCadastro = (Button) findViewById(R.id.btLOGCadastro);

        btLOGAcessar.setOnClickListener(this);
        btLOGCadastro.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btLOGCadastro) {

            Intent telaCadastro = new Intent(this, Cadastre_se.class);
            startActivity(telaCadastro);
        }
        if (view.getId() == R.id.btLOGAcessar){
            if (validaDados() ){
                Intent tela = new Intent(this, Menu.class);
                Bundle parametros = new Bundle();
                parametros.putString("email", txtLOGEmail.getText().toString());
                tela.putExtras(parametros);
                startActivity(tela);
            }

        }

    }
    public boolean validaDados(){
        boolean retorno = true;
        String msg= "";

        if (txtLOGEmail.getText().length() == 0){
            msg = "o campo email não foi preenchido";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            retorno=false;
        }else {
            if (txtLOGSenha.getText().length() == 0) {
                msg = "o campo senha não foi preenchido";
                Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
                retorno=false;
            }else {
                BancoController bd = new BancoController(getBaseContext());

                Cursor dados = bd.carregaDadosPeloEmailSenha(txtLOGEmail.getText().toString(),txtLOGSenha.getText().toString()) ;

                if(dados.moveToFirst()){
                    msg= "email e senha forão Cadastrados";

                }else {
                    msg = "email ou senha Não encontrados";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                    retorno= false;
                }
            }
        }
        return retorno;
    }

}