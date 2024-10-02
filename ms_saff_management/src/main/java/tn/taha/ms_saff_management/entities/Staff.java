package tn.taha.ms_saff_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.ms_saff_management.entities.enums.Role;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    public enum Role {
        Housekeeping,Concierge, Maintenance,Security
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStaff;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @Column(insertable = false,updatable = false ,columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date hireDate;

    @Enumerated(EnumType.STRING)
    private Role role;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="staff")
    private List<Tasks> tasksList;

    public Staff(int iDstaff) {
    }

    @Override
    public String toString() {
        return "Staff{" +
                "idStaff=" + idStaff +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", hireDate=" + hireDate +
                ", role=" + role +
                '}';
    }
}
