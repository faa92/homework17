package by.tms.fedoseevanton.homework16;

import java.util.Objects;

public class User {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userNickName.equals(user.userNickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNickName);
    }

    private final String userNickName;

    public User(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserNickName() {
        return userNickName;
    }
}

