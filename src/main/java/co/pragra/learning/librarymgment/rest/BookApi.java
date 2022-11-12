package co.pragra.learning.librarymgment.rest;

import co.pragra.learning.librarymgment.entity.Book;
import co.pragra.learning.librarymgment.repo.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookApi {

    private BookRepository repo;

    public BookApi(BookRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/api/book")
    public Book createBook(@RequestBody Book book) {
        return  repo.save(book);
    }

    @GetMapping("/api/book")
    public List<Book> getAll() {
        return repo.findAll();
    }

    @GetMapping("/api/book/noreview")
    public List<Book> getAllwithNoReview() {
        return repo.findAll().stream().filter(book -> book.getReviews().size()==0).collect(Collectors.toList());
    }

    @GetMapping("/api/book/id/{id}")
    public Optional<Book> getById(@PathVariable int id) {
        return repo.findById(id);
    }

    @GetMapping("/api/book/isbn/{isbn}")
    public Optional<Book> getByIsbn(@PathVariable String isbn) {
        return repo.findByIsbn(isbn);
    }

    @DeleteMapping("/api/book/id/{id}")
    public Book deleteById(@PathVariable int id) {
        Optional<Book> byId = repo.findById(id);
        if(byId.isPresent()) {
            repo.deleteById(id);
        }

      return  byId.get();
    }

    @PutMapping("/api/book")
    public Book update(@RequestBody Book book){
        return repo.save(book);
    }

}
