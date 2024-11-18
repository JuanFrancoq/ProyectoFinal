package co.edu.uniquindio.poo.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empleado;
import javafx.event.ActionEvent;

public class PrimaryController {

    App app;
    
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String correo = emailField.getText();
        String clave = passwordField.getText();

        // Verificar el tipo de usuario utilizando el método de App
        String userType = verificarUsuario(correo, clave);

        if (userType != null) {
            switch (userType) {
                case "CLIENTE":
                    abrirInterfaz("ClienteView.fxml");
                    break;
                case "EMPLEADO":
                    abrirInterfaz("EmpleadoView.fxml");
                    break;
                case "ADMINISTRADOR":
                    abrirInterfaz("AdminView.fxml");
                    break;
                default:
                    mostrarError("Tipo de usuario no reconocido.");
                    break;
            }
        } else {
            mostrarError("Credenciales incorrectas. Intente nuevamente.");
        }
    }

    private String verificarUsuario(String correo, String clave) {
        // Verificar si el correo y la clave coinciden con algún Cliente
        for (Cliente cliente : App.clientes) {
            if (cliente.getCorreo().equals(correo) && cliente.getClave().equals(clave)) {
                return "CLIENTE";
            }
        }

        // Verificar si el correo y la clave coinciden con algún Empleado
        for (Empleado empleado : App.empleados) {
            if (empleado.getCorreo().equals(correo) && empleado.getClave().equals(clave)) {
                return "EMPLEADO";
            }
        }

        // Verificar si el correo y la clave coinciden con algún Administrador (si tienes esta lista)
        for (Empleado admin : App.administradores) {
            if (admin.getCorreo().equals(correo) && admin.getClave().equals(clave)) {
                return "ADMINISTRADOR";
            }
        }

        return null; // Credenciales no válidas
    }

    private void abrirInterfaz(String fxmlFile) {
        try {
            // Ajuste para la ruta completa de los archivos FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/" + fxmlFile));
            Stage stage = (Stage) emailField.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            
            // Obtener el controlador del FXML cargado
            Object controller = loader.getController();
    
            // Verificar el tipo de controlador y asignar la instancia de App
            if (controller instanceof EmpleadoViewController) {
                EmpleadoViewController empleadoController = (EmpleadoViewController) controller;
                empleadoController.setApp(this.app);
            } else if (controller instanceof ClienteViewController) {
                ClienteViewController clienteController = (ClienteViewController) controller;
                clienteController.setApp(this.app);
            } else if (controller instanceof AdminViewController) {
                AdminViewController adminController = (AdminViewController) controller;
                adminController.setApp(this.app);
            }
    
            // Centrar la ventana en la pantalla
            stage.setScene(scene);
            stage.centerOnScreen();  // Centrar la ventana
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar la interfaz: " + fxmlFile);
        }
    }

    private void mostrarError(String mensaje) {
        // Mostrar un mensaje de error en la consola o en una alerta (simplificado aquí)
        System.out.println("Error: " + mensaje);
    }
    

    @FXML
    void initialize(){
        // Puedes usar este método si necesitas inicializar otros componentes
    }
}
