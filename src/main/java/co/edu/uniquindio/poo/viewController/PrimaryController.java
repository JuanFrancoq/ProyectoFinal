package co.edu.uniquindio.poo.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
    @FXML
    public void handleForgotPassword(ActionEvent event) {
        String email = emailField.getText();

        // Aquí deberías verificar si el correo existe en tu base de datos
        String password = getPasswordByEmail(email); // Método que obtiene la contraseña

        if (password != null) {
            sendPasswordResetEmail(email, password);
        } else {
            // Aquí puedes mostrar un mensaje de error si el correo no se encuentra registrado
            System.out.println("Correo no encontrado en el sistema");
        }
    }

    // Método que obtiene la contraseña de la base de datos (simulado aquí)
    private String getPasswordByEmail(String email) {
        // Este es un ejemplo; deberías consultar tu base de datos para obtener la contraseña real
        if ("admin".equals(email)) {
            return "admin"; // contraseña ficticia
        }
        return null;
    }

    // Método para enviar el correo con la contraseña
    private void sendPasswordResetEmail(String toEmail, String password) {
        String fromEmail = "juanj.francoq@uqvirtual.edu.co"; // Dirección de correo del servidor
        String host = "smtp.gmail.com"; // Servidor SMTP (ajusta según tu proveedor)

        // Configurar las propiedades para el correo
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Puerto de Gmail (sin SSL)
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Habilitar STARTTLS

        // Crear sesión con autenticación
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("juanj.francoq@uqvirtual.edu.co", "Locolauncho0915"); // Cambiar con tus credenciales
            }
        });

        try {
            // Crear el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Recuperación de contraseña");
            message.setText("Hola, tu contraseña es: " + password);

            // Enviar el mensaje
            Transport.send(message);
            System.out.println("Correo enviado correctamente");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
