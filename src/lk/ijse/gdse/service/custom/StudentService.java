package lk.ijse.gdse.service.custom;

import lk.ijse.gdse.dto.StudentDto;
import lk.ijse.gdse.entity.Student;
import lk.ijse.gdse.service.SuperService;

import java.io.IOException;
import java.util.List;

public interface StudentService extends SuperService {
    boolean SaveStudent(StudentDto studentDto)throws Exception;

    boolean UpdateStudent(StudentDto studentDto)throws Exception;

    boolean DeleteStudent(String id)throws Exception;

    String genarateStudentId()throws Exception;

    List<StudentDto>getAllStudents()throws IOException;
}
