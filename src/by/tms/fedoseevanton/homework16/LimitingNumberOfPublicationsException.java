package by.tms.fedoseevanton.homework16;

import java.time.Instant;

public class LimitingNumberOfPublicationsException extends Exception {
    final Instant timeCanChat;

    public LimitingNumberOfPublicationsException(Instant timeCanChat) {
        super("The user has exceeded the message limit. Can chat through: " + timeCanChat);
        this.timeCanChat = timeCanChat;
    }

    public Instant getTimeCanChat() {
        return timeCanChat;
    }

}
