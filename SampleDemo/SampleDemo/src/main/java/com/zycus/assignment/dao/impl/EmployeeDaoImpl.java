package com.zycus.assignment.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zycus.assignment.dao.IEmployeeDao;
import com.zycus.assignment.model.Employee;

@Repository(value = "jpa")
@Scope("prototype")
public class EmployeeDaoImpl implements IEmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Employee getEmployeeById(long employeeId) {
		try {
			return entityManager.find(Employee.class, employeeId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveEmployee(Employee employee) {
		try {
			entityManager.persist(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Employee updateEmployee(Employee employee) {
		try {
			return entityManager.merge(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteEmployee(long employeeId) {
		Employee student = null;
		try {
			student = entityManager.getReference(Employee.class, employeeId);
			entityManager.remove(student);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Employee> getAllEmployee() {
		try {
			return entityManager.createQuery("FROM Employee p", Employee.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
