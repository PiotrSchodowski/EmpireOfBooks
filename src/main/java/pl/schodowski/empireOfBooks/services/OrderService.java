package pl.schodowski.empireOfBooks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.schodowski.empireOfBooks.controler.dto.OrderDto;
import pl.schodowski.empireOfBooks.repository.InvoiceRepo;

import java.util.List;
@Service
public class OrderService {

    @Autowired
    private final InvoiceRepo invoiceRepo;

    public OrderService(InvoiceRepo invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }
    public List<OrderDto> getAllOrders(){

        return invoiceRepo.getAllOrders();
    }
}
