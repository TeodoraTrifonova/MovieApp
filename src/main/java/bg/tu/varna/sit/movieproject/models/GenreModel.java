package bg.tu.varna.sit.movieproject.models;

import javax.persistence.Column;
import java.util.Objects;

public class GenreModel {

    private  Long idGenre;
    private  String genreName;

    public GenreModel() {
    }

    public GenreModel(String genreName) {
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
        GenreModel that = (GenreModel) o;
        return Objects.equals(genreName, that.genreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreName);
    }

    @Override
    public String toString() {
        return  genreName ;
    }
}
