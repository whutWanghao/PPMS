package com.whut.dao.Impl;

import com.whut.dao.DepartmentDao;
import com.whut.domain.Department;
import com.whut.domain.PageBean;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by WH on 2017/7/17.
 */
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public boolean addDepartment(Department department) {
        hibernateTemplate.save(department);
        return true;
    }

    @Override
    public Department getDepartmentById(int did) {
       Department department= hibernateTemplate.get(Department.class,did);
        return department;
    }

    @Override
    public Department getDepartmentByName(String name) {
        String hql="from Department where dname=?";
        Department department=(Department) hibernateTemplate.find(hql,name).get(0);
        return department;
    }

    @Override
    public boolean updateDepartment(Department department) {
        hibernateTemplate.update(department);
        return true;
    }

    @Override
    public boolean deleteDepartment(Department department) {
        department=hibernateTemplate.get(Department.class,department.getDid());
        hibernateTemplate.delete(department);
        return true;
    }

    @Override
    public List<Department> getAllDepartment() {
        String hql="from Department";
        List<Department> list=(List<Department>) hibernateTemplate.find(hql);
        return list;

    }



    @Override
    public PageBean<Department> findByPage(int pageCode, int pageSize) {
        PageBean<Department> pageBean=new PageBean<>();
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);
        List departmentList=null;
        try {
            String sql="SELECT count(*) FROM Department";
            List list=hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(sql).list();
            int totalRecord=Integer.parseInt(list.get(0).toString());
            pageBean.setTotalRecord(totalRecord);
            String hql="from Department";
            departmentList=doSplitPage(hql,pageCode,pageSize);
        }catch (Throwable e1){
            e1.printStackTrace();
            throw new RuntimeException(e1.getMessage());
        }
        if (departmentList!=null&&departmentList.size()>0){
            pageBean.setBeanList(departmentList);
            return pageBean;
        }
        return null;
    }
    public List doSplitPage(final String hql,final int pageCode,final int pageSize){
        return (List) hibernateTemplate.execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException {
                Query query=session.createQuery(hql);
                return query.setFirstResult((pageCode-1)*pageSize).setMaxResults(pageSize).list();
            }
        });
    }
}
