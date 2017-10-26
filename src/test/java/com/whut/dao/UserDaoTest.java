package com.whut.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by WH on 2017/6/21.
 */
public class UserDaoTest {
    @Test
    public void testAdd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao=(UserDao) context.getBean("userDao");
        userDao.add();
    }

}