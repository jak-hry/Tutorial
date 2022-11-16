package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theUsersList = new ArrayList<>();

    public Forum() {

        theUsersList.add(new ForumUser(1, "James", 'M', 2001, 4, 6, 3));
        theUsersList.add(new ForumUser(2, "Liam", 'M', 2004, 8, 22, 13));
        theUsersList.add(new ForumUser(3, "Olivia", 'F', 2010, 10, 1, 7));
        theUsersList.add(new ForumUser(4, "Emma", 'F', 2007, 8, 14, 5));
        theUsersList.add(new ForumUser(5, "Oliver", 'M', 2009, 1, 18, 12));
        theUsersList.add(new ForumUser(6, "Lucas", 'M', 2011, 10, 13, 8));
        theUsersList.add(new ForumUser(7, "Mia", 'F', 2013, 7, 23, 0));
        theUsersList.add(new ForumUser(8, "Amelia", 'F', 2017, 2, 7, 16));
        theUsersList.add(new ForumUser(9, "Isabella", 'F', 2020, 9, 24, 1));

    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUsersList);
    }
}
