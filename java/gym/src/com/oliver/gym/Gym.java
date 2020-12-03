package com.oliver.gym;

import java.util.*;
import java.util.logging.XMLFormatter;
import java.util.stream.Collectors;

import static com.oliver.gym.PersonnummerUtils.*;

public class Gym {
    public Gym() {
        members.add(new Member("oliver", "boudet", "0204150072", 1));
        while (true) {
            PresentOptions(Actions);
            switch (GetOption(Actions)) {
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
        String[] actOpts = act.GetFormattedActivites();
        PresentOptions(actOpts);
        int i = GetOption(actOpts);
        // Get activity at selected index
        Activity selectedActivity = act.GetActivity(i);

        String[] seatOpts = selectedActivity.GetFormattedAvailableSeats();
        PresentOptions(seatOpts);
        int j = GetOption(seatOpts);
        Seat seat = selectedActivity.GetSeat(j);
        seat.Available = false;

        System.out.printf("Seat %s booked.", seat.Name);
    }

    private void BliMedlem() {
        // enter from last nextInt messes with it idk
        scan.nextLine();
        String name = GetValue("Enter name");
        String lastName = GetValue("Enter lastname");
        String pnr = GetPnr();

        // Get all membership options
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < MembershipDurations.length; i++) {
            options.add(String.format("%s - %skr", MembershipDurations[i], MembershipPrices[i]));
        }
        String[] optionsArr = options.toArray(new String[options.size()]);

        PresentOptions(optionsArr);
        int i = GetOption(optionsArr);

        members.add(new Member(name, lastName, pnr, i));
        System.out.printf("New member paying %skr/month\n", MembershipPrices[i]);
    }

    private void LogIn() {
        Member member = GetMember();

        CurrentMember = member;
        System.out.printf("Logged in as %s %s. Pnr: %s\n", member.Name, member.LastName, member.SSN);
    }

    public static Integer GetPriceForMonth(int month) {
        if (month < 0)
            return null;
        int[] priceList = Arrays.stream(MembershipOptions.values().toArray()).mapToInt(x -> (int)x).toArray();
        if (1 <= month && month <= 2)
            return priceList[0];
        if (3 <= month && month <= 6)
            return priceList[1];
        if (7 <= month && month <= 12)
            return priceList[2];
        if (month > 12)
            return priceList[3];
        else
            return priceList[3];
    }

    private Member GetMember() {
        scan.nextLine();
        Optional<Member> m = Optional.empty();

        while (m.isEmpty()) {
            String pnr = GetPnr();
            m = members.stream().filter(x -> x.SSN.equals(pnr)).findFirst();
        }

        return m.get();
    }

    private String GetPnr() {
        String pnr = GetValue("Enter pnr");

        while (!(pnr.length() == 10 && CheckPnr(StringToIntArray(pnr)))) {
            pnr = GetValue("Enter pnr");
        }

        return pnr;
    }

    private String GetValue(String message) {
        System.out.printf("%s: ", message);
        return scan.nextLine();
    }

    private static void PresentOptions(String[] opts) {
        int i = 0;
        for (String s : opts) {
            System.out.printf("%s. %s\n", i, s);
            i++;
        }
    }

    private int GetOption(String[] actions) {
        int option = -1;
        while (!(option >= 0 && option < actions.length)) {
            System.out.print("Enter option: ");
            option = scan.nextInt();
        }

        return option;
    }

    private Member CurrentMember;
    public final ArrayList<Member> members = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);
    private final ActivityManager act = new ActivityManager();

    private static final String[] Actions = new String[] {
            "Bli Medlem",
            "Logga In",
            "Boka plats",
            "Avsluta"
    };
    private static final Map<String, Integer> MembershipOptions = new HashMap<>() {{
        put("1-2 months", 400);
        put("3-6 months", 350);
        put("7-12 months", 300);
        put("More than 12 months", 250);
    }};

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
