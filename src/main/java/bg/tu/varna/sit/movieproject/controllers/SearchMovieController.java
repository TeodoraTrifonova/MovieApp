package bg.tu.varna.sit.movieproject.controllers;

import bg.tu.varna.sit.movieproject.entities.Genre;
import bg.tu.varna.sit.movieproject.models.FilmModel;
import bg.tu.varna.sit.movieproject.models.UserModel;
import bg.tu.varna.sit.movieproject.services.FilmService;
import bg.tu.varna.sit.movieproject.services.GenreService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

import static bg.tu.varna.sit.movieproject.common.Constants.View.HOMEPAGE_VIEW;

public class SearchMovieController implements Initializable {

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
            private TableView<FilmModel> table;
    @FXML
            private TableColumn<FilmModel, String> nameC;
    @FXML
            private TableColumn<FilmModel, Genre> genreC;
    @FXML
            private TableColumn<FilmModel, Integer> dateC;
    @FXML
            private TableColumn<FilmModel, Integer> ratingC;
    @FXML
            private TableColumn<FilmModel, String> actorC;
    @FXML
            private TableColumn<FilmModel, String> descriptionC;
    @FXML
            private Button exit;
    @FXML
            private RadioButton nameRadio;
    @FXML
            private RadioButton yearRadio;
    @FXML
            private RadioButton genreRadio;
    @FXML
            private RadioButton ratingRadio;
    @FXML
            private RadioButton actorRadio;


    private double xOffset = 0;
    private double yOffset = 0;

    Stage s =new Stage();
    public SearchMovieController(){ }
    public SearchMovieController(Stage stage){
        s=stage;
    }
    FilmService filmService = new FilmService();
    GenreService genreService= new GenreService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genre.getItems().clear();
        genre.getItems().addAll(genreService.getAllGenres());

        rating.getItems().clear();
        for (int i = 1; i<11; i++)
        {
            rating.getItems().add(i);
        }
        nameC.setCellValueFactory(new PropertyValueFactory<>("filmName"));
        genreC.setCellValueFactory(new PropertyValueFactory<>("byGenre"));
        dateC.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        ratingC.setCellValueFactory(new PropertyValueFactory<>("rating"));
        actorC.setCellValueFactory(new PropertyValueFactory<>("actors"));
        descriptionC.setCellValueFactory(new PropertyValueFactory<>("description"));
        ObservableList<FilmModel> list = filmService.getAllFilms();
        for(FilmModel u : list)
        {
            table.getItems().add(u);
        }
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

    @FXML
    public void Exit(ActionEvent e) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void SearchMovies()
    {
        ObservableList<FilmModel> movies;
        nameC.setCellValueFactory(new PropertyValueFactory<>("filmName"));
        genreC.setCellValueFactory(new PropertyValueFactory<>("byGenre"));
        dateC.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        ratingC.setCellValueFactory(new PropertyValueFactory<>("rating"));
        actorC.setCellValueFactory(new PropertyValueFactory<>("actors"));
        descriptionC.setCellValueFactory(new PropertyValueFactory<>("description"));

        if (nameRadio.isSelected())
        {
            movies = filmService.getFilmsByName(name.getText());
            if (movies.size()<1)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "There are no movies that match your search!", ButtonType.OK);
                alert.show();
            }
            else
            {
               table.getItems().clear();
                for(FilmModel u : movies)
                {
                    table.getItems().add(u);
                }
            }
        }
        else if (yearRadio.isSelected())
        {
            int yearN = Integer.parseInt(year.getText());
            movies = filmService.getFilmsByYear(yearN);
            if (movies.size()<1)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "There are no movies that match your search!", ButtonType.OK);
                alert.show();
            }
            else
            {
                table.getItems().clear();
                for(FilmModel u : movies)
                {
                    table.getItems().add(u);
                }
            }
        }
        else if (genreRadio.isSelected())
        {
            Genre genreMovie = genreService.getGenreByName(genre.getValue().toString());
            movies = filmService.getFilmsByGenre(genreMovie);
            if (movies.size()<1)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "There are no movies that match your search!", ButtonType.OK);
                alert.show();
            }
            else
            {
                table.getItems().clear();
                for(FilmModel u : movies)
                {
                    table.getItems().add(u);
                }
            }
        }
        else if (ratingRadio.isSelected())
        {
            int ratingMovie = Integer.parseInt(rating.getValue().toString());
            movies = filmService.getFilmsByRating(ratingMovie);
            if (movies.size()<1)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "There are no movies that match your search!", ButtonType.OK);
                alert.show();
            }
            else
            {
                table.getItems().clear();
                for(FilmModel u : movies)
                {
                    table.getItems().add(u);
                }
            }
        }
        else if (actorRadio.isSelected())
        {
            movies = filmService.getFilmsByActor(actor.getText());
            if (movies.size()<1)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "There are no movies that match your search!", ButtonType.OK);
                alert.show();
            }
            else
            {
                table.getItems().clear();
                for(FilmModel u : movies)
                {
                    table.getItems().add(u);
                }
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select a category to seach by!", ButtonType.OK);
            alert.show();
        }

    }


}

