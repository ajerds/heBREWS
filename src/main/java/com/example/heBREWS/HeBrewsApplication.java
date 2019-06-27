package com.example.heBREWS;

import com.example.heBREWS.mongo.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.util.stream.*;


@SpringBootApplication
public class HeBrewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeBrewsApplication.class, args);
	}

	@Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User(name, "Erdmann", name.toLowerCase() + "@domain.com");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }

}
