package co.edu.uniquindio.poo.controller;

import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Empresa;

import co.edu.uniquindio.poo.model.Vehiculo;

public class EmpresaController {



    public EmpresaController() {

    }

    
    

    
    

    
  

    Empresa empresa;

    public EmpresaController(Empresa empresa) {
        this.empresa = empresa;
    }

    
    public boolean crearCliente(Cliente cliente) {
        return empresa.agregarCliente(cliente);
    }

    public Collection<Cliente> obtenerListaClientes() {
        return empresa.getClientes();
    }

    public boolean eliminarCliente(String cedula) {
        return empresa.eliminarCliente(cedula);
    }

    public boolean actualizarCliente(String cedula, Cliente cliente) {
        return empresa.actualizarCliente(cedula, cliente);
    }
    public boolean crearEmpleado(Empleado empleado) {
        return empresa.agregarEmpleado(empleado);
    }

    public Collection<Empleado> obtenerListaEmpleados() {
        return empresa.getEmpleados();
    }

    public boolean eliminarEmpleado(String cedula) {
        return empresa.eliminarEmpleado(cedula);
    }

    public boolean actualizarEmpleado(String cedula, Empleado empleado) {
        return empresa.actualizarEmpleado(cedula, empleado);
    }
    public void guardarClienteEnArchivo(Cliente cliente) {
    String rutaArchivo = "src\\main\\java\\co\\edu\\uniquindio\\poo\\data\\clientes.txt";
    File archivo = new File(rutaArchivo);

    try {
        // Crear archivo si no existe
        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        // Usamos BufferedWriter para escribir en el archivo
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));

        // Escribir los datos del cliente en el archivo (por ejemplo, cedula, nombre, apellido, etc.)
        writer.write(cliente.getCedula() + "," + cliente.getNombre() + "," + cliente.getApellido() + ","
                + cliente.getTelefono() + "," + cliente.getCorreo() + "," + cliente.getDireccion() + "\n");

        // Cerrar el archivo
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
