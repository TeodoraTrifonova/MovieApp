package bg.tu.varna.sit.movieproject.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Table(name="actors")
@Entity
public class Actor implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin",nullable = false)
    private  Long idActor;

    @Column(name="actorName",nullable = false)
    private String actorName;

    public Actor(){}

    public Long getIdActor() {
        return idActor;
    }

    public void setIdActor(Long idActor) {
        this.idActor = idActor;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(actorName, actor.actorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorName);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "idActor=" + idActor +
                ", actorName='" + actorName + '\'' +
                '}';
    }
}
