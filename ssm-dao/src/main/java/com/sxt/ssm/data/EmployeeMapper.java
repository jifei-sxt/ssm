package com.sxt.ssm.data;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sxt.ssm.entity.EmployeeEntity;
@Mapper
public interface EmployeeMapper {
	List<EmployeeEntity> selectAllEmployees();
}
