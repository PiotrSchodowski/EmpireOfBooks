package pl.schodowski.empireOfBooks.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Bookstore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Product> products;

    @OneToMany
    private Set<Seller> sellers;

}
