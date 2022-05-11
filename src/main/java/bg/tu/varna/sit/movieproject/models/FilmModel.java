package bg.tu.varna.sit.movieproject.models;

import bg.tu.varna.sit.movieproject.entities.Genre;

import java.util.Objects;

public class FilmModel {

    private Long idFilm;
    private String filmName;
    private String actors;
    private int releaseYear;
    private int rating;
    private String description;
    private Genre byGenre;

    public FilmModel() {
    }

    public FilmModel(String filmName) {
    }

    public FilmModel(String filmName, String actors, int releaseYear, int rating, String description, Genre byGenre) {
        this.filmName = filmName;
        this.actors = actors;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.description = description;
        this.byGenre = byGenre;
    }



    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getByGenre() {
        return byGenre;
    }

    public void setByGenre(Genre byGenre) {
        this.byGenre = byGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmModel filmModel = (FilmModel) o;
        return releaseYear == filmModel.releaseYear && Objects.equals(filmName, filmModel.filmName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName, releaseYear);
    }

    @Override
    public String toString() {
        return ""+filmName;
    }
}
