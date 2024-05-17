package com.example.modeloparcial;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioModel implements Serializable {
    private String nombre;
    private String contrasenia;
    private String contrasenia2;

    private String tipoUsuario;

    public UsuarioModel() {
    }

    public UsuarioModel(String nombre, String contrasenia, String tipoUsuario) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.contrasenia2 = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getContrasenia2() {
        return contrasenia2;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = this.contrasenia2 = contrasenia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioModel that = (UsuarioModel) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(contrasenia, that.contrasenia) && Objects.equals(tipoUsuario, that.tipoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, contrasenia, tipoUsuario);
    }

    public void setContrasenia2(String pass2) {
        this.contrasenia2 = pass2;
    }
}
