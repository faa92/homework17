package by.tms.fedoseevanton.homework16;

import java.time.Instant;

public class Post {
    private final User authorMassage;
    private final String massage;
    private final Instant messageTimeCreate;

    public Post(User authorMassage, String massage, Instant massageTimeCreate) {
        this.authorMassage = authorMassage;
        this.massage = massage;
        this.messageTimeCreate = massageTimeCreate;
    }

    public User getAuthorMessage() {
        return authorMassage;
    }

    public String getContent() {
        return massage;
    }

    public Instant getPostCreateTime() {
        return messageTimeCreate;
    }
}
