package bg.tu.varna.sit.movieproject.controllers;

import bg.tu.varna.sit.movieproject.models.UserModel;
import javafx.event.ActionEvent;
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

import static bg.tu.varna.sit.movieproject.common.Constants.View.HOMEPAGE_VIEW;

public class SearchMovieController {




    @FXML
            private TextField name;
    @FXML
            private TextField year;
    @FXML
            private TextField actor;
    @FXML
            private ComboBox genre;
    @FXML
            private ComboBox rating;
    @FXML
            private TableView table;
    @FXML
            private TableColumn nameC;
    @FXML
            private TableColumn genreC;
    @FXML
            private TableColumn yearC;
    @FXML
            private TableColumn ratingC;
    @FXML
            private TableColumn actorC;
    @FXML
    private Button exit;


    private double xOffset = 0;
    private double yOffset = 0;

    Stage s =new Stage();
    public SearchMovieController(){ }
    public SearchMovieController(Stage stage){
        s=stage;
    }

    @FXML
    public void toHomePage()
    {
         try
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
            }
            catch (Exception e) {
                e.printStackTrace();
            }
    }


    public void Exit(ActionEvent e) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

}

