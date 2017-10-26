package com.whut.service;

import com.whut.domain.Department;
import com.whut.domain.PageBean;

import java.util.List;

public interface DepartmentService {
    List<String> getAllDepartmentNames();
    List<Department> getAllDepartment();
    Department getDepartmentByName(String name);
    Department getDepartmentByDid(int did);
    PageBean<Department> getDepartmentByPage(int pageCode,int pageSize);
}
