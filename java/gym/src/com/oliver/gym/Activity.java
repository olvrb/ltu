package com.oliver.gym;

import java.util.ArrayList;
import java.util.Arrays;

public class Activity {
    public final String Name;
    public final Seat[] Seats;

    public Activity(String name, Seat[] seats) {
        Name = name;
        Seats = seats;
    }

    public final Seat[] GetAvailableSeats() {
        ArrayList<Seat> seats = new ArrayList<>();

        for (Seat s : Seats) {
            if (s.Available) seats.add(s);
        }
        return seats.toArray(new Seat[seats.size()]);
    }

    public final String[] GetFormattedAvailableSeats() {
        return Arrays.stream(GetAvailableSeats()).map(x -> x.Name).toArray(String[]::new);
    }

    public final Seat GetSeat(int i) {
        return Seats[i];
    }
}
