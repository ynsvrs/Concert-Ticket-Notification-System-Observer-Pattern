package concrete;

import interfaces.IConcertOrganizer;
import interfaces.IFan;
import java.util.ArrayList;
import java.util.List;

public class ConcertOrganizerImpl implements IConcertOrganizer {
    private List<IFan> subscribers = new ArrayList<>();
    private List<String> concerts = new ArrayList<>();
    private String organizerName;

    public ConcertOrganizerImpl(String organizerName) {
        this.organizerName = organizerName;
    }

    @Override
    public void addSubscriber(IFan fan) {
        subscribers.add(fan);
        System.out.println(fan.getNickname() + " subscribed to " + organizerName + " notifications");
    }

    @Override
    public void removeSubscriber(IFan fan) {
        subscribers.remove(fan);
        System.out.println(fan.getNickname() + " unsubscribed from " + organizerName);
    }

    @Override
    public void notifySubscribers(String message) {
        System.out.println("\n [" + organizerName + "] Sending notification to all fans...");
        for (IFan fan : subscribers) {
            fan.update(message);
        }
    }

    public void addConcert(String artist, String location, int tickets) {
        String concertInfo = artist + " at " + location + " (" + tickets + " tickets)";
        concerts.add(concertInfo);
        System.out.println("\n New concert added: " + concertInfo);
        notifySubscribers( artist + " concert announced! Location: " + location + " | Tickets: " + tickets);
    }

    public void removeConcert(String artist) {
        concerts.removeIf(concert -> concert.contains(artist));
        System.out.println("\n Concert removed: " + artist);
        notifySubscribers( artist + " concert has been cancelled.");
    }

    public void updateTickets(String artist, int ticketsLeft) {
        notifySubscribers(" Update: " + artist + " now has " + ticketsLeft + " tickets left!");
    }

    public List<String> getConcerts() {
        return concerts;
    }
}
