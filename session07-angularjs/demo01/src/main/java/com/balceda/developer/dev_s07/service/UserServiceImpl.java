package com.balceda.developer.dev_s07.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.balceda.developer.dev_s07.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final AtomicLong COUNTER = new AtomicLong();

    private static List<User> users;

    static {
        populateDummyUsers();
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public User findById(long id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public User findByName(String name) {
        return users.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public void saveUser(User user) {
        user.setId(COUNTER.incrementAndGet());
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    @Override
    public void deleteUserById(long id) {
        users.removeIf(u -> u.getId() == id);
    }

    @Override
    public boolean isUserExist(User user) {
        return findByName(user.getUsername()) != null;
    }

    @Override
    public void deleteAllUsers() {
        users.clear();
    }

    private static void populateDummyUsers() {
        users = new ArrayList<>();
        users.add(new User(COUNTER.incrementAndGet(), "Sam", "NY", "sam@abc.com"));
        users.add(new User(COUNTER.incrementAndGet(), "Tomy", "ALBAMA", "tomy@abc.com"));
        users.add(new User(COUNTER.incrementAndGet(), "Kelly", "NEBRASKA", "kelly@abc.com"));
    }

}
