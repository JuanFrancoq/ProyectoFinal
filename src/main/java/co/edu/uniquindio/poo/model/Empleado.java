package co.edu.uniquindio.poo.model;

public class Empleado extends Persona {
    private String salario;

    

    public Empleado(String nombre, String apellido, String cedula, String telefono, String direccion, String correo,
            String clave, String salario) {
        super(nombre, apellido, cedula, telefono, direccion, correo, clave);
        this.salario = salario;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

}

