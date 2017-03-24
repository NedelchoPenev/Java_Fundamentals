package lab.p01_Weekdays;

import java.util.Comparator;

public class WeeklyEntry {
    public final static Comparator<WeeklyEntry> BY_WEEKDAY = getCompByDay();

    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Weekday.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    private static Comparator<WeeklyEntry> getCompByDay(){
        return (Comparator.comparing(d -> d.weekday));
    }

    @Override
    public String toString() {
        return this.weekday + " - " + this.notes;
    }
}
