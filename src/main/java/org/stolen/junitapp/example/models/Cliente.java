package org.stolen.junitapp.example.models;

public class Cliente {

    private  Integer id;
    private  String nombre;
    private  String apellido;
    private  Integer membresia;

    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, String nombre, String apellido, Integer membresia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.membresia = membresia;
    }

    public Cliente(String nombre, String apellido, Integer membresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.membresia = membresia;
    }

    public Integer getId() {
        return id;
    }

    public Cliente setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Cliente setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Integer getMembresia() {
        return membresia;
    }

    public Cliente setMembresia(Integer membresia) {
        this.membresia = membresia;
        return this;
    }

    @Override
    public String toString() {
        return id +
                " | " + nombre +
                " | " + apellido +
                " | " + membresia;
    }
}
