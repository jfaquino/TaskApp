package ado.edu.itla.taskapp.entidad;

import android.content.Intent;

import java.io.Serializable;

/**
 * Created by MESCyT on 7/7/2018.
 */

public class Usuario implements Serializable{

    public enum TipoUsuario{
        TECNICO, NORMAL
    }

    private Integer id;
    private String nombre;
    private String email;
    private String contrasena;

    private TipoUsuario tipoUsuario;

    public Usuario() {

    }

    public Usuario(Integer id, String nombre, String email, String contrasena, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {

        return id+" - "+nombre;
    }
}
