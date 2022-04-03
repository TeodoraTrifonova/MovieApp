package bg.tu.varna.sit.movieproject.services;

import bg.tu.varna.sit.movieproject.entities.Genre;
import bg.tu.varna.sit.movieproject.models.GenreModel;
import bg.tu.varna.sit.movieproject.repositories.GenreRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class GenreService {

    private static final Logger log= Logger.getLogger(UserService.class);
    private final GenreRepository genreRepository = GenreRepository.getInstance();

    public static GenreService getInstance(){
        return GenreService.GenreServiceHolder.INSTANCE;
    }

    private static class GenreServiceHolder{
        public static final GenreService INSTANCE = new GenreService();
    }

    public Genre listViewToEntity(GenreModel g){
        Genre temp = new Genre(g.getGenreName());
        List<Genre> genres = genreRepository.getAll();
        for (Genre genre: genres) {
            if(genre.equals(temp))
                return genre;
        }
        return null;
    }

    public ObservableList<GenreModel> getAllGenres()
    {
        List<Genre> genres = genreRepository.getAll();
        if(genres!=null && genres.size()!=0)
        {
            return FXCollections.observableList(genres.stream().map(genre-> new GenreModel(genre.getGenreName())).collect(Collectors.toList()));
        }
        else
        {
            log.error("Cannot find any genres in database!");
            return null;
        }
    }
}
