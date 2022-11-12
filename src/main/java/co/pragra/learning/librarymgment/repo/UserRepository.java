package co.pragra.learning.librarymgment.repo;

import co.pragra.learning.librarymgment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
