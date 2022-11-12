package co.pragra.learning.librarymgment.rest;

import co.pragra.learning.librarymgment.entity.Book;
import co.pragra.learning.librarymgment.entity.Review;
import co.pragra.learning.librarymgment.repo.BookRepository;
import co.pragra.learning.librarymgment.repo.ReviewRep;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReviewApi {
    private ReviewRep reviewRep;
    private BookRepository repository;

    public ReviewApi(ReviewRep reviewRep, BookRepository repository) {
        this.reviewRep = reviewRep;
        this.repository = repository;
    }

    @PostMapping("/api/book/{id}/review")
    public Review addReview(@PathVariable(name = "id") int bookid, @RequestBody Review review){
        Optional<Book> byId = repository.findById(bookid);
        if(byId.isPresent()) {
            Review savedReview = reviewRep.save(review);
            Book book = byId.get();
            book.getReviews().add(savedReview);
            repository.save(book);
            return savedReview;
        }
        return null;

    }
}
