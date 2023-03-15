package com.example.webfluxclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Component
public class User {

    private String id;
    private String name;
    private String surname;
    private String phone;

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
