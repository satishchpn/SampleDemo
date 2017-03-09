package com.zycus.assignment.service;

import com.zycus.assignment.model.Employee;
import com.zycus.assignment.model.ResponseStructure;

public interface IEmployeeService {
	ResponseStructure getEmployeeById(long employeeId);

	ResponseStructure saveEmployee(Employee employee);

	ResponseStructure updateEmployee(Employee employee, long employeeId);

	ResponseStructure deleteEmployee(long employeeId);

	ResponseStructure getAllEmployee();
}
