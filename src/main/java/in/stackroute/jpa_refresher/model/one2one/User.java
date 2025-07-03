package in.stackroute.jpa_refresher.model.one2one;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String userName;

    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Profile profile;

    public User(String userName, Profile profile) {
        this.userName = userName;
        this.profile = profile;
    }
}
