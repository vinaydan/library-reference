package co.pragra.learning.librarymgment;

import co.pragra.learning.librarymgment.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import co.pragra.learning.librarymgment.repo.AuthorRepo;
import co.pragra.learning.librarymgment.repo.BookRepo;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class LibraryMgmentApplication {

    private BookRepo repo;
    private AuthorRepo repoAuthor;

    public LibraryMgmentApplication(BookRepo repo, AuthorRepo repoAuthor) {
        this.repo = repo;
        this.repoAuthor = repoAuthor;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryMgmentApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
           //repo.createSchema();
//           repo.create(Book.builder()
//                           .id(2)
//                           .isbn("ISBN2882738")
//                           .category("Programming")
//                           .author(Author.builder().id(1).name("Himanshu").build())
//                           .createDate(new Date())
//                           .publishDate(new Date())
//                           .title("Awesome Java")
//                   .build());
//            repo.create(Book.builder()
//                    .id(3)
//                    .isbn("ISBN2882739")
//                    .category("Programming")
//                    .author(Author.builder().id(1).name("Mayank").build())
//                    .createDate(new Date())
//                    .publishDate(new Date())
//                    .title("Awesome Git")
//                    .build());
            List<Book> books = repo.getAll(Collections.emptyMap());

            System.out.println(repo.getById(2));
        };


    }

}
