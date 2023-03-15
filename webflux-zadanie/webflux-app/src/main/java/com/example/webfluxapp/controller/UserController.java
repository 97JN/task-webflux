package com.example.webfluxapp.controller;

import com.example.webfluxapp.model.User;
import com.example.webfluxapp.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/all", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable String id){
        Mono<User> user = userService.getUserById(id);
        return user;
    }

    @DeleteMapping("delete/{id}")
    public Mono<String> deleteById(@PathVariable String id){
        userService.deleteById(id);
        return Mono.just("Użytkownik o id: "+id+" został usunięty");
    }

    @PostMapping("/save")
    public Mono<User> saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
