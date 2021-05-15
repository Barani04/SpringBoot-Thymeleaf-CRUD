package com.example.cruddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.cruddemo.model.Employee;
import com.example.cruddemo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		model.addAttribute("ListEmployee", employeeService.getAllEmployee());
		return "index";
	}
	
	@GetMapping("/addNewEmployeeForm")
	public String addNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "add_Employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/updateEmployeeForm/{empid}")
	public String updateEmployee(@PathVariable (value = "empid") long id, Model model) {

		
		Employee employee = employeeService.getEmployeeById(id);
		
		model.addAttribute("employee", employee);
		
		return "update_Employee";
	}
	
	@GetMapping("/deleteEmployee/{empid}")
	public String deleteEmployee(@PathVariable (value = "empid") long id, Model model) {
		
		employeeService.deleteEmployee(id);
		
		return "redirect:/";
	}
	
}