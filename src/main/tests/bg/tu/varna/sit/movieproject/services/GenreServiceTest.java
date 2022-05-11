package bg.tu.varna.sit.movieproject.services;

import bg.tu.varna.sit.movieproject.entities.Film;
import bg.tu.varna.sit.movieproject.entities.Genre;
import bg.tu.varna.sit.movieproject.models.GenreModel;
import bg.tu.varna.sit.movieproject.repositories.GenreRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenreServiceTest {
    private GenreService genreService;
    private GenreRepository genreRepository;
    private Genre genre;
    private GenreModel genreModel;

    @BeforeEach
    void setUp() {
        this.genreService=GenreService.getInstance();
        this.genreRepository=GenreRepository.getInstance();
        genreModel=new GenreModel("Musical");
        genre=new Genre("Anime");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listViewToEntity() {
        assertNull(genreService.listViewToEntity(genreModel));
    }

    @Test
    void getAllGenres() {
        List<Genre> allGenres=genreRepository.getAll();
        assertEquals(allGenres,genreRepository.getAll());
    }

    @Test
    void getGenreByName() {
    Genre genre2=genreRepository.getAll().get(0);
        assertEquals(genre2.getGenreName(),genreRepository.getAll().get(0).getGenreName());
    }
}