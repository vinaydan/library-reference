package co.pragra.learning.librarymgment.contoller;

import co.pragra.learning.librarymgment.entity.Book;
import co.pragra.learning.librarymgment.repo.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/book")
    public String bookHome(Model model) {
        List<Book> all = repository.findAll();
        model.addAttribute("title", "Library Managing Book -" + all.size() );
        model.addAttribute("books", all);
        return "book";
    }
}
