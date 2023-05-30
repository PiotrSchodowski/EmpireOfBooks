package pl.schodowski.empireOfBooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.schodowski.empireOfBooks.repository.entity.Bookstore;
@Repository
public interface BookstoreRepo extends JpaRepository<Bookstore,Long> {
}
