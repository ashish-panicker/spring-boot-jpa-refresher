package in.stackroute.jpa_refresher.repository;

import in.stackroute.jpa_refresher.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    // Find all Person who are in the same Home City
    @Query("select p from Person p where p.homeAddress.city = :city")
    List<Person> findAllPeopleInSameHomeCity(String city);

    List<Person> findByHomeAddressCity(String city);
}
