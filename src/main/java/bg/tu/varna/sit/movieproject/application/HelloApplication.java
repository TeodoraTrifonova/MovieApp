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
/*



    @Override
    public void start(Stage stage) throws IOException {
        URL path = getClass().getResource(Constants.View.LOGIN_VIEW);

        FXMLLoader fxmlLoader = new FXMLLoader(path);
        fxmlLoader.setController(new LoginController(stage));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle(Constants.Titles.LoginTitle);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT); // Tedi ottuk si ti!!!
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

 */
@Override
public void start(Stage stage) throws Exception {

    URL path = getClass().getResource(Constants.View.LOGIN_VIEW);
    FXMLLoader fxmlLoader = new FXMLLoader(path);
    fxmlLoader.setController(new LoginController(stage));
    Parent root = fxmlLoader.load();
    //you can use underdecorated or transparent.
        stage.initStyle(StageStyle.TRANSPARENT);
    //stage.initStyle(StageStyle.UNDERDECORATED);

    //grab your root here
             root.setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        }
    });

    //move around here
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


}