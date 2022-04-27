package com.test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Map;

import com.test.demo.UserService;
import com.test.demo.UserServiceIml;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DemoController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();

    }

    @GetMapping(value = "/user")
    public ResponseEntity<Object> getUser() {
        UserService userService = new UserServiceIml();
        Collection<User> users = userService.getUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/user/add")
    public String addUser(Model model) {
        model.addAttribute("User", new User());
        return "user";
    }



    @PostMapping(value="/addUser")
    public ResponseEntity<Object> createUser(@RequestParam Map<String,String> user) {
        UserService userService = new UserServiceIml();
        User user1 = new User();
        user1.setId(Integer.parseInt(user.get("id")));
        user1.setName(user.get("name"));
        user1.setEmail(user.get("email"));
        userService.addUser(user1);
        userRepository.save(user1);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }
    

}
