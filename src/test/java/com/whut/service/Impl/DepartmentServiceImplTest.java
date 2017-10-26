package com.whut.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whut.domain.Department;
import com.whut.service.DepartmentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class DepartmentServiceImplTest {
    @Test
    public void getAllDepartmentNames() throws Exception {
        ApplicationContext context=new  ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentService departmentService=(DepartmentService) context.getBean("departmentService");
        List<String> list=departmentService.getAllDepartmentNames();
        List<Department> list1=departmentService.getAllDepartment();
        for (String string:list){
            System.out.println(string);
        }
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(list1);
        System.out.println(json);

    }

}