package com.example.pupupu.services;

import com.example.pupupu.entities.*;
import com.example.pupupu.repositories.*;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestService {

    private final UserRepository userRepository;
    private final DirectionRepository directionRepository;
    private final GroupRepository groupRepository;
    private final ResponseRepository responseRepository;
    private final TaskRepository taskRepository;
    private final TestRepository testRepository;
    private final UserStatusRepository userStatusRepository;

    public RestService(UserRepository userRepository, DirectionRepository directionRepository, GroupRepository groupRepository, ResponseRepository responseRepository, TaskRepository taskRepository, TestRepository testRepository, UserStatusRepository userStatusRepository) {
        this.userRepository = userRepository;
        this.directionRepository = directionRepository;
        this.groupRepository = groupRepository;
        this.responseRepository = responseRepository;
        this.taskRepository = taskRepository;
        this.testRepository = testRepository;
        this.userStatusRepository = userStatusRepository;
    }

    public void createUser(String email, String password, String group) throws Exception {
        User user = new User();
        Group group1 = groupRepository.findByName(group).orElseThrow();
        user.setEmail(email);
        user.setPassword(password);
        user.setGroup(group1);
        userRepository.save(user);
    }


    public List<User> readAllUser() {
        return userRepository.findAll();
    }


    public User readUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }


    public User updateUser(String email, String password, String group, Long id) {
        User user = userRepository.findById(id).orElseThrow();
        Group group1 = groupRepository.findByName(group).orElseThrow();
        user.setEmail(email);
        user.setPassword(password);
        user.setGroup(group1);
        return userRepository.save(user);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public void createDirection(String name) {
        Direction direction = new Direction();
        direction.setName(name);
        directionRepository.save(direction);
    }


    public List<Direction> readAllDirection() {
        return directionRepository.findAll();
    }


    public Direction readDirection(Long id) {
        return directionRepository.findById(id).orElseThrow();
    }


    public Direction updateDirection(String name, Long id) {
        Direction direction = directionRepository.findById(id).orElseThrow();
        direction.setName(name);
        return directionRepository.save(direction);
    }


    public void deleteDirection(Long id) {
        directionRepository.deleteById(id);
    }


    public void createGroup(String direction, String name) {
        Group group = new Group();
        Direction direction1 = directionRepository.findByName(direction).orElseThrow();
        group.setName(name);
        group.setDirectionId(direction1);
        groupRepository.save(group);
    }


    public List<Group> readAllGroup() {
        return groupRepository.findAll();
    }


    public Group readGroup(Long id) {
        return groupRepository.findById(id).orElseThrow();
    }


    public Group updateGroup(String direction, String name, Long id) {
        Group group = groupRepository.findById(id).orElseThrow();
        Direction direction1 = directionRepository.findByName(direction).orElseThrow();
        group.setName(name);
        group.setDirectionId(direction1);
        return groupRepository.save(group);
    }


    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }


    public void createTest(String topic, String status) {
        Test test = new Test();
        test.setTopic(topic);
        test.setStatus(status);
        testRepository.save(test);
    }


    public List<Test> readAllTest() {
        return testRepository.findAll();
    }


    public Test readTest(Long id) {
        return testRepository.findById(id).orElseThrow();
    }


    public Test updateTest(String topic, String status, Long id) {
        Test test = testRepository.findById(id).orElseThrow();
        test.setTopic(topic);
        test.setStatus(status);
        return testRepository.save(test);
    }


    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }


    public void createTask(String value) {
        Task task = new Task();
        task.setValue(value);
        taskRepository.save(task);
    }


    public List<Task> readAllTask() {
        return taskRepository.findAll();
    }


    public Task readTask(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }


    public Task updateTask(String value, Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setValue(value);
        return taskRepository.save(task);
    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }


    public void createResponse(String value, Boolean status, String task) {
        Response response = new Response();
        Task task1 = taskRepository.findByValue(task).orElseThrow();
        response.setValue(value);
        response.setStatus(status);
        response.setTask(task1);
        responseRepository.save(response);
    }


    public List<Response> readAllResponse() {
        return responseRepository.findAll();
    }


    public Response readResponse(Long id) {
        return responseRepository.findById(id).orElseThrow();
    }


    public Response updateResponse(String value, Boolean status, String task, Long id) {
        Response response = responseRepository.findById(id).orElseThrow();
        Task task1 = taskRepository.findByValue(task).orElseThrow();
        response.setValue(value);
        response.setStatus(status);
        response.setTask(task1);
        return responseRepository.save(response);
    }


    public void deleteResponse(Long id) {
        responseRepository.deleteById(id);
    }

    public UserStatus readUserStatus(Long id) {
        return userStatusRepository.findById(id).orElseThrow();
    }

    public boolean isExist(long id) {
        User user = readUser(id);
        return user != null;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
