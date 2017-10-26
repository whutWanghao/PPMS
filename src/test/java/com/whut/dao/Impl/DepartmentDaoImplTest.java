package com.whut.dao.Impl;

import com.whut.dao.DepartmentDao;
import com.whut.domain.Department;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by WH on 2017/7/17.
 */
public class DepartmentDaoImplTest {
    ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
    DepartmentDao departmentDao=(DepartmentDao) context.getBean("departmentDao");
    @Test
    public void testAddDepartment(){

        Department department=new Department();
        department.setDname("ios开发部");
        department.setDesc("负责ios端app开发和维护");
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date myDate = dateFormat.parse("2017-7-3");
            department.setSetdate(myDate);
        }catch (Exception e){
            e.printStackTrace();
        }

        department.setDid(2);
        departmentDao.addDepartment(department);
    }
    @Test
    public void testGetDepartmentById(){
        Department department=departmentDao.getDepartmentById(1);
        System.out.println(department.getDname());
    }
    @Test
    public void testUpdateDepartment(){
        Department department=departmentDao.getDepartmentById(1);
        department.setDesc("从事管理系统开发");
        departmentDao.updateDepartment(department);
    }
}