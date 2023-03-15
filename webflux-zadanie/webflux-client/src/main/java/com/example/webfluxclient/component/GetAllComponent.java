package com.example.webfluxclient.component;

import com.example.webfluxclient.model.User;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;


@Component
public class GetAllComponent {
    WebClient webClient = WebClient.create("http://localhost:8080");
    @Bean
    public Flux<User> get() {
        Flux<User> flux = webClient
                .get()
                .uri("/users/all")
                .retrieve()
                .bodyToFlux(User.class).delayElements(Duration.ofSeconds(2));
        flux.subscribe(System.out::println);
        return flux;
    }
    @Bean
    public Mono<User> create(User user) {
        user = new User("1", "Jan", "Nowak", "123 023 025");
        Mono<User> mono = webClient
                .post()
                .uri("/users/save")
                .body(Mono.just(user), User.class)
                .retrieve().bodyToMono(User.class);
        mono.subscribe(System.out::println);
        return mono;
    }

    public Mono<User> getById(String id) {
        Mono<User> mono = webClient
                .get()
                .uri("/users/" + id)
                .retrieve()
                .bodyToMono(User.class);
        return mono;
    }


    public Mono<Void> delete(String id) {
        return webClient.delete()
                .uri("/users/" + id)
                .retrieve()
                .bodyToMono(Void.class);
    }

}
