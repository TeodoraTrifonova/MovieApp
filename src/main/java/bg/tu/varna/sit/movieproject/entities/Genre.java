package bg.tu.varna.sit.movieproject.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Table(name="genres")
@Entity
public class Genre implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGenre",nullable = false)
    private  Long idGenre;

    @Column(name = "genreName",nullable = false)
    private  String genreName;

    public Genre(){}

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public Long getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Long idGenre) {
        this.idGenre = idGenre;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(genreName, genre.genreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreName);
    }

    @Override
    public String toString() {
        return genreName;
    }
}
