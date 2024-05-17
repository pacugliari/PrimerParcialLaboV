package com.example.modeloparcial;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView txtNombre;
    TextView txtTipoUsuario;
    Button btnEditar;

    private int position;

    private final MyOnItemClick listener;


    public MyViewHolder(@NonNull View itemView,MyOnItemClick listener) {
        super(itemView);
        txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
        txtTipoUsuario = (TextView) itemView.findViewById(R.id.txtTipoUsuario);
        btnEditar = itemView.findViewById(R.id.botonEditar);
        btnEditar.setOnClickListener(this);
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(position);
    }

    public void setPosition(int position)
    {
        this.position = position;
    }
}
