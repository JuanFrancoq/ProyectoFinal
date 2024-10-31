package co.edu.uniquindio.poo.model;

/**
 * Esta es la clase de Auto la cual hereda de la clase Vehiculo
 */

public class Auto extends Vehiculo {
    private int puertas;

    /**
     * Metodo constructor para la clase Auto
     * 
     * @param matricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param tarifaBase
     * @param puertas
     */

    public Auto(String tipoVehiculo, String matricula, String marca, String modelo, int anioFabricacion,
            double tarifaBase, int puertas) {
        super(tipoVehiculo, matricula, marca, modelo, anioFabricacion, tarifaBase);
        this.puertas = puertas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    /**
     * Metodo para calcular la tarifa de reserva para un auto
     * 
     * @param dias
     * @return
     */
    public double calcularTarifa(int dias) {
        return getTarifaBase() * dias;
    }

    @Override
    public String toString() {
        return "Auto [tipoVehiculo=" + tipoVehiculo + ", matricula=" + matricula + ", marca=" + marca + ", modelo="
                + modelo + ", anioFabricacion=" + anioFabricacion + ", puertas=" + puertas + ", tarifaBase="
                + tarifaBase + "]";
    }

    
}
