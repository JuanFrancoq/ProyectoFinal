package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

import javafx.beans.property.*;

public class Transaccion {

    private LocalDate fecha;
    private String tipo;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private double monto;

    public Transaccion(LocalDate fecha, String tipo, Vehiculo vehiculo, Cliente cliente, double monto) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    
}