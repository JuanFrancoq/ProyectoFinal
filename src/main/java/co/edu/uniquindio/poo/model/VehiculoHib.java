package co.edu.uniquindio.poo.model;

public abstract class VehiculoHib extends Vehiculo {
    private boolean enchufable;
    private TipoCombustible TipoCombustible;

    VehiculoHib(String marca, String modelo, String tipoVehiculo, String placa, boolean nuevo, boolean revisionTecnica, int cambios, double velocidadMax, double cilindraje, TipoTransmision tipoTransmision, boolean enchufable, TipoCombustible tipoCombustible){
        super(marca, modelo, tipoVehiculo, placa, nuevo, revisionTecnica, cambios, velocidadMax, cilindraje, tipoTransmision);
        this.TipoCombustible =  tipoCombustible;
        this.enchufable=enchufable;
    }

    public boolean isEnchufable() {
        return enchufable;
    }

    public void setEnchufable(boolean enchufable) {
        this.enchufable = enchufable;
    }

    public TipoCombustible getTipoCombustible() {
        return TipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        TipoCombustible = tipoCombustible;
    }
    
}
