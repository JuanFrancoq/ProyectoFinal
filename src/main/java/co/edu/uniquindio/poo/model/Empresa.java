package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Empresa {

    private String nombre;
    private Collection<Cliente> clientes;
    private ObservableList<Vehiculo> vehiculos;

    /**
     * Metodo constructor de la clase Empresa
     * @param nombre
     */
    public Empresa(String nombre) {
        this.nombre = nombre;
        clientes = new LinkedList<>();
        this.vehiculos = FXCollections.observableArrayList();
    }

    /**
     * Método para agregar un cliente
     * @param cliente
     */
    public boolean agregarCliente(Cliente cliente) {
        boolean centinela = false;
        if (!verificarCliente(cliente.getCedula())) {
            clientes.add(cliente);
            centinela = true;
        }
        return centinela;
    }
    /**
     * Metodo para eliminar un cliente
     * @param cedula
     * @return
     */
    public boolean eliminarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                clientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    /**
     * Metodo para actualizar los datos de un cliente
     * @param cedula
     * @param actualizado
     * @return
     */
    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setCedula(actualizado.getCedula());
                cliente.setNombre(actualizado.getNombre());
                cliente.setCorreo(actualizado.getCorreo());
                cliente.setTelefono(actualizado.getTelefono());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    /**
     * Metodo para verificar un cliente y no se repita en la lista
     * @param cedula
     * @return
     */
    public boolean verificarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }
    /**
     * Método para agregar un vehículo
     * @param vehiculo
     */
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    /**
     * Obtener la lista de clientes
     * @return
     */
    public Collection<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Obtener la lista de vehículos
     * @return
     */
    public ObservableList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClientes(ObservableList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setVehiculos(ObservableList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    
}