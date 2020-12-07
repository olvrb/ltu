package com.oliver.gym;

public class Seat {
    public final String Name;
    public Member BookedMember;

    public Seat(String name, Member bookedMember) {
        Name = name;
        BookedMember = bookedMember;
    }
}
