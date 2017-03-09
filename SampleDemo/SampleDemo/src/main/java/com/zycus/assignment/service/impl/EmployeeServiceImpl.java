package com.zycus.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zycus.assignment.dao.IEmployeeDao;
import com.zycus.assignment.model.Employee;
import com.zycus.assignment.model.ResponseStructure;
import com.zycus.assignment.service.IEmployeeService;

@Service
@Scope("prototype")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	@Qualifier("jpa")
	IEmployeeDao employeeDao;

	@Override
	public ResponseStructure getEmployeeById(long employeeId) {
		ResponseStructure res = new ResponseStructure();
		try {
			Employee emp = employeeDao.getEmployeeById(employeeId);
			res.setCode(200);
			res.setStatus("Success");
			if (emp != null) {
				res.setDesc("Data Found");
				res.setData(emp);
			} else {
				res.setDesc("Data Not Found");
				res.setData(null);
			}

		} catch (Exception e) {
			res.setCode(500);
			res.setData(null);
			res.setStatus("Failed");
			res.setDesc("Interval Server Error");
		}
		return res;
	}

	@Override
	public ResponseStructure saveEmployee(Employee employee) {
		ResponseStructure res = new ResponseStructure();
		try {
			employeeDao.saveEmployee(employee);
			res.setCode(200);
			res.setStatus("Success");
			res.setDesc("Data Saved Sucessfully");
			res.setData(null);

		} catch (Exception e) {
			res.setCode(500);
			res.setData(null);
			res.setStatus("Failed");
			res.setDesc("Interval Server Error");
		}
		return res;
	}

	@Override
	public ResponseStructure updateEmployee(Employee employee, long employeeId) {
		ResponseStructure res = new ResponseStructure();
		try {
			Employee oldEmp = employeeDao.getEmployeeById(employeeId);
			if (oldEmp == null) {
				res.setCode(500);
				res.setData(null);
				res.setStatus("Success");
				res.setDesc("No Data Found to Update");
				return res;
			} else {
				oldEmp.setAddress(employee.getAddress());
				oldEmp.setEmployeeName(employee.getEmployeeName());
				employeeDao.updateEmployee(employee);
				res.setCode(200);
				res.setStatus("Success");
				res.setDesc("Data Updated Sucessfully");
				res.setData(oldEmp);
			}
		} catch (Exception e) {
			res.setCode(500);
			res.setData(null);
			res.setStatus("Failed");
			res.setDesc("Interval Server Error");
		}
		return res;
	}

	@Override
	public ResponseStructure deleteEmployee(long employeeId) {
		ResponseStructure res = new ResponseStructure();
		try {
			Employee oldEmp = employeeDao.getEmployeeById(employeeId);
			if (oldEmp == null) {
				res.setCode(500);
				res.setData(null);
				res.setStatus("Success");
				res.setDesc("No Data Found to Delete");
				return res;
			} else {
				employeeDao.deleteEmployee(employeeId);
				res.setCode(200);
				res.setStatus("Success");
				res.setDesc("Data Deleted Sucessfully");
				res.setData(oldEmp);
			}
		} catch (Exception e) {
			res.setCode(500);
			res.setData(null);
			res.setStatus("Failed");
			res.setDesc("Interval Server Error");
		}
		return res;
	}

	@Override
	public ResponseStructure getAllEmployee() {
		ResponseStructure res = new ResponseStructure();
		try {
			List<Employee> empList = employeeDao.getAllEmployee();
			res.setCode(200);
			res.setStatus("Success");
			if (empList != null && !empList.isEmpty()) {
				res.setDesc("Data Found");
				res.setData(empList);
			} else {
				res.setDesc("Data Not Found");
				res.setData(null);
			}

		} catch (Exception e) {
			res.setCode(500);
			res.setData(null);
			res.setStatus("Failed");
			res.setDesc("Interval Server Error");
		}
		return res;

	}

}
