package Application.Entities.User;

import javax.persistence.Entity;

@Entity
public class Student extends User {
    public Student() {
        super();
        this.maxRent = 10;
    }
}
