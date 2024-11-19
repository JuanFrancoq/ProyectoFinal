package co.edu.uniquindio.poo.viewController;

import java.time.LocalDate;

import co.edu.uniquindio.poo.model.Transaccion;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class TransaccionController {

    @FXML
    private Label lblTipoTransaccion;
    @FXML
    private TextField txtCliente;
    @FXML
    private TextField txtVehiculo;
    @FXML
    private TextField txtMonto;

    private EmpleadoViewController parentController;
    private String tipoTransaccion;

    public void setParentController(EmpleadoViewController controller) {
        this.parentController = controller;
    }

    public void setTipoTransaccion(String tipo) {
        this.tipoTransaccion = tipo;
        lblTipoTransaccion.setText(tipo);
    }

    @FXML
    private void confirmarTransaccion() {
        String cliente = txtCliente.getText();
        String vehiculo = txtVehiculo.getText();
        double monto = Double.parseDouble(txtMonto.getText());
        String fecha = java.time.LocalDate.now().toString();

        Transaccion transaccion = new Transaccion(LocalDate.of(2024, 11, 18), fecha, null, null, monto);
        parentController.agregarTransaccion(transaccion);

        Stage stage = (Stage) txtMonto.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancelarTransaccion() {
        Stage stage = (Stage) txtMonto.getScene().getWindow();
        stage.close();
    }
}
