package com.whut.service;

import com.whut.domain.Employee;
import com.whut.domain.PageBean;

/**
 * Created by WH on 2017/7/11.
 */
public interface EmployeeService {
    PageBean<Employee> findEmployeeByPage(int pageCode,int pageSize);
    PageBean<Employee> queryEmployee(Employee employee,int pageCode,int pageSize);
    Employee getEmployeeById(int eid);
    Employee getEmployeeByName(String name);
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(Employee employee);
}
