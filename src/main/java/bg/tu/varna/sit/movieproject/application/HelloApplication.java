package bg.tu.varna.sit.movieproject.application;

import bg.tu.varna.sit.movieproject.common.Constants;
import bg.tu.varna.sit.movieproject.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL path = getClass().getResource(Constants.View.LOGIN_VIEW);

        FXMLLoader fxmlLoader = new FXMLLoader(path);
        fxmlLoader.setController(new LoginController(stage));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);//
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle(Constants.Titles.LoginTitle);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setWidth(600);
        stage.setHeight(400);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}