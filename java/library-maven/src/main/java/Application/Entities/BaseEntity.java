package Application.Entities;

import org.activejpa.entity.Model;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.io.Serializable;
import java.util.UUID;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BaseEntity extends Model {
    @Id
    private final String Id;

    public BaseEntity() {
        this.Id = UUID.randomUUID()
                      .toString();
    }

    @Override
    public String getId() {
        return null;
    }
}
