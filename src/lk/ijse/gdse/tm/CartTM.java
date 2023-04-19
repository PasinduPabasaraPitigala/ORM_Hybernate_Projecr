package lk.ijse.gdse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartTM {
    private String RoomId;
    private String RoomType;
    private double keyMoney;
    private String status;
}
