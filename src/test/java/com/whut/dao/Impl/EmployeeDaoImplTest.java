package com.whut.dao.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whut.dao.EmployeeDao;
import com.whut.domain.Department;
import com.whut.domain.Employee;
import com.whut.domain.PageBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.text.Document;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by WH on 2017/6/30.
 */
public class EmployeeDaoImplTest {
    @Test
    public void testAddEmployee() throws Exception {
        Employee employee=new Employee();

        employee.setEname("习近平");
        employee.setGender("男");
        employee.setEid(12);

        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao employeeDao=(EmployeeDao)context.getBean("employeeDao");
        employeeDao.addEmployee(employee);
    }
    @Test
    public void testGetEmployeeById(){
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao employeeDao=(EmployeeDao)context.getBean("employeeDao");

        System.out.println(employeeDao.getEmployeeById(1).getEname());
    }
    @Test
    public void testUpdateEmployee(){
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao employeeDao=(EmployeeDao)context.getBean("employeeDao");
        Employee employee=employeeDao.getEmployeeById(1);
        employee.setEname("江泽民");
//        Department d1=new Department();
//        d1.setDname("软件开发部");
//        employee.setDepartment(d1);
        employeeDao.updateEmployee(employee);
    }
    @Test
    public void testFindByPage(){
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao employeeDao=(EmployeeDao)context.getBean("employeeDao");
        PageBean pb=employeeDao.findByPage(1,5);
        System.out.println(pb.getBeanList());
        List<Employee> list=pb.getBeanList();
        for (Employee employee:list){
            System.out.println(employee.getEname());
        }
    }
    @Test
    public void testGetEmployeeByName() throws IOException{
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao employeeDao=(EmployeeDao)context.getBean("employeeDao");
        Employee employee=employeeDao.getEmployeeByName("江泽民");
        System.out.println(employee);
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(employee);
        System.out.println(json);
    }
}