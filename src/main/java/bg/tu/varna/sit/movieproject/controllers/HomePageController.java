package bg.tu.varna.sit.movieproject.controllers;

import bg.tu.varna.sit.movieproject.access.Connection;
import bg.tu.varna.sit.movieproject.common.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static bg.tu.varna.sit.movieproject.common.Constants.View.ADDMOVIE_VIEW;
import static bg.tu.varna.sit.movieproject.common.Constants.View.REGISTRATION_VIEW;

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


    @FXML
    public void logOut() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.LOGIN_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new LoginController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toAddMovie(){
        try
        {   s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADDMOVIE_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new AddMovieController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void toSearchMovie(){
        try
        {   s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADDMOVIE_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new AddMovieController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
