package bg.tu.varna.sit.movieproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            private TableCell nameC;
    @FXML
            private TableCell genreC;
    @FXML
            private TableCell yearC;
    @FXML
            private TableCell ratingC;
    @FXML
            private TableCell actorC;

    Stage s =new Stage();
    public SearchMovieController(){ }
    public SearchMovieController(Stage stage){
        s=stage;
    }
}
