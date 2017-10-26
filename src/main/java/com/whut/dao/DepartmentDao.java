package com.whut.dao;

import com.whut.domain.Department;
import com.whut.domain.PageBean;

import java.util.List;

/**
 * Created by WH on 2017/7/17.
 */
public interface DepartmentDao {
    boolean addDepartment(Department department);
    Department getDepartmentById(int did);
    Department getDepartmentByName(String name);
    boolean updateDepartment(Department department);
    boolean deleteDepartment(Department department);
    List<Department> getAllDepartment();
    PageBean<Department> findByPage(int pageCode, int pageSize);
}
