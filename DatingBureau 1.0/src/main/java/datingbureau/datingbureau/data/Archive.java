package datingbureau.datingbureau.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "archive")
public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RegistrationNumber1", nullable = false)
    private Client registrationNumber1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RegistrationNumber2", nullable = false)
    private Client registrationNumber2;

    public Archive(Client cl1, Client cl2) {
        this.registrationNumber1 = cl1;
        this.registrationNumber2 = cl2;
    }

}