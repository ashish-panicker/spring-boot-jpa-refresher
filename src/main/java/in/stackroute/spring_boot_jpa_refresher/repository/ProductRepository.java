package in.stackroute.spring_boot_jpa_refresher.repository;

import in.stackroute.spring_boot_jpa_refresher.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find all the poducts with a particular name
    List<Product> findByName(String name);

    // Find all the products that contains a text in a case insensitive manner
    List<Product> findByNameContainsIgnoreCase(String text);

    // Find all products with quantity less than or equal to reorder level
    List<Product> findByQuantityLessThanEqual(int level);

    @Query("select p from Product p where p.quantity < :level")
    List<Product> findAllProductsBelowReorderLevel(int level);


    // Find all products with quantity above the reorder level
    @Query(value = "select * from Products p where p.quantity > ?1", nativeQuery = true)
    List<Product> findAllProductsAboveReorderLevel(int level);
}
