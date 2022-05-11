package bg.tu.varna.sit.movieproject.repositories;

import bg.tu.varna.sit.movieproject.access.Connection;
import bg.tu.varna.sit.movieproject.entities.Genre;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class GenreRepository  implements DAORepository<Genre>{

    private static final Logger log = Logger.getLogger(GenreRepository.class);

    public static GenreRepository getInstance() {return GenreRepository.GenreRepositoryHolder.INSTANCE;}

    private static class GenreRepositoryHolder {
        public static final GenreRepository INSTANCE = new GenreRepository();
    }

    @Override
    public void save(Genre obj)
    {    Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Genre saved successfully");
        }catch (Exception e)
        {
            log.error("Genre save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }


    @Override
    public void update(Genre obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Genre updated successfully");
        }catch (Exception e)
        {
            log.error("Genre update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Genre obj) {

        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Genre deleted successfully");
        }catch (Exception e)
        {
            log.error("Genre delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }
    }



    @Override
    public List<Genre> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Genre> actor = new LinkedList<>();
        try {
            String jpql = "SELECT t FROM Genre t";
            actor.addAll(session.createQuery(jpql, Genre.class).getResultList());
            log.info("Get all genres");
        }
        catch (Exception e)
        {
            log.error("Get genre error: " + e.getMessage());
        }
        finally {
            transaction.commit();
        }
        return actor;
    }

}
