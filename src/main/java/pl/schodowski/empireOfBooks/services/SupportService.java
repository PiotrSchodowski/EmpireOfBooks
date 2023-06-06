package pl.schodowski.empireOfBooks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.schodowski.empireOfBooks.repository.*;
import pl.schodowski.empireOfBooks.repository.entity.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;


@Service
public class SupportService {

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

    public SupportService(CustomerRepo customerRepo, InvoiceRepo invoiceRepo, BookstoreRepo bookstoreRepo, ProductRepo productRepo, SellerRepo sellerRepo){

        this.invoiceRepo = invoiceRepo;
        this.customerRepo = customerRepo;
        this.bookstoreRepo = bookstoreRepo;
        this.productRepo = productRepo;
        this.sellerRepo = sellerRepo;

        Bookstore bookstore1 = new Bookstore();
        bookstore1.setAddress("Katowice");

        Seller seller1 = new Seller();
        seller1.setName("Justa");
        sellerRepo.save(seller1);

        bookstore1.setSellers(Set.of(seller1));

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

        bookstoreRepo.save(bookstore1);    // save bookstore1 in database with set of sellers and products(added cascade)

        Customer customer1 = new Customer();
        customer1.setName("Piotr");
        customer1.setEmail("ps@gmail.com");
        customer1.setAddress("Łaziska Górne ul.Gorna20");

        Customer customer2 = new Customer();
        customer2.setName("Jerzy");
        customer2.setEmail("jerzyk@gmail.com");
        customer2.setAddress("Katowice ul.Ostatnia 15");

        Customer customer3 = new Customer();
        customer3.setName("Bogdan");
        customer3.setEmail("bogus@gmail.com");
        customer3.setAddress("Bogdanowice ul.Letnia 10");


        Invoice invoice1 = new Invoice();
        invoice1.setDate(LocalDate.now());
        invoice1.setCustomer(customer1);
        invoice1.setProducts(Set.of(product1,product2));

        Invoice invoice2 = new Invoice();
        invoice2.setDate(LocalDate.now());
        invoice2.setCustomer(customer2);
        invoice2.setProducts(Set.of(product2));

        Invoice invoice3 = new Invoice();
        invoice3.setDate(LocalDate.now());
        invoice3.setCustomer(customer3);
        invoice3.setProducts(Set.of(product1,product2,product3));

        invoiceRepo.saveAll(Arrays.asList(invoice1,invoice2,invoice3));

        System.out.println(invoiceRepo.getAllOrders());
        System.out.println("***********************************************************************************");

    }
}
