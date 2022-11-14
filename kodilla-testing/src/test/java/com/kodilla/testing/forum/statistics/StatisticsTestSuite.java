package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    private List<String> generateListOfUsers(int value) {
        List<String> result = new ArrayList<>();
        for (int n = 0; n < value; n++) {
            String userName = "User " + n;
            result.add(userName);
        }
        return result;
    }

    @Nested
    @DisplayName("Tests for posts")
    class TestForPosts {

        @Test
        void testWhenTheNumberOfPostsEqualsZero() {

            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.postsCount()).thenReturn(0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, forumStatistics.getPostsQty());
            assertEquals(0, forumStatistics.getAvrPostsPerUser());
            assertEquals(0, forumStatistics.getAvrCommentsPerUser());

        }

        @Test
        void testWhenTheNumberOfPostsEquals1000() {

            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(1500);
            when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(50));

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(1000, forumStatistics.getPostsQty());
            assertEquals(1.5, forumStatistics.calculateAvrCommentsPerPost());
            assertEquals(20, forumStatistics.calculateAvrPostPerUser());

        }

        @Test
        void testWhenTheNumberOfCommentsEqualsZero() {

            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.commentsCount()).thenReturn(0);
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(50));

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, forumStatistics.getCommentsQty());
            assertEquals(0, forumStatistics.getAvrCommentsPerPost());
            assertEquals(0, forumStatistics.getAvrCommentsPerUser());

        }

        @Test
        void testWhenTheNumberOfCommentsIsLessThanTheNumberOfPost() {

            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.commentsCount()).thenReturn(6);
            when(statisticsMock.postsCount()).thenReturn(10);
            when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(2));

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(6, forumStatistics.getCommentsQty());
            assertEquals(10, forumStatistics.getPostsQty());
            assertEquals(0.6, forumStatistics.getAvrCommentsPerPost());
            assertEquals(5, forumStatistics.getAvrPostsPerUser());
            assertEquals(3, forumStatistics.getAvrCommentsPerUser());
        }

        @Test
        void testWhenTheNumberOfCommentsIsGreaterThanTheNumberOfPosts() {

            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.commentsCount()).thenReturn(30);
            when(statisticsMock.postsCount()).thenReturn(20);
            when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(4));

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(30, forumStatistics.getCommentsQty());
            assertEquals(20, forumStatistics.getPostsQty());
            assertEquals(1.5, forumStatistics.getAvrCommentsPerPost());
            assertEquals(5, forumStatistics.getAvrPostsPerUser());
            assertEquals(7.5, forumStatistics.getAvrCommentsPerUser());

        }

        @Test
        void testWhenTheNumberOfUsersEqualsZero() {

            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(0));

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, forumStatistics.getUsersQty());

        }

        @Test
        void testWhenTheNumberOfUsersEquals100() {

            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(100));
            when(statisticsMock.commentsCount()).thenReturn(340);
            when(statisticsMock.postsCount()).thenReturn(225);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(100, forumStatistics.getUsersQty());
            assertEquals(1.51, forumStatistics.getAvrCommentsPerPost(), 0.01);
            assertEquals(2.25, forumStatistics.getAvrPostsPerUser());
            assertEquals(3.4, forumStatistics.getAvrCommentsPerUser());

        }
    }
}
