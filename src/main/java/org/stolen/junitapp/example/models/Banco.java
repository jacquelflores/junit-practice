package org.stolen.junitapp.example.models;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Cuenta> cuentas;
    private String nombre;

    public Banco() {
        cuentas = new ArrayList<>();
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public Banco setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
        return this;
    }

    public void addCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
        cuenta.setBanco(this);
    }

    public String getNombre() {
        return nombre;
    }

    public Banco setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void transferir(Cuenta origen, Cuenta destino, Double monto) {
        origen.debito(monto);
        destino.credito(monto);
    }
}
