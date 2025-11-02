package interfaces;

public interface IConcertOrganizer {
    void addSubscriber(IFan fan);
    void removeSubscriber(IFan fan);
    void notifySubscribers(String message);
}
