package com.oliver.gym;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivityManager {
    private ArrayList<Activity> activities = new ArrayList<>();

    public final void AddActivity(Activity act) {
        activities.add(act);
    }

    public final Activity[] GetActivities() {
        return activities.toArray(Activity[]::new);
    }

    public final Activity GetActivity(String name) {
        // Find activity by name
        for (Activity act : activities) {
            if (act.getName() == name)
                return act;
        }
        return null;
    }

    public final Activity GetActivity(int i) {
        return activities.get(i);
    }

    // Get formatted activities with available seats
    public final String[] GetFormattedActivites() {
        return Arrays.stream(GetActivities()).filter(x -> x.GetAvailableSeats().length > 0).map(Activity::getName).toArray(String[]::new);
    }

    public ActivityManager() {
        // Add place holder activities. This would be fetched from a persistent database.
        AddActivity(new Activity("Volleyball", new Seat[] {
                new Seat("1a", null),
                new Seat("1b", null),
                new Seat("1c", null),
                new Seat("2a", null),
                new Seat("2b", null),
                new Seat("2c", null),
                new Seat("3a", null),
                new Seat("3b", null),
                new Seat("3c", null)
        }));
        AddActivity(new Activity("Futsal", new Seat[] {
                new Seat("1a", null),
                new Seat("1b", null),
                new Seat("1c", null),
                new Seat("2a", null),
                new Seat("2b", null),
                new Seat("2c", null),
                new Seat("3a", null),
                new Seat("3b", null),
                new Seat("3c", null)
        }));
        AddActivity(new Activity("Spin", new Seat[] {
                new Seat("1a", null),
                new Seat("1b", null),
                new Seat("1c", null),
                new Seat("2a", null),
                new Seat("2b", null),
                new Seat("2c", null),
                new Seat("3a", null),
                new Seat("3b", null),
                new Seat("3c", null)
        }));
    }

    public ActivityManager(ArrayList<Activity> activities) {
        this.activities = activities;
    }
}
