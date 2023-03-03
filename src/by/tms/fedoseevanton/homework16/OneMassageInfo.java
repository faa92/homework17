package by.tms.fedoseevanton.homework16;

import java.time.Instant;

public class OneMassageInfo {
    private String authorMassage;
    private String content;
    public Instant postMassageTime;

    private OneMassageInfo(String authorMassage, String content, Instant postMassageTime) {
        this.authorMassage = authorMassage;
        this.content = content;
        this.postMassageTime = postMassageTime;
    }

    public String getAuthorMassage() {
        return authorMassage;
    }

    public String getContent() {
        return content;
    }

    public Instant getPostMassageTime() {
        return postMassageTime;
    }
}
