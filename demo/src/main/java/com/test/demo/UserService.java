package com.test.demo;
import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Service;

public interface UserService {
    public abstract void addUser(User user) ;
    public abstract Collection<User> getUser();
 }
