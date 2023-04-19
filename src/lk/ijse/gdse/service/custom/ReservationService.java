package lk.ijse.gdse.service.custom;

import javafx.collections.ObservableList;
import lk.ijse.gdse.dto.RoomDto;
import lk.ijse.gdse.dto.StudentDto;
import lk.ijse.gdse.service.SuperService;
import lk.ijse.gdse.tm.CartTM;

import java.io.IOException;
import java.util.List;

public interface ReservationService extends SuperService {
    void Register(ObservableList<CartTM> list,String StudentId,String lblId)throws Exception;
    List<StudentDto> getAllStudents()throws IOException;
    List<RoomDto> getAllRooms()throws IOException;
    List<RoomDto> getRoomDetail(String id)throws Exception;
    List<StudentDto> getStudentdetail(String id)throws Exception;
    String genarateReservationId()throws Exception;
}
