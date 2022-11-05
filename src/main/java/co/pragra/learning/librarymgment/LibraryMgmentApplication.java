package co.pragra.learning.librarymgment;

import co.pragra.learning.librarymgment.entity.Author;
import co.pragra.learning.librarymgment.entity.Book;
import co.pragra.learning.librarymgment.repo.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class LibraryMgmentApplication {

    private BookRepo repo;

    public LibraryMgmentApplication(BookRepo repo) {
        this.repo = repo;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryMgmentApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
           //repo.createSchema();
//           repo.create(Book.builder()
//                           .id(1)
//                           .isbn("ISBN2882737")
//                           .category("Programming")
//                           .author(Author.builder().id(1).name("Edward").build())
//                           .createDate(new Date())
//                           .publishDate(new Date())
//                           .title("Awesome Spring")
//                   .build());
            List<Book> books = repo.getAll(Collections.emptyMap());
            System.out.println(books);
        };


    }

}
