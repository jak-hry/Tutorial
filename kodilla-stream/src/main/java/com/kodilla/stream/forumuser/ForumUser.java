package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final int userId;
    private String userName;
    private char sex;
    private LocalDate birthDate;
    private int postsQty;

    public ForumUser(final int userId, String userName, char sex, int yearOfBirth,
                     int monthOfBirth, int dayOfBirth, int postsQty) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.postsQty = postsQty;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsQty() {
        return postsQty;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", publishedPosts=" + postsQty +
                '}';
    }
}
