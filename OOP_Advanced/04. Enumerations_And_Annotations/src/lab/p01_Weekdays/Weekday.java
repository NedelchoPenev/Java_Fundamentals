package lab.p01_Weekdays;

public enum  Weekday {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    @Override
    public String toString() {
        String letters = super.name().substring(1).toLowerCase();
        return super.name().charAt(0) + letters;
    }
}
