package com.amsidh.mvc.service;

import com.amsidh.mvc.domain.EmployeeA;
import com.amsidh.mvc.domain.EmployeeB;

public interface EmployeeService {
	void persistEmployee(EmployeeA employeeA,EmployeeB employeeB) throws Exception;
	
	
}
