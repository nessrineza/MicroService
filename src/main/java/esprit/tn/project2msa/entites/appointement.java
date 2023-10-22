package esprit.tn.project2msa.entites;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class appointement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "appointment_start_time")
    private LocalTime appointmentStartTime;

    @Column(name = "appointment_end_time")
    private LocalTime appointmentEndTime;

    @Column(name = "appointment_status")
    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;
    @Column(name = "id_annonce")
    private Integer idAnnonce;
}

