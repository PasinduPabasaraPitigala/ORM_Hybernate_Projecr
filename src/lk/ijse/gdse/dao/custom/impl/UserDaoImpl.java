package lk.ijse.gdse.dao.custom.impl;

import lk.ijse.gdse.dao.custom.UserDao;
import lk.ijse.gdse.entity.User;
import lk.ijse.gdse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(User user) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User user) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.update(user);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session =FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User user = session.load(User.class,id);
        session.delete(user);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<User> getAll() throws IOException {
        Session session =FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User");
        List<User> list= query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String genarateId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List resultList = session.createSQLQuery("SELECT * FROM  User ORDER BY UserId DESC LIMIT 1").addEntity(User.class).getResultList();
        transaction.commit();
        session.close();
        return resultList.size()==0?"S000":((User)resultList.get(0)).getUserId();
    }

    @Override
    public List<User> getUserDetail(String UserName, String password) throws Exception {
        Session session =FactoryConfiguration.getInstance().getSession();
        Transaction transaction =session.beginTransaction();

            Query query = session.createQuery("FROM User WHERE UserName=:u AND Password=:p");
        query.setParameter("u",UserName);
        query.setParameter("p",password);
        List<User> list=query.list();

        transaction.commit();
        session.close();

        return list;
    }
}
