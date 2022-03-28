package bg.tu.varna.sit.movieproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button register;
    @FXML
    private Button goBack;

    Stage s =new Stage();
    public RegistrationController(){ }
    public RegistrationController(Stage stage){
        s=stage;
    }
}
