package lk.ijse.gdse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTm {
    private String StuId;
    private String StuName;
    private String StuAddress;
    private int Contact_no;
    private LocalDate DateOfBirth;
    private String Gender;

}
