package com.whut.service.Impl;

import com.whut.dao.DepartmentDao;
import com.whut.domain.Department;
import com.whut.domain.PageBean;
import com.whut.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<String> getAllDepartmentNames() {
        List<Department> list=departmentDao.getAllDepartment();
        List<String> namelist=new ArrayList<String>();
        for (int i=0;i<list.size();i++){
            Department department=list.get(i);
            String name=department.getDname();
            namelist.add(name);
        }
        return namelist;
    }

    @Override
    public List<Department> getAllDepartment() {
        List<Department> list=departmentDao.getAllDepartment();
        return list;
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentDao.getDepartmentByName(name);
    }

    @Override
    public Department getDepartmentByDid(int did) {
        return departmentDao.getDepartmentById(did);
    }

    @Override
    public PageBean<Department> getDepartmentByPage(int pageCode, int pageSize) {

        return departmentDao.findByPage(pageCode,pageSize);
    }
}
