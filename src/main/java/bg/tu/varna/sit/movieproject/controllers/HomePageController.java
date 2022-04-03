package bg.tu.varna.sit.movieproject.controllers;

import bg.tu.varna.sit.movieproject.access.Connection;
import bg.tu.varna.sit.movieproject.common.Constants;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

import static bg.tu.varna.sit.movieproject.common.Constants.View.*;

public class HomePageController {
    @FXML
    private Button addMovies;
    @FXML
    private Button searchMovies;
    @FXML
    private Button logout;
    @FXML
    private Button exit;

    Stage s =new Stage();
    public HomePageController(){ }
    public HomePageController(Stage stage){s=stage;
    }

    private double xOffset = 0;
    private double yOffset = 0;


    @FXML
    public void logOut() {
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

    @FXML
    public void toAddMovie(){
        try
        {
            s.close();
            Stage stage =new Stage();
            URL path = getClass().getResource(ADDMOVIE_VIEW);
            FXMLLoader fxmlLoader = new FXMLLoader(path);
            fxmlLoader.setController(new AddMovieController(stage));
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
    public void toSearchMovie(){
        try
        {    s.close();
            Stage stage =new Stage();
            URL path = getClass().getResource(SEARCH_MOVIE_VIEW);
            FXMLLoader fxmlLoader = new FXMLLoader(path);
            fxmlLoader.setController(new SearchMovieController(stage));
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
