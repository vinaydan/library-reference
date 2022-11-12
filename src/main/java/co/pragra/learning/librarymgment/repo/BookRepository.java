package co.pragra.learning.librarymgment.repo;

import co.pragra.learning.librarymgment.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByIsbn(String isbn);

    @Query("select b from Book  b where count (b.reviews)=0")
    List<Book> getAllWithNoReview();
}
