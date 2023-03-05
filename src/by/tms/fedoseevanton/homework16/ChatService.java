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
        for (int i = allPost.length - 1; i > 0; i--) {
            if ((user.equals(allPost[i].getAuthorMessage()))) {
                if (allPost[i].getPostCreateTime().isAfter(timeNow.minus(timeInterval))) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    // сохранить текущее время
    //пройти по всем постам с обратной стороны и проверить что юзер одинаковый ()
    // иф для опред поста юзер одинаковый И время поста является бифо времени текущего - тайи рейт
    //внутри ещё один иф и проверяем время - таймрейт
    //если иф проходит возвр тру, если нет то фолс
    // если юзера не нашло возвр тру


    public Post[] getPostHistory() {
        return Arrays.copyOf(allPost, allPost.length);
    }


}
