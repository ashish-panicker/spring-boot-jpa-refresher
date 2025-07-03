package in.stackroute.spring_boot_jpa_refresher.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private double price;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    public Product(double price, String name, int quantity) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }
}
