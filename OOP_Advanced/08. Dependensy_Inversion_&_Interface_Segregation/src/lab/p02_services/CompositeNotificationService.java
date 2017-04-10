package lab.p02_services;

public class CompositeNotificationService implements NotificationService {

    private boolean isActive;
    private NotificationService[] notificationServices;

    public CompositeNotificationService(boolean isActive, NotificationService... notificationServices) {
        this.isActive = isActive;
        this.notificationServices = notificationServices;
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public void sendNotification() {
        for (NotificationService service : this.notificationServices) {
            if (service.isActive()){
                service.sendNotification();
            }
        }
    }
}
