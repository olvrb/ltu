package Application.Entities.Inventory;

import Application.Entities.BaseEntity;
import Application.Entities.Rental;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class RentalObject extends BaseEntity {
    @ManyToOne
    private Set<Rental> rentals = new HashSet<>();

    protected int rentalPeriod;


    public boolean canBeRented() {
        return this.rentalPeriod > 0;
    }
}
