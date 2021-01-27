package com.sxt.ssm.service;

import java.util.List;

import com.sxt.ssm.entity.EmployeeEntity;

public interface EmployeeService {
	List<EmployeeEntity> findAllEmployees();
}
