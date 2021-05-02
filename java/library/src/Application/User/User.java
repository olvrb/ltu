package Application.User;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {
    @Id
    private String id;

    private String name;


    public User() {
        this.id = UUID.randomUUID().toString();
    }
}
