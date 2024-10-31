package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import java.io.IOException;

import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.TipoCaja;
import co.edu.uniquindio.poo.viewController.ReservaViewController;
import co.edu.uniquindio.poo.viewController.PrimaryController;

public class App extends Application {

    private Stage primaryStage;
    public static Empresa empresa = new Empresa("FULLGAS");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Iniciar Reservación");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            PrimaryController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void openCrudReserva() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudReserva.fxml"));
            TabPane rootLayout = (TabPane) loader.load();

            ReservaViewController reservaViewController = loader.getController();
            if (reservaViewController != null) {
                reservaViewController.setApp(this);
                reservaViewController.setClientes(FXCollections.observableArrayList(empresa.getClientes()));
                reservaViewController.setVehiculos(empresa.getVehiculos()); // Establece los vehículos en el controlador
            } else {
                System.out.println("El controlador reservaViewController es nulo");
            }

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();      
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Datos que se queman para las listas
     */
    public void inicializarData() {
        /**
         * clientes que se Visualizaran en el choiceBox
         */
        empresa.agregarCliente(new Cliente("1004870686", "Juan Franco", "juanj.francoq@uqvitual.edu.co", "3174875717"));

        /**
         * Vehiculos que se Visualizaran en el choiceBox
         */
        empresa.agregarVehiculo(new Camioneta("Camioneta", "HAD666", "Toyota", "Hilux", 2015, 50000, 4));
        empresa.agregarVehiculo(new Moto("Moto", "TCB25G", "Suzuki", "Gixxer 150 FI ABS", 2025, 50000, TipoCaja.MANUAL));
        empresa.agregarVehiculo(new Moto("Moto", "BTG85F", "Yamaha", "BWS FI ABS", 2017, 50000, TipoCaja.AUTOMATICA));
        empresa.agregarVehiculo(new Auto("Auto", "ABC123", "MAZDA", "323", 1998, 40000, 4));
    }
}
