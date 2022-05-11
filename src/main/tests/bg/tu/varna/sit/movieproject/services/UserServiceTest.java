package bg.tu.varna.sit.movieproject.services;

import bg.tu.varna.sit.movieproject.models.UserModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        this.userService=UserService.getInstance();
    }


    @Test
    void getAllUsers() {
        ObservableList<UserModel> userModels= userService.getAllUsers();
        assertEquals(userModels,userService.getAllUsers());
    }
}