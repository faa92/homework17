package by.tms.fedoseevanton.homework16;

public class User {
    private String userNickName;

    private User(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserNickName() {
        return userNickName;
    }
}

