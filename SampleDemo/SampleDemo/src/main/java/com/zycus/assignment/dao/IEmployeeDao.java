package com.zycus.assignment.dao;

import java.util.List;

import com.zycus.assignment.model.Employee;

public interface IEmployeeDao {
	Employee getEmployeeById(long employeeId);

	boolean saveEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	boolean deleteEmployee(long employeeId);

	List<Employee> getAllEmployee();
}
