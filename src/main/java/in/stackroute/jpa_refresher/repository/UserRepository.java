package in.stackroute.jpa_refresher.repository;

import in.stackroute.jpa_refresher.model.one2one.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
