package lk.ijse.gdse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@Data
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String StuId;
    private String StuName;
    private String StuAddress;
    private int Contact_no;
    private LocalDate DateOfBirth;
    private String Gender;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Reservation>reservations=new ArrayList<>();

    public Student(String stuId, String stuName, String stuAddress, int contact_no, LocalDate dateOfBirth, String gender) {
    }
}
