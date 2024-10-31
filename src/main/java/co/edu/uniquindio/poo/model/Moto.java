package co.edu.uniquindio.poo.model;

/**
 * Esta es la clase de Moto la cual hereda de la clase Vehiculo
 */

public class Moto extends Vehiculo {
    private TipoCaja TipoCaja;

    /**
     * Constructor de la clase Moto
     * 
     * @param tipoVehiculo
     * @param matricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param tarifaBase
     * @param tipoCaja
     */

    public Moto(String tipoVehiculo, String matricula, String marca, String modelo, int anioFabricacion,
            double tarifaBase, co.edu.uniquindio.poo.model.TipoCaja tipoCaja) {
        super(tipoVehiculo, matricula, marca, modelo, anioFabricacion, tarifaBase);
        TipoCaja = tipoCaja;
    }

    public TipoCaja getTipoCaja() {
        return TipoCaja;
    }

    public void setTipoCaja(TipoCaja tipoCaja) {
        TipoCaja = tipoCaja;
    }

    /**
     * Metodo para calcular la tarifa de la reserva para una moto
     * 
     * @param dias
     * @param tipoCaja
     * @return
     */
    
    @Override
    public double calcularTarifa(int dias) {
        double costo = getTarifaBase() * dias;
        if (getTipoCaja() == TipoCaja.AUTOMATICA) {
            costo += 50000;
        }
        return costo;
    }

    @Override
    public String toString() {
        return "Moto [tipoVehiculo=" + tipoVehiculo + ", matricula=" + matricula + ", marca=" + marca + ", modelo="
                + modelo + ", anioFabricacion=" + anioFabricacion + ", TipoCaja=" + TipoCaja + ", tarifaBase="
                + tarifaBase + "]";
    }

}
