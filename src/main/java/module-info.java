module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;

    exports co.edu.uniquindio.poo;
    exports co.edu.uniquindio.poo.model;
    opens co.edu.uniquindio.poo.model to javafx.base;
    opens co.edu.uniquindio.poo.viewController to javafx.fxml;
}
