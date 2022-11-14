package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int usersQty;
    private int postsQty;
    private int commentsQty;
    private double avrPostsPerUser;
    private double avrCommentsPerUser;
    private double avrCommentsPerPost;

    public int getUsersQty() {
        return usersQty;
    }

    public int getPostsQty() {
        return postsQty;
    }

    public int getCommentsQty() {
        return commentsQty;
    }

    public double getAvrPostsPerUser() {
        return avrPostsPerUser;
    }

    public double getAvrCommentsPerUser() {
        return avrCommentsPerUser;
    }

    public double getAvrCommentsPerPost() {
        return avrCommentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        usersQty = statistics.usersNames().size();
        postsQty = statistics.postsCount();
        commentsQty = statistics.commentsCount();
        avrPostsPerUser = calculateAvrPostPerUser();
        avrCommentsPerUser = calculateAvrCommentsPerUser();
        avrCommentsPerPost = calculateAvrCommentsPerPost();
    }

    public double calculateAvrPostPerUser() {

        if (usersQty > 0) {
            return (double) postsQty / usersQty;
        } else {
            return 0;
        }
    }

    public double calculateAvrCommentsPerUser() {

        if (usersQty > 0) {
            return (double) commentsQty / usersQty;
        } else {
            return 0;
        }
    }

    public double calculateAvrCommentsPerPost() {

        if (postsQty > 0) {
            return (double) commentsQty / postsQty;
        } else {
            return 0;
        }
    }

    public void showStatistics() {
        System.out.println("The number of users is: " + usersQty);
        System.out.println("The number of posts is: " + postsQty);
        System.out.println("The number of comments is: " + commentsQty);
        System.out.println("Average posts per user is: " + avrPostsPerUser);
        System.out.println("Average comments per user is : " + avrCommentsPerUser);
    }

}
