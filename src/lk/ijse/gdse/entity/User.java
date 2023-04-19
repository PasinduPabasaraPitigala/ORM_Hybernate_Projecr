package lk.ijse.gdse.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Cacheable
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String UserId;
    private String UserName;
    private int TelNumber;
    private String Email;
    private String Password;
}
