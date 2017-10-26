package com.whut.dao;

import com.whut.domain.Employee;
import com.whut.domain.PageBean;

import java.util.List;

/**
 * Created by WH on 2017/6/30.
 */
public interface EmployeeDao {
     void addEmployee(Employee employee);
     Employee getEmployeeById(int eid);
     Employee getEmployeeByName(String name);
     boolean updateEmployee(Employee employee);
     boolean deleteEmployee(Employee employee);
     PageBean<Employee> findByPage(int pageCode, int pageSize);
     PageBean<Employee> queryEmployee(Employee employee,int pageCode,int pageSize);
}
