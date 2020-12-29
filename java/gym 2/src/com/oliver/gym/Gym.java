package com.oliver.gym;

import java.util.*;
import java.util.logging.XMLFormatter;
import java.util.stream.Collectors;

import static com.oliver.gym.PersonnummerUtils.*;

/* Issues */

// User can book multiple spots for the same activity. Bug or feature? Maybe they want to bring a friend?

// Bad user interface, best we can do with a terminal 🤷‍

// No visual representation for seat selection

// User database is not persistent

// Gym class is a bit cluttered. A lot of it could be split into other classes:
// * Log in, register member could be moved to Member
// * Activity booking thing could be moved to Activity or ActivityManager

// Should have made an input helper class to get rid of all that from Gym.

public class Gym {
    public Gym() {
        members.add(new Member("oliver", "boudet", "0204150072", 1));


        while (true) {
            PresentOptions(Actions);
            switch (GetOption(Actions, "Select action")) {
                case 0:
                    BliMedlem();
                    break;
                case 1:
                    LogIn();
                    break;
                case 2:
                    ActivityBook();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }

    }

    private void ActivityBook() {
        // Check if user is logged in.
        if (CurrentMember == null) {
            System.out.println("Not logged in");
            return;
        }

        // Present all activities with available seats.
        String[] actOpts = act.GetFormattedActivites();
        PresentOptions(actOpts);
        int i = GetOption(actOpts, "Select activity");


        // Get activity at selected index
        Activity selectedActivity = act.GetActivity(i);

        // Present all available seats.
        String[] seatOpts = selectedActivity.GetFormattedAvailableSeats();
        PresentOptions(seatOpts);

        // Ask which seat user would like, mark seat as booked.
        int j = GetOption(seatOpts, "Select seat");
        Seat seat = selectedActivity.GetSeat(j);
        seat.Book(CurrentMember);

        System.out.printf("Seat %s booked.\n", seat.getName());
    }

    private void BliMedlem() {
        // enter from last nextInt messes with it idk why


        // Get name, lastName, and valid pnr
        String name = GetValue("Enter name");
        String lastName = GetValue("Enter lastname");
        String pnr = GetPnr(true);

        // Get all membership options from predefined list
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < MembershipDurations.length; i++) {
            options.add(String.format("%s - %skr", MembershipDurations[i], MembershipPrices[i]));
        }
        String[] optionsArr = options.toArray(String[]::new);

        // Ask which membership user would like
        PresentOptions(optionsArr);
        int i = GetOption(optionsArr, "Select membership");

        // Add user to in-memory database. Should use something persistent...
        members.add(new Member(name, lastName, pnr, i));
        System.out.printf("New member paying %skr/month\n", MembershipPrices[i]);
    }

    private void LogIn() {
        // Log in with pnr.
        Member member = GetMember();

        CurrentMember = member;
        System.out.printf("Logged in as %s %s. Pnr: %s\n", member.getName(), member.getLastName(), member.getSSN());
    }

    public static Integer GetPriceForMonth(int month) {
        // 1-2 månader – 400 SEK/månad
        // 3-6 månader – 350 SEK/månad
        // 7-12 månader – 300 SEK/månad
        // Längre än 12 månader – 250 SEK/månad
        // Membership fee is added in Member class.
        if (month < 0)
            return null;
        if (1 <= month && month <= 2)
            return MembershipPrices[0];
        if (3 <= month && month <= 6)
            return MembershipPrices[1];
        if (7 <= month && month <= 12)
            return MembershipPrices[2];
        if (month > 12)
            return MembershipPrices[3];
        else
            return MembershipPrices[3];
    }

    private Member GetMember() {
        Member member = null;

        // Ask for ssn until we get a matching member
        while (member == null) {
            member = GetMemberFromSsn(GetPnr(false));
        }
        return member;
    }

    private Member GetMemberFromSsn(String pnr) {
        // Find first member with ssn
        // ssn should be unique.
        Optional<Member> member = members.stream().filter(x -> x.getSSN().equals(pnr)).findFirst();

        // Return null if can't find member.
        return member.orElse(null);
    }

    private String GetPnr(boolean unique) {
        String pnr = GetValue("Enter pnr");

        // Check if member exists, if it does, get pnr again.
        if (GetMemberFromSsn(pnr) != null && unique) {
            System.out.println("Member exists!");
            return GetPnr(unique);
        }

        // Check length and if pnr is valid, if not ask for pnr again.
        while (!(pnr.length() == 10 && CheckPnr(StringToIntArray(pnr)))) {
            pnr = GetValue("Invalid pnr, try again");
        }

        return pnr;
    }

    private String GetValue(String message) {
        System.out.printf("%s: ", message);
        return scan.nextLine();
    }

    private static void PresentOptions(String[] opts) {
        int i = 0;

        // Write out every option, provided by method parameter
        for (String s : opts) {
            System.out.printf("%s. %s\n", i, s);
            i++;
        }
    }

    private int GetOption(String[] actions, String question) {
        int option = -1;
        boolean firstTime = true;

        // While answer is not between 0 and actions length, get input.
        while (!(option >= 0 && option < actions.length)) {
            if (!firstTime)
                System.out.printf("Invalid, %s: ", question);
            else
                System.out.printf("%s: ", question);
            firstTime = false;
            option = scan.nextInt();
            scan.nextLine();
        }

        return option;
    }

    private Member CurrentMember;
    private final ArrayList<Member> members = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);
    private final ActivityManager act = new ActivityManager();

    private static final String[] Actions = new String[] {
            "Bli Medlem",
            "Logga In",
            "Boka plats",
            "Avsluta"
    };

    private static final String[] MembershipDurations = {
            "1-2 months",
            "3-6 months",
            "7-12 months",
            "More than 13 months"
    };
    private static final int[] MembershipPrices = {
            400,
            250,
            300,
            250
    };
}
