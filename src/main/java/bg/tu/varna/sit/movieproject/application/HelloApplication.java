package bg.tu.varna.sit.movieproject.application;

import bg.tu.varna.sit.movieproject.common.Constants;
import bg.tu.varna.sit.movieproject.controllers.LoginController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

@Override
public void start(Stage stage) throws Exception {

    URL path = getClass().getResource(Constants.View.LOGIN_VIEW);
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
}

    public static void main(String[] args) {
        launch(args);
    }


}