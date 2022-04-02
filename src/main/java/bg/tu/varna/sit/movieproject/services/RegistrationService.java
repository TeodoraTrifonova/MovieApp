package bg.tu.varna.sit.movieproject.services;

import bg.tu.varna.sit.movieproject.entities.User;
import bg.tu.varna.sit.movieproject.models.UserModel;
import bg.tu.varna.sit.movieproject.repositories.UserRepository;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class RegistrationService {
    private final UserService userService = UserService.getInstance();
    private final UserRepository userRepository=UserRepository.getInstance();

    public static RegistrationService getInstance(){
        return RegistrationService.RegistrationServiceHolder.INSTANCE;
    }

    private  static class RegistrationServiceHolder{
        public static final RegistrationService INSTANCE = new RegistrationService();
    }

    public boolean isUserExist (UserModel u)
    {
        ObservableList<UserModel> users = userService.getAllUsers();
        if(users==null)
            return false;
        for (UserModel user: users){
            if(user.equals(u)){
                return true;
            }
        }
        return false;
    }

    public void saveUser (UserModel u)
    {
        User user = new User(u.getUsername(), u.getPassword());
        userRepository.save(user);
    }
}
