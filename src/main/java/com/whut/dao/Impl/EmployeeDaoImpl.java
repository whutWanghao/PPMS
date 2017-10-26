package com.whut.dao.Impl;

import com.whut.dao.EmployeeDao;
import com.whut.domain.Employee;
import com.whut.domain.PageBean;
import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by WH on 2017/6/30.
 */
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    @Override
    public void addEmployee(Employee employee){
        hibernateTemplate.save(employee);

    }

    @Override
    public Employee getEmployeeById(int eid) {
        Employee employee=hibernateTemplate.get(Employee.class,eid);
        return employee;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        String hql="from Employee where ename=?";
        Employee employee=(Employee) hibernateTemplate.find(hql,name).get(0);
        return employee;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        hibernateTemplate.update(employee);
        return true;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        employee=hibernateTemplate.get(Employee.class,employee.getEid());
        hibernateTemplate.delete(employee);
        return true;
    }

    @Override
    public PageBean<Employee> findByPage(int pageCode, int pageSize) {
        PageBean<Employee> pageBean=new PageBean<>();   //pageBean对象，用于分页
        //根据传入的pageCode的当前页码和pageSize页面记录数来设置pageBean对象
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);
        List employList=null;
        try {
            String sql="SELECT count(*) FROM Employee"; //计算表中行数
            List list=hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(sql).list();
            int totalRecord=Integer.parseInt(list.get(0).toString());//得到总记录数
            pageBean.setTotalRecord(totalRecord);
            String hql="from Employee";
            employList=doSplitPage(hql,pageCode,pageSize);
        }catch (Throwable e1){
            e1.printStackTrace();
            throw new RuntimeException(e1.getMessage());
        }
        if (employList!=null&&employList.size()>0){
            pageBean.setBeanList(employList);
            return pageBean;
        }
        return null;
    }

    @Override
    public PageBean<Employee> queryEmployee(Employee employee, int pageCode, int pageSize) {
        PageBean<Employee> pb=new PageBean<>();
        pb.setPageCode(pageCode);
        pb.setPageSize(pageSize);

        StringBuilder sb=new StringBuilder();
        StringBuilder sb_sql=new StringBuilder();
        String sql="SELECT count(*) FROM Employee e where 1=1";
        String hql="from Employee e where 1=1";
        sb.append(hql);
        sb_sql.append(sql);
        if (!"".equals(employee.getEname().trim())){
            sb.append(" and e.ename like '%"+employee.getEname()+"%'");
            sb_sql.append(" and e.ename like '%"+employee.getEname()+"%'");
        }
        if (!"".equals(employee.getGender().trim())){
            sb.append(" and e.gender like '%"+employee.getGender()+"%'");
            sb_sql.append(" and e.gender like '%"+employee.getGender()+"%'");
        }
        if (!"".equals(employee.getLevel().trim())){
            sb.append(" and e.level like '%"+employee.getLevel()+"%'");
            sb_sql.append(" and e.level like '%"+employee.getLevel()+"%'");
        }
        if (employee.getEid()!=-1){
            sb.append(" and e.eid= "+employee.getBirthday());
            sb_sql.append(" and e.eid= "+employee.getBirthday());
        }
        if (!"".equals(employee.getDepartment().getDname())){
            sb.append(" and e.department like '%"+employee.getDepartment().getDname()+"%'");
            sb_sql.append(" and e.department like '%"+employee.getDepartment().getDname()+"%'");
        }
        try{
            Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
            List list=session.createQuery(sb_sql.toString()).list();
            int totalRecord=Integer.parseInt(list.get(0).toString());
            pb.setTotalRecord(totalRecord);
           // session.close();
            List<Employee> employeeList=doSplitPage(sb.toString(),pageCode,pageSize);
            if(employeeList!=null&&employeeList.size()>0){
                pb.setBeanList(employeeList);
                return pb;
            }
        }catch(Throwable e1) {
            e1.printStackTrace();
            throw new RuntimeException(e1.getMessage());
        }
        return null;
    }

    public List doSplitPage(final String hql, final int pageCode, final int pageSize) {
        //调用模板的execute方法,参数是实现了HibernateCallback的接口的匿名类
        return (List) hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                return query.setFirstResult((pageCode - 1) * pageSize).setMaxResults(pageSize).list();
            }
        });
    }
    public List doSpPage(final String hql,final int pageCode,final int pageSize){
        return (List)hibernateTemplate.execute((Session session)->{
            Query query = session.createQuery(hql);
            return query.setFirstResult((pageCode - 1) * pageSize).setMaxResults(pageSize).list();
        });
    }
 }
