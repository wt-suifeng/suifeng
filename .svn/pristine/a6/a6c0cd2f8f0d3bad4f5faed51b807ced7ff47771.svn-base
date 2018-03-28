package com.qfedu.lvyou.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qfedu.lvyou.dao.IEmployeeDao;
import com.qfedu.lvyou.model.Employee;

@Repository
public class EmployeeDao implements IEmployeeDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<Employee> getEmployees() {
		String hql = "from Employee e";
		return sessionFactory.getCurrentSession().createQuery(hql,Employee.class).getResultList();
	}

	@Override
	public void createEmployee(Employee emp) {
		sessionFactory.getCurrentSession().persist(emp);
	}

}
