package com.oliver.gym;

import com.oliver.gym.Gym;

public class Member {
    public Member(String name, String lastName, String ssn, int dur) {
        this.Name = name;
        this.LastName = lastName;
        this.SSN = ssn;
        this.Duration = dur;
    }

    private String Name;
    private String LastName;
    private String SSN;
    private int Duration;

    public int GetPrice() {
        // Price + membership fee (100kr)
        return Gym.GetPriceForMonth(Duration) * Duration + 100;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getSSN() {
        return SSN;
    }
}
