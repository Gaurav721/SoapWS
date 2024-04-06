package com.gaurav.springbootsoapexample.service;

import com.gaurav.soap.example.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final Map<String, User> users = new HashMap<>();
    @PostConstruct
    public  void initialize(){
        User peter = new User();
        peter.setName("Peter");
        peter.setEmpId(111);
        peter.setSalary(20000);

        User sam = new User();
        sam.setName("Sam");
        sam.setEmpId(112);
        sam.setSalary(30000);

        User ryan = new User();
        ryan.setName("Ryan");
        ryan.setEmpId(113);
        ryan.setSalary(40000);

        users.put(peter.getName(), peter);
        users.put(sam.getName(), sam);
        users.put(ryan.getName(), ryan);


    }

    public User getUsers(String name) {
        return users.get(name);
    }
}
