package pl.schodowski.empireOfBooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.schodowski.empireOfBooks.repository.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    @Query("SELECT u FROM Customer u WHERE u.name like 'P%'")
    List<Customer>getAllCustomers();

}
