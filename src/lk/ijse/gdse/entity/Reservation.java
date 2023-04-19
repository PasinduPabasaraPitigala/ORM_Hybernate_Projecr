package lk.ijse.gdse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ResId;
    private LocalDate Date;

    @ManyToMany
    @JoinColumn(name = "StuId")
    private Student student;

    @ManyToMany
    @JoinColumn(name = "RoomId")
    private Room room;

    private String status;
}
