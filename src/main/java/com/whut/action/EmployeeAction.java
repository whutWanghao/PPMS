package com.whut.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.whut.domain.Department;
import com.whut.domain.Employee;
import com.whut.domain.PageBean;
import com.whut.service.EmployeeService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

/**
 * Created by WH on 2017/6/22.
 */
public class EmployeeAction extends ActionSupport {
    private String ename;
    private String gender;
    private int eid;
    private String department;
    private String level;
    private Date birthday;
    private Date joindate;
    private String phone;


    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private int pageCode;
    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }
/*
*根据页码查询员工
* */
    public String findEmployeeByPage(){
        //从页面获取传递过来的当前页码
        if (pageCode==0){
            pageCode=1;
        }
        //给pageSize，每页的记录赋值
        int pageSize=5;
        PageBean<Employee> pb=employeeService.findEmployeeByPage(pageCode,pageSize);
        if (pb!=null){
            pb.setUrl("findEmployeeByPage.action?");
        }
        //存入request域中
        ServletActionContext.getRequest().setAttribute("pb",pb);
        return SUCCESS;
    }
/*
* 多条件查询员工
* */
    public String queryEmployee(){
        System.out.println(eid);
        System.out.println(ename);
        //获取页面传递过来的当前页码数
        if(pageCode==0){
            pageCode=1;
        }
        //给pageSize每页的记录赋值
        int pageSize=5;
        PageBean<Employee> pb=null;
        if("".equals(ename.trim())&&"".equals(department.trim())&&"".equals(level.trim())&&"".equals(gender.trim())&&eid==-1){
            pb=employeeService.findEmployeeByPage(pageCode,pageSize);
        }else {
            Department dept=new Department();
            dept.setDname(department);
            Employee employee=new Employee(eid,ename,gender,dept,level);
            pb=employeeService.queryEmployee(employee,pageCode,pageSize);
        }
        if (pb!=null){
            pb.setUrl("queryEmployee.action?eid="+eid+"&ename="+ename+"&gender="+gender+"&department="+department+"&levle="+level);
        }
        System.out.println(pb);
        ServletActionContext.getRequest().setAttribute("pb",pb);
        return null;
    }

/*
* 得到指定编号的员工信息
* ajax请求该方法
* 返回该员工信息的json对象
* */
    public String getEmployee() throws IOException{
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Employee employee=employeeService.getEmployeeById(eid);
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(employee);
        System.out.println(json);
        PrintWriter out=response.getWriter();
        out.print(json);
        out.flush();
        out.close();
        return null;
    }
/*
* 添加员工
* */
    public String addEmployee(){
        Department dept=new Department();
        dept.setDname(department);
        Employee employee=new Employee(eid,ename,gender,birthday,joindate,phone,dept,level);
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
}
