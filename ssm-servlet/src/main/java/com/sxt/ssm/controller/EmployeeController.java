package com.sxt.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxt.ssm.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String getEmployees(Model model) {
		model.addAttribute("empList", employeeService.findAllEmployees());

		return "emp/list";
	}
}
