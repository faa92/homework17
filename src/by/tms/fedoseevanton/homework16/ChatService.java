package by.tms.fedoseevanton.homework16;

import java.time.Instant;
import java.util.Arrays;

public class ChatService {
    private String[] massagesHistory;
    private Instant rateLimiting;

    public ChatService(String[] massagesHistory, Instant rateLimiting) {
        this.massagesHistory = massagesHistory;
        this.rateLimiting = rateLimiting;         // !!!!!!!!!!
    }

    public void addMassage(String massage) {
        Arrays.copyOf(massagesHistory, massagesHistory.length + massage.length());
    }
}
