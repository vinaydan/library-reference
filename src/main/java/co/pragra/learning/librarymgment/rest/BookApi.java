package co.pragra.learning.librarymgment.rest;

import co.pragra.learning.librarymgment.entity.Book;
import co.pragra.learning.librarymgment.repo.BookRepo;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BookApi {

    private BookRepo repo;

    public BookApi(BookRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/api/book")
    public Book createBook(@RequestBody Book book) {
        if(book.getId()==0) {
            book.setId(((int) Math.floor(Math.random() * 10000)));
        }
        return  repo.create(book);
    }

    @GetMapping("/api/book")
    public List<Book> getAll() {
        return repo.getAll(Collections.emptyMap());
    }

    @GetMapping("/api/book/isbn/{isbn}")
    public Optional<Book> getByIsbn(@PathVariable String isbn) {
        return repo.getByIsbn(isbn);
    }

}
