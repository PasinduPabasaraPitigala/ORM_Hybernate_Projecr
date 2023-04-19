package lk.ijse.gdse.service.custom.impl;

import lk.ijse.gdse.dao.DaoFactory;
import lk.ijse.gdse.dao.custom.StudentDao;
import lk.ijse.gdse.dto.StudentDto;
import lk.ijse.gdse.entity.Student;
import lk.ijse.gdse.service.custom.StudentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao = (StudentDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.STUDENTFORM);

    @Override
    public boolean SaveStudent(StudentDto studentDto) throws Exception {

        return studentDao.save(new Student(studentDto.getStuId(), studentDto.getStuName(), studentDto.getStuAddress(), studentDto.getContact_no(), studentDto.getDateOfBirth(), studentDto.getGender()));
    }

    @Override
    public boolean UpdateStudent(StudentDto studentDto) throws Exception {

        return studentDao.update(new Student(studentDto.getStuId(), studentDto.getStuName(), studentDto.getStuAddress(), studentDto.getContact_no(), studentDto.getDateOfBirth(), studentDto.getGender()));

    }

    @Override
    public boolean DeleteStudent(String id) throws Exception {
        return studentDao.delete(id);
    }

    @Override
    public String genarateStudentId() throws Exception {
        String id = studentDao.genarateId();
        return id;
    }

    @Override
    public List<StudentDto> getAllStudents() throws IOException {
        List<Student> all = studentDao.getAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : all
        ) {
            studentDtos.add(
                    new StudentDto(student.getStuId(), student.getStuName(), student.getStuAddress(), student.getContact_no(), student.getDateOfBirth(), student.getGender())
            );
        }
        return studentDtos;
    }
}