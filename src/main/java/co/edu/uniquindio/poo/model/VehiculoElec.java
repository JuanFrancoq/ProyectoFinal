package co.edu.uniquindio.poo.model;

public abstract class VehiculoElec extends Vehiculo {
    private double autonomiaCarga, tiempoCarga;

    public VehiculoElec(String marca, String modelo, String tipoVehiculo, String placa, boolean nuevo,
            boolean revisionTecnica, int cambios, double velocidadMax, double cilindraje,
            co.edu.uniquindio.poo.model.TipoTransmision tipoTransmision, double autonomiaCarga, double tiempoCarga) {
        super(marca, modelo, tipoVehiculo, placa, nuevo, revisionTecnica, cambios, velocidadMax, cilindraje,
                tipoTransmision);
        this.autonomiaCarga = autonomiaCarga;
        this.tiempoCarga = tiempoCarga;
    }

    public double getAutonomiaCarga() {
        return autonomiaCarga;
    }

    public void setAutonomiaCarga(double autonomiaCarga) {
        this.autonomiaCarga = autonomiaCarga;
    }

    public double getTiempoCarga() {
        return tiempoCarga;
    }

    public void setTiempoCarga(double tiempoCarga) {
        this.tiempoCarga = tiempoCarga;
    }

    


    
    

}
