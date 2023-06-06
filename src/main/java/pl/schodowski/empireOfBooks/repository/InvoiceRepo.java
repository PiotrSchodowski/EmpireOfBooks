package pl.schodowski.empireOfBooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.schodowski.empireOfBooks.controler.dto.OrderDto;
import pl.schodowski.empireOfBooks.repository.entity.Invoice;

import java.util.List;


@Repository
public interface InvoiceRepo extends JpaRepository<Invoice,Long> {

    @Query("select new pl.schodowski.empireOfBooks.controler.dto.OrderDto(customer.name, invoice.date, sum(products.price), customer.address) " +
            "from Invoice invoice " +
            "join invoice.customer customer " +
            "join invoice.products products " +
            "group by invoice.id")
   List<OrderDto> getAllOrders();


    @Query("SELECT u FROM Invoice u")
    List<Invoice> getInvoices();

}
