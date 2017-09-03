package com.springs.security.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springs.security.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(EmployeeEntity employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}
	
	@Override
	public void editEmployee(EmployeeEntity employee) {
		this.sessionFactory.getCurrentSession().update(employee);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		EmployeeEntity employee = (EmployeeEntity) sessionFactory.getCurrentSession().get(
				EmployeeEntity.class, employeeId);
        if (null != employee) {
        	this.sessionFactory.getCurrentSession().delete(employee);
        }
	}

	@Override
	public EmployeeEntity getEmployee(Integer employeeId) {
		EmployeeEntity employee = (EmployeeEntity) this.sessionFactory.getCurrentSession().get(
				EmployeeEntity.class, employeeId);
		return employee;
	}

	
}
