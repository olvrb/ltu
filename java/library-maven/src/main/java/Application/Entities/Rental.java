package Application.Entities;

import Application.Entities.BaseEntity;
import Application.Entities.Inventory.RentalObject;
import Application.Entities.User.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Rental extends BaseEntity {
    private boolean returned;
    private Date startDate;


    @ManyToOne
    private RentalObject rentalObject;

    @ManyToOne
    private User user;

    public boolean returned() {
        return this.returned;
    }
}
