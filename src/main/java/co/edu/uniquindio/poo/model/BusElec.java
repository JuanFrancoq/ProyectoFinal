package co.edu.uniquindio.poo.model;

public class BusElec extends VehiculoElec {
    private int numPasajeros, numPuertas, numBolsasAire, numEjes, numSalidasEmergencia;
    private boolean aireAcon, abs, camaraReversa;
    private double capacidadMaletero;
    public BusElec(String marca, String modelo, String tipoVehiculo, String placa, boolean nuevo, boolean revisionTecnica,
            int cambios, double velocidadMax, double cilindraje,
            co.edu.uniquindio.poo.model.TipoTransmision tipoTransmision, double autonomiaCarga, double tiempoCarga,
            int numPasajeros, int numPuertas, int numBolsasAire, int numEjes, int numSalidasEmergencia,
            boolean aireAcon, boolean abs, boolean camaraReversa, double capacidadMaletero) {
        super(marca, modelo, tipoVehiculo, placa, nuevo, revisionTecnica, cambios, velocidadMax, cilindraje,
                tipoTransmision, autonomiaCarga, tiempoCarga);
        this.numPasajeros = numPasajeros;
        this.numPuertas = numPuertas;
        this.numBolsasAire = numBolsasAire;
        this.numEjes = numEjes;
        this.numSalidasEmergencia = numSalidasEmergencia;
        this.aireAcon = aireAcon;
        this.abs = abs;
        this.camaraReversa = camaraReversa;
        this.capacidadMaletero = capacidadMaletero;
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
    public int getNumEjes() {
        return numEjes;
    }
    public void setNumEjes(int numEjes) {
        this.numEjes = numEjes;
    }
    public int getNumSalidasEmergencia() {
        return numSalidasEmergencia;
    }
    public void setNumSalidasEmergencia(int numSalidasEmergencia) {
        this.numSalidasEmergencia = numSalidasEmergencia;
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
    public double getCapacidadMaletero() {
        return capacidadMaletero;
    }
    public void setCapacidadMaletero(double capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }
    

    
    
    
}
