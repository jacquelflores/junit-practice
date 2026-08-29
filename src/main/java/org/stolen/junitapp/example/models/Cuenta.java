package org.stolen.junitapp.example.models;

import org.stolen.junitapp.example.exceptions.DineroInsuficienteException;


public class Cuenta {
    private Integer id;
    private String numero;
    private Double saldo;
    private Cliente cliente;
    private Banco banco;

    public Cuenta(Integer id, String numero, Double saldo, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public Cuenta(String numero, Double saldo, Cliente cliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public Cuenta setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Cuenta setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Cuenta setSaldo(Double saldo) {
        this.saldo = saldo;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Cuenta setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public Banco getBanco() {
        return banco;
    }

    public Cuenta setBanco(Banco banco) {
        this.banco = banco;
        return this;
    }

    public void debito(Double monto) {
        double nuevoSaldo = saldo - monto;
        if (nuevoSaldo < 0) {
            throw new DineroInsuficienteException("Dinero insuficiente");
        }
        this.saldo = nuevoSaldo;
    }

    public void credito(Double monto) {
        saldo += monto;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cuenta)) {
            return false;
        }
        Cuenta cuenta = (Cuenta) obj;
        if (this.id == null || this.numero == null || this.saldo == 0 || this.cliente == null) {
            return false;
        }
        return this.id.equals(cuenta.getId()) &&
                this.numero.equals(cuenta.getNumero()) &&
                this.saldo.equals(cuenta.getSaldo()) &&
                this.cliente.equals(cuenta.getCliente());
    }
}
