package pl.schodowski.empireOfBooks.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private float orderValue;

    @OneToOne
    private Customer customer;

    @ManyToMany
    private Set<Product> products;

}
