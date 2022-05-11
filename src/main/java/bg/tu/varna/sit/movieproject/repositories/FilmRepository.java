package bg.tu.varna.sit.movieproject.repositories;

import bg.tu.varna.sit.movieproject.access.Connection;
import bg.tu.varna.sit.movieproject.entities.Film;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class FilmRepository  implements DAORepository<Film>  {

    private static final Logger log = Logger.getLogger(FilmRepository.class);

    public static FilmRepository getInstance() {return FilmRepository.FilmRepositoryHolder.INSTANCE;}

    private static class FilmRepositoryHolder {
        public static final FilmRepository INSTANCE = new FilmRepository();
    }

    @Override
    public void save(Film obj)
    {    Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Film saved successfully");
        }catch (Exception e)
        {
            log.error("Film save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }


    @Override
    public void update(Film obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Film updated successfully");
        }catch (Exception e)
        {
            log.error("Film update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Film obj) {

        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Film deleted successfully");
        }catch (Exception e)
        {
            log.error("Film delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }
    }


    @Override
    public List<Film> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Film> film = new LinkedList<>();
        try {
            String jpql = "SELECT t FROM Film t";
            film.addAll(session.createQuery(jpql, Film.class).getResultList());
            log.info("Get all films");
        }
        catch (Exception e)
        {
            log.error("Get actor error: " + e.getMessage());
        }
        finally {
            transaction.commit();
        }
        return film;
    }

}
