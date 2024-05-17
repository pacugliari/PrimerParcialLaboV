package com.example.modeloparcial;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity  implements MyOnItemClick{

    MyAdapter adapter = null;
    static Integer posicion  = null;

    static List<UsuarioModel> usuarioModels = new ArrayList<UsuarioModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SETEO DE TITULO
        ActionBar actionBar = super.getSupportActionBar();
        if(actionBar != null)
            actionBar.setTitle(R.string.tituloMenuPrincipal);

        usuarioModels = new ArrayList<UsuarioModel>();
        //CARGO DATOS HARDCODEADOS
        for (int i = 0; i < 5; i++) {
            usuarioModels.add(new UsuarioModel("JPerez "+i,"1234",getResources().getString(R.string.textoAdministradorRadio)));
            usuarioModels.add(new UsuarioModel("Rodolfo "+i,"1234",getResources().getString(R.string.textoUsuarioRadio)));
        }

        RecyclerView list = (RecyclerView)findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        adapter = new MyAdapter(usuarioModels,this);
        list.setAdapter(adapter);


    }


    @Override
    protected void onRestart() {
        adapter.notifyItemChanged(MainActivity.posicion);
        super.onRestart();
    }

    @Override
    public void onItemClick(int position) {
        MainActivity.posicion = position;
        UsuarioModel usuario = MainActivity.usuarioModels.get(position);
        Intent intent = new Intent(this, UsuarioActivity.class);
        intent.putExtra(UsuarioActivity.USUARIO,usuario);
        super.startActivity(intent);
    }
}