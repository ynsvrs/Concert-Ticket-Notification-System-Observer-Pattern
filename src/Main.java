import concrete.ConcertOrganizerImpl;
import concrete.FanUser;

public class Main {
    public static void main(String[] args) {
        ConcertOrganizerImpl liveNation = new ConcertOrganizerImpl("Live Nation Kazakhstan");

        liveNation.addConcert("ENHYPEN", "Astana Arena", 5000);
        liveNation.addConcert("BTS", "Seoul Olympic Stadium", 10000);

        System.out.println("\n----------------------");

        FanUser fan1 = new FanUser("niyaFan", "ENHYPEN");
        FanUser fan2 = new FanUser("jayLover", "BTS");
        FanUser fan3 = new FanUser();
        fan3.setNickname("musicSoul");
        fan3.setFavoriteArtist("TXT");

        liveNation.addSubscriber(fan1);
        liveNation.addSubscriber(fan2);
        liveNation.addSubscriber(fan3);

        liveNation.notifySubscribers(" Big concert weekend coming soon!");

        System.out.println("\nAfter removing ENHYPEN concert:");
        liveNation.removeConcert("ENHYPEN");

        System.out.println("\nAfter removing musicSoul subscriber:");
        liveNation.removeSubscriber(fan3);

        System.out.println("\nAdding new concert:");
        liveNation.addConcert("TXT", "Almaty Central Stadium", 8000);

        liveNation.updateTickets("TXT", 2000);

        System.out.println("\n All concerts currently planned:");
        for (String concert : liveNation.getConcerts()) {
            System.out.println("- " + concert);
        }

        System.out.println("\n==============================");
        System.out.println("Initializing new organizer: BigHit Events Europe");
        ConcertOrganizerImpl bigHit = new ConcertOrganizerImpl("BigHit Events Europe");

        FanUser euroFan = new FanUser("EuroStar", "BTS");
        bigHit.addSubscriber(euroFan);
        bigHit.addConcert("BTS", "Paris Accor Arena", 7000);
    }
}
