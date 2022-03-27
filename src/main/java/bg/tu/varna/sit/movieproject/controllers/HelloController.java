package bg.tu.varna.sit.movieproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    Stage s=new Stage();

    public HelloController(Stage stage){
        s=stage;
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}