package com.qfedu.lvyou.dao;

import java.util.List;

import com.qfedu.lvyou.model.Employee;

public interface IEmployeeDao {

	public List<Employee> getEmployees();

	public void createEmployee(Employee emp);

}
