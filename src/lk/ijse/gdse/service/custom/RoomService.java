package lk.ijse.gdse.service.custom;

import lk.ijse.gdse.dto.RoomDto;
import lk.ijse.gdse.service.SuperService;

import java.io.IOException;
import java.util.List;

public interface RoomService extends SuperService {
    boolean SaveRoom(RoomDto roomDto)throws Exception;

    boolean UpdateRoom(RoomDto roomDto)throws Exception;

    boolean DeleteRoom(String id)throws Exception;

    List<RoomDto> getAllRooms()throws IOException;
}
