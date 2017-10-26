package com.whut.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by WH on 2017/6/30.
 */
@Entity
public class Employee {
    private int eid;
    private String ename;
    private String gender;
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date birthday;
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date joindate;
    private String phone;
    @JsonIgnoreProperties(value = {"employees"})
    private Department department;
    private String level;


    public Employee(){

    }
    public Employee(int eid,String ename,String gender,Department department,String level){
        this.eid=eid;
        this.ename=ename;
        this.gender=gender;
        this.department=department;
        this.level=level;
    }

    public Employee(int eid, String ename, String gender, Date birthday, Date joindate, String phone, Department department, String level) {
        this.eid = eid;
        this.ename = ename;
        this.gender = gender;
        this.birthday = birthday;
        this.joindate = joindate;
        this.phone = phone;
        this.department = department;
        this.level = level;
    }

    @Id

    @GenericGenerator(name = "id",strategy ="assigned")
    @Column(name = "eid", nullable = false)
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "ename", nullable = true, length = 20)
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 2)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "joindate", nullable = true)
    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Department.class)
    @JoinColumn(name = "did")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Basic
    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (eid != employee.eid) return false;
        if (ename != null ? !ename.equals(employee.ename) : employee.ename != null) return false;
        if (gender != null ? !gender.equals(employee.gender) : employee.gender != null) return false;
        if (birthday != null ? !birthday.equals(employee.birthday) : employee.birthday != null) return false;
        if (joindate != null ? !joindate.equals(employee.joindate) : employee.joindate != null) return false;
        if (phone != null ? !phone.equals(employee.phone) : employee.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid;
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (joindate != null ? joindate.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
