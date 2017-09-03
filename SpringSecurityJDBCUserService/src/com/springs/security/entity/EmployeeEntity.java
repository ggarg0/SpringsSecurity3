package com.springs.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "Employee")
@Table(name="EMPLOYEE")
public class EmployeeEntity {
     
    @Id
    @Column(name="EMPLOYEE_ID")
    private Integer id;
     
	@Column(name="FIRST_NAME")
    private String firstname;
 
    @Column(name="LAST_NAME")
    private String lastname;
 
    @Column(name="EMAIL")
    private String email;
     
    @Column(name="PHONE_NUMBER")
    private String telephone;
     
    @Column(name="JOB_ID")
    private String jobid;
     
    @Column(name="SALARY")
    private String salary;
    
    @Column(name="MANAGER_ID")
    private String managerid;
     
    @Column(name="DEPARTMENT_ID")
    private String departmentid;
    
    public String getEmail() {
        return email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getManagerid() {
		return managerid;
	}
	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
    
}