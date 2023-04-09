package by.tms.fedoseevanton.homework16;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ChatService {
    private List<Post> allPost;
    private final Duration timeIntervalCreatePost;
    private final int limitPosts;


    public ChatService(int limitPosts, Duration rateLimiting) {
        this.limitPosts = limitPosts;
        this.timeIntervalCreatePost = rateLimiting;
        allPost = new ArrayList<>();
    }

    public boolean addNewPost(User user, String message) throws LimitingNumberOfPublicationsException {
        Instant timeNow = Instant.now();

        validateUserHitTimeInterval(user, timeNow);

        savePost(user, message, timeNow);

        return true;
    }

    private void savePost(User user, String message, Instant timeNow) {
        allPost.add(new Post(user, message, timeNow));
    }


    private void validateUserHitTimeInterval(User user, Instant timeNow) throws LimitingNumberOfPublicationsException {
        int count = 0;
        ListIterator<Post> postListIterator = allPost.listIterator(allPost.size());
        while (postListIterator.hasPrevious()) {
            Post currentPost = postListIterator.previous();
            if (currentPost.getPostCreateTime().isBefore(timeNow.minus(timeIntervalCreatePost))) {
                return;
            }
            if ((currentPost.getAuthorMessage().equals(user))) {
                count++;
                if (count == limitPosts) {
                    throw new LimitingNumberOfPublicationsException(currentPost.getPostCreateTime().plus(timeIntervalCreatePost));
                }
            }
        }
    }

    public List<Post> getPostHistory() {
        return Collections.unmodifiableList(allPost);
    }
}
