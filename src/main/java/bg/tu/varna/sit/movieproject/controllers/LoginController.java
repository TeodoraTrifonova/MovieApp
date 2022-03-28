package bg.tu.varna.sit.movieproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.nio.Buffer;


public class LoginController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Button register;

    Stage s =new Stage();
    public LoginController(){ }
    public LoginController(Stage stage){
        s=stage;
    }


}
