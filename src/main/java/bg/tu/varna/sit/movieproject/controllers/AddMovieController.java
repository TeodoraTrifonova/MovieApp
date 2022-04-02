package bg.tu.varna.sit.movieproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

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
}
