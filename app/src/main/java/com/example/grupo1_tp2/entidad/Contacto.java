package com.example.grupo1_tp2.entidad;

import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;
    private String fechaDeNacimiento;
    private String nivelDeEstudioAlcanzado;
    private String intereses;
    private boolean notificacion;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, String telefono, String email, String direccion, String fechaDeNacimiento, String nivelDeEstudioAlcanzado, String intereses, boolean notificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nivelDeEstudioAlcanzado = nivelDeEstudioAlcanzado;
        this.intereses = intereses;
        this.notificacion = notificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNivelDeEstudioAlcanzado() {
        return nivelDeEstudioAlcanzado;
    }

    public void setNivelDeEstudioAlcanzado(String nivelDeEstudioAlcanzado) {
        this.nivelDeEstudioAlcanzado = nivelDeEstudioAlcanzado;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public boolean isNotificacion() {
        return notificacion;
    }

    public void setNotificacion(boolean notificacion) {
        this.notificacion = notificacion;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaDeNacimiento='" + fechaDeNacimiento + '\'' +
                ", nivelDeEstudioAlcanzado='" + nivelDeEstudioAlcanzado + '\'' +
                ", intereses='" + intereses + '\'' +
                ", notificacion=" + notificacion +
                '}';
    }
}
