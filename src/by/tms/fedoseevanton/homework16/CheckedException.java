package by.tms.fedoseevanton.homework16;

import java.time.Instant;

public class CheckedException extends Exception {
    Instant timeCanChat;

    public CheckedException(Instant timeCanChat) {
        super("User exceeded rate limiting of sending messages at " + timeCanChat);
        this.timeCanChat = timeCanChat;
    }

    public Instant getTimeCanChat() {
        return timeCanChat;
    }

}
