package com.kodilla.good.patterns.allegro;

public class MailService {

    public void sendMail(User user, Product product) {
        System.out.println("Thanks " + user + " for order! - \"" + product + "\"");
    }
}
