package com.example.meuble;

import com.example.meuble.Entities.Meuble;
import com.example.meuble.Repositories.MeubleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MeubleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MeubleApplication.class, args);
    }
    @Autowired
    private MeubleRepository repository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            // save
            repository.save(new Meuble("a", "aaa"));
            repository.save(new Meuble("b", "bbb"));
            repository.save(new Meuble("c", "cc"));
            // fetch
            repository.findAll().forEach(System.out::println);

        };
    }

}
