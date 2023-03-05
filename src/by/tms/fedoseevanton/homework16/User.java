package by.tms.fedoseevanton.homework16;

public class User {
    private final String userNickName;

    User(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserNickName() {
        return userNickName.toString();
    }
}

