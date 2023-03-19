package by.tms.fedoseevanton.homework16;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ChatService {
    private Post[] allPost;
    private final Duration timeIntervalCreatePost;
    private final int limitPosts;

    public ChatService(int limitPosts, Duration rateLimiting) {
        this.limitPosts = limitPosts;
        this.timeIntervalCreatePost = rateLimiting;
        allPost = new Post[0];
    }

    public boolean addNewPost(User user, String message) throws CheckedException {
        Instant timeNow = Instant.now();

        isUserHitTimeInterval(user, timeNow);

        savePost(user, message, timeNow);

        return true;
    }

    private void savePost(User user, String message, Instant timeNow) {
        allPost = Arrays.copyOf(allPost, allPost.length + 1);
        allPost[allPost.length - 1] = new Post(user, message, timeNow);
    }


    private void isUserHitTimeInterval(User user, Instant timeNow) throws CheckedException {
        int count = 0;
        for (int i = allPost.length - 1; i >= 0; i--) {
            if (allPost[i].getPostCreateTime().isBefore(timeNow.minus(timeIntervalCreatePost))) {
                return;
            }
            if ((user.getUserNickName().equals(allPost[i].getAuthorMessage().getUserNickName()))) {
                count++;
                if (count == limitPosts) {
                    throw new CheckedException(allPost[i].getPostCreateTime().plus(timeIntervalCreatePost));
                }
            }
        }
    }
    public Post[] getPostHistory() {
        return Arrays.copyOf(allPost, allPost.length);
    }


}
