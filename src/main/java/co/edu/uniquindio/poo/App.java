package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.TipoCaja;
import co.edu.uniquindio.poo.viewController.EmpleadoViewController;
import co.edu.uniquindio.poo.viewController.PrimaryController;

public class App extends Application {

    private Stage primaryStage;
    public static List<Cliente> clientes = new ArrayList<>();
    public static List<Empleado> empleados = new ArrayList<>();
    public static List<Empleado> administradores = new ArrayList<>(); // Si tienes administradores

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
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load(); 
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

    
    
    public void inicializarData() {

        Cliente cliente1 = new Cliente("Pepito", "Perez", "123", "3218824490", "Av Las Americas", "cliente", "cliente");
        clientes.add(cliente1);
        Empleado empleado1 = new Empleado("lupita", "franco", "321", "3214424491", "Barrio Granada", "empleado", "empleado", "100");
        empleados.add(empleado1);
        Empleado admin1 = new Empleado("admin", "admin", "admin", "admin@uq.com", "Oficina Central", "admin", "admin", "1000");
        administradores.add(admin1);

        /** 
         * Vehiculos que se Visualizaran en el choiceBox
         */
       
    }
     // Método para verificar las credenciales
     public String verificarUsuario(String correo, String clave) {
        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().equals(correo) && cliente.getClave().equals(clave)) {
                return "CLIENTE";
            }
        }
        for (Empleado empleado : empleados) {
            if (empleado.getCorreo().equals(correo) && empleado.getClave().equals(clave)) {
                return "EMPLEADO";
            }
        }
        for (Empleado admin : administradores) {
            if (admin.getCorreo().equals(correo) && admin.getClave().equals(clave)) {
                return "ADMINISTRADOR";
            }
        }
        return null;  // Credenciales no válidas
    }
    public static void main(String[] args) {
        launch();
    
}
}