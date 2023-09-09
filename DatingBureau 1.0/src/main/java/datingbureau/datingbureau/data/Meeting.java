package datingbureau.datingbureau.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "meetings")
public class Meeting {
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

    @Column(name = "Date", nullable = false)
    private LocalDate date;

    @Lob
    @Column(name = "Status", nullable = false)
    private String status;

    public Meeting(Client cl1, Client cl2, LocalDate date) {
        this.registrationNumber1 = cl1;
        this.registrationNumber2 = cl2;
        this.date = date;
        this.status = "planned";
    }

}