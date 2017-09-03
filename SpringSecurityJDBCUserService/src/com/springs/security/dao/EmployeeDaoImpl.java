package com.springs.security.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springs.security.entity.EmployeeEntity;
import com.springs.security.model.UserRoles;
import com.springs.security.model.Users;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO, UserDetailsService {

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
		return this.sessionFactory.getCurrentSession()
				.createQuery("from Employee").list();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		EmployeeEntity employee = (EmployeeEntity) sessionFactory
				.getCurrentSession().get(EmployeeEntity.class, employeeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}
	}

	@Override
	public EmployeeEntity getEmployee(Integer employeeId) {
		EmployeeEntity employee = (EmployeeEntity) this.sessionFactory
				.getCurrentSession().get(EmployeeEntity.class, employeeId);
		return employee;
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		System.out.println("Getting access details from employee dao !!");

	/*	List<Users> users = new ArrayList<Users>();
*/
		Users users = (Users) this.sessionFactory
				.getCurrentSession().get(Users.class, username);
		
		
	/*	users = sessionFactory.getCurrentSession()
				.createQuery("from Users where username=?")
				.setParameter(0, username).list();
*/
		
			boolean enabled = false;
			if (users.isEnabled() > 0) {
				enabled = true;
			}

			List<GrantedAuthority> authorities = buildUserAuthority(users.getUserRole());

			UserDetails user = new User(users.getUsername(), users
					.getPassword(), enabled, true, true, true,
					authorities);
			return user;
		
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRoles> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (UserRoles userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);

		return Result;
	}

}
