package lk.ijse.gdse.dao.custom;

import lk.ijse.gdse.dao.CrudDao;
import lk.ijse.gdse.entity.User;

import java.util.List;

public interface UserDao extends CrudDao<User,String> {
    List<User> getUserDetail(String UserName,String password)throws Exception;
}
