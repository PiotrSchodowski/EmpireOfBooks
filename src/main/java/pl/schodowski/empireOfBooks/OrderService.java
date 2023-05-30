package pl.schodowski.empireOfBooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.schodowski.empireOfBooks.repository.*;
import pl.schodowski.empireOfBooks.repository.entity.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;


@Service
public class OrderService {

    @Autowired
    private final CustomerRepo customerRepo;
    @Autowired
    private final InvoiceRepo invoiceRepo;
    @Autowired
    private final BookstoreRepo bookstoreRepo;
    @Autowired
    private  final ProductRepo productRepo;
    @Autowired
    private  final SellerRepo sellerRepo;

    public OrderService(CustomerRepo customerRepo, InvoiceRepo invoiceRepo,BookstoreRepo bookstoreRepo,ProductRepo productRepo,SellerRepo sellerRepo){

        this.invoiceRepo = invoiceRepo;
        this.customerRepo = customerRepo;
        this.bookstoreRepo = bookstoreRepo;
        this.productRepo = productRepo;
        this.sellerRepo = sellerRepo;

        Bookstore bookstore1 = new Bookstore();
        bookstore1.setAddress("Katowice");

        Seller seller = new Seller();
        seller.setName("Justa");
        sellerRepo.save(seller);
        bookstore1.setSellers(Set.of(seller));


        Product product1 = new Product();
        product1.setName("Najlepsze Miejsce Na Swiecie");
        product1.setPrice(49);

        Product product2 = new Product();
        product2.setName("Podstawy programowania");
        product2.setPrice(75);

        Product product3 = new Product();
        product3.setName("Władca Pierscieni");
        product3.setPrice(111.99f);

        bookstore1.setProducts(Set.of(product1,product2,product3));

        bookstoreRepo.save(bookstore1);

        Customer customer1 = new Customer();
        customer1.setName("Piotr");
        customer1.setEmail("ps@gmail.com");
        customer1.setAddress("gorna20");
        customerRepo.save(customer1);

        Invoice invoice1 = new Invoice();
        invoice1.setDate(LocalDate.now());
        invoice1.setCustomer(customer1);
        invoice1.setProducts(Set.of(product1,product2,product3));
        invoice1.setOrderValue(product1.getPrice() + product2.getPrice() + product3.getPrice());

        invoiceRepo.save(invoice1);

        bookstore1.setFinalValue(invoice1.getOrderValue());
        bookstoreRepo.save(bookstore1);

    }
}
