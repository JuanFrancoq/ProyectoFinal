package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.ClienteController;
import co.edu.uniquindio.poo.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClienteViewController {

    ClienteController clienteController;
    ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    Cliente selectedCliente;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_Nombre;

    @FXML
    private Button btn_Limpiar;

    @FXML
    private TableView<Cliente> tbl_ListCliente;

    @FXML
    private Button btn_Eliminar;

    @FXML
    private Button btn_ActualizarCliente;

    @FXML
    private TableColumn<Cliente, String> tbc_Nombre;

    @FXML
    private TextField txt_Correo;

    @FXML
    private TableColumn<Cliente, String> tbc_Correo;

    @FXML
    private TextField txt_Telefono;

    @FXML
    private TableColumn<Cliente, String> tbc_Telefono;

    @FXML
    private Button btn_AgregarCliente;

    @FXML
    private TableColumn<Cliente, String> tbc_Cedula;

    @FXML
    private TextField txt_Cedula;
    private App app;

    @FXML
    void onAgregarCliente() {
        agregarCliente();
    }

    @FXML
    void onActualizarCliente() {
        actualizarCliente();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminarCliente();
    }

    @FXML
    void initialize() {
        clienteController = new ClienteController(app.empresa);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerClientes();

        // Limpiar la tabla
        tbl_ListCliente.getItems().clear();

        // Agregar los elementos a la tabla
        tbl_ListCliente.setItems(listClientes);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbc_Cedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbc_Nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_Correo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tbc_Telefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerClientes() {
        listClientes.addAll(clienteController.obtenerListaClientes());
    }

    private void listenerSelection() {
        tbl_ListCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
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

    private void agregarCliente() {
        Cliente cliente = buildCliente();
        if (clienteController.crearCliente(cliente)) {
            listClientes.add(cliente);
            limpiarCamposCliente();
        }
    }

    private Cliente buildCliente() {
        Cliente cliente = new Cliente(txt_Cedula.getText(), txt_Nombre.getText(), txt_Correo.getText(), txt_Telefono.getText());
        return cliente;
    }

    private void eliminarCliente() {
        if (clienteController.eliminarCliente(txt_Cedula.getText())) {
            listClientes.remove(selectedCliente);
            limpiarCamposCliente();
            limpiarSeleccion();
        }
    }

    private void actualizarCliente() {

        if (selectedCliente != null &&
                clienteController.actualizarCliente(selectedCliente.getCedula(), buildCliente())) {

            int index = listClientes.indexOf(selectedCliente);
            if (index >= 0) {
                listClientes.set(index, buildCliente());
            }

            tbl_ListCliente.refresh();
            limpiarSeleccion();
            limpiarCamposCliente();
        }
    }

    private void limpiarSeleccion() {
        tbl_ListCliente.getSelectionModel().clearSelection();
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