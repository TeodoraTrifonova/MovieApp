package bg.tu.varna.sit.movieproject.repositories;

import bg.tu.varna.sit.movieproject.access.Connection;
import bg.tu.varna.sit.movieproject.entities.Actor;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ActorRepository implements DAORepository<Actor> {

    private static final Logger log = Logger.getLogger(ActorRepository.class);

    public static ActorRepository getInstance() {return ActorRepository.ActorRepositoryHolder.INSTANCE;}

    private static class ActorRepositoryHolder {
        public static final ActorRepository INSTANCE = new ActorRepository();
    }

    @Override
    public void save(Actor obj)
    {    Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Actor saved successfully");
        }catch (Exception e)
        {
            log.error("Actor save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }


    @Override
    public void update(Actor obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Actor updated successfully");
        }catch (Exception e)
        {
            log.error("Actor update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Actor obj) {

        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Actor deleted successfully");
        }catch (Exception e)
        {
            log.error("Actor delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Actor getById(int id) {
        return null;
    }


    @Override
    public List<Actor> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Actor> actor = new LinkedList<>();
        try {
            String jpql = "SELECT t FROM actors t";
            actor.addAll(session.createQuery(jpql, Actor.class).getResultList());
            log.info("Get all actors");
        }
        catch (Exception e)
        {
            log.error("Get actor error: " + e.getMessage());
        }
        finally {
            transaction.commit();
        }
        return actor;
    }


}
