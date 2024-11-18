package co.edu.uniquindio.poo.model;

public class PickUpElec extends VehiculoElec {

    private int numPasajeros, numPuertas, numBolsasAire;
    private boolean aireAcon, abs, camaraReversa, velocidadCrucero, capacidadCajaCarga;
    public PickUpElec(String marca, String modelo, String tipoVehiculo, String placa, boolean nuevo,
            boolean revisionTecnica, int cambios, double velocidadMax, double cilindraje,
            co.edu.uniquindio.poo.model.TipoTransmision tipoTransmision, double autonomiaCarga, double tiempoCarga,
            int numPasajeros, int numPuertas, int numBolsasAire, boolean aireAcon, boolean abs, boolean camaraReversa,
            boolean velocidadCrucero, boolean capacidadCajaCarga) {
        super(marca, modelo, tipoVehiculo, placa, nuevo, revisionTecnica, cambios, velocidadMax, cilindraje,
                tipoTransmision, autonomiaCarga, tiempoCarga);
        this.numPasajeros = numPasajeros;
        this.numPuertas = numPuertas;
        this.numBolsasAire = numBolsasAire;
        this.aireAcon = aireAcon;
        this.abs = abs;
        this.camaraReversa = camaraReversa;
        this.velocidadCrucero = velocidadCrucero;
        this.capacidadCajaCarga = capacidadCajaCarga;
    }
    public int getNumPasajeros() {
        return numPasajeros;
    }
    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }
    public int getNumPuertas() {
        return numPuertas;
    }
    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
    public int getNumBolsasAire() {
        return numBolsasAire;
    }
    public void setNumBolsasAire(int numBolsasAire) {
        this.numBolsasAire = numBolsasAire;
    }
    public boolean isAireAcon() {
        return aireAcon;
    }
    public void setAireAcon(boolean aireAcon) {
        this.aireAcon = aireAcon;
    }
    public boolean isAbs() {
        return abs;
    }
    public void setAbs(boolean abs) {
        this.abs = abs;
    }
    public boolean isCamaraReversa() {
        return camaraReversa;
    }
    public void setCamaraReversa(boolean camaraReversa) {
        this.camaraReversa = camaraReversa;
    }
    public boolean isVelocidadCrucero() {
        return velocidadCrucero;
    }
    public void setVelocidadCrucero(boolean velocidadCrucero) {
        this.velocidadCrucero = velocidadCrucero;
    }
    public boolean isCapacidadCajaCarga() {
        return capacidadCajaCarga;
    }
    public void setCapacidadCajaCarga(boolean capacidadCajaCarga) {
        this.capacidadCajaCarga = capacidadCajaCarga;
    }

    
    
}
