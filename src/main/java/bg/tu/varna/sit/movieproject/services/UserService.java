package bg.tu.varna.sit.movieproject.services;

import bg.tu.varna.sit.movieproject.entities.User;
import bg.tu.varna.sit.movieproject.models.UserModel;
import bg.tu.varna.sit.movieproject.repositories.UserRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static final Logger log= Logger.getLogger(UserService.class);
    private final UserRepository userRepository = UserRepository.getInstance();

    public static UserService getInstance(){
        return UserServiceHolder.INSTANCE;
    }

    private static class UserServiceHolder{
        public static final UserService INSTANCE = new UserService();
    }

    public ObservableList<UserModel> getAllUsers()
    {
        List<User> users = userRepository.getAll();
        if(users!=null && users.size()!=0)
        {
            return FXCollections.observableList(users.stream().map(user -> new UserModel(user.getUsername(), user.getPassword())).collect(Collectors.toList()));
        }
        else
        {
            log.error("Cannot find any admins in database!");
            return null;
        }
    }
}
