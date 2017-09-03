package com.springs.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springs.security.entity.EmployeeEntity;
import com.springs.security.service.EmployeeManager;

@Controller
public class EditEmployeeController {

	@Autowired
	private EmployeeManager employeeManager;
	
	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(ModelMap map) {
		return "redirect:/list";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) {
		
		/*map.addAttribute("employee", new EmployeeEntity());*/
		map.addAttribute("employeeList", employeeManager.getAllEmployees());

		return "viewEmployeeList";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(
			@ModelAttribute(value = "employee") EmployeeEntity employee,
			BindingResult result) {
		employeeManager.addEmployee(employee);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/editEmp/edit", method = RequestMethod.POST)
	public String editEmployee(
			@ModelAttribute(value = "employee") EmployeeEntity employee,
			BindingResult result) {
		employeeManager.editEmployee(employee);
		return "redirect:/list";
	}

	@RequestMapping("/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		employeeManager.deleteEmployee(employeeId);
		return "redirect:/list";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}
	
	@RequestMapping(value = "/addEmp", method = RequestMethod.GET)
	public String addEmployee(ModelMap model) {
		model.addAttribute("employee", new EmployeeEntity());
		return "addEmployeeList";
	}
	
	@RequestMapping("/editEmp/{employeeId}")
	public String updateEmplyoee(@PathVariable("employeeId") Integer employeeId,
			ModelMap model) {
		//EmployeeEntity employee = employeeManager.updateEmployee(employeeId);
		model.addAttribute("employee", employeeManager.getEmployee(employeeId));
		return "editEmployeeList";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
}
