package com.springs.security.dao;

import java.util.List;

import com.springs.security.entity.EmployeeEntity;

public interface EmployeeDAO 
{
    public void addEmployee(EmployeeEntity employee);
    public void editEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
    public EmployeeEntity getEmployee(Integer employeeId);
}