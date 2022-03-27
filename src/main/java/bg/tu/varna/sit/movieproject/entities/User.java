package bg.tu.varna.sit.movieproject.entities;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Table(name="users")
@Entity
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser",nullable = false)
    private Long IdUser;

    @Column(name = "username",nullable = false)
    private  String username;

    @Column(name = "password",nullable = false)
    private  String password;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getIdUser() {
        return IdUser;
    }

    public void setIdUser(Long idUser) {
        IdUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "IdUser=" + IdUser +
                '}';
    }
}
