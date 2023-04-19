package lk.ijse.gdse.dao.custom;

import lk.ijse.gdse.dao.CrudDao;
import lk.ijse.gdse.entity.Student;

import java.util.List;

public interface StudentDao extends CrudDao<Student,String> {
    List<Student> getStudentDetail(String id)throws Exception;
}
