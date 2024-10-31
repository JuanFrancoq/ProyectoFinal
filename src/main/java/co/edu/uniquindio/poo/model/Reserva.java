package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Reserva {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double valorReserva;

    public Reserva(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, Vehiculo vehiculo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        calcularValorReserva();
    }

    private void calcularValorReserva() {
        int dias = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay());
        this.valorReserva = vehiculo.calcularTarifa(dias); // llama al método polimórfico
    }

    // Getters para cada propiedad que se necesita en la tabla
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public String getCedulaCliente() {
        return cliente != null ? cliente.getCedula() : "";
    }

    public String getNombre() {
        return cliente != null ? cliente.getNombre() : "";
    }

    public String getTelefono() {
        return cliente != null ? cliente.getTelefono() : "";
    }

    public String getTipoVehiculo() {
        return vehiculo != null ? vehiculo.getTipoVehiculo() : "";
    }

    public String getMarca() {
        return vehiculo != null ? vehiculo.getMarca() : "";
    }

    public String getModelo() {
        return vehiculo != null ? vehiculo.getModelo() : "";
    }

    public String getMatricula() {
        return vehiculo != null ? vehiculo.getMatricula() : "";
    }

    public double getValorReserva() {
        return valorReserva;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setValorReserva(double valorReserva) {
        this.valorReserva = valorReserva;
    }
    
}