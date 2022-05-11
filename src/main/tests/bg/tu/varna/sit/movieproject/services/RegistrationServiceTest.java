package bg.tu.varna.sit.movieproject.services;

import bg.tu.varna.sit.movieproject.entities.Film;
import bg.tu.varna.sit.movieproject.entities.User;
import bg.tu.varna.sit.movieproject.models.UserModel;
import bg.tu.varna.sit.movieproject.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationServiceTest {
    private RegistrationService registrationService;
    private UserModel userModel;
    private User user;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        this.registrationService=RegistrationService.getInstance();
        this.userRepository=UserRepository.getInstance();
        userModel=new UserModel("usr","psw");
        user=new User("usr","psw");
    }

    @AfterEach
    void tearDown() {
        List<User> allUsers=userRepository.getAll();
        for (User u:allUsers
        ) {
            if(u.equals(user))
                userRepository.delete(user);
        }
    }

    @Test
    void isUserExist() {
        assertFalse(registrationService.isUserExist(userModel));
    }

    @Test
    void saveUser() {
        userRepository.save(user);
        assertTrue(registrationService.isUserExist(userModel));
    }
}