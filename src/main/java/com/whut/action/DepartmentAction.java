package com.whut.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.whut.domain.Department;
import com.whut.domain.PageBean;
import com.whut.service.DepartmentService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class DepartmentAction extends ActionSupport{
    private int pageCode;

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String getAllDepartmentNames() throws IOException{
        List<Department> list=departmentService.getAllDepartment();
        ObjectMapper mapper=new ObjectMapper();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        String json=mapper.writeValueAsString(list);
        response.getWriter().print(json);
        return null;
    }

    public String findDepartmentByPage(){
        if (pageCode==0){
            pageCode=1;
        }
        int pageSize=5;
        PageBean<Department> pb=departmentService.getDepartmentByPage(pageCode,pageSize);
        if (pb!=null){
            pb.setUrl("findDepartmentByPage.action");
        }
        ServletActionContext.getRequest().setAttribute("pb",pb);
        return SUCCESS;
    }
}
