package lk.ijse.gdse.dao.custom;

import lk.ijse.gdse.dao.CrudDao;
import lk.ijse.gdse.entity.Room;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface RoomDao extends CrudDao<Room,String> {
    List<Room> getRoomDetail(String id)throws Exception;
}
