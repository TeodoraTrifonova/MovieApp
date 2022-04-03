package bg.tu.varna.sit.movieproject.controllers;

import bg.tu.varna.sit.movieproject.common.Constants;
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
import org.w3c.dom.Text;

import java.net.URL;
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


    private double xOffset = 0;
    private double yOffset = 0;

    Stage s =new Stage();
    public LoginController(){ }
    public LoginController(Stage stage){
        s=stage;
    }
    private final RegistrationService registrationService=RegistrationService.getInstance();

    @FXML
    public void toRegistration(){
        try
        {
            s.close();
            Stage stage =new Stage();
            URL path = getClass().getResource(REGISTRATION_VIEW);
            FXMLLoader fxmlLoader = new FXMLLoader(path);
            fxmlLoader.setController(new RegistrationController(stage));
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
                    Stage stage =new Stage();
                    URL path = getClass().getResource(HOMEPAGE_VIEW);
                    FXMLLoader fxmlLoader = new FXMLLoader(path);
                    fxmlLoader.setController(new HomePageController(stage));
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
