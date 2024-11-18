package co.edu.uniquindio.poo.model;

public class SedanHib extends VehiculoHib {

    private int numPasajeros, numPuertas, numBolsasAires;
    private boolean capacidadMaletero, aireAcon, abs, sensorCol, asistenteCarril, sensorTrafico, camaraReversa,
            velocidadCrucero;

    public SedanHib(String marca, String modelo, String tipoVehiculo, String placa, boolean nuevo, boolean revisionTecnica,
            int cambios, double velocidadMax, double cilindraje,
            co.edu.uniquindio.poo.model.TipoTransmision tipoTransmision, boolean enchufable,
            co.edu.uniquindio.poo.model.TipoCombustible tipoCombustible, int numPasajeros, int numPuertas,
            int numBolsasAires, boolean capacidadMaletero, boolean aireAcon, boolean abs, boolean sensorCol,
            boolean asistenteCarril, boolean sensorTrafico, boolean camaraReversa, boolean velocidadCrucero) {
        super(marca, modelo, tipoVehiculo, placa, nuevo, revisionTecnica, cambios, velocidadMax, cilindraje,
                tipoTransmision, enchufable, tipoCombustible);
        this.numPasajeros = numPasajeros;
        this.numPuertas = numPuertas;
        this.numBolsasAires = numBolsasAires;
        this.capacidadMaletero = capacidadMaletero;
        this.aireAcon = aireAcon;
        this.abs = abs;
        this.sensorCol = sensorCol;
        this.asistenteCarril = asistenteCarril;
        this.sensorTrafico = sensorTrafico;
        this.camaraReversa = camaraReversa;
        this.velocidadCrucero = velocidadCrucero;
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

    public int getNumBolsasAires() {
        return numBolsasAires;
    }

    public void setNumBolsasAires(int numBolsasAires) {
        this.numBolsasAires = numBolsasAires;
    }

    public boolean isCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(boolean capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
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

    public boolean isSensorCol() {
        return sensorCol;
    }

    public void setSensorCol(boolean sensorCol) {
        this.sensorCol = sensorCol;
    }

    public boolean isAsistenteCarril() {
        return asistenteCarril;
    }

    public void setAsistenteCarril(boolean asistenteCarril) {
        this.asistenteCarril = asistenteCarril;
    }

    public boolean isSensorTrafico() {
        return sensorTrafico;
    }

    public void setSensorTrafico(boolean sensorTrafico) {
        this.sensorTrafico = sensorTrafico;
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

}
