package bg.tu.varna.sit.movieproject.repositories;

import java.util.List;

public interface DAORepository <T>{
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    List<T> getAll();
}
