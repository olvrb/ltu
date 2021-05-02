package Application.Entities.User;

import Application.Entities.BaseEntity;
import Application.Entities.Inventory.RentalObject;
import Application.Entities.Rental;

import javax.persistence.*;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;


// A user has a

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User extends BaseEntity {
    private String name;
    protected int maxRent;

    @OneToMany
    private Set<Rental> rentals = new HashSet<Rental>();

    @OneToMany
    private Set<User> supervisees = new HashSet<>();

    @ManyToOne
    private Set<User> supervisor = new HashSet<>();


    public int getMaxRent() {
        return this.maxRent;
    }

    public Set<Rental> getRentals() {
        return this.rentals;
    }

    public boolean canRent(RentalObject object) {
        // Check if user is allowed to rent books, and if the object can be rented.
        return this.allowedToRent() && object.canBeRented();
    }

    public boolean allowedToRent() {
        // Check if user has reached max quota
        return this.maxRent < this.currentlyRented();
    }

    private int currentlyRented() {
        return this.rentals.stream()
                           .filter(x -> !x.returned())
                           .toArray().length;
    }
}
