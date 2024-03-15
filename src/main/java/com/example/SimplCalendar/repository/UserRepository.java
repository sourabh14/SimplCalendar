package com.example.SimplCalendar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.SimplCalendar.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    List<User> users;
    Map<Integer, User> idToUser;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User(1, "user1", "user1@gmail.com"));
        users.add(new User(2, "user2", "user2@gmail.com"));
        users.add(new User(3, "user3", "user3@gmail.com"));
        users.add(new User(4, "user4", "user4@gmail.com"));
        users.add(new User(5, "user4", "user4@gmail.com"));

        idToUser = new HashMap<>();
        for (User user : users) {
            idToUser.put(user.getId(), user);
        }
    }

    public List<User> getUsersByIds(List<Integer> inviteeUserIds) {
        List<User> invitees = new ArrayList<>();
        for (Integer id : inviteeUserIds) {
            if (idToUser.containsKey(id)) {
                invitees.add(idToUser.get(id));
            }
        }
        return invitees;
    }

}
