package com.whut.action;


import com.opensymphony.xwork2.ActionSupport;
import com.whut.domain.Department;
import com.whut.domain.Employee;
import com.whut.service.DepartmentService;
import com.whut.service.EmployeeService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeManageAction extends ActionSupport{
    private int eid;
    private String ename;
    private int gender;
    private String phone;
    private int department;
    private String birthday;
    private String joindate;
    private String level;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*
            * 添加员工
            * */
    public String addEmployee() throws ParseException,IOException{
        String empGender;
        Date empBirthday;
        Date empJoindate;
        Department dept=departmentService.getDepartmentByDid(department);
        if (gender==-1){
            empGender=null;
        }else if(gender==0){
            empGender="男";
        }else {
            empGender="女";
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        empBirthday=simpleDateFormat.parse(birthday);
        empJoindate=simpleDateFormat.parse(joindate);
        Employee employee=new Employee(eid,ename,empGender,empBirthday,empJoindate,phone,dept,level);
       // String json=new ObjectMapper().writeValueAsString(employee);
       // System.out.println(json);
        Employee oldEmployee=employeeService.getEmployeeById(eid);
        int success=0;
        if (oldEmployee!=null){
            success=-1; //已存在该id
        }else {
            boolean b=employeeService.addEmployee(employee);
            if (b){
                success=1;
            }
        }
        try {
            ServletActionContext.getResponse().getWriter().print(success);
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    public String deleteEmployee(){
        Employee employee=employeeService.getEmployeeById(eid);
        boolean result=employeeService.deleteEmployee(employee);
        int i=0;
        if (result==true) i=1;
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/text");
        try {
            response.getWriter().print(i);
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
        return SUCCESS;
    }


    public String updateEmployee() throws ParseException{
        String empGender;
        Date empBirthday;
        Date empJoindate;
        Employee updateEmployee=employeeService.getEmployeeById(eid);
        updateEmployee.setEname(ename);
        if (gender==-1){
            empGender=null;
        }else if(gender==0){
            empGender="男";
        }else {
            empGender="女";
        }
        updateEmployee.setGender(empGender);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        empBirthday=simpleDateFormat.parse(birthday);
        empJoindate=simpleDateFormat.parse(joindate);
        updateEmployee.setBirthday(empBirthday);
        updateEmployee.setJoindate(empJoindate);
        Department dept=departmentService.getDepartmentByDid(department);
        updateEmployee.setDepartment(dept);
        updateEmployee.setLevel(level);
        updateEmployee.setPhone(phone);

        Boolean result=employeeService.updateEmployee(updateEmployee);
        int success=0;
        if (result==true){
            success=1;
        }
        try {
            HttpServletResponse response=ServletActionContext.getResponse();
            response.setContentType("text/text");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(success);
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }
}
