package bg.tu.varna.sit.movieproject.repositories;

import bg.tu.varna.sit.movieproject.access.Connection;
import bg.tu.varna.sit.movieproject.entities.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class UserRepository  implements DAORepository<User>{

    private static final Logger log = Logger.getLogger(UserRepository.class);

    public static UserRepository getInstance() {return UserRepository.UserRepositoryHolder.INSTANCE;}

    private static class UserRepositoryHolder {
        public static final UserRepository INSTANCE = new UserRepository();
    }

    @Override
    public void save(User obj)
    {    Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("User saved successfully");
        }catch (Exception e)
        {
            log.error("User save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }


    @Override
    public void update(User obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("User updated successfully");
        }catch (Exception e)
        {
            log.error("User update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(User obj) {

        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("User deleted successfully");
        }catch (Exception e)
        {
            log.error("User delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public User getById(int id) {
        return null;
    }


    @Override
    public List<User> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> actor = new LinkedList<>();
        try {
            String jpql = "SELECT t FROM users t";
            actor.addAll(session.createQuery(jpql, User.class).getResultList());
            log.info("Get all users");
        }
        catch (Exception e)
        {
            log.error("Get user error: " + e.getMessage());
        }
        finally {
            transaction.commit();
        }
        return actor;
    }
}
