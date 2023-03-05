package by.tms.fedoseevanton.homework16;

import java.time.LocalDateTime;

public class Post {
    private final User authorMassage;
    private final String massage;
    private final LocalDateTime messageTimeCreate;

    public Post(User authorMassage, String massage, LocalDateTime massageTimeCreate) {
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

    public LocalDateTime getPostCreateTime() {
        return messageTimeCreate;
    }
}
