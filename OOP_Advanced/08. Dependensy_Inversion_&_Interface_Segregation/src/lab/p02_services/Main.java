package lab.p02_services;

public class Main {

    public static void main(String[] args) {
        OnlineStoreOrder onlineStoreOrder = new OnlineStoreOrder(
                new CompositeNotificationService(
                        true,
                        new SmsNotificationService(true),
                        new EmailNotificationService(true)
                )
        );
    }
}
