//package com.example.pupupu.controllers;
//
//import com.example.pupupu.entities.Direction;
//import com.example.pupupu.entities.Group;
//import com.example.pupupu.entities.User;
//import com.example.pupupu.repositories.DirectionRepository;
//import com.example.pupupu.repositories.GroupRepository;
//import com.example.pupupu.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class TestController {
//
//    private GroupRepository groupRepository;
//    private UserRepository userRepository;
//    private DirectionRepository directionRepository;
//    @Autowired
//    public TestController(GroupRepository groupRepository, UserRepository userRepository,DirectionRepository directionRepository) {
//        this.groupRepository = groupRepository;
//        this.userRepository = userRepository;
//        this.directionRepository = directionRepository;
//        Group group = new Group();
//        Direction direction = new Direction();
//        direction.setName("aboba");
//        directionRepository.save(direction);
//        group.setName("31234");
//        group.setDirection(direction);
//        groupRepository.save(group);
////        User user = new User();
////        user.setGroup(group);
//    }
//}
