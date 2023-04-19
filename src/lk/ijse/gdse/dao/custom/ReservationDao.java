package lk.ijse.gdse.dao.custom;

import lk.ijse.gdse.dao.CrudDao;
import lk.ijse.gdse.entity.Reservation;

public interface ReservationDao extends CrudDao<Reservation,String> {
    boolean updateUsingId(String id,String status)throws Exception;
}
