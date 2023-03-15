package com.example.webfluxapp.repository;

import com.example.webfluxapp.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User,String> {
}
