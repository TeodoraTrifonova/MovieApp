package bg.tu.varna.sit.movieproject.controllers;

import bg.tu.varna.sit.movieproject.models.UserModel;
import bg.tu.varna.sit.movieproject.services.RegistrationService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.nio.Buffer;

import static bg.tu.varna.sit.movieproject.common.Constants.View.*;


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
    private final RegistrationService registrationService=RegistrationService.getInstance();

    @FXML
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

    @FXML
    public void toHomePage()
    {
        if (username.getText().equals("") || password.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Insert your username and password!", ButtonType.OK);
            alert.show();

        } else
        {
            UserModel userModel = new UserModel(username.getText(),password.getText());

            if (registrationService.isUserExist(userModel))
            { try
                {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HOMEPAGE_VIEW));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new HomePageController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                    }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect username or password!", ButtonType.OK);
                alert.show();
            }
        }

    }


}
