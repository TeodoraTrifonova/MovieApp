package bg.tu.varna.sit.movieproject.controllers;


import bg.tu.varna.sit.movieproject.entities.Genre;
import bg.tu.varna.sit.movieproject.models.FilmModel;
import bg.tu.varna.sit.movieproject.models.GenreModel;
import bg.tu.varna.sit.movieproject.services.FilmService;
import bg.tu.varna.sit.movieproject.services.GenreService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ResourceBundle;

import static bg.tu.varna.sit.movieproject.common.Constants.View.HOMEPAGE_VIEW;
import static bg.tu.varna.sit.movieproject.common.Constants.View.LOGIN_VIEW;

public class AddMovieController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField year;
    @FXML
    private TextArea actors;
    @FXML
    private TextArea description;
    @FXML
    private ComboBox<GenreModel> genre ;
    @FXML
    private ComboBox<Integer> rating;
    @FXML
    private Button addMovie;
    @FXML
    private Button goBack;

    private final FilmService filmService= FilmService.getInstance();
    private final GenreService genreService= GenreService.getInstance();

    private final ObservableList<Integer> num = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);

    Stage s =new Stage();
    public AddMovieController(){ }
    public AddMovieController(Stage stage){s=stage;
    }
    @FXML
    public void addTheMovie(){

        if(name.getText().equals("") || year.getText().equals("") || actors.getText().equals("") || description.getText().equals("") || genre.getValue()==null || rating.getValue() == null){
            Alert alert=new Alert(Alert.AlertType.WARNING,"Please, fill all fields.", ButtonType.OK);
            alert.show();

        }
        else
        {
            FilmModel filmModel = new FilmModel(name.getText(),actors.getText(),Integer.parseInt(year.getText()) ,rating.getValue() , description.getText(),genreService.listViewToEntity(genre.getValue()));
            if(filmService.saveFilm(filmModel)){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"The movie has been added successfully.", ButtonType.OK);
                alert.show();

            }
            else
            {
                Alert alert=new Alert(Alert.AlertType.WARNING,"The movie is already added", ButtonType.OK);
                alert.show();
            }

        }

    }
     // Da se dobavqt izklyucheniq za nomera, da se ogranichi textfielda - 1900-2022 i samo chisla
    @FXML
    public void BackToHomePage(){
        try
        {   s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HOMEPAGE_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new HomePageController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rating.setItems(num);
        genre.setItems(genreService.getAllGenres());

        year.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                year.setText(t1.replaceAll("[^\\d]",""));
            }
        });


    }
}
