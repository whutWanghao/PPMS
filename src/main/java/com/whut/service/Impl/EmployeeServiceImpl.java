package com.whut.service.Impl;

import com.whut.dao.EmployeeDao;
import com.whut.domain.Employee;
import com.whut.domain.PageBean;
import com.whut.service.EmployeeService;

/**
 * Created by WH on 2017/7/11.
 */
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public PageBean<Employee> findEmployeeByPage(int pageCode, int pageSize) {
        return employeeDao.findByPage(pageCode,pageSize);
    }
    @Override
    public PageBean<Employee> queryEmployee(Employee employee,int pageCode,int pageSize){
        return employeeDao.queryEmployee(employee,pageCode,pageSize);
    }
    @Override
    public Employee getEmployeeById(int eid){
        return employeeDao.getEmployeeById(eid);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeDao.getEmployeeByName(name);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        try {
            employeeDao.addEmployee(employee);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Boolean result=false;
        try {
            result=employeeDao.updateEmployee(employee);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        boolean result=false;
        try {
            result=employeeDao.deleteEmployee(employee);
        }catch (Exception e){
            e.printStackTrace();
            result=false;
        }
        return result;
    }
}
