package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Empresa {

    private String nombre;
    private Collection<Cliente> clientes;
    private Collection<Empleado> empleados;
    private Collection<Vehiculo> vehiculos;

    /**
     * Metodo constructor de la clase Empresa
     * 
     * @param nombre
     */

    public Empresa(String nombre) {
        this.nombre = nombre;
        clientes = new LinkedList<>();
        empleados = new LinkedList<>();
        vehiculos = new LinkedList<>();

    }

    /**
     * Método para agregar un cliente
     * 
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
     * 
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
     * 
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
                cliente.setApellido(actualizado.getApellido());
                cliente.setDireccion(actualizado.getDireccion());
                cliente.setClave(actualizado.getClave());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo para verificar un cliente y no se repita en la lista
     * 
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

    public boolean agregarEmpleado(Empleado empleado) {
        boolean centinela = false;
        if (!verificarEmpleado(empleado.getCedula())) {
            empleados.add(empleado);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarEmpleado(String cedula) {
        boolean centinela = false;
        for (Empleado empleado : empleados) {
            if (empleado.getCedula().equals(cedula)) {
                empleados.remove(empleado);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarEmpleado(String cedula, Empleado actualizado) {
        boolean centinela = false;
        for (Empleado empleado : empleados) {
            if (empleado.getCedula().equals(cedula)) {
                empleado.setCedula(actualizado.getCedula());
                empleado.setNombre(actualizado.getNombre());
                empleado.setCorreo(actualizado.getCorreo());
                empleado.setTelefono(actualizado.getTelefono());
                empleado.setApellido(actualizado.getApellido());
                empleado.setDireccion(actualizado.getDireccion());
                empleado.setClave(actualizado.getClave());
                empleado.setSalario(actualizado.getSalario());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo para verificar un cliente y no se repita en la lista
     * 
     * @param cedula
     * @return
     */
    public boolean verificarEmpleado(String cedula) {
        boolean centinela = false;
        for (Empleado empleado : empleados) {
            if (empleado.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public Collection<Cliente> getClientes() {
        return clientes;
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

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Collection<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Collection<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

}