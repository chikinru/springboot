package com.test.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserService {

    private static Map<Integer, User> userRepo = new HashMap<>();

    static{
        User user = new User();
        user.setId(1);
        user.setName("John");
        user.setEmail("asdasd");
        userRepo.put(user.getId(), user);
 
        user = new User();
        user.setId(2);
        user.setName("Jane");
        user.setEmail("asdasd");
        userRepo.put(user.getId(), user);
        
    }

    @Override
    public void addUser(User user) {
        
        userRepo.put(user.getId(), user);
    }

    @Override
    public Collection<User> getUser() {
        return userRepo.values();
    }

}
    

