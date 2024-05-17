package com.example.modeloparcial;

import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;
import android.view.View;

public class UsuarioController implements View.OnClickListener{

    private UsuarioModel model;
    private UsuarioView view;

    private Activity activity;

    public UsuarioController(UsuarioModel model, UsuarioView view, Activity activity){
        this.model = model;
        this.view = view;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        this.view.cargarModel();
        if(this.validarDatos()){
            MainActivity.usuarioModels.set(MainActivity.posicion,model);
            this.activity.finish();
        }
    }

    public Boolean validarDatos(){
        String pass1 = this.model.getContrasenia();
        String pass2 = this.model.getContrasenia2();
        String nombre = this.model.getNombre();
        if(nombre != null && pass1 != null && this.model.getTipoUsuario() != null  && pass1.equals(pass2) && nombre.length() >= 3){
            return true;
        }else{
            if(pass1 != null && pass2 != null && !pass1.equals(pass2)){
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("ERROR")
                        .setMessage(activity.getString(R.string.error1))
                        .setCancelable(true)
                        .show();
            }else if(nombre != null && nombre.length() < 3){
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("ERROR")
                        .setMessage(activity.getString(R.string.error2))
                        .setCancelable(true)
                        .show();
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("ERROR")
                        .setMessage(activity.getString(R.string.error3))
                        .setCancelable(true)
                        .show();
            }
            return false;
        }

    }

}
