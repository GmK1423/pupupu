package com.example.pupupu.controllers;

import com.example.pupupu.entities.*;
import com.example.pupupu.pojo.GroupDto;
import com.example.pupupu.pojo.ResponseDto;
import com.example.pupupu.pojo.TestDto;
import com.example.pupupu.pojo.UserDto;
import com.example.pupupu.services.RestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    private final RestService restService;

    public MainController(RestService restService) {
        this.restService = restService;
    }


    @PostMapping(value = "/users")
    public ResponseEntity<?> createDirection(@RequestBody UserDto userDto) throws Exception {
        restService.createUser(userDto.getEmail(),userDto.getPassword(), userDto.getPassword());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> readUserById() {
        final List<User> users = restService.readAllUser();

        return users != null &&  !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> readUserById(@PathVariable(name = "id") Long id) {
        final User user = restService.readUser(id);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(name = "id") Long id, @RequestBody UserDto userDto) {
        final User user = restService.updateUser(userDto.getEmail(),userDto.getPassword(), userDto.getPassword(), id);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long id) {
        restService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/directions")
    public ResponseEntity<?> createDirection(@RequestBody String name) {
        restService.createDirection(name);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/directions")
    public ResponseEntity<List<Direction>> readDirection() {
        final List<Direction> directions = restService.readAllDirection();
        return directions != null &&  !directions.isEmpty()
                ? new ResponseEntity<>(directions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/directions/{id}")
    public ResponseEntity<Direction> readDirectionById(@PathVariable(name = "id") Long id) {
        final Direction direction = restService.readDirection(id);

        return direction != null
                ? new ResponseEntity<>(direction, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/directions/{id}")
    public ResponseEntity<?> updateDirection(@PathVariable(name = "id") Long id, @RequestBody String name) {
        final Direction direction = restService.updateDirection(name, id);
        return direction != null
                ? new ResponseEntity<>(direction, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/directions/{id}")
    public ResponseEntity<?> deleteDirection(@PathVariable(name = "id") Long id) {
        restService.deleteDirection(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/groups")
    public ResponseEntity<?> createGroup(@RequestBody GroupDto groupDto) {
        restService.createGroup(groupDto.getDirection(),groupDto.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/groups")
    public ResponseEntity<List<Group>> readGroup() {
        final List<Group> groups = restService.readAllGroup();
        return groups != null &&  !groups.isEmpty()
                ? new ResponseEntity<>(groups, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/groups/{id}")
    public ResponseEntity<Group> readGroupById(@PathVariable(name = "id") Long id) {
        final Group group = restService.readGroup(id);

        return group != null
                ? new ResponseEntity<>(group, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/groups/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable(name = "id") Long id, @RequestBody GroupDto groupDto) {
        final Group group = restService.updateGroup(groupDto.getDirection(),groupDto.getName(), id);

        return group != null
                ? new ResponseEntity<>(group, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/groups/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable(name = "id") Long id) {
        restService.deleteGroup(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/tests")
    public ResponseEntity<?> createTest(@RequestBody TestDto testDto) {
        restService.createTest(testDto.getTopic(),testDto.getStatus());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/tests")
    public ResponseEntity<List<Test>> readTest() {
        final List<Test> tests = restService.readAllTest();
        return tests != null &&  !tests.isEmpty()
                ? new ResponseEntity<>(tests, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/tests/{id}")
    public ResponseEntity<Test> readTestById(@PathVariable(name = "id") Long id) {
        final Test test = restService.readTest(id);

        return test != null
                ? new ResponseEntity<>(test, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/tests/{id}")
    public ResponseEntity<?> updateTest(@PathVariable(name = "id") Long id, @RequestBody TestDto testDto) {
        final Test test = restService.updateTest(testDto.getTopic(),testDto.getStatus(), id);

        return test != null
                ? new ResponseEntity<>(test, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/tests/{id}")
    public ResponseEntity<?> deleteTest(@PathVariable(name = "id") Long id) {
        restService.deleteTest(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/tasks")
    public ResponseEntity<?> createTask(@RequestBody String value) {
        restService.createTask(value);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/tasks")
    public ResponseEntity<List<Task>> readTask() {
        final List<Task> tasks = restService.readAllTask();
        return tasks != null &&  !tasks.isEmpty()
                ? new ResponseEntity<>(tasks, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<Task> readTaskById(@PathVariable(name = "id") Long id) {
        final Task task = restService.readTask(id);

        return task != null
                ? new ResponseEntity<>(task, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity<?> updateTask(@PathVariable(name = "id") Long id, @RequestBody String value) {
        final Task task = restService.updateTask(value, id);

        return task != null
                ? new ResponseEntity<>(task, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable(name = "id") Long id) {
        restService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/responses")
    public ResponseEntity<?> createResponse(@RequestBody ResponseDto responseDto) {
        restService.createResponse(responseDto.getValue(),responseDto.getStatus(),responseDto.getTask());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/responses")
    public ResponseEntity<List<Response>> readResponse() {
        final List<Response> responses = restService.readAllResponse();
        return responses != null &&  !responses.isEmpty()
                ? new ResponseEntity<>(responses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/responses/{id}")
    public ResponseEntity<Response> readResponseById(@PathVariable(name = "id") Long id) {
        final Response response = restService.readResponse(id);

        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/responses/{id}")
    public ResponseEntity<?> updateResponse(@PathVariable(name = "id") Long id, @RequestBody ResponseDto responseDto) {
        final Response response = restService.updateResponse(responseDto.getValue(),responseDto.getStatus(),responseDto.getTask(), id);

        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/responses/{id}")
    public ResponseEntity<?> deleteResponse(@PathVariable(name = "id") Long id) {
        restService.deleteResponse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/user_status/{id}")
    public ResponseEntity<UserStatus> readUserStatusById(@PathVariable(name = "id") Long id) {
        final UserStatus userStatus = restService.readUserStatus(id);

        return userStatus != null
                ? new ResponseEntity<>(userStatus, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
