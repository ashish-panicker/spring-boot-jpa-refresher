package in.stackroute.jpa_refresher.model.one2one;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue
    private long id;

    private LocalDate createdDate;

    private String phoneNumber;

    @OneToOne(mappedBy = "profile")
    private User user;

    public Profile(LocalDate createdDate, String phoneNumber) {
        this.createdDate = createdDate;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
