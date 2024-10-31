package co.edu.uniquindio.poo.controller;

import javafx.collections.ObservableList;
import java.time.LocalDate;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

public class ReservaController {

    private ObservableList<Reserva> reservas;

    public ReservaController(ObservableList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean crearReserva(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, Vehiculo vehiculo) {
        if (fechaInicio != null && fechaFin != null && cliente != null && vehiculo != null) {
            double tarifaBase = calcularValorReserva(fechaInicio, fechaFin);
            Reserva reserva = new Reserva(fechaInicio, fechaFin, cliente, vehiculo);
            reservas.add(reserva);
            return true; // Reserva creada exitosamente
        }
        return false; // No se pudo crear la reserva
    }

    public boolean eliminarReserva(Reserva reserva) {
        return reservas.remove(reserva); // Devuelve true si se eliminó correctamente
    }

    public double calcularValorReserva(LocalDate fechaInicio, LocalDate fechaFin) {
        if (fechaInicio != null && fechaFin != null && fechaInicio.isBefore(fechaFin)) {
            long dias = fechaFin.toEpochDay() - fechaInicio.toEpochDay();
            double tarifaPorDia = 10000; // Ajusta el costo por día según sea necesario
            return dias * tarifaPorDia;
        }
        throw new IllegalArgumentException("Las fechas de inicio y fin no son válidas");
    }

    public ObservableList<Reserva> getReservas() {
        return reservas; // Permite acceder a la lista de reservas
    }
}
