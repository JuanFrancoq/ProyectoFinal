package co.edu.uniquindio.poo.model;

/**
 * Esta es la clase de Camioneta la cual hereda de la clase Vehiculo
 */

public class Camioneta extends Vehiculo {
    private double capacidadToneladas;

    /**
     * Metodo constructo para la clase Camioneta
     * 
     * @param tipoVehiculo
     * @param matricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param tarifaBase
     * @param capacidadToneladas
     */
    public Camioneta(String tipoVehiculo, String matricula, String marca, String modelo, int anioFabricacion,
            double tarifaBase, double capacidadToneladas) {
        super(tipoVehiculo, matricula, marca, modelo, anioFabricacion, tarifaBase);
        this.capacidadToneladas = capacidadToneladas;
    }

    public double getCapacidadToneladas() {
        return capacidadToneladas;
    }

    public void setCapacidadToneladas(double capacidadToneladas) {
        this.capacidadToneladas = capacidadToneladas;
    }

    /**
     * Metodo para calcular la tarifa de reserva para una camioneta
     * 
     * @param dias
     * @param capacidadToneladas
     * @return
     */
    public double calcularTarifaCamioneta(int dias, double capacidadToneladas) {

        double tarifaBaseTotal = getTarifaBase() * dias;
        double porcentajeExtra = tarifaBaseTotal * (capacidadToneladas * 0.20);
        return tarifaBaseTotal + porcentajeExtra;
    }

    @Override
    public String toString() {
        return "Camioneta [tipoVehiculo=" + tipoVehiculo + ", matricula=" + matricula + ", marca=" + marca + ", modelo="
                + modelo + ", anioFabricacion=" + anioFabricacion + ", capacidadToneladas=" + capacidadToneladas
                + ", tarifaBase=" + tarifaBase + "]";
    }

}
