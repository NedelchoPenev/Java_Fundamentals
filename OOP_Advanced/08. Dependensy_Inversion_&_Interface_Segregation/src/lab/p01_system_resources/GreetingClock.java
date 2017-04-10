package lab.p01_system_resources;

public class GreetingClock {

    private TimeProvider timeProvider;
    private Writer writer;

    public GreetingClock(TimeProvider timeProvider, Writer writer) {
        this.timeProvider = timeProvider;
        this.writer = writer;
    }

    public void greeting() {
        if (this.timeProvider.getHour() < 12) {
            this.writer.println("Good morning...");
        } else if (this.timeProvider.getHour() < 18) {
            this.writer.println("Good afternoon...");
        } else {
            this.writer.println("Good evening...");
        }
    }
}
