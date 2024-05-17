package com.example.modeloparcial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class UsuarioView {
    EditText nombre;
    EditText pass1;
    EditText pass2;
    RadioGroup tipo;
    UsuarioModel model;
    UsuarioController controller;

    Activity activity;

    public UsuarioView(Activity activity, UsuarioModel model){
        nombre = activity.findViewById(R.id.inputNombre);
        tipo = activity.findViewById(R.id.inputTipo);
        pass1 = activity.findViewById(R.id.inputPassword);
        pass2 = activity.findViewById(R.id.inputPassword2);
        this.model = model;
        this.activity = activity;
    }

    public void setController(UsuarioController controller){
        this.controller = controller;
        Button btn = activity.findViewById(R.id.botonGuardar);
        btn.setOnClickListener(controller);
    }

    public void cargarModel(){//HACE LOS GET TEXT
        String nombre = this.nombre.getText().toString().isEmpty() ?null:this.nombre.getText().toString();
        String pass = this.pass1.getText().toString().isEmpty() ?null:this.pass1.getText().toString();
        String pass2 = this.pass2.getText().toString().isEmpty() ?null:this.pass2.getText().toString();
        int selectedId = tipo.getCheckedRadioButtonId();
        RadioButton radioButton = activity.findViewById(selectedId);
        String tipo = (String)radioButton.getTag();

        model.setNombre(nombre);
        model.setTipoUsuario(tipo);
        model.setContrasenia(pass);
        model.setContrasenia2(pass2);

    }

    @SuppressLint("SetTextI18n")
    public void mostrarModelo(){//HACE LOS SET TEXT
        nombre.setText(model.getNombre());
        if(model.getTipoUsuario().equals(activity.getResources().getString(R.string.textoAdministradorRadio))) {
            RadioButton radioButtonAdministrador = activity.findViewById(R.id.inputAdministrador);
            radioButtonAdministrador.setChecked(true);
        } else {
            RadioButton radioButtonUsuario = activity.findViewById(R.id.inputUsuario);
            radioButtonUsuario.setChecked(true);
        }
    }
}
