package co.edu.uniquindio.poo.controller;

import javafx.collections.ObservableList;
import java.time.LocalDate;
import java.util.Collection;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

public class ReservaController {

    private ObservableList<Reserva> reservas;

    public ReservaController(ObservableList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Método para crear una reservación
     * 
     * @param fechaInicio
     * @param fechaFin
     * @param cliente
     * @param vehiculo
     * @return
     */
    public boolean crearReserva(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, Vehiculo vehiculo) {
        if (fechaInicio != null && fechaFin != null && cliente != null && vehiculo != null) {
            double tarifaBase = calcularValorReserva(fechaInicio, fechaFin);
            Reserva reserva = new Reserva(fechaInicio, fechaFin, cliente, vehiculo);
            reservas.add(reserva);
            return true; // Reserva creada exitosamente
        }
        return false; // No se pudo crear la reserva
    }

    /**
     * Método para eliminar una reservación
     * 
     * @param reserva
     * @return
     */
    public boolean eliminarReserva(Reserva reserva) {
        return reservas.remove(reserva); // Devuelve true si se eliminó correctamente
    }

    /**
     * Método para calcular el valor de una reservación
     * 
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    public double calcularValorReserva(LocalDate fechaInicio, LocalDate fechaFin) {
        if (fechaInicio != null && fechaFin != null && fechaInicio.isBefore(fechaFin)) {
            long dias = fechaFin.toEpochDay() - fechaInicio.toEpochDay();
            double tarifaPorDia = 10000; // Ajusta el costo por día según sea necesario
            return dias * tarifaPorDia;
        }
        throw new IllegalArgumentException("Las fechas de inicio y fin no son válidas");
    }

    /**
     * Permite acceder a la lista de reservas
     * @return
     */

    public ObservableList<Reserva> getReservas() {
        return reservas;
    }

    Empresa empresa;

    public ReservaController(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Método para crear un cliente luego de ingresar los datos
     * 
     * @param cliente
     * @return
     */
    public boolean crearCliente(Cliente cliente) {
        return empresa.agregarCliente(cliente);
    }

    public Collection<Cliente> obtenerListaClientes() {
        return empresa.getClientes();
    }

    /**
     * Método para eliminar un cliente seleccionado
     * 
     * @param cedula
     * @return
     */
    public boolean eliminarCliente(String cedula) {
        return empresa.eliminarCliente(cedula);
    }

    /**
     * Método para actualizar un cliente
     * 
     * @param cedula
     * @param cliente
     * @return
     */
    public boolean actualizarCliente(String cedula, Cliente cliente) {
        return empresa.actualizarCliente(cedula, cliente);
    }
}
