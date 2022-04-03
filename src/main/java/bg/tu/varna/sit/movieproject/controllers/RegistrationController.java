package bg.tu.varna.sit.movieproject.controllers;

import bg.tu.varna.sit.movieproject.models.UserModel;
import bg.tu.varna.sit.movieproject.services.RegistrationService;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

import static bg.tu.varna.sit.movieproject.common.Constants.View.LOGIN_VIEW;
import static bg.tu.varna.sit.movieproject.common.Constants.View.REGISTRATION_VIEW;

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

    private double xOffset = 0;
    private double yOffset = 0;

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
            {
                registrationService.saveUser(userModel);
                try
                {
                    s.close();
                    Stage stage =new Stage();
                    URL path = getClass().getResource(LOGIN_VIEW);
                    FXMLLoader fxmlLoader = new FXMLLoader(path);
                    fxmlLoader.setController(new LoginController(stage));
                    Parent root = fxmlLoader.load();
                    stage.initStyle(StageStyle.TRANSPARENT);
                    root.setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            xOffset = event.getSceneX();
                            yOffset = event.getSceneY();
                        }
                    });
                    root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            stage.setX(event.getScreenX() - xOffset);
                            stage.setY(event.getScreenY() - yOffset);
                        }
                    });
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
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

    @FXML
    public void backToLogin(){
        try
        {
            s.close();
            Stage stage =new Stage();
            URL path = getClass().getResource(LOGIN_VIEW);
            FXMLLoader fxmlLoader = new FXMLLoader(path);
            fxmlLoader.setController(new LoginController(stage));
            Parent root = fxmlLoader.load();
            stage.initStyle(StageStyle.TRANSPARENT);
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
