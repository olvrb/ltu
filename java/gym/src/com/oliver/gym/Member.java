package com.oliver.gym;

import com.oliver.gym.Gym;

public class Member {
    public Member(String name, String lastName, String ssn, int dur) {
        this.Name = name;
        this.LastName = lastName;
        this.SSN = ssn;
        this.Duration = dur;
    }

    public String Name;
    public String LastName;
    public String SSN;
    public int Duration;
    public int GetPrice() {
        return Gym.GetPriceForMonth(Duration) * Duration + 100;
    }
}
