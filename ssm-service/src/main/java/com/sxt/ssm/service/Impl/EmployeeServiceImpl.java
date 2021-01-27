package com.sxt.ssm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.ssm.data.EmployeeMapper;
import com.sxt.ssm.entity.EmployeeEntity;
import com.sxt.ssm.service.EmployeeService;

@Service
@Transactional

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	@Transactional(readOnly = true)
	public List<EmployeeEntity> findAllEmployees() {
		return employeeMapper.selectAllEmployees();
	}

}
