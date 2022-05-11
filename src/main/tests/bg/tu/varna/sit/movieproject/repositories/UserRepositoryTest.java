package bg.tu.varna.sit.movieproject.repositories;

import bg.tu.varna.sit.movieproject.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private User user;
    private UserRepository userRepository;
    private List<User> allUsers;

    @BeforeEach
    void setUp() {
        this.user=new User("temp","t123");
        this.userRepository=UserRepository.getInstance();
        this.allUsers=userRepository.getAll();
    }

    @AfterEach
    void tearDown() {
        userRepository.delete(user);
    }

    @Test
    void save() {
        List<User> users =userRepository.getAll();
        userRepository.save(user);
        assertNotEquals(users,userRepository.getAll());
    }

    @Test
    void update() {
        List<User> users =userRepository.getAll();
        User u= userRepository.getAll().get(0);
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        userRepository.update(u);

        assertNotEquals(users,userRepository.getAll());
    }

    @Test
    void delete() {
        List<User> users =userRepository.getAll();
        userRepository.delete(user);
        assertEquals(users,userRepository.getAll());
    }

    @Test
    void getAll() {
        List<User> allUsers=userRepository.getAll();
        assertEquals(allUsers,userRepository.getAll());
    }
}