package lk.ijse.gdse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomTm {
    private String RoomId;
    private String RoomType;
    private double keyMoney;
    private int qty;
}
