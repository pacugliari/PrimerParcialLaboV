package com.example.modeloparcial;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private final List<UsuarioModel> lista;

    private final MyOnItemClick listener;

    public  MyAdapter(List<UsuarioModel> lista, MyOnItemClick listener){

        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.usuario_layout, parent, false);
        return new MyViewHolder(v, this.listener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UsuarioModel p = lista.get(position);
        holder.txtNombre.setText(p.getNombre());
        holder.txtTipoUsuario.setText(p.getTipoUsuario());
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
