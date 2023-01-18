package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {

        //Given
        User john = new Millenials("john144");
        User jacob = new YGeneration("jacob001");
        User anna = new ZGeneration("anna321");

        //When
        String johnPrefer = john.sharePost();
        System.out.println(john.getUserName() + " preferes to use: " + johnPrefer);
        String jacobPrefer = jacob.sharePost();
        System.out.println(jacob.getUserName() + " preferes to use: " + jacobPrefer);
        String annaPrefer = anna.sharePost();
        System.out.println(anna.getUserName() + " preferes to use: " + annaPrefer);

        //Then
        assertEquals("Facebook", johnPrefer);
        assertEquals("Twitter", jacobPrefer);
        assertEquals("Snapchat", annaPrefer);
        assertNotEquals(jacobPrefer, annaPrefer);
        assertNotEquals(jacobPrefer, johnPrefer);
        assertNotEquals(johnPrefer, annaPrefer);
    }

    @Test
    void testIndividualSharingStrategy() {

        //Given
        User john = new Millenials("john11");

        //When
        String johnPrefer1 = john.sharePost();
        System.out.println(john.getUserName() + " preferes to use: " + johnPrefer1);
        john.setSocialPublisher(new TwitterPublisher());
        String johnPrefer2 = john.sharePost();
        System.out.println(john.getUserName() + " preferes to use: " + johnPrefer2);

        //Then
        assertEquals("Twitter", johnPrefer2);
        assertNotEquals(johnPrefer1, johnPrefer2);
    }
}
