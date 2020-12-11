package com.oliver.gym;

public class Seat {
    private final String Name;
    private Member BookedMember;

    public Seat(String name, Member bookedMember) {
        Name = name;
        BookedMember = bookedMember;
    }

    public boolean IsFree() {
        return BookedMember != null;
    }

    public void Book(Member member) {
        this.BookedMember = member;
    }

    public String getName() {
        return Name;
    }
}
