package co.edu.uniquindio.poo.model;

public class Admin extends Persona {
    private double salario;

    
    public Admin(String nombre, String apellido, String cedula, String telefono, String direccion, String correo,
            String clave, double salario) {
        super(nombre, apellido, cedula, telefono, direccion, correo, clave);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
