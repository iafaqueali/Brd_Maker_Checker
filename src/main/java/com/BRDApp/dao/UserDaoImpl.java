package com.BRDApp.dao;

import com.BRDApp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@SuppressWarnings("deprecation")
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        user.setPassword(TripleDes.encode(user.getPassword()));
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public Boolean loginUser(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        Session session = sessionFactory.openSession();
        boolean userFound = false;
        //Query using Hibernate Query Language
            String username= user.getUsername();
            String roleType=user.getRoleType();
            String password=TripleDes.encode(user.getPassword());
                    System.out.println("inside login impl : ");
            System.out.println("username : "+username);
            System.out.println("password : "+password);

        Transaction transaction = null;
        User userDataFrommDB = null;
        try (Session session = sessionFactory.openSession())
        {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            userDataFrommDB = (User) session.createQuery("FROM User U WHERE U.username = :username").setParameter("username", username)
                    .uniqueResult();
            System.out.println("userDataFrommDB : "+userDataFrommDB);

            if (userDataFrommDB != null && userDataFrommDB.getPassword().equals(password) && userDataFrommDB.getRoleType().equals(roleType
            )) {
                System.out.println("Login Successfully!");
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

//
//        User userDataFromDB = (User) session.get(User.class,username);
//
//        if(username.equals(userDataFromDB.getUsername()) && password.equals(userDataFromDB.getPassword()))
//        {
//            System.out.println("User Login Successfully !!!");
//             userFound = true;
//        }else{
//
//            System.out.println("Invalid credentials !!!");
//        }
//            return  userFound;
//        String SQL_QUERY =" from User as u where u.username=? and u.password=?";
//        System.out.println("login query successfully run!");
//        Query query = session.createQuery(SQL_QUERY);
//        System.out.println("setting query parameter");
//        query.setParameter(0,username);
//        query.setParameter(1,password);
//        List list = query.list();
//        System.out.println("query list :"+list);
//        if ((list != null) && (list.size() > 0)) {
//            userFound= true;
//        }
//
//        session.close();
//        return userFound;
//        try {
//            String username= user.getUsername();
//            String password=TripleDes.encode(user.getPassword());
//            System.out.println("inside login impl : ");
//            System.out.println("username : "+username);
//            System.out.println("password : "+password);
//            Query<User> query = session.createQuery("from User where username =:username and password =:password", User.class);
//            System.out.println("query run successfully!");
//            query.setParameter("username", user.getUsername());
//            query.setParameter("password", user.getPassword());
//            user = (User) query.getSingleResult();
//            System.out.println("obtained user :"+user);
//            return user;
//        } catch (NoResultException e) {
//
//            System.out.println("No user Found err : "+e);
//            return null;
//        }

    }

