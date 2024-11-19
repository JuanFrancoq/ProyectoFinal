    package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    private String marca, modelo, tipoVehiculo, placa;
    private boolean nuevo, revisionTecnica;
    private int cambios;
    private double velocidadMax, cilindraje;
    private TipoTransmision TipoTransmision;
    public Vehiculo(String marca, String modelo, String tipoVehiculo, String placa, boolean nuevo, boolean revisionTecnica, int cambios, double velocidadMax, double cilindraje, TipoTransmision tipoTransmision) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.placa = placa;
        this.nuevo = nuevo;
        this.revisionTecnica = revisionTecnica;
        this.cambios = cambios;
        this.velocidadMax = velocidadMax;
        this.cilindraje = cilindraje;
        TipoTransmision = tipoTransmision;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public boolean isNuevo() {
        return nuevo;
    }
    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }
    public boolean isRevisionTecnica() {
        return revisionTecnica;
    }
    public void setRevisionTecnica(boolean revisionTecnica) {
        this.revisionTecnica = revisionTecnica;
    }
    public int getCambios() {
        return cambios;
    }
    public void setCambios(int cambios) {
        this.cambios = cambios;
    }
    public double getVelocidadMax() {
        return velocidadMax;
    }
    public void setVelocidadMax(double velocidadMax) {
        this.velocidadMax = velocidadMax;
    }
    public double getCilindraje() {
        return cilindraje;
    }
    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }
    public TipoTransmision getTipoTransmision() {
        return TipoTransmision;
    }
    public void setTipoTransmision(TipoTransmision tipoTransmision) {
        TipoTransmision = tipoTransmision;
    }
    @Override
    public String toString() {
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", tipoVehiculo=" + tipoVehiculo + ", placa=" + placa
                + ", nuevo=" + nuevo + ", revisionTecnica=" + revisionTecnica + ", cambios=" + cambios
                + ", velocidadMax=" + velocidadMax + ", cilindraje=" + cilindraje + ", TipoTransmision="
                + TipoTransmision + "]";
    }
   
}
