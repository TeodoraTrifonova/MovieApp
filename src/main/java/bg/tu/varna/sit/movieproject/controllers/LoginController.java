package bg.tu.varna.sit.movieproject.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.nio.Buffer;

import static bg.tu.varna.sit.movieproject.common.Constants.View.LOGIN_VIEW;
import static bg.tu.varna.sit.movieproject.common.Constants.View.REGISTRATION_VIEW;


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

    public void toRegistration(){
        try
        {   s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(REGISTRATION_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new RegistrationController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
