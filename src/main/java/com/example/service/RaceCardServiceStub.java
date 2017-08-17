package com.example.service;

import com.example.model.Participant;
import com.example.model.Race;
import com.example.model.RaceCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum RaceCardServiceStub implements IRaceCardService {
    INSTANCE;

    private List<RaceCard> raceCards = new ArrayList<>();
    private List<Integer> ids = new ArrayList<>();

    RaceCardServiceStub() {

        RaceCard raceCard = new RaceCard(1, 2, "Semi-Final 100 Meters Men");
        Race race = new Race(1, 1);
        race.getParticipants().add(createParticipant(2, 1281, "Akani", "Simbine", "RSA", 9.92, 9.89));
        race.getParticipants().add(createParticipant(3, 1103, "Aska", "Cambridge", "JPN", 10.08, 10.08));
        race.getParticipants().add(createParticipant(4, 953, "James", "Dasaolu", "GBR", 10.06, 9.91));
        race.getParticipants().add(createParticipant(5, 1083, "Julian", "Forte", "JAM", 9.99, 9.99));
        race.getParticipants().add(createParticipant(6, 1395, "Justin", "Gatlin", "USA", 9.95, 9.74));
        race.getParticipants().add(createParticipant(7, 790, "Ben Youssef", "Meité", "CIV", 9.98, 9.96));
        race.getParticipants().add(createParticipant(8, 1153, "Kukyoung", "Kim", "KOR", 10.07, 10.07));
        race.getParticipants().add(createParticipant(9, 784, "Zhenye", "Xie", "CHN", 10.09, 10.08));
        raceCard.getRaces().add(race);

        race = new Race(2, 2);
        race.getParticipants().add(createParticipant(2, 1165, "Emmanuel", "Matadi", "LBR", 10.18, 10.14));
        race.getParticipants().add(createParticipant(3, 1299, "Alex", "Wilson", "SUI", 10.11, 10.11));
        race.getParticipants().add(createParticipant(4, 1074, "Yohan", "Blake", "JAM", 9.90, 9.69));
        race.getParticipants().add(createParticipant(5, 1118, "Abdul Hakim", "Sani Brown", "JPN", 10.05, 10.05));
        race.getParticipants().add(createParticipant(6, 778, "Bingtian", "Su", "CHN", 10.03, 9.99));
        race.getParticipants().add(createParticipant(7, 1347, "Jak Ali", "Harvey", "TUR", 10.10, 9.92));
        race.getParticipants().add(createParticipant(8, 1376, "Christopher", "Belcher", "USA", 9.93, 9.93));
        race.getParticipants().add(createParticipant(9, 976, "Reece", "Prescod", "GBR", 10.03, 10.03));
        raceCard.getRaces().add(race);

        race = new Race(3, 3);
        race.getParticipants().add(createParticipant(2, 1120, "Shuhei", "Tada", "JPN", 10.08, 10.08));
        race.getParticipants().add(createParticipant(3, 1343, "Emre Zafer", "Barnes", "TUR", 10.17, 10.12));
        race.getParticipants().add(createParticipant(4, 1386, "Christian", "Coleman", "USA", 9.82, 9.82));
        race.getParticipants().add(createParticipant(5, 736, "Andrew", "Fisher", "BRN", 10.12, 9.94));
        race.getParticipants().add(createParticipant(6, 1075, "Usain", "Bolt", "JAM", 9.95, 9.58));
        race.getParticipants().add(createParticipant(7, 982, "Chijindu", "Ujah", "GBR", 9.98, 9.96));
        race.getParticipants().add(createParticipant(8, 943, "Jimmy", "Vicaut", "FRA", 9.97, 9.86));
        race.getParticipants().add(createParticipant(9, 621, "Cejhae", "Greene", "ANT", 10.05, 10.01));
        raceCard.getRaces().add(race);

        raceCards.add(raceCard);

        raceCard = new RaceCard(2, 1, "Semi-Final 100 Meters Women");
        race = new Race(4, 1);
        race.getParticipants().add(createParticipant(2, 4261, "Kelly-Ann", "Baptiste", "TTO", 10.88, 10.84));
        race.getParticipants().add(createParticipant(3, 4025, "Simone", "Facey", "JAM", 11.04, 10.95));
        race.getParticipants().add(createParticipant(4, 3901, "Daryll", "Neita", "GBR", 11.14, 11.14));
        race.getParticipants().add(createParticipant(5, 4373, "Deajah", "Stevens", "USA", 11.00, 11.00));
        race.getParticipants().add(createParticipant(6, 4132, "Dafne", "Schippers", "NED", 10.95, 10.81));
        race.getParticipants().add(createParticipant(7, 3772, "Marie-Josée", "Ta Lou", "CIV", 10.90, 10.86));
        race.getParticipants().add(createParticipant(8, 3713, "Ivet", "Lalova-Collio", "BUL", 11.26, 10.77));
        race.getParticipants().add(createParticipant(9, 4034, "Jura", "Levy", "JAM", 11.06, 11.06));
        raceCard.getRaces().add(race);

        race = new Race(5, 2);
        race.getParticipants().add(createParticipant(2, 4181, "Ewa", "Swoboda", "POL", 11.24, 11.12));
        race.getParticipants().add(createParticipant(3, 3889, "Desiree", "Henry", "GBR", 11.09, 11.06));
        race.getParticipants().add(createParticipant(4, 4046, "Elaine", "Thompson", "JAM", 10.71, 10.70));
        race.getParticipants().add(createParticipant(5, 3725, "Crystal", "Emmanuel", "CAN", 11.14, 11.14));
        race.getParticipants().add(createParticipant(6, 3696, "Rosangela", "Santos", "BRA", 11.04, 11.04));
        race.getParticipants().add(createParticipant(7, 4234, "Mujinga", "Kambundji", "SUI", 11.07, 11.07));
        race.getParticipants().add(createParticipant(8, 4378, "Ariana", "Washington", "USA", 11.06, 11.01));
        race.getParticipants().add(createParticipant(9, 4204, "Carina", "Horn", "RSA", 11.10, 11.06));
        raceCard.getRaces().add(race);

        race = new Race(6, 3);
        race.getParticipants().add(createParticipant(2, 3905, "Asha", "Philip", "GBR", 11.14, 11.10));
        race.getParticipants().add(createParticipant(3, 4235, "Salomé", "Kora", "SUI", 11.27, 11.27));
        race.getParticipants().add(createParticipant(4, 4317, "Tori", "Bowie", "USA", 10.90, 10.78));
        race.getParticipants().add(createParticipant(5, 4149, "Blessing", "Okagbare-Ighoteguonor", "NGR", 10.99, 10.79));
        race.getParticipants().add(createParticipant(6, 3946, "Gina", "Lückenkemper", "GER", 10.95, 10.95));
        race.getParticipants().add(createParticipant(7, 3771, "Murielle", "Ahouré", "CIV", 10.83, 10.78));
        race.getParticipants().add(createParticipant(8, 4038, "Natasha", "Morrison", "JAM", 11.09, 10.96));
        race.getParticipants().add(createParticipant(9, 4260, "Michelle-Lee", "Ahye", "TTO", 10.82, 10.82));
        raceCard.getRaces().add(race);

        raceCards.add(raceCard);

        Collections.sort(raceCards, (Comparator.comparingInt(RaceCard::getSortOrder)));
    }

    @Override
    public List<Integer> getRaceCardIds() {

        ids.clear();
        raceCards.forEach(rc -> ids.add(rc.getId()));

        return ids;
    }

    @Override
    public RaceCard getRaceCard(int raceCardId) {
        return raceCards.stream().filter(rc -> rc.getId() == raceCardId).findFirst().orElse(null);
    }

    private Participant createParticipant(int lane, int startNumber, String firstname, String lastname, String country, double sb2017, double pb) {
        Participant participant = new Participant(lane, startNumber, firstname, lastname, country, sb2017, pb);
        return participant;
    }

    public static RaceCardServiceStub getInstance() {
        return INSTANCE;
    }
}
