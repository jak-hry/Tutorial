package com.kodilla.stream.forum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ForumUserTestSuite {

    @Test
    void testGetLocaionsOffFriends() {

        //Given
        ForumUser user1 = new ForumUser("alan01", "Alan Kosovsky", "Washington");
        ForumUser user2 = new ForumUser("ethanreard", "Ethan Reard", "Miami");
        ForumUser user3 = new ForumUser("eRiK", "Erik Hull", "Key West");
        ForumUser user4 = new ForumUser("booth", "Mya Booth", "Washington");
        ForumUser user5 = new ForumUser("nicole1987", "Nicole Lee", "Orlando");
        ForumUser user6 = new ForumUser("nobody", "Briana Williams", "Miami");
        ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Washington");
        ForumUser user8 = new ForumUser("thebigone", "Clay Small", "Orlando");
        ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Washington");
        ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");

        //When
        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);

        user3.addFriend(user1);
        user3.addFriend(user7);
        user3.addFriend(user2);
        user3.addFriend(user9);

        user7.addFriend(user1);
        user7.addFriend(user3);

        user10.addFriend(user1);

        user2.addFriend(user3);

        user9.addFriend(user3);

        //Then
        //użytkownik1 ma 3 znajomych z następującymi lokalizacjami
        //      user3:  "Key West"
        //      user7:  "Washington"
        //      user10: "Miami"
        assertEquals(3, user1.getLocationsOffFriends().size());
        assertTrue(user1.getLocationsOffFriends().contains("Key West"));
        assertTrue(user1.getLocationsOffFriends().contains("Washington"));
        assertTrue(user1.getLocationsOffFriends().contains("Miami"));
        assertFalse(user1.getLocationsOffFriends().contains("Orlando"));
    }

    @Test
    void testGetLocationsOfFriendsOfFriends(){

        //Given
        ForumUser user1 = new ForumUser("alan01", "Alan Kosovsky", "Washington");
        ForumUser user2 = new ForumUser("ethanreard", "Ethan Reard", "Miami");
        ForumUser user3 = new ForumUser("eRiK", "Erik Hull", "Key West");
        ForumUser user4 = new ForumUser("booth", "Mya Booth", "Washington");
        ForumUser user5 = new ForumUser("nicole1987", "Nicole Lee", "Orlando");
        ForumUser user6 = new ForumUser("nobody", "Briana Williams", "Miami");
        ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Washington");
        ForumUser user8 = new ForumUser("thebigone", "Clay Small", "Orlando");
        ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Washington");
        ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");

        //When
        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);

        user3.addFriend(user1);
        user3.addFriend(user7);
        user3.addFriend(user2);
        user3.addFriend(user9);

        user7.addFriend(user1);
        user7.addFriend(user3);

        user10.addFriend(user1);

        user2.addFriend(user3);

        user9.addFriend(user3);

        //Then
        //user1 ma 3 znajomych z następującymi znajomymi i ich lokalizacjami:
        //      user3:  user1: - should be skipped ("this" in context of user1)
        //      user7: "Washington"
        //      user2: "Miami"
        //      user9: "Washington" - duplicated, should be skipped
        //      user7:  user1: - should be skipped ("this" in context of user1)
        //      user3: "Key West"
        //      user10: user1: - should be skipped ("this" in context of user1)

        assertEquals(3, user1.getLocationsOffFriends().size());
        assertTrue(user1.getLocationsOffFriends().contains("Key West"));
        assertTrue(user1.getLocationsOffFriends().contains("Washington"));
        assertTrue(user1.getLocationsOffFriends().contains("Miami"));
        assertFalse(user1.getLocationsOffFriends().contains("Orlando"));
    }
}
