package com.example.webfluxapp.model;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

    @Id
    private String id;
    private String name;
    private String surname;
    private String phone;

    public User(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
