package com.whut.dao.Impl;

import com.whut.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import com.whut.domain.User;
import java.util.List;

/**
 * Created by WH on 2017/6/21.
 */
@Transactional
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add() {
        Session session = sessionFactory.getCurrentSession();
        User user=new User();
        user.setUsername("admin");
        user.setPassword("123456");
        session.save(user);
    }

    @Override
    public User queryUser(User user) {
        Session session =sessionFactory.getCurrentSession();
        String hql="from User where username=? and password=?";
        Query query=session.createQuery(hql);
        query.setParameter(0,user.getUsername());
        query.setParameter(1,user.getPassword());
        List<User> list=query.list();
        if (list.size()>0){
            return list.get(0);
        }else
        return null;
    }
}
