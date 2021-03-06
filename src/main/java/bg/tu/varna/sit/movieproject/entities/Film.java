package bg.tu.varna.sit.movieproject.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Table(name="films")
@Entity
public class Film implements Serializable {
    @Serial
    private  static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFilm",nullable = false)
    private Long idFilm;

    @Column(name = "filmName",nullable = false)
    private String filmName;

    @Column(name = "actors",nullable = false)
    private String actors;

    @Column(name="releaseYear",nullable = false)
    private int releaseYear;

    @Column(name="rating",nullable = false)
    private int rating;

    @Column(name="description",nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGenre")
    private Genre byGenre;

    public Film() {}

    public Film(String filmName, String actors, int releaseYear, int rating, String description, Genre byGenre) {
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
        Film film = (Film) o;
        return releaseYear == film.releaseYear && Objects.equals(filmName, film.filmName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName, releaseYear);
    }

    @Override
    public String toString() {
        return "Film{" +
                "idFilm=" + idFilm +
                ", filmName='" + filmName + '\'' +
                '}';
    }
}
