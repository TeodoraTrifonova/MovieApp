package bg.tu.varna.sit.movieproject.services;

import bg.tu.varna.sit.movieproject.entities.Film;
import bg.tu.varna.sit.movieproject.entities.Genre;
import bg.tu.varna.sit.movieproject.entities.User;
import bg.tu.varna.sit.movieproject.models.FilmModel;
import bg.tu.varna.sit.movieproject.models.UserModel;
import bg.tu.varna.sit.movieproject.repositories.FilmRepository;
import bg.tu.varna.sit.movieproject.repositories.UserRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class FilmService {
    private static final Logger log= Logger.getLogger(UserService.class);
    private final FilmRepository filmRepository = FilmRepository.getInstance();

    public static FilmService getInstance(){
        return FilmService.FilmServiceHolder.INSTANCE;
    }


    private static class FilmServiceHolder{
        public static final FilmService INSTANCE = new FilmService();
    }

    public boolean filmExist(Film f){
       List<Film> films= filmRepository.getAll();
       for (Film film: films){
           if(film.equals(f))
               return true;
       }
       return false;
    }

    public boolean saveFilm(FilmModel f){
        Film film= new Film(f.getFilmName(),f.getActors(),f.getReleaseYear(),f.getRating(),f.getDescription(),f.getByGenre());
        if(filmExist(film))
            return false;
        else {
            filmRepository.save(film);
            return true;
        }
    }

    public ObservableList<FilmModel> getAllFilms()
    {
        List<Film> films = filmRepository.getAll();
        if(films!=null && films.size()!=0)
        {
            return FXCollections.observableList(films.stream().map(film -> new FilmModel(film.getFilmName(),film.getActors(),film.getReleaseYear(),film.getRating(),film.getDescription(),film.getByGenre())).collect(Collectors.toList()));
        }
        else
        {
            log.error("Cannot find any films in database!");
            return null;
        }
    }


    public ObservableList<FilmModel> getFilmsByActor(String text) {
        ObservableList<FilmModel> allcopies = getAllFilms();
        ObservableList<FilmModel> copies = FXCollections.observableArrayList();
        for(FilmModel copy : allcopies)
        {
            if(copy.getActors().contains(text))
            {
                copies.add(copy);
            }
        }
        return copies;
    }

    public ObservableList<FilmModel> getFilmsByName(String name)
    {
        ObservableList<FilmModel> allcopies = getAllFilms();
        ObservableList<FilmModel> copies = FXCollections.observableArrayList();
        for(FilmModel copy : allcopies)
        {
            if(copy.getFilmName().equals(name))
            {
                copies.add(copy);
            }
        }
        return copies;
    }

    public ObservableList<FilmModel> getFilmsByRating(int ratingMovie)
    {
        ObservableList<FilmModel> allcopies = getAllFilms();
        ObservableList<FilmModel> copies = FXCollections.observableArrayList();
        for(FilmModel copy : allcopies)
        {
            if(copy.getRating()==ratingMovie)
            {
                copies.add(copy);
            }
        }
        return copies;
    }


    public ObservableList<FilmModel> getFilmsByYear(int year)
    {
        ObservableList<FilmModel> allcopies = getAllFilms();
        ObservableList<FilmModel> copies = FXCollections.observableArrayList();
        for(FilmModel copy : allcopies)
        {
            if(copy.getReleaseYear()==year)
            {
                copies.add(copy);
            }
        }
        return copies;
    }


    public ObservableList<FilmModel> getFilmsByGenre(Genre genreMovie) {
        ObservableList<FilmModel> allcopies = getAllFilms();
        ObservableList<FilmModel> copies = FXCollections.observableArrayList();
        for(FilmModel copy : allcopies)
        {
            if(copy.getByGenre().equals(genreMovie))
            {
                copies.add(copy);
            }
        }
        return copies;
    }

}


