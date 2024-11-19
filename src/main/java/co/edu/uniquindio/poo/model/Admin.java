package co.edu.uniquindio.poo.model;

public class Admin extends Persona implements IGestionable{
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
    public void venderVehiculo(Empleado empleado, Cliente cliente, Vehiculo vehiculo, double precioVenta,
            double impuesto) {
        // Validar que los datos ingresados sean correctos
        if (precioVenta < 0 || impuesto < 0) {
            throw new IllegalArgumentException("El precio de venta y el impuesto deben ser valores positivos.");
        }

        // Calcular el monto total (precio de venta + impuesto)
        double montoTotal = precioVenta + (precioVenta * impuesto / 100);

        // Generar un ID único para la transacción de venta
        String idTransaccion = "VT-" + System.currentTimeMillis();

        // Obtener la fecha actual
        String fecha = java.time.LocalDateTime.now().toString();

        // Crear una representación de la transacción
        String transaccion = String.format(
                "ID Transacción: %s\nFecha: %s\nEmpleado: %s\nCliente: %s\nVehículo: %s\nPrecio de Venta: %.2f\nImpuesto: %.2f%%\nMonto Total: %.2f\n",
                idTransaccion,
                fecha,
                empleado.getNombre(),
                cliente.getNombre(),
                vehiculo.getModelo(),
                precioVenta,
                impuesto,
                montoTotal);

        // Mostrar la transacción registrada
        System.out.println("Transacción registrada (Venta):\n" + transaccion);
    }

    public void comprarVehiculo(Empleado empleado, Cliente cliente, Vehiculo vehiculo, double precioCompra,
            double descuento) {
        // Validar que los datos ingresados sean correctos
        if (precioCompra < 0 || descuento < 0) {
            throw new IllegalArgumentException("El precio de compra y el descuento deben ser valores positivos.");
        }

        // Calcular el monto final después de aplicar el descuento
        double montoFinal = precioCompra - (precioCompra * descuento / 100);

        // Generar un ID único para la transacción de compra
        String idTransaccion = "CP-" + System.currentTimeMillis();

        // Obtener la fecha actual
        String fecha = java.time.LocalDateTime.now().toString();

        // Crear una representación de la transacción
        String transaccion = String.format(
                "ID Transacción: %s\nFecha: %s\nEmpleado: %s\nCliente: %s\nVehículo: %s\nPrecio de Compra: %.2f\nDescuento: %.2f%%\nMonto Final: %.2f\n",
                idTransaccion,
                fecha,
                empleado.getNombre(),
                cliente.getNombre(),
                vehiculo.getModelo(),
                precioCompra,
                descuento,
                montoFinal);

        // Mostrar la transacción registrada
        System.out.println("Transacción registrada (Compra):\n" + transaccion);
    }

    @Override
    public void alquilarVehiculo(Empleado empleado, Cliente cliente, Vehiculo vehiculo, double precioBase,
            double impuesto) {
        // Validar que los datos ingresados sean correctos
        if (precioBase < 0 || impuesto < 0) {
            throw new IllegalArgumentException("El precio base y el impuesto deben ser valores positivos.");
        }

        // Calcular el monto total (precio base + impuesto)
        double montoTotal = precioBase + (precioBase * impuesto / 100);

        // Generar un ID único para la transacción
        String idTransaccion = "TX-" + System.currentTimeMillis();

        // Obtener la fecha actual
        String fecha = java.time.LocalDateTime.now().toString();

        // Crear una representación de la transacción
        String transaccion = String.format(
                "ID Transacción: %s\nFecha: %s\nEmpleado: %s\nCliente: %s\nVehículo: %s\nPrecio Base: %.2f\nImpuesto: %.2f%%\nMonto Total: %.2f\n",
                idTransaccion,
                fecha,
                empleado.getNombre(),
                cliente.getNombre(),
                vehiculo.getModelo(),
                precioBase,
                impuesto,
                montoTotal);

        // Mostrar la transacción registrada
        System.out.println("Transacción registrada:\n" + transaccion);
    }


}
