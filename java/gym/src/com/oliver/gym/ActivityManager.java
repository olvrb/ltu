package com.oliver.gym;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivityManager {
    private final ArrayList<Activity> activities = new ArrayList<>();

    public final void AddActivity(Activity act) {
        activities.add(act);
    }

    public final Activity[] GetActivities() {
        return activities.toArray(new Activity[activities.size()]);
    }

    public final Activity GetActivity(String name) {
        for (Activity act : activities) {
            if (act.Name == name)
                return act;
        }
        return null;
    }

    public final Activity GetActivity(int i) {
        return activities.get(i);
    }

    public final String[] GetFormattedActivites() {
        return Arrays.stream(GetActivities()).map(x -> x.Name).toArray(String[]::new);
    }

    public ActivityManager() {
        AddActivity(new Activity("Volleyball", new Seat[] {
                new Seat("1", null),
                new Seat("2", null),
                new Seat("3", null),
                new Seat("4", null),
                new Seat("5", null),
                new Seat("6", null)
        }));
        AddActivity(new Activity("Futsal", new Seat[] {
                new Seat("1", null),
                new Seat("2", null),
                new Seat("3", null),
                new Seat("4", null),
                new Seat("5", null),
                new Seat("6", null)
        }));
        AddActivity(new Activity("Spin", new Seat[] {
                new Seat("1", null),
                new Seat("2", null),
                new Seat("3", null),
                new Seat("4", null),
                new Seat("5", null),
                new Seat("6", null)
        }));
    }
}
