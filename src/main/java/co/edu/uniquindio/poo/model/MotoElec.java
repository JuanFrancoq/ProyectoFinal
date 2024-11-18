package co.edu.uniquindio.poo.model;

public class MotoElec extends VehiculoElec {
    
    public MotoElec(String marca, String modelo, String tipoVehiculo, String placa, boolean nuevo, boolean revisionTecnica, int cambios, double velocidadMax, double cilindraje, co.edu.uniquindio.poo.model.TipoTransmision tipoTransmision, double autonomiaCarga, double tiempoCarga){
        super(marca, modelo, tipoVehiculo, placa, nuevo, revisionTecnica, cambios, velocidadMax, cilindraje, tipoTransmision, autonomiaCarga, tiempoCarga);
        
    }

    @Override
    public String toString() {
        return "MotoElec []";
    }
    
}
