package bg.tu.varna.sit.movieproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageController {
    @FXML
    private Button addMovies;
    @FXML
    private Button searchMovies;
    @FXML
    private Button logout;


    Stage s =new Stage();
    public HomePageController(){ }
    public HomePageController(Stage stage){s=stage;
    }
}
