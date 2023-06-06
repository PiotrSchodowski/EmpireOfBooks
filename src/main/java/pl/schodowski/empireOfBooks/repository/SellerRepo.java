package pl.schodowski.empireOfBooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.schodowski.empireOfBooks.repository.entity.Seller;
@Repository
public interface SellerRepo extends JpaRepository<Seller,Long>{

}
