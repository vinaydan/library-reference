package co.pragra.learning.librarymgment.repo;

import co.pragra.learning.librarymgment.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRep extends JpaRepository<Review, Long> {

}
