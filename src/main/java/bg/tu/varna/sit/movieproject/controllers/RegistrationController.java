package bg.tu.varna.sit.movieproject.controllers;

import bg.tu.varna.sit.movieproject.models.UserModel;
import bg.tu.varna.sit.movieproject.services.RegistrationService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static bg.tu.varna.sit.movieproject.common.Constants.View.LOGIN_VIEW;

public class RegistrationController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button register;
    @FXML
    private Button goBack;
    private final RegistrationService registrationService=RegistrationService.getInstance();

    Stage s =new Stage();
    public RegistrationController(){ }
    public RegistrationController(Stage stage){
        s=stage;
    }

    @FXML
    public void userRegistration() throws InterruptedException {
        if(username.getText().equals("") || password.getText().equals(""))
        {
            Alert alert=new Alert(Alert.AlertType.WARNING,"Insert your username and password!", ButtonType.OK);
            alert.show();

        }
        else
        {
            UserModel userModel = new UserModel(username.getText(),password.getText());
            if(registrationService.isUserExist(userModel)){
                Alert alert=new Alert(Alert.AlertType.WARNING,"User is already exist.", ButtonType.OK);
                alert.show();
            }
            else
            {registrationService.saveUser(userModel);
                try
                {   s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(LOGIN_VIEW));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new LoginController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Your registration has been successful.", ButtonType.OK);
                alert.show();
            }
        }
    }


}
