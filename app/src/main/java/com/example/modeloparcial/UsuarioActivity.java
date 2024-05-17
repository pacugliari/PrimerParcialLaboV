package com.example.modeloparcial;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class UsuarioActivity extends AppCompatActivity{


    public final static String USUARIO = "usuario";
    private UsuarioModel model;

    private UsuarioView view;

    private UsuarioController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        ActionBar actionBar = super.getSupportActionBar();

        if(actionBar != null){
            actionBar.setTitle(R.string.tituloMenuEditar);
            actionBar.setDisplayHomeAsUpEnabled(true);//BOTON DE BACK
        }

        Bundle extras = super.getIntent().getExtras();
        UsuarioModel usuario = (UsuarioModel) extras.get(USUARIO);
        model = usuario;
        view = new UsuarioView(this,model);
        view.mostrarModelo();
        controller = new UsuarioController(model,view,this);
        view.setController(controller);

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            super.finish(); // EJECUTA EN ONDESTROY DEL ACTIVITY ACTUAL
        }
        return super.onOptionsItemSelected(item);
    }

}