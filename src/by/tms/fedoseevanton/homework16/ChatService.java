package by.tms.fedoseevanton.homework16;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ChatService {
    private Post[] allPost;
    private final Duration timeInterval;
    private final int limitPosts;

    public ChatService(int limitPosts, Duration rateLimiting) {
        this.limitPosts = limitPosts;
        this.timeInterval = rateLimiting;
        allPost = new Post[0];
    }

    public boolean addNewPost(User user, String message) {
        if (isUserHitTimeInterval(user)) {
            savePost(user, message);
            return true;
        }

        return false;
    }

    private void savePost(User user, String message) {
        allPost = Arrays.copyOf(allPost, allPost.length + 1);
        allPost[allPost.length - 1] = new Post(user, message, LocalDateTime.now());
    }


    private boolean isUserHitTimeInterval(User user) {
        LocalDateTime timeNow = LocalDateTime.now();
        int count = 0;
        for (int i = allPost.length - 1; i >= 0; i--) {
            if ((user.getUserNickName().equals(allPost[i].getAuthorMessage()))) {
                if (allPost[i].getPostCreateTime().isBefore(timeNow.minus(timeInterval))) {
                    return true;
                }
                count++;
                if (count > limitPosts) {
                    return false;
                }
            }
        }
        return true;
    }
    public Post[] getPostHistory() {
        return Arrays.copyOf(allPost, allPost.length);
    }


}
