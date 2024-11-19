package co.edu.uniquindio.poo.model;

public interface IGestionable  {

    public void venderVehiculo(Empleado empleado, Cliente cliente, Vehiculo vehiculo, double precioVenta,
            double impuesto);

    public void comprarVehiculo(Empleado empleado, Cliente cliente, Vehiculo vehiculo, double precioCompra,
            double descuento);

    public void alquilarVehiculo(Empleado empleado, Cliente cliente, Vehiculo vehiculo, double precioBase,
            double impuesto);
    


    
}
