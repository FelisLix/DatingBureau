package datingbureau.datingbureau.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RegistrationNumber", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Lob
    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Lob
    @Column(name = "Sex", nullable = false)
    private String sex;

    @Column(name = "RegistrationDate", nullable = false)
    private LocalDate registrationDate;

    @Lob
    @Column(name = "Characteristics", nullable = false)
    private String characteristics;

    @Lob
    @Column(name = "Requirements", nullable = false)
    private String requirements;

    @Lob
    @Column(name = "Status")
    private String status;

    @OneToMany(mappedBy = "registrationNumber1")
    private Set<Archive> archives1 = new LinkedHashSet<>();

    @OneToMany(mappedBy = "registrationNumber2")
    private Set<Archive> archives2 = new LinkedHashSet<>();

    @OneToMany(mappedBy = "registrationNumber1")
    private Set<Meeting> meetings1 = new LinkedHashSet<>();

    @OneToMany(mappedBy = "registrationNumber2")
    private Set<Meeting> meetings2 = new LinkedHashSet<>();

    public Client(String lastName, String firstName, String sex, String characteristics, String requirements) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.registrationDate = java.time.LocalDate.now();
        this.characteristics = characteristics;
        this.requirements = requirements;
        this.status = "active";
    }

}