package com.example.webfluxapp.service;

import com.example.webfluxapp.model.User;
import com.example.webfluxapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> saveUser(User user) {
        return userRepository.save(user);

    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<User> getUserById(String id){
        return userRepository.findById(id).switchIfEmpty(Mono.empty());
    }

    public Mono<Void> deleteById(String id){
        return userRepository.deleteById(id);
    }
}
