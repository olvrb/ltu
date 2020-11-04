package com.oliver.gym;

import java.util.*;

import static com.oliver.gym.PersonnummerUtils.*;

public class Gym {
    public Gym() {
        members.add(new Member("oliver", "boudet", "0204150072", 1));
        while (true) {
            PresentOptions(Actions);
            switch (GetOption()) {
                case 0:
                    BliMedlem();
                    break;
                case 1:
                    LogIn();
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }

    }

    private void BliMedlem() {
        // enter from last nextInt messes with it idk
        scan.nextLine();
        String name = GetValue("Enter name");
        String lastName = GetValue("Enter lastname");
        String pnr = GetPnr();
        PresentOptions((String[])MembershipOptions.keySet().toArray());
        int i = GetOption();
        Integer price = null;
        while (GetPriceForMonth(price) == null) {
            price = GetOption();
        }

        members.add(new Member(name, lastName, pnr, i));
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

    private int GetOption() {
        int option = -1;
        while (!(option >= 0 && option < Actions.length)) {
            System.out.print("Enter option: ");
            option = scan.nextInt();
        }

        return option;
    }

    private Member CurrentMember;
    public final ArrayList<Member> members = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);

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
}
