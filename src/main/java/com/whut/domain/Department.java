package com.whut.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

/**
 * Created by WH on 2017/6/30.
 */
@Entity
public class Department {
    private int did;
    private String dname;
    private String desc;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date setdate;
    private Set<Employee> employees=new HashSet<Employee>();
    private int enumber;

    public Department(){

    }
    public Department(int did, String dname, String desc, Date setdate, Set<Employee> employees) {
        this.did = did;
        this.dname = dname;
        this.desc = desc;
        this.setdate = setdate;
        this.employees = employees;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did", nullable = false)
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Basic
    @Column(name = "dname", nullable = true, length = 40)
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Basic
    @Column(name = "ddesc", nullable = true, length = 255)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "setdate", nullable = true)
    public Date getSetdate() {
        return setdate;
    }

    public void setSetdate(Date setdate) {
        this.setdate = setdate;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Employee.class)
    @JoinColumn(name = "did")
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Basic
    @Column(name="enumber",nullable = true,length = 255)
    public int getEnumber() {
        return employees.size();
    }

    public void setEnumber(int enumber) {
        this.enumber = enumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (did != that.did) return false;
        if (dname != null ? !dname.equals(that.dname) : that.dname != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (setdate != null ? !setdate.equals(that.setdate) : that.setdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = did;
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (setdate != null ? setdate.hashCode() : 0);
        return result;
    }
}
