package pl.schodowski.empireOfBooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.schodowski.empireOfBooks.repository.entity.Bookstore;
import pl.schodowski.empireOfBooks.repository.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
