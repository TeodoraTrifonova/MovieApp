package bg.tu.varna.sit.movieproject.services;

import bg.tu.varna.sit.movieproject.entities.Film;
import bg.tu.varna.sit.movieproject.entities.Genre;
import bg.tu.varna.sit.movieproject.models.FilmModel;
import bg.tu.varna.sit.movieproject.repositories.FilmRepository;
import bg.tu.varna.sit.movieproject.repositories.GenreRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilmServiceTest {
    private FilmService filmService;
    private FilmRepository filmRepository;
    private Film film;
    private FilmModel filmModel;
    private GenreRepository genreRepository;
    private Genre genre1;



    @BeforeEach
    void setUp() {
        this.filmService=FilmService.getInstance();
        this.filmRepository=FilmRepository.getInstance();
        this.genreRepository=GenreRepository.getInstance();
        genre1= genreRepository.getAll().get(0);
        filmModel = new FilmModel("movie1","actor1", 2000,8,"asd",genre1);
        film = new Film("movie1","actor1", 2000,8,"asd",genre1);
    }

    @AfterEach
    void tearDown() {
        List<Film> allFilms=filmRepository.getAll();
        for (Film f:allFilms
             ) {
            if(f.equals(film))
                filmRepository.delete(film);
        }
    }

    @Test
    void filmExist() {
        List<Film> films= filmRepository.getAll();
        boolean b =false;
        for (Film f: films){
            if(f.equals(film))
            b=true;
        }
        assertFalse(b);
    }

    @Test
    void saveFilm() {
        filmRepository.save(film);
       assertTrue(filmService.filmExist(film));
    }

    @Test
    void getAllFilms() {
        List<Film> allFilms=filmRepository.getAll();
        assertEquals(allFilms,filmRepository.getAll());
    }

    @Test
    void getFilmsByActor() {

        List<Film> allFilms=filmRepository.getAll();
        int c=0;
        for(Film f : allFilms)
        {
            if(f.getActors().equals("qwe"))
            {
                c++;
            }
        }
        assertEquals(c,3);
    }

    @Test
    void getFilmsByName() {
       List<Film> allFilms=filmRepository.getAll();
       int c=0;
        for(Film f : allFilms)
        {
            if(f.getFilmName().equals("asd"))
            {
                c++;
            }
        }
        assertEquals(c,2);
    }

    @Test
    void getFilmsByRating() {
        List<Film> allFilms=filmRepository.getAll();
        int c=0;
        for(Film f : allFilms)
        {
            if(f.getRating()==4)
            {
                c++;
            }
        }
        assertEquals(c,3);

    }

    @Test
    void getFilmsByYear() {
        List<Film> allFilms=filmRepository.getAll();
        int c=0;
        for(Film f : allFilms)
        {
            if(f.getFilmName().equals("asd"))
            {
                c++;
            }
        }
        assertEquals(c,2);
    }

    @Test
    void getFilmsByGenre() {
        List<Film> allFilms=filmRepository.getAll();
        int c=0;
        for(Film f : allFilms)
        {
            if(f.getByGenre().equals(genre1))
            {
                c++;
            }
        }
        assertEquals(c,4);
    }
}