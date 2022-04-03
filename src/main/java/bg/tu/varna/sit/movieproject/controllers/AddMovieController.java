package bg.tu.varna.sit.movieproject.controllers;


import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.Text;

import java.net.URL;

import static bg.tu.varna.sit.movieproject.common.Constants.View.HOMEPAGE_VIEW;

public class AddMovieController {

    @FXML
    private TextField name;
    private TextField date;
    private TextArea actors;
    private TextArea description;
    private ComboBox genre;
    private ComboBox rating;
    private Button addMovie;
    private Button goBack;

    Stage s =new Stage();
    public AddMovieController(){ }
    public AddMovieController(Stage stage){s=stage;
    }

    private double xOffset = 0;
    private double yOffset = 0;


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
}
