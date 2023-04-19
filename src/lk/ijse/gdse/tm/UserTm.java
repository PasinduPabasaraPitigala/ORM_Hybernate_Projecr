package lk.ijse.gdse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTm {
    private String UserId;
    private String UserName;
    private int TelNumber;
    private String Email;
    private String Password;
}
