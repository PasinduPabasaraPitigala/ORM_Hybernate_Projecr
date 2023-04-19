package lk.ijse.gdse.dao.custom.impl;

import lk.ijse.gdse.dao.custom.StudentDao;
import lk.ijse.gdse.entity.Student;
import lk.ijse.gdse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean save(Student student) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student student) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.update(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Student student = session.load(Student.class,id);
        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Student> getAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Student");
        List<Student> list= query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String genarateId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction =session.beginTransaction();

        List resultList = session. createSQLQuery("SELECT * FROM Student ORDER BY StuId DESC LIMIT 1").addEntity(Student.class).getResultList();
        transaction.commit();
        session.close();
        return resultList.size()==0?"S000":((Student)resultList.get(0)).getStuId();
    }

    @Override
    public List<Student> getStudentDetail(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction =session.beginTransaction();

        Query query = session.createQuery("FROM Student WHERE StuId =: id");
        query.setParameter("id",id);

        List<Student> List=query.list();

        transaction.commit();
        session.close();

        return List;
    }
}
