package by.tms.fedoseevanton.homework16;

import java.time.Duration;
import java.time.LocalDateTime;
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

    public boolean addNewPost(User user, String message) {
        LocalDateTime timeNow = LocalDateTime.now();
        if (isUserHitTimeInterval(user, timeNow)) {
            savePost(user, message, timeNow);
            return true;
        }

        return false;
    }

    private void savePost(User user, String message, LocalDateTime timeNow) {
        allPost = Arrays.copyOf(allPost, allPost.length + 1);
        allPost[allPost.length - 1] = new Post(user, message, timeNow);
    }


    private boolean isUserHitTimeInterval(User user, LocalDateTime timeNow) {
        int count = 0;
        for (int i = allPost.length - 1; i >= 0; i--) {
            if ((user.getUserNickName().equals(allPost[i].getAuthorMessage().getUserNickName()))) {
                count++;
                if (count == limitPosts) {
                    return false;
                }
                if (allPost[i].getPostCreateTime().isBefore(timeNow.minus(timeIntervalCreatePost))) {
                    return true;
                }
                if (!(user.getUserNickName().equals(allPost[i].getAuthorMessage().getUserNickName())) && count == 0) {
                    break;
                }
            }
        }
        return true;
    }
    public Post[] getPostHistory() {
        return Arrays.copyOf(allPost, allPost.length);
    }


}
