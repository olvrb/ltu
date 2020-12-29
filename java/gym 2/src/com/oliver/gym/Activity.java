package com.oliver.gym;

import java.util.ArrayList;
import java.util.Arrays;

public class Activity {
    private final String Name;
    private final Seat[] Seats;

    public String getName() {
        return Name;
    }

    public Activity(String name, Seat[] seats) {
        Name = name;
        Seats = seats;
    }

    public final Seat[] GetAvailableSeats() {
        ArrayList<Seat> seats = new ArrayList<>();

        // Get all seats that don't have a member assigned to them
        for (Seat s : Seats) {
            if (!s.IsFree()) seats.add(s);
        }
        return seats.toArray(Seat[]::new);
    }

    public final String[] GetFormattedAvailableSeats() {
        // Get all seat names as an array
        return Arrays.stream(GetAvailableSeats()).map(x -> x.getName()).toArray(String[]::new);
    }

    public final Seat GetSeat(int i) {
        return Seats[i];
    }
}
