package lab.p01_Weekdays;

public class Main {

    public static void main(String[] args) {
        WeeklyCalendar weeklyCalendar = new WeeklyCalendar();
        weeklyCalendar.addEntry("Friday", "sleep");
        weeklyCalendar.addEntry("Monday", "sport");

        Iterable<WeeklyEntry> schedule = weeklyCalendar.getWeeklySchedule();
        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }
    }
}
