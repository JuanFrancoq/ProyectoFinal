package co.edu.uniquindio.poo.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.ReservaController;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

public class ReservaViewController {

    private App app;
    private ReservaController reservaController;
    private ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    private ObservableList<Reserva> reservas = FXCollections.observableArrayList();
    private Cliente selectedCliente;

    // Campos para Reservas
    @FXML
    private Label lbl_FechaInicio, lbl_FechaFin;
    @FXML
    private ChoiceBox<Cliente> cb_Cliente;
    @FXML
    private ChoiceBox<Vehiculo> cb_Modelo;
    @FXML
    private DatePicker datePickerInicio, datePickerFin;
    @FXML
    private TableView<Reserva> tbl_ListReservas;
    @FXML
    private TableColumn<Reserva, String> tbc_Fecha, tbc_Cedula, tbc_Nombre, tbc_Telefono, tbc_TipoVehiculo, tbc_Marca, tbc_Modelo, tbc_Matricula;
    @FXML
    private TableColumn<Reserva, Double> tbc_Valor;
    @FXML
    private Button btn_Crear, btn_Eliminar, btn_Actualizar, btn_Calcular;
    @FXML
    private ImageView imageView;

    // Campos para Clientes
    @FXML
    private TextField txt_Cedula, txt_Nombre, txt_Correo, txt_Telefono;
    @FXML
    private TableView<Cliente> tbl_ListClientes;
    @FXML
    private TableColumn<Cliente, String> tbc_CedulaCliente, tbc_NombreCliente, tbc_CorreoCliente, tbc_TelefonoCliente;
    @FXML
    private Button btn_CrearCliente, btn_EliminarCliente, btn_ActualizarCliente, btn_Limpiar;

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    void initialize() {
        reservaController = new ReservaController(app.empresa);

        // Inicializar tablas y ChoiceBox
        initReservaView();
        initClienteView();

        // Cargar datos de clientes y llenar ChoiceBox
        obtenerClientes();
        cb_Cliente.setItems(listClientes);
    }

    // ---- Métodos para gestionar la vista de reservas ----

    private void initReservaView() {
        tbc_Fecha.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        tbc_Cedula.setCellValueFactory(new PropertyValueFactory<>("cedulaCliente"));
        tbc_Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tbc_Telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tbc_TipoVehiculo.setCellValueFactory(new PropertyValueFactory<>("tipoVehiculo"));
        tbc_Marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tbc_Modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tbc_Matricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        tbc_Valor.setCellValueFactory(new PropertyValueFactory<>("valorReserva"));

        tbl_ListReservas.setItems(reservas);
    }

    @FXML
    private void crearReserva() {
        LocalDate fechaInicio = datePickerInicio.getValue();
        LocalDate fechaFin = datePickerFin.getValue();
        Cliente cliente = cb_Cliente.getValue();
        Vehiculo vehiculo = cb_Modelo.getValue();

        if (fechaInicio != null && fechaFin != null && cliente != null && vehiculo != null) {
            double valorReserva = calcularValorReserva(fechaInicio, fechaFin);
            Reserva reserva = new Reserva(fechaInicio, fechaFin, cliente, vehiculo);
            reservas.add(reserva);
            tbl_ListReservas.refresh();
        } else {
            System.out.println("Por favor completa todos los campos");
        }
    }

    @FXML
    private void eliminarReserva() {
        Reserva selectedReserva = tbl_ListReservas.getSelectionModel().getSelectedItem();
        if (selectedReserva != null) {
            reservas.remove(selectedReserva);
        } else {
            System.out.println("Seleccione una reserva para eliminar.");
        }
    }

    @FXML
    private void actualizarReserva() {
        System.out.println("Funcionalidad para actualizar la reserva aún no implementada.");
    }

    @FXML
    private void calcularReserva() {
        LocalDate fechaInicio = datePickerInicio.getValue();
        LocalDate fechaFin = datePickerFin.getValue();
        if (fechaInicio != null && fechaFin != null) {
            double valor = calcularValorReserva(fechaInicio, fechaFin);
            System.out.println("El valor de la reserva es: " + valor);
        } else {
            System.out.println("Selecciona fechas de inicio y fin.");
        }
    }

    private double calcularValorReserva(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = fechaFin.toEpochDay() - fechaInicio.toEpochDay();
        return dias * 10000;
    }

    public void setClientes(ObservableList<Cliente> clientes) {
        listClientes.setAll(clientes);
        cb_Cliente.setItems(listClientes);
    }
    
    public void setVehiculos(ObservableList<Vehiculo> vehiculos) {
        cb_Modelo.setItems(vehiculos);
    }

    // ---- Métodos para gestionar la vista de clientes ----

    private void initClienteView() {
        tbc_CedulaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbc_NombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_CorreoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tbc_TelefonoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));

        tbl_ListClientes.setItems(listClientes);

        listenerSelection();
    }

    private void obtenerClientes() {
        listClientes.addAll(reservaController.obtenerListaClientes());
    }

    private void listenerSelection() {
        tbl_ListClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            mostrarInformacionCliente(selectedCliente);
        });
    }

    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txt_Cedula.setText(cliente.getCedula());
            txt_Nombre.setText(cliente.getNombre());
            txt_Correo.setText(cliente.getCorreo());
            txt_Telefono.setText(cliente.getTelefono());
        }
    }

    @FXML
    private void agregarCliente() {
        Cliente cliente = buildCliente();
        if (reservaController.crearCliente(cliente)) {
            listClientes.add(cliente);
            limpiarCamposCliente();
        }
    }

    private Cliente buildCliente() {
        return new Cliente(txt_Cedula.getText(), txt_Nombre.getText(), txt_Correo.getText(), txt_Telefono.getText());
    }

    @FXML
    private void eliminarCliente() {
        if (reservaController.eliminarCliente(txt_Cedula.getText())) {
            listClientes.remove(selectedCliente);
            limpiarCamposCliente();
            limpiarSeleccion();
        }
    }

    @FXML
    private void actualizarCliente() {
        if (selectedCliente != null &&
                reservaController.actualizarCliente(selectedCliente.getCedula(), buildCliente())) {

            int index = listClientes.indexOf(selectedCliente);
            if (index >= 0) {
                listClientes.set(index, buildCliente());
            }

            tbl_ListClientes.refresh();
            limpiarSeleccion();
            limpiarCamposCliente();
        }
    }

    @FXML
    private void limpiarSeleccion() {
        tbl_ListClientes.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }

    private void limpiarCamposCliente() {
        txt_Cedula.clear();
        txt_Nombre.clear();
        txt_Correo.clear();
        txt_Telefono.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
