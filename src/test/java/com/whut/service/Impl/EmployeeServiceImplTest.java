package com.whut.service.Impl;

import com.whut.domain.Department;
import com.whut.domain.Employee;
import com.whut.service.DepartmentService;
import com.whut.service.EmployeeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class EmployeeServiceImplTest {
    ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeService employeeService=(EmployeeService) context.getBean("employeeService");
    DepartmentService departmentService=(DepartmentService) context.getBean("departmentService");
    @Test
    public void addEmployee() throws Exception {
        Employee employee=new Employee();
        employee.setEname("胡锦涛");
        employee.setGender("男");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date birthday=simpleDateFormat.parse("1980-5-24");
        Date joindate=simpleDateFormat.parse("2017-7-1");
        employee.setBirthday(birthday);
        employee.setJoindate(joindate);
        employee.setPhone("18202727486");
        employee.setLevel("项目经理");
        Department department=departmentService.getDepartmentByName("java开发部");
        employee.setDepartment(department);
        employeeService.addEmployee(employee);
    }

}