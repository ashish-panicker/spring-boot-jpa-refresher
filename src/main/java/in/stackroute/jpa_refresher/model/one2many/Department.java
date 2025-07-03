package in.stackroute.jpa_refresher.model.one2many;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Department {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DeptEmployee> employees = new ArrayList<>();

    @ElementCollection
    private List<String> specializations;
}
