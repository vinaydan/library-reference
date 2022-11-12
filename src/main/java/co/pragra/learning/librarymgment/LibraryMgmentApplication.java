package co.pragra.learning.librarymgment;

import co.pragra.learning.librarymgment.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class LibraryMgmentApplication {


    public static void main(String[] args) {
        SpringApplication.run(LibraryMgmentApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {

        };

    }

}
