package co.edu.uniquindio.poo.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.EmpresaController;
import co.edu.uniquindio.poo.model.Cliente;

import co.edu.uniquindio.poo.model.Vehiculo;

public class ClienteViewController {

    private App app;
    private EmpresaController empresaController;
    private ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    private Cliente selectedCliente;

   
    @FXML
    private ImageView imageView;

    /**
     * Campos para Clientes
     */
    @FXML
    private TextField txt_Cedula, txt_Nombre, txt_Correo, txt_Telefono, txt_Direccion, txt_Clave, txt_Apellido;
    @FXML
    private TableView<Cliente> tbl_ListClientes;
    @FXML
    private TableColumn<Cliente, String> tbc_CedulaCliente, tbc_NombreCliente, tbc_ApellidoCliente, tbc_TelefonoCliente, tbc_CorreoCliente, tbc_DireccionCliente, tbc_ClaveCliente;
    @FXML
    private Button btn_CrearCliente, btn_EliminarCliente, btn_ActualizarCliente, btn_LimpiarClientes, btn_Atras;

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    void initialize() {
        empresaController = new EmpresaController(app.empresa);

        // Inicializar tablas y ChoiceBox

        initClienteView();

        // Cargar datos de clientes y llenar ChoiceBox
        obtenerClientes();
    }

    /**
     * Métodos para gestionar la vista de reservas 
     */

    private void initView() {
        /**
         * Traer los datos del cliente a la tabla
         */
        initDataBinding();

        /**
         * Obtiene la lista
         */
        obtenerClientes();

        /**
         * Limpiar la tabla
         */
        tbl_ListClientes.getItems().clear();

        /*
         * Agregar los elementos a la tabla
         */
        tbl_ListClientes.setItems(listClientes);

        /**
         * Seleccionar elemento de la tabla
         */
        listenerSelection();
    }

    private void initDataBinding() {
        tbc_CedulaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbc_NombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_ApellidoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tbc_CorreoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tbc_DireccionCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        tbc_TelefonoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tbc_ClaveCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClave()));
    }

   

    @FXML
    private void LimpiarClientes(ActionEvent event) {
        limpiarClientes();
    }

    @FXML
    private void limpiarClientes() {
        listClientes.clear(); // Limpia la lista de clientes
        tbl_ListClientes.refresh(); // Refresca la tabla para mostrar los cambios
    }
    

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    // ---- Métodos para gestionar la vista de clientes ----

    private void initClienteView() {
        tbc_CedulaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbc_NombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_ApellidoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tbc_CorreoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tbc_DireccionCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        tbc_TelefonoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tbc_ClaveCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClave()));

        tbl_ListClientes.setItems(listClientes);

        listenerSelection();
    }

    private void obtenerClientes() {
        listClientes.addAll(empresaController.obtenerListaClientes());
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
            txt_Apellido.setText(cliente.getApellido());
            txt_Correo.setText(cliente.getCorreo());
            txt_Direccion.setText(cliente.getDireccion());
            txt_Telefono.setText(cliente.getTelefono());
            txt_Clave.setText(cliente.getClave());
        }
    }

    @FXML
    private void agregarCliente() {
        Cliente cliente = buildCliente();
        if (empresaController.crearCliente(cliente)) {
            listClientes.add(cliente);
            limpiarCamposCliente();
        }
    }

    private Cliente buildCliente() {
        Cliente cliente = new Cliente(txt_Cedula.getText(), txt_Nombre.getText(), txt_Apellido.getText(), txt_Telefono.getText(), txt_Correo.getText(), txt_Direccion.getText(), txt_Clave.getText());
        return cliente;
    }

    @FXML
    private void eliminarCliente() {
        if (empresaController.eliminarCliente(txt_Cedula.getText())) {
            listClientes.remove(selectedCliente);
            limpiarCamposCliente();
            limpiarSeleccion();
        }
    }

    @FXML
    private void actualizarCliente() {
        if (selectedCliente != null &&
                empresaController.actualizarCliente(selectedCliente.getCedula(), buildCliente())) {

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
        txt_Apellido.clear();
        txt_Correo.clear();
        txt_Direccion.clear();
        txt_Clave.clear();
        txt_Telefono.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    private void volverAtras() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/primary.fxml"));
            AnchorPane loginPage = loader.load();
            Stage stage = (Stage) btn_Atras.getScene().getWindow();
            Scene scene = new Scene(loginPage);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}